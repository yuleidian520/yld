package com.cf.web.order.recall;

import org.springframework.beans.factory.annotation.Autowired;

import com.cf.datasource.CustomerContextHolder;
import com.cf.web.order.entity.CFOrderRecallTask;

/**
 * 回溯任务模板
 * @author yuleidian
 * 2018年1月5日 下午7:15:00
 */
public abstract class AbstractOperateTemplate implements IOperateTemplate {

	@Autowired
	private CommonService commonService;
	
	public void executeRecall(CFOrderRecallTask task) {
		createOrSelectOrder(task);
		consummateOrderData(task);
		calcPercentageData(task);
		saveOrUpdateOrder(task);
		deleteRecallRecord(task);
	}
	
	/** 执行创建order*/
	protected abstract void createOrSelectOrder(CFOrderRecallTask task);
	
	/** 完善order*/
	protected abstract void consummateOrderData(CFOrderRecallTask task);
	
	/** 计算提成*/
	protected abstract void calcPercentageData(CFOrderRecallTask task);
	
	
	/**
	 * 保存订单
	 * @param record
	 */
	private void saveOrUpdateOrder(CFOrderRecallTask task) {
		CustomerContextHolder.setCustomerType(CustomerContextHolder.SESSION_FACTORY_OFFLINEANALYSIS);
		try {
			commonService.saveOrUpdate(task.getOrder());
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			CustomerContextHolder.setCustomerType(CustomerContextHolder.SESSION_FACTORY_JEECG);
		}
	}
	
	/**
	 * 删除操作记录
	 * @param record
	 */
	private void deleteRecallRecord(CFOrderRecallTask task) {
		CustomerContextHolder.setCustomerType(CustomerContextHolder.SESSION_FACTORY_JEECG);
		try {
			commonService.delete(task);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			CustomerContextHolder.setCustomerType(CustomerContextHolder.SESSION_FACTORY_JEECG);
		}
	}
}
