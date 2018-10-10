package com.cf.web.order.recall.service;

import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.service.CommonService;

import com.cf.interfaces.dto.CommonQC;

/**
 * 回溯订单service
 * @author yuleidian
 * 2018年1月9日 下午3:14:14
 */
public interface IRecallOrderService extends CommonService {

	/**
	 * 分页查询回溯订单
	 * @param condition
	 * @param datagrid
	 * @return
	 */
	public DataGrid getPaginationOAorderInfo(CommonQC condition, DataGrid datagrid);
}
