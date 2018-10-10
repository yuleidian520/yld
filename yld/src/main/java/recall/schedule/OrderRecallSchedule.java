package com.cf.web.order.recall.schedule;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.cf.util.BaseUtil;
import com.cf.web.order.service.IOrderRecallTaskService;

/**
 * 订单回溯定时任务
 * @author yuleidian
 * 2018年1月2日 下午5:14:07
 */
@Component
public class OrderRecallSchedule {

	private final static Logger logger = BaseUtil.getLogger(OrderRecallSchedule.class);
	
	@Autowired
	private IOrderRecallTaskService orderRecallTaskService;
	
	/**
	 * 每晚10点执行回溯
	 */
	@Scheduled(cron = "0 00 22 * * ?")
	public void execute() {
		try {
			logger.info("执行回溯任务");
			orderRecallTaskService.executeTodayRecallTask();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("执行订单回溯任务时抛出异常" + e.getMessage());
		}
	}
	
}
