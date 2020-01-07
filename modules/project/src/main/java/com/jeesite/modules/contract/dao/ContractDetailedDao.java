/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.contract.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.contract.entity.ContractDetailed;

/**
 * 合同明细表DAO接口
 * @author hlj
 * @version 2019-11-06
 */
@MyBatisDao
public interface ContractDetailedDao extends CrudDao<ContractDetailed> {
	
}