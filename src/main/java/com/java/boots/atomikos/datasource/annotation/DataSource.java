package com.java.boots.atomikos.datasource.annotation;

import java.lang.annotation.*;

/**
 * 多数据源注解
 * @author hy852
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface DataSource {

    /**
     * 数据源名, 使用DataSourceNames已经定义的
     * @return
     */
    String name() default "";
}
