package com.cf.web.order.recall.behavior.impl;
import java.util.List;

import org.jeecgframework.web.system.pojo.base.TSUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cf.util.BaseUtil;
import com.cf.web.order.entity.CFExamineFlowRecord;
import com.cf.web.order.entity.CFOrderRecallTask;
import com.cf.web.order.enums.FlowEnum;
import com.cf.web.order.recall.behavior.ConsummateDataBehavior;
import com.cf.web.order.recall.model.OAOrderInfo;
import com.cf.web.order.service.IExamineFlowRecordService;
import com.cf.web.order.service.IOrderActivitiService;
import com.cf.web.user.enums.AgentEnum;
import com.cf.web.user.service.IUserInfoService;
import com.google.common.collect.Lists;

@Transactional
@Service("consummateOrderDataBehaviorImpl")
public class ConsummateOrderDataImpl implements ConsummateDataBehavior {

	@Autowired
	private IUserInfoService userIUserInfoService;
	
	@Autowired
	private IExamineFlowRecordService examineFlowRecordService;
	
	@Override
	public void consummateData(CFOrderRecallTask task) {
		OAOrderInfo order = task.getOrder();
		if (BaseUtil.objNotNull(order)) {
			order.setProductName(FlowEnum.getFlowName(order.getFlow()));
			order.setAgentName(AgentEnum.getName(order.getAgent()));
			List<TSUser> higherUps = userIUserInfoService.getTopParentLeaderByUserNameAndLevel(order.getSdUserName(), Lists.newArrayList("03", "05"));
			if (BaseUtil.collectionNotNull(higherUps)) {
				order.setHigherUpUserName(higherUps.get(0).getUserName());
				order.setHigherUpRealName(higherUps.get(0).getRealName());
			}
			//  完善流程审核人员信息
			consummateExamineFlowPersonnel(order);
		}
	}
	
	private void consummateExamineFlowPersonnel(OAOrderInfo order) {
		List<CFExamineFlowRecord> records = examineFlowRecordService.getFlowRecordByAppno(order.getAppno());
		for (CFExamineFlowRecord record : records) {
			if (BaseUtil.objNotNull(record)) {
				switch (record.getNodeKey()) {
				case IOrderActivitiService.INFORMATIONREVIEW_KEY:
					order.setIfvUserName(record.getCreateBy());
					order.setIfvRealName(record.getRealName());
					break;
				case IOrderActivitiService.INITIALREVIEW_KEY:
					order.setRmUserName(record.getCreateBy());
					order.setRmRealName(record.getRealName());
					break;
				case IOrderActivitiService.INTERREVIEW_KEY:
				case IOrderActivitiService.SENIORREVIEW_KEY:
				case IOrderActivitiService.FINALREVIEW_KEY:
				case IOrderActivitiService.INITIALAPPROVETOINTER_REVIEW:
				case IOrderActivitiService.INITIALAPPROVETOSENIOR_REVIEW:
				case IOrderActivitiService.INITIALAPPROVETOFINAL_REVIEW:
				case IOrderActivitiService.REFUSETOINTER_REVIEW:
				case IOrderActivitiService.REFUSETOSENIOR_REVIEW:
					order.setFinalUserName(record.getCreateBy());
					order.setFinalRealName(record.getRealName());
					break;
				default:
					break;
				}
			}
		}
	}
}
