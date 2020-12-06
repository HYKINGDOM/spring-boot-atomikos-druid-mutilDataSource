package com.java.boots.atomikos.business.testController;


import com.java.boots.atomikos.business.first.entity.InterfaceInfo;
import com.java.boots.atomikos.business.first.service.RPDBDataImp;
import com.java.boots.atomikos.business.second.entity.UserEntity;
import com.java.boots.atomikos.business.second.service.SIDBDataImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service
public class TestDemoInterfaceImpl implements TestDemoInterface {

    @Autowired
    private RPDBDataImp rpdbDataImp;

    @Autowired
    private SIDBDataImp sidbDataImp;


    @Override
    @Transactional
    public int testInsert() {
        InterfaceInfo info = new InterfaceInfo();
        info.setId("16");
        info.setServerId(17);
        info.setInterfaceCode("408");
        info.setServerUrl("/user");

        UserEntity userEntity = new UserEntity();
        userEntity.setId("11");
        userEntity.setDeptId("12");
        userEntity.setLoginName("wangmazi");
        userEntity.setUserName("王麻子");
        userEntity.setPasswd("sdasdawdwad");

        int in = rpdbDataImp.insertInterfaceInfo(info);
        int si = sidbDataImp.insertUser(userEntity);
        return in + si;
    }

    /**
     * 自身不加事务再调用加事务的方法
     * @return
     */
    @Override
    public int testInsertNotTransactional() {
        InterfaceInfo info = new InterfaceInfo();
        info.setId("15");
        info.setServerId(16);
        info.setInterfaceCode("408");
        info.setServerUrl("/user");
        return rpdbDataImp.insertInterfaceInfo(info);
    }


}
