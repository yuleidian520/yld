package com.cf.web.order.recall.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cf.interfaces.dto.CommonQC;
import com.cf.web.order.recall.dao.IRecallOrderDAO;
import com.cf.web.order.recall.service.IRecallOrderService;

@Transactional
@Service("recallOrderServiceImpl")
public class RecallOrderServiceImpl extends CommonServiceImpl implements IRecallOrderService {

	@Autowired
	private IRecallOrderDAO recallOrderDAO;
	
	@Override
	public DataGrid getPaginationOAorderInfo(CommonQC condition, DataGrid datagrid) {
		DataGrid result = datagrid;
		result.setResults(recallOrderDAO.getPaginationOAorderInfo(condition, datagrid));
		result.setTotal(recallOrderDAO.getPaginationOAorderInfoCount(condition));
		return result;
	}
}
