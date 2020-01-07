/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.contract.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.contract.entity.ContractDetailed;
import com.jeesite.modules.contract.service.ContractDetailedService;

/**
 * 合同明细表Controller
 * @author hlj
 * @version 2019-11-06
 */
@Controller
@RequestMapping(value = "${adminPath}/contract/contractDetailed")
public class ContractDetailedController extends BaseController {

	@Autowired
	private ContractDetailedService contractDetailedService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public ContractDetailed get(String id, boolean isNewRecord) {
		return contractDetailedService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("contract:contractDetailed:view")
	@RequestMapping(value = {"list", ""})
	public String list(ContractDetailed contractDetailed, Model model) {
		model.addAttribute("contractDetailed", contractDetailed);
		return "modules/contract/contractDetailedList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("contract:contractDetailed:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<ContractDetailed> listData(ContractDetailed contractDetailed, HttpServletRequest request, HttpServletResponse response) {
		contractDetailed.setPage(new Page<>(request, response));
		Page<ContractDetailed> page = contractDetailedService.findPage(contractDetailed);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("contract:contractDetailed:view")
	@RequestMapping(value = "form")
	public String form(ContractDetailed contractDetailed, Model model) {
		model.addAttribute("contractDetailed", contractDetailed);
		return "modules/contract/contractDetailedForm";
	}

	/**
	 * 保存合同明细表
	 */
	@RequiresPermissions("contract:contractDetailed:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated ContractDetailed contractDetailed) {
		contractDetailedService.save(contractDetailed);
		return renderResult(Global.TRUE, text("保存合同明细表成功！"));
	}
	
	/**
	 * 删除合同明细表
	 */
	@RequiresPermissions("contract:contractDetailed:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(ContractDetailed contractDetailed) {
		contractDetailedService.delete(contractDetailed);
		return renderResult(Global.TRUE, text("删除合同明细表成功！"));
	}
	
}