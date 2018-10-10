package com.cf.web.order.recall.behavior;

import com.cf.web.order.entity.CFOrderRecallTask;

/**
 * 创建操作
 * @author yuleidian
 * 2018年1月5日 下午7:09:50
 */
public interface CreateBehavior {

	public void createOrSelect(CFOrderRecallTask task);
	
}
