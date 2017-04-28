package uk.ac.bris.cs.databases.api;

import uk.ac.bris.cs.databases.util.Params;

/**
 * Summary view of a topic. In the main view of a forum, a summary of all topics
 * that it contains is displayed.
 * 
 * @author csxdb
 */
public class TopicSummaryView {
    
    /* The id of this topic. */
    private final long topicId;
    
    /* The id of the forum that contains this topic. */
    private final long forumId;
    
    /* The title of this topic. */
    private final String title;
    
    /* The date/time at which this topic was created. */
    private final String created;
    
    /* The date/time of the last post in this topic.
     * A topic always contains at least one post, the inital one made when it
     * was created.
     */
    private final String lastPostTime;
    
    /* The number of posts in this topic. Guaranteed to be >= 1. */
    private final int postCount;
    
    /*
     * The name of the user who made the last post in this topic.
     */
    private final String lastPostName;
    
    /* The name of this topic's creator. */
    private final String creatorName;
    
    /* The username of this topic's creator. */
    private final String creatorUserName;
    
    /* The number of likes that this topic has got. */
    private final int likes;

    public TopicSummaryView(long topicId, long forumId, String title, int postCount,
            String created, String lastPostTime, String lastPostName, int likes,
            String creatorName, String creatorUserName) {
        
        Params.cannotBeEmpty(title);
        Params.cannotBeEmpty(lastPostName);
        Params.cannotBeEmpty(creatorName);
        Params.cannotBeEmpty(creatorUserName);
        
        this.topicId = topicId;
        this.forumId = forumId;
        this.title = title;
        this.created = created;
        this.lastPostTime = lastPostTime;
        this.lastPostName = lastPostName;
        this.likes = likes;
        this.creatorName = creatorName;
        this.creatorUserName = creatorUserName;
        this.postCount = postCount;
    }
    
       
    /**
     * @return the topicId
     */
    public long getTopicId() {
        return topicId;
    }

    /**
     * @return the forumId
     */
    public long getForumId() {
        return forumId;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }


    /**
     * @return the created
     */
    public String getCreated() {
        return created;
    }

    /**
     * @return the lastPostTime
     */
    public String getLastPostTime() {
        return lastPostTime;
    }

    /**
     * @return the lastPostName
     */
    public String getLastPostName() {
        return lastPostName;
    }

    /**
     * @return the likes
     */
    public int getLikes() {
        return likes;
    }

    /**
     * @return the creatorName
     */
    public String getCreatorName() {
        return creatorName;
    }

    /**
     * @return the creatorUsername
     */
    public String getCreatorUserName() {
        return creatorUserName;
    }

    /**
     * @return the postCount
     */
    public int getPostCount() {
        return postCount;
    }
}
