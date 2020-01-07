/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.contract.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.contract.entity.ContractDetailed;
import com.jeesite.modules.contract.dao.ContractDetailedDao;
import com.jeesite.modules.file.utils.FileUploadUtils;

/**
 * 合同明细表Service
 * @author hlj
 * @version 2019-11-06
 */
@Service
@Transactional(readOnly=true)
public class ContractDetailedService extends CrudService<ContractDetailedDao, ContractDetailed> {
	
	/**
	 * 获取单条数据
	 * @param contractDetailed
	 * @return
	 */
	@Override
	public ContractDetailed get(ContractDetailed contractDetailed) {
		return super.get(contractDetailed);
	}
	
	/**
	 * 查询分页数据
	 * @param contractDetailed 查询条件
	 * @param contractDetailed.page 分页对象
	 * @return
	 */
	@Override
	public Page<ContractDetailed> findPage(ContractDetailed contractDetailed) {
		return super.findPage(contractDetailed);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param contractDetailed
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(ContractDetailed contractDetailed) {
		super.save(contractDetailed);
		// 保存上传附件
		FileUploadUtils.saveFileUpload(contractDetailed.getId(), "contractDetailed_file");
	}
	
	/**
	 * 更新状态
	 * @param contractDetailed
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(ContractDetailed contractDetailed) {
		super.updateStatus(contractDetailed);
	}
	
	/**
	 * 删除数据
	 * @param contractDetailed
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(ContractDetailed contractDetailed) {
		super.delete(contractDetailed);
	}
	
}