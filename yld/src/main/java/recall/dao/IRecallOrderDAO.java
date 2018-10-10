package com.cf.web.order.recall.dao;
import java.util.List;


import com.cf.interfaces.dto.CommonQC;
import com.cf.web.order.recall.model.OAOrderInfo;

/**
 * 回溯订单DAO 使用的数据源为mysql
 * @author yuleidian
 * 2018年1月9日 下午3:03:33
 */
@MiniDao
public interface IRecallOrderDAO {

	/**
	 * 分页查询回溯订单信息
	 * @param condition
	 * @param datagrid
	 * @return
	 */
	@Arguments({"condition", "datagrid"})
	public List<OAOrderInfo> getPaginationOAorderInfo(CommonQC condition, DataGrid datagrid);
	
	/**
	 * IRecallOrderDAO_getPaginationOAorderInfoCount.sql
	 * 分页查询回溯订单信息总数
	 * @param condition
	 * @param datagrid
	 * @return
	 */
	@Arguments({"condition"})
	public Integer getPaginationOAorderInfoCount(CommonQC condition);
	
	/**
	 * IRecallOrderDAO_getOrderInfo.sql
	 * 获取订单
	 * @param appno
	 * @return
	 */
	@Arguments("appno")
	public OAOrderInfo getOAOrderInfo(String appno);
	
}
