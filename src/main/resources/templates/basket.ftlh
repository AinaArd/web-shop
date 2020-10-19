<#if basket.products??>
    <#list basket.products as product>
        <ul>
            <li>
                <a href="/products/${product.id}">${product.name}</a>
            </li>
        </ul>
    </#list>
</#if>