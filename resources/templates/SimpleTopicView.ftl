<#include "header.html">

<h1>Topic: ${data.title?html}</h1>

<#list data.posts as p>
<div class="section">
<p>Post #${p.postNumber} by ${p.author} at ${p.postedAt}
<#if session??>
<span class="like">
  <a href="/likePost/${data.topicId}/${p.postNumber}/1">like</a>
  <a href="/likePost/${data.topicId}/${p.postNumber}/0">unlike</a>
</span>
</#if>
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

