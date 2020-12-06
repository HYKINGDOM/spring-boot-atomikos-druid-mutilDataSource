package com.java.boots.atomikos.business.first.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author hy852
 */
@TableName("interface_info")
@Data
public class InterfaceInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@TableId
	private String id;

	private int serverId;

	private String serverUrl;

	private String interfaceCode;


}
