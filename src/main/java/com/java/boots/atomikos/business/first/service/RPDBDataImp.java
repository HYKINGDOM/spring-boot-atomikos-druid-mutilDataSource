package com.java.boots.atomikos.business.first.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.java.boots.atomikos.business.first.entity.InterfaceInfo;

import java.util.List;

public interface RPDBDataImp extends IService<InterfaceInfo> {

    List<InterfaceInfo> getRpDbData();

    int insertInterfaceInfo(InterfaceInfo interfaceInfo);
}
