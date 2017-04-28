<#include "header.html">

<h1>Forums</h1>

<#list data.data as forum>
    <div class="section">
    <p><b><a href="/forum/${forum.id}">${forum.title}</a></b></p>
    <#if (forum.lastTopic)??>
        <p>Last post in: <a href="/topic/${forum.lastTopic.topicId}"><b>${forum.lastTopic.title}</b></a></p>
    <#else>
        <p>No posts.</p>
    </#if>
    </div>
</#list>

<p><a href="/forums0">Simple view</a> normal view <a href="/forums2">advanced view</a></p>

<div class="section alt">
<p><a href="/newforum">Create new forum</a></p>
</div>

<#include "footer.html">

