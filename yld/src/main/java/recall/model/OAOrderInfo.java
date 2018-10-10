package com.cf.web.order.recall.model;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 离线分析订单主表
 * @author yuleidian
 * 2018年1月2日 下午12:01:53
 */
@Entity
@Table(name = "orderInfo")
public class OAOrderInfo implements Serializable {
	
	private static final long serialVersionUID = 3768994512113940414L;
	
	private String appno;						// 订单编号

	private String name;						// 客户姓名

	private String phone;						// 客户联系电话
	
	private String idCard;						// 客户身份证
	
	private String flow;						// 订单产品编号
	
	private String productName;					// 产品名称
	
	private String sdUserName;					// 销售id
	
	private String sdRealName;					// 销售姓名
	
	private String higherUpUserName;			// 上级账号(区域经理, 渠道经理)
	
	private String higherUpRealName;			// 上级真实姓名(区域经理, 渠道经理, 账号)
	
	private Date createDate;					// 订单创建时间
	
	private Date loanStartDate;					// 起贷时间
	
	private Double loanAmounts;					// 贷款金额
	
	private Double passLoanAmounts;				// 实际贷款金额
	
	private Integer term;						// 贷款期数
	
	private String provcode;					// 订单所属省份
	
	private String citycode;					// 订单所属城市
	
	private String countycode;					// 订单所属乡县
	
	private String provName;					// 订单所属省份名称
	
	private String cityName;					// 订单所属城市名称
	
	private String countyName;					// 订单所属乡县名称
	
	private String agent;						// 销售身份(代理,正式员工,兼职)
	
	private String agentName;					// 代理身份名称(代理,正式员工,兼职)
	
	private Double currentRate;					// 月利率
	
	private Double charge;						// 服务费
	
	private Double interest;					// 总利息
	
	private Double cost;						// 资金成本
	
	private Double ifvPercentage;				// 资料审核人员提成
	
	private String ifvUserName;					// 资料审核用户名
	
	private String ifvRealName;					// 资料审核姓名
	
	private Double rmPercentage;				// 电核提成
	
	private String rmUserName;					// 电核用户名
	
	private String rmRealName;					// 电核姓名
	
	private String finalUserName;				// 终审用户名
	
	private String finalRealName;				// 终审姓名
	
	private Double caPercentage;				// ca提成
	
	private String caUserName;					// ca用户名
	
	private String caRealName;					// ca姓名
	
	private Double sdPercentage;				// 销售提成
	
	private String id;
	
	@Id
	@Column(name = "appno", length = 32)
	public String getAppno() {
		return appno;
	}

	@Column(name = "name", length = 50)
	public String getName() {
		return name;
	}

	@Column(name = "phone", length = 11)
	public String getPhone() {
		return phone;
	}

	@Column(name = "idCard", length = 18)
	public String getIdCard() {
		return idCard;
	}

	@Column(name = "flow", length = 2)
	public String getFlow() {
		return flow;
	}

	@Column(name = "productName", length = 30)
	public String getProductName() {
		return productName;
	}

	@Column(name = "sdUserName", length = 50)
	public String getSdUserName() {
		return sdUserName;
	}

	@Column(name = "sdRealName", length = 200)
	public String getSdRealName() {
		return sdRealName;
	}

	@Column(name = "higherUpUserName", length = 50)
	public String getHigherUpUserName() {
		return higherUpUserName;
	}

	@Column(name = "higherUpRealName", length = 200)
	public String getHigherUpRealName() {
		return higherUpRealName;
	}

	@Column(name = "createDate")
	public Date getCreateDate() {
		return createDate;
	}

	@Column(name = "loanStartDate")
	public Date getLoanStartDate() {
		return loanStartDate;
	}

	@Column(name = "loanAmounts")
	public Double getLoanAmounts() {
		return loanAmounts;
	}

	@Column(name = "passLoanAmounts")
	public Double getPassLoanAmounts() {
		return passLoanAmounts;
	}

	@Column(name = "term")
	public Integer getTerm() {
		return term;
	}

	@Column(name = "provcode", length = 10)
	public String getProvcode() {
		return provcode;
	}

	@Column(name = "citycode", length = 10)
	public String getCitycode() {
		return citycode;
	}

	@Column(name = "countycode", length = 10)
	public String getCountycode() {
		return countycode;
	}

	@Column(name = "provName", length = 30)
	public String getProvName() {
		return provName;
	}

	@Column(name = "cityName", length = 30)
	public String getCityName() {
		return cityName;
	}

	@Column(name = "countyName", length = 30)
	public String getCountyName() {
		return countyName;
	}

	@Column(name = "agent", length = 2)
	public String getAgent() {
		return agent;
	}

	@Column(name = "agentName", length = 20)
	public String getAgentName() {
		return agentName;
	}

	@Column(name = "currentRate")
	public Double getCurrentRate() {
		return currentRate;
	}

	@Column(name = "charge")
	public Double getCharge() {
		return charge;
	}

	@Column(name = "interest")
	public Double getInterest() {
		return interest;
	}

	@Column(name = "cost")
	public Double getCost() {
		return cost;
	}

	@Column(name = "ifvPercentage")
	public Double getIfvPercentage() {
		return ifvPercentage;
	}

	@Column(name = "sdPercentage")
	public Double getSdPercentage() {
		return sdPercentage;
	}

	@Column(name = "rmPercentage")
	public Double getRmPercentage() {
		return rmPercentage;
	}

	@Column(name = "caPercentage")
	public Double getCaPercentage() {
		return caPercentage;
	}

	@Column(name = "ifvUserName", length = 50)
	public String getIfvUserName() {
		return ifvUserName;
	}

	@Column(name = "ifvRealName", length = 50)
	public String getIfvRealName() {
		return ifvRealName;
	}

	@Column(name = "rmUserName", length = 50)
	public String getRmUserName() {
		return rmUserName;
	}

	@Column(name = "rmRealName", length = 50)
	public String getRmRealName() {
		return rmRealName;
	}

	@Column(name = "caUserName", length = 50)
	public String getCaUserName() {
		return caUserName;
	}

	@Column(name = "caRealName", length = 50)
	public String getCaRealName() {
		return caRealName;
	}

	
	@Column(name = "finalUserName", length = 50)
	public String getFinalUserName() {
		return finalUserName;
	}

	@Column(name = "finalRealName", length = 50)
	public String getFinalRealName() {
		return finalRealName;
	}

	@Transient
	public String getId() {
		return id;
	}

	
	public void setAppno(String appno) {
		this.appno = appno;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public void setFlow(String flow) {
		this.flow = flow;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setSdUserName(String sdUserName) {
		this.sdUserName = sdUserName;
	}

	public void setSdRealName(String sdRealName) {
		this.sdRealName = sdRealName;
	}

	public void setHigherUpUserName(String higherUpUserName) {
		this.higherUpUserName = higherUpUserName;
	}

	public void setHigherUpRealName(String higherUpRealName) {
		this.higherUpRealName = higherUpRealName;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public void setLoanStartDate(Date loanStartDate) {
		this.loanStartDate = loanStartDate;
	}

	public void setLoanAmounts(Double loanAmounts) {
		this.loanAmounts = loanAmounts;
	}

	public void setPassLoanAmounts(Double passLoanAmounts) {
		this.passLoanAmounts = passLoanAmounts;
	}

	public void setTerm(Integer term) {
		this.term = term;
	}

	public void setProvcode(String provcode) {
		this.provcode = provcode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public void setCountycode(String countycode) {
		this.countycode = countycode;
	}

	public void setProvName(String provName) {
		this.provName = provName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public void setCurrentRate(Double currentRate) {
		this.currentRate = currentRate;
	}

	public void setCharge(Double charge) {
		this.charge = charge;
	}

	public void setInterest(Double interest) {
		this.interest = interest;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public void setIfvPercentage(Double ifvPercentage) {
		this.ifvPercentage = ifvPercentage;
	}

	public void setSdPercentage(Double sdPercentage) {
		this.sdPercentage = sdPercentage;
	}

	public void setRmPercentage(Double rmPercentage) {
		this.rmPercentage = rmPercentage;
	}

	public void setCaPercentage(Double caPercentage) {
		this.caPercentage = caPercentage;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setIfvUserName(String ifvUserName) {
		this.ifvUserName = ifvUserName;
	}

	public void setIfvRealName(String ifvRealName) {
		this.ifvRealName = ifvRealName;
	}

	public void setRmUserName(String rmUserName) {
		this.rmUserName = rmUserName;
	}

	public void setRmRealName(String rmRealName) {
		this.rmRealName = rmRealName;
	}

	public void setCaUserName(String caUserName) {
		this.caUserName = caUserName;
	}

	public void setCaRealName(String caRealName) {
		this.caRealName = caRealName;
	}

	public void setFinalUserName(String finalUserName) {
		this.finalUserName = finalUserName;
	}

	public void setFinalRealName(String finalRealName) {
		this.finalRealName = finalRealName;
	}
	
}
