package uk.ac.bris.cs.databases.api;

import uk.ac.bris.cs.databases.util.Params;

/**
 * View of a single post.
 * @author csxdb
 */
public class PostView {
    
    /* id of the forum/topic containing this post. */
    private final long forumId;
    private final long topicId;
    
    /* The number of the post in the topic - the first post of each topic is
     * always number 1.
     */
    private final int postNumber;
    
    /* The name of the post author. */
    private final String authorName;

    /* The username of the post author. */
    private final String authorUserName;

    /* The contents of this post. */
    private final String text;
    
    /* The date/time this post was made. */
    private final String postedAt;

    /* The number of likes that this post has got. */
    private final int likes;
    
    public PostView(long forumId, long topicId, int postNumber,
            String authorName, String authorUserName, String text,
            String postedAt, int likes) {
        
        Params.cannotBeEmpty(authorName);
        Params.cannotBeEmpty(authorUserName);
        Params.cannotBeEmpty(text);
        
        this.forumId = forumId;
        this.topicId = topicId;
        this.postNumber = postNumber;
        this.authorName = authorName;
        this.authorUserName = authorUserName;
        this.text = text;
        this.postedAt = postedAt;
        this.likes = likes;
    }

    /**
     * @return the forumId
     */
    public long getForumId() {
        return forumId;
    }

    /**
     * @return the topicId
     */
    public long getTopicId() {
        return topicId;
    }

    /**
     * @return the postNumber
     */
    public int getPostNumber() {
        return postNumber;
    }

    /**
     * @return the authorName
     */
    public String getAuthorName() {
        return authorName;
    }

    /**
     * @return the authorUserName
     */
    public String getAuthorUserName() {
        return authorUserName;
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @return the postedAt
     */
    public String getPostedAt() {
        return postedAt;
    }

    /**
     * @return the likes
     */
    public int getLikes() {
        return likes;
    }
}
