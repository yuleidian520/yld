SELECT
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
WHERE appno =:appno