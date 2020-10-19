<html>
<head>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
</head>

<body>
<#if shop.products??>
    <#list shop.products as product>
        <ul>
            <li>
                <a href="/products/${product.id}">${product.name}</a>
            </li>
        </ul>
    </#list>
</#if>
</body>
</html>