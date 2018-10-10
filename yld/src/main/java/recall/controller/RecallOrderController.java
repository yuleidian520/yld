package com.cf.web.order.recall.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cf.interfaces.dto.CommonQC;
import com.cf.web.order.recall.service.IRecallOrderService;

/**
 * 回溯订单controller
 * @author yuleidian
 * 2018年1月9日 下午3:02:10
 */
@Controller
@RequestMapping("/recallOrderController")
public class RecallOrderController {

	@Autowired
	private IRecallOrderService recallOrderService;
	
	@RequestMapping(params="list")
	public ModelAndView list(HttpServletRequest request){
		return new ModelAndView("recallorder/list");
	}
	
	@RequestMapping(params = "datagrid")
	public void list(CommonQC condition, DataGrid datagrid, HttpServletRequest request, HttpServletResponse response) throws Exception{
		DataSourceContextHolder.setDataSourceType(DataSourceType.dataSource_offlineAnalysis);
		try {
			datagrid = recallOrderService.getPaginationOAorderInfo(condition, datagrid);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataSourceContextHolder.setDataSourceType(DataSourceType.dataSource_jeecg);
		}
		TagUtil.datagrid(response, datagrid);
	}
}
