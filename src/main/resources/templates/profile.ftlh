<html>
<head>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
</head>

<body>
<div class="form-style-2-heading">
    User: &nbsp;
    ${user.login}
    <br>
    <ul>
        <li>
            <a href="/baskets/${user.basket.id}">Basket</a>
        </li>
        <li>
            <a class="nav-link" href="/shops">Shops</a>
        </li>
    </ul>
    <br>
    <div class="form-style-2">
        <#if user.orders??>
            <#list user.orders as order>
                User orders:
                <ul>
                    <li>
                        Order №: ${order.number} has status ${order.status}
                        <p>
                            <a href="/orders/${order.id}">More info</a>
                        </p>
                    </li>
                </ul>
            </#list>
        </#if>
    </div>
</div>
</body>
</html>
