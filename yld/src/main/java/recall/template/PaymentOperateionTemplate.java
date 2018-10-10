package com.cf.web.order.recall.template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cf.web.order.entity.CFOrderRecallTask;
import com.cf.web.order.recall.AbstractOperateTemplate;
import com.cf.web.order.recall.behavior.CalculateBehavior;
import com.cf.web.order.recall.behavior.ConsummateDataBehavior;
import com.cf.web.order.recall.behavior.CreateBehavior;

@Transactional
@Service("paymentOperations")
public class PaymentOperateionTemplate extends AbstractOperateTemplate {

	@Autowired
	@Qualifier("createOrderBehaviorImpl")
	private CreateBehavior createBehavior;
	
	@Autowired
	@Qualifier("consummateOrderDataBehaviorImpl")
	private ConsummateDataBehavior consummateBehavior;
	
	@Autowired
	@Qualifier("calculatePercentageBehaviorImpl")
	private CalculateBehavior calculateBehavior;
	
	@Override
	protected void createOrSelectOrder(CFOrderRecallTask task) {
		createBehavior.createOrSelect(task);
	}

	@Override
	protected void consummateOrderData(CFOrderRecallTask task) {
		consummateBehavior.consummateData(task);
	}

	@Override
	protected void calcPercentageData(CFOrderRecallTask task) {
		calculateBehavior.calculatePercentage(task);
	}

}
