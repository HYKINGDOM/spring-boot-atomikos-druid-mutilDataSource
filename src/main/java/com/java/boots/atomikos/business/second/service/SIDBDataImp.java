package com.java.boots.atomikos.business.second.service;

import com.java.boots.atomikos.business.second.entity.UserEntity;

import java.util.List;

public interface SIDBDataImp {

    List<UserEntity> getSIdbData();

    int insertUser(UserEntity userEntity);
}
