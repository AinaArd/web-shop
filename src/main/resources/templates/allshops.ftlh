<html>
<head>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
</head>

<body>
<#if shops??>
    <#list shops as shop>
        <ul>
            <li>
                <a href="/shops/${shop.id}">${shop.name}</a>
            </li>
        </ul>
    </#list>
</#if>
</body>
</html>