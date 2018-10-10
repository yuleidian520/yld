package com.cf.web.order.recall.behavior.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cf.util.BaseUtil;
import com.cf.web.bairong.utils.CalcAverageCapitalPlusInterestUtils;
import com.cf.web.order.entity.CFOrderRecallTask;
import com.cf.web.order.recall.behavior.CalculateBehavior;
import com.cf.web.order.recall.model.OAOrderInfo;
import com.cf.web.order.utils.EqualityCorpusInterestUtil;
import com.cf.web.payment.cutpayment.service.ICutPaymentService;

@Transactional
@Service("calculatePercentageBehaviorImpl")
public class CalculatePercentageImpl implements CalculateBehavior {

	@Autowired
	private ICutPaymentService cutPaymentService;
	
	@Override
	public void calculatePercentage(CFOrderRecallTask task) {
		OAOrderInfo order = task.getOrder();
		if (BaseUtil.objNotNull(task.getOrder())) {
			order.setCharge(cutPaymentService.calcPaymentMoney(order.getPassLoanAmounts(), order.getAgent(), order.getSdUserName()).doubleValue());
			order.setInterest(getInterestCount(order));
			// 目前无法计算以下提成
			order.setCost(0d);
			order.setIfvPercentage(0d);
			order.setSdPercentage(0d);
			order.setRmPercentage(0d);
			order.setCaPercentage(0d);
		}
	}

	private double getInterestCount(OAOrderInfo order) {
		switch (order.getFlow()) {
		case "01":
		case "02":
		case "04":
		case "05":
		case "06":
		case "07":
			return EqualityCorpusInterestUtil.getInterestCount(order.getPassLoanAmounts(),
					order.getCurrentRate() * 12, order.getTerm()).doubleValue();
		case "03":
			return CalcAverageCapitalPlusInterestUtils.getInterestCount(order.getPassLoanAmounts(), 
					order.getCurrentRate() * 12, order.getTerm());
		default:
			break;
		}
		return 0d;
	}
}
