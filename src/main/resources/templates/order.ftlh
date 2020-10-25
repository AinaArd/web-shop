<html>
<head>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
</head>

<body>
<div class="form-style-2">
    <table class="borders">
        <tr>
            <th>Date</th>
            <th>Status</th>
            <th>Total price</th>
        </tr>
            <tr>
                <td>${order.date}</td>
                <td>${order.status}</td>
                <td>${order.totalPrice}</td>
            </tr>
    </table>
    <br>
    <#if order.products??>
        <#list order.products as product>
            Products in order:
            <ul>
                <li>
                    <a href="/products/${product.id}">${product.name}</a>
                </li>
            </ul>
        </#list>
    </#if>
</div>

</body>
</html>