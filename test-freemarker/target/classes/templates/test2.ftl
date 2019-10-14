<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Hello World!</title>
</head>

<table>
    <tr>
        <td>序号</td>
        <td>姓名</td>
        <td>年龄</td>
        <td>钱包</td>
        <td>出生日期</td>
    </tr>
    <#list stus as stu>
        <tr>
            <td>${stu_index +1}</td>
            <td>${stu.name}</td>
            <td>${stu.age}</td>
            <td>${stu.money}</td>
            <td>${stu.birthday?date}</td>
        </tr>
    </#list>
</table>

<br/>
姓名:${stuMap['stu1'].name}
<br/>
<#list stuMap?keys as k>
    姓名:${stuMap[k].name}<br/>
    年龄:${stuMap[k].age}<br/>
</#list>
</html>