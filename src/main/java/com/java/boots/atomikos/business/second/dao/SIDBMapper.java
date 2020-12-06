package com.java.boots.atomikos.business.second.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.java.boots.atomikos.business.second.entity.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface SIDBMapper extends BaseMapper<UserEntity> {
}
