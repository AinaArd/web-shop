<html>
<head>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
</head>

<body>
<div class="form-style-2">
    <#if basket.products??>
        <#list basket.products as product>
            Products in basket:
            <ul>
                <li>
                    <a href="/products/${product.id}">${product.name}</a>
                </li>
            </ul>
        </#list>
    <#else>
        <img src="/images/empty_basket.jpg">
    </#if>

    <div class="form-style-2-heading">
        Fill in your address
    </div>
    <form method="post">
        <label for="country">Country
            <input class="input-field" type="text" id="country" name="country">
        </label>
        <label for="city">City
            <input class="input-field" type="text" id="city" name="city">
        </label>
        <input type="submit" value="Make an order">
    </form>
</div>

<a href="/users/${basket.user.id}">Profile</a>

</body>
</html>