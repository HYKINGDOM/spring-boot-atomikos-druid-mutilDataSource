package com.java.boots.atomikos.datasource.aspect;

import com.java.boots.atomikos.datasource.annotation.DataSourceNames;
import com.java.boots.atomikos.datasource.DynamicDataSource;
import com.java.boots.atomikos.datasource.annotation.DataSource;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.lang.reflect.Method;

/**
 * 多数据源，切面处理类
 *
 * @author hy852
 */
@Aspect
@Configuration
@Order(0)
public class DataSourceAspect {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Pointcut("@annotation(com.java.boots.atomikos.datasource.annotation.DataSource) " +
            "|| @within(com.java.boots.atomikos.datasource.annotation.DataSource)")
    public void dataSourcePointCut() {

    }

    @Before("dataSourcePointCut()")
    public void intercept(JoinPoint point) {
        Class<?> target = point.getTarget().getClass();
        MethodSignature signature = (MethodSignature) point.getSignature();
        for (Class<?> clazz : target.getInterfaces()) {
            resolveDataSource(clazz, signature.getMethod());
        }
        resolveDataSource(target, signature.getMethod());
        Method method = signature.getMethod();
        resolveDataSource(target, method);
    }

    @Around("dataSourcePointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        Class<?> target = point.getTarget().getClass();
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        DataSource ds = resolveDataSource(target, method);

        if (ds == null) {
            DynamicDataSource.setDataSource(DataSourceNames.FIRST);
            logger.info("set default datasource is {}", DataSourceNames.FIRST);
        } else {
            DynamicDataSource.setDataSource(ds.name());
            logger.info("set datasource is {}", ds.name());
        }
        return point.proceed();
    }

    @After("dataSourcePointCut()")
    public void restoreDataSource(JoinPoint point) {
        logger.info("method end of execution {}", point.toString());
        DynamicDataSource.clearDataSource();
    }

    /**
     * 获取最终的dataSource
     *
     * @param clazz
     * @param method
     * @return
     */
    private DataSource resolveDataSource(Class<?> clazz, Method method) {
        try {
            DataSource ds = null;
            Class<?>[] types = method.getParameterTypes();
            // 默认使用类型注解
            if (clazz.isAnnotationPresent(DataSource.class)) {
                ds = clazz.getAnnotation(DataSource.class);
                DynamicDataSource.setDataSource(ds.name());
                logger.info("set datasource is {}", ds.name());
                logger.info(DynamicDataSource.getDataSource());
            }
            // 方法注解可以覆盖类型注解
            Method clazzMethod = clazz.getMethod(method.getName(), types);
            if (clazzMethod.isAnnotationPresent(DataSource.class)) {
                ds = clazzMethod.getAnnotation(DataSource.class);
                DynamicDataSource.setDataSource(ds.name());
                logger.info("set datasource is {}", ds.name());
                logger.info(DynamicDataSource.getDataSource());
            }
            return ds;
        } catch (Exception e) {
            logger.error(clazz + ":" + e.getMessage());
        }
        return null;
    }
}
