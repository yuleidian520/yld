package com.cf.web.order.recall.task;


import com.cf.util.BaseUtil;
import com.cf.util.SpringContextUtils;
import com.cf.web.order.entity.CFOrderRecallTask;

/**
 * 回溯任务
 * @author yuleidian
 * 2018年1月2日 下午4:27:27
 */
public class RecallTask implements Runnable {

	private CFOrderRecallTask recall;
	
	public RecallTask(String appno, String operation) {
		recall = new CFOrderRecallTask(appno, operation);
	}
	
	public RecallTask(CFOrderRecallTask recall) {
		this.recall = recall;
	}

	@Override
	public void run() {
		if (BaseUtil.objNotNull(recall)) {
			CommonService commonService = (CommonService) SpringContextUtils.getBean("commonService");
			commonService.save(recall);
		}
	}
}
