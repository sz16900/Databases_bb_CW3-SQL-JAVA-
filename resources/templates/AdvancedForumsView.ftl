<#include "header.html">

<h1>Forums</h1>

<#list data.data as forum>
    <div class="section">
    <p><b><a href="/forum2/${forum.id}">${forum.title}</a></b></p>
    <#if (forum.lastTopic)??>
        <p>Last post in: <a href="/topic/${forum.lastTopic.topicId}"><b>${forum.lastTopic.title}</b></a>
           by ${forum.lastTopic.lastPostName} at ${forum.lastTopic.lastPostTime}</p>
    <#else>
        <p>No posts.</p>
    </#if>
    </div>
</#list>

<p><a href="/forums0">Simple view</a> <a href="/forums">normal view</a> advanced view</p>

<div class="section alt">
<p><a href="/newforum">Create new forum</a></p>
</div>

<#include "footer.html">

