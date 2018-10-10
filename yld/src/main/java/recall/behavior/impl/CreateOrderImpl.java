package com.cf.web.order.recall.behavior.impl;
import org.jeecgframework.core.common.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cf.datasource.CustomerContextHolder;
import com.cf.util.BaseUtil;
import com.cf.web.order.dao.IOrderDao;
import com.cf.web.order.entity.CFOrderRecallTask;
import com.cf.web.order.recall.behavior.CreateBehavior;
import com.cf.web.order.recall.model.OAOrderInfo;

@Transactional
@Service("createOrderBehaviorImpl")
public class CreateOrderImpl implements CreateBehavior {

	@Autowired
	private IOrderDao orderDAO;
	
	@Autowired
	private CommonService commonService;
	
	@Override
	public void createOrSelect(CFOrderRecallTask task) {
		OAOrderInfo order = getOfflineAnalysisOrderInfo(task.getAppno());
		if (BaseUtil.objIsNull(order) || BaseUtil.isBlank(order.getAppno())) {
			order = orderDAO.getOAOrderInfo(task.getAppno());
		}
		task.setOrder(order);
	}

	private OAOrderInfo getOfflineAnalysisOrderInfo(String appno) {
		CustomerContextHolder.setCustomerType(CustomerContextHolder.SESSION_FACTORY_OFFLINEANALYSIS);
		OAOrderInfo order = null;
		try {
			order = commonService.get(OAOrderInfo.class, appno);
		} catch (Exception e) {
			
		} finally {
			CustomerContextHolder.setCustomerType(CustomerContextHolder.SESSION_FACTORY_JEECG);
		}
		return order;
	}
}
