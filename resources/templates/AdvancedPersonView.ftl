<#include "header.html">

<h1>Person: ${data.name}</h1>

<div class="section">
<h2>Information</h2>
<div class="grid">
    <div class="col-2"></div>
    <div class="col-4">Name</div>
    <div class="col-4">${data.name}</div>
    <div class="col-2"></div>
</div>
<div class="grid">
    <div class="col-2"></div>
    <div class="col-4">Username</div>
    <div class="col-4">${data.username}</div>
    <div class="col-2"></div>
</div>
<div class="grid">
    <div class="col-2"></div>
    <div class="col-4">Student id</div>
    <div class="col-4">${data.studentId}</div>
    <div class="col-2"></div>
</div>

<p><a href="/person/${data.username}">simple view</a></p>
</div>

<div class="section">
<h2>Likes</h2>
<p>
${data.name} has received ${data.topicLikes} likes for their topics and
${data.postLikes} likes for their posts.
</p>
</div>

<div class="section">
<h2>Liked topics</h2>
<#list data.likedTopics as topic>
<div class="subsection">
<p><a href="/topic/${topic.topicId}"><b>${topic.title}</b></a>
    (created by ${topic.creatorName} [${topic.creatorUserName}]
    at ${topic.created})</p>
<p>${topic.postCount} posts, last one by ${topic.lastPostName}
    at ${topic.lastPostTime}. ${topic.likes} likes.</p>
</div>
</#list>
</div>

<#include "footer.html">

