package com.cf.web.order.recall.behavior;

import com.cf.web.order.entity.CFOrderRecallTask;

/**
 * 计算操作
 * @author yuleidian
 * 2018年1月5日 下午7:09:06
 */
public interface CalculateBehavior {

	public void calculatePercentage(CFOrderRecallTask task);
	
}
