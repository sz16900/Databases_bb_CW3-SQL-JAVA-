<#include "header.html">

<h1>Forum: ${data.title}</h1>

<#list data.topics as t>
<div class="section">
<p><b><a href="/topic0/${t.topicId}">${t.title}</a></b>
<#if session??>
<span class="like">
  <a href="/likeTopic/${t.topicId}">like</a>
  <a href="/unlikeTopic/${t.topicId}">unlike</a>
</span>
</#if>
</p>
</div>
</#list>

<p>default view <a href="/forum2/${data.id}">advanced view</a></p>

<div class="section alt">
<#if session??>
<p><a href="/newtopic/${data.id}">Create new topic</a></p>
<#else>
<p><a href="/people">Log in</a> to create new topics.</p>
</#if>
</div>

<#include "footer.html">

