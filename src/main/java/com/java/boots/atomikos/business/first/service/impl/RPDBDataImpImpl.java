package com.java.boots.atomikos.business.first.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.java.boots.atomikos.business.first.dao.RPDBMapper;
import com.java.boots.atomikos.business.first.entity.InterfaceInfo;
import com.java.boots.atomikos.business.first.service.RPDBDataImp;
import com.java.boots.atomikos.datasource.annotation.DataSource;
import com.java.boots.atomikos.datasource.annotation.DataSourceNames;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@DataSource(name = DataSourceNames.FIRST)
public class RPDBDataImpImpl extends ServiceImpl<RPDBMapper, InterfaceInfo> implements RPDBDataImp {


    @Override
    public List<InterfaceInfo> getRpDbData() {
        return baseMapper.selectList(null);
    }

    @Override
    @Transactional
    public int insertInterfaceInfo(InterfaceInfo interfaceInfo) {
        int insert = baseMapper.insert(interfaceInfo);
        int i = 1 / 0;
        return insert;
    }
}
