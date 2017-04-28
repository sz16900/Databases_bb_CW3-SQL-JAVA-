<#include "header.html">

<h1>Topic: ${data.title?html}</h1>

<div class="section">
<p>In forum: <a href="/forum/${data.forumId}">${data.forumName}</a></p>
<#if (data.page > 0)>
<p>Page ${data.page}</p>
</#if>
</div>

<#list data.posts as p>
<div class="section">
<p>Post #${p.postNumber} (${p.likes} likes)
by: <a href="/person/${p.authorUserName}">${p.authorName} [${p.authorUserName}]</a>
    at ${p.postedAt}
<span class="like">
  <a href="/likePost/${data.topicId}/${p.postNumber}/1">like</a>
  <a href="/likePost/${data.topicId}/${p.postNumber}/0">unlike</a>
</span>
</p>
<pre>
${p.text?html}
</pre>
</div>
</#list>

<div class="section alt">
<p>
<#if session??>
<a href="/newpost/${data.topicId}">Reply</a>
<#else>
<a href="/people">Log in</a> to reply.
</#if>
</p>
</div>

<#include "footer.html">

