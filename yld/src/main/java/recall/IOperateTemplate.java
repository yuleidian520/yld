package com.cf.web.order.recall;

import com.cf.web.order.entity.CFOrderRecallTask;

/**
 * 目前无法确定收集信息在哪一步开始
 * (暂定在 运营部 放款管理功能中, 放款确认后加入记录表)
 * @author yuleidian
 * 2018年1月2日 上午10:42:00
 */
public interface IOperateTemplate {

	/** 放款操作*/
	String PAYMENTOPERATIONS = "paymentOperations";
	
	/**
	 * 执行回溯操作
	 */
	public void executeRecall(CFOrderRecallTask task);
	
}
