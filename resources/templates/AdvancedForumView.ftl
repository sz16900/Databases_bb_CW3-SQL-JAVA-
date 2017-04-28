<#include "header.html">

<h1>Forum: ${data.title}</h1>

<#list data.topics as t>
<div class="section">
<p><b><a href="/topic/${t.topicId}">${t.title}</a></b>
    (created by <a href="/person/${t.creatorUserName}">${t.creatorName} [${t.creatorUserName}]</a>
    at ${t.created})</p>
<p><b>${t.postCount} posts</b>, last one by ${t.lastPostName}
    at ${t.lastPostTime}. ${t.likes} likes.
<#if session??>
<span class="like">
  <a href="/likeTopic/${t.topicId}">like</a>
  <a href="/unlikeTopic/${t.topicId}">unlike</a>
</span>
</#if>
</p>
</div>
</#list>

<p><a href="/forum/${data.id}">default view</a> advanced view</p>

<div class="section alt">
<p><a href="/newtopic/${data.id}">Create new topic</a></p>
</div>

<#include "footer.html">

