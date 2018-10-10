SELECT 
	COUNT(appno) 
FROM orderInfo
WHERE 1 = 1
<#if condition?exists && condition.appno?? && condition.appno?length gt 0>
	AND appno = '${condition.appno}' 
</#if>
<#if condition?exists && condition.name?? && condition.name?length gt 0>
	AND name = '${condition.name}' 
</#if>
<#if condition?exists && condition.idCard?? && condition.idCard?length gt 0>
	AND o.idCard = '${condition.idCard}' 
</#if>
