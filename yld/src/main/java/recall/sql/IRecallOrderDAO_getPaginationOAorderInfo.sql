SELECT
	appno AS id,
	appno AS appno,
	name AS name,
	phone AS phone,
	idCard AS idCard,
	flow AS flow,
	productName AS productName,
	sdUserName AS sdUserName,
	sdRealName AS sdRealName,
	higherUpUserName AS higherUpUserName,
	higherUpRealName AS higherUpRealName,
	createDate AS createDate,
	loanStartDate AS loanStartDate,
	loanAmounts AS loanAmounts,
	passLoanAmounts AS passLoanAmounts,
	term AS term,
	provcode AS provcode,
	citycode AS citycode,
	countycode AS countycode,
	provName AS provName,
	cityName AS cityName,
	countyName AS countyName,
	agent AS agent,
	agentName AS agentName,
	currentRate AS currentRate,
	charge AS charge,
	interest AS interest,
	ifvPercentage AS ifvPercentage,
	sdPercentage AS sdPercentage,
	rmPercentage AS rmPercentage,
	caPercentage AS caPercentage,
	ifvUserName AS ifvUserName,
	ifvRealName AS ifvRealName,
	rmUserName AS rmUserName,
	rmRealName AS rmRealName,
	caUserName AS caUserName,
	caRealName AS caRealName,
	finalUserName AS finalUserName,
	finalRealName AS finalRealName
FROM orderInfo
WHERE 1 = 1
<#if condition?exists && condition.appno?? && condition.appno?length gt 0>
	AND appno = '${condition.appno}' 
</#if>
<#if condition?exists && condition.name?? && condition.name?length gt 0>
	AND name = '${condition.name}' 
</#if>
<#if condition?exists && condition.idCard?? && condition.idCard?length gt 0>
	AND idCard = '${condition.idCard}' 
</#if>
ORDER BY createDate DESC
LIMIT ${datagrid.startRows} , ${datagrid.rows}