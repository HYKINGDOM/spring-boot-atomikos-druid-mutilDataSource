package com.java.boots.atomikos.business.second.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.java.boots.atomikos.business.second.dao.SIDBMapper;
import com.java.boots.atomikos.business.second.entity.UserEntity;
import com.java.boots.atomikos.business.second.service.SIDBDataImp;
import com.java.boots.atomikos.datasource.annotation.DataSource;
import com.java.boots.atomikos.datasource.annotation.DataSourceNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@DataSource(name = DataSourceNames.SECOND)
public class SIDBDataImpl extends ServiceImpl<SIDBMapper, UserEntity> implements SIDBDataImp {

    @Autowired
    private SIDBMapper sidbMapper;

    @Override
    @Transactional
    public List<UserEntity> getSIdbData() {
        return sidbMapper.selectList(null);
    }



    @Override
    public int insertUser(UserEntity userEntity) {
        int insert = baseMapper.insert(userEntity);
        int i = 1 / 0;
        return insert;
    }
}
