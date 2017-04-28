package uk.ac.bris.cs.databases.api;

import java.util.List;
import uk.ac.bris.cs.databases.util.Params;

/**
 * Detailed view of a singe topic (i.e. the posts).
 * @author csxdb
 */
public class TopicView {
    
    /* forumId and topicId identify this topic. */
    private final long forumId;
    private final long topicId;
    
    /* The name of the forum containing this topic. */
    private final String forumName;
    
    /* The title of this topic. */
    private final String title;
    
    /* The posts in this topic, in the order that they were created.
     * If this is the whole topic then this list contains all posts,
     * otherwise it contains maximal 10 of them.
     */
    private final List<PostView> posts;
    
    /* If this is the whole topic, set to 0. Otherwise it's the page number. */
    private final int page;

    public TopicView(long forumId, long topicId, String forumName, String title,
            List<PostView> posts, int page) {
        
        Params.cannotBeEmpty(forumName);
        Params.cannotBeEmpty(title);
        Params.cannotBeEmpty(posts);
        
        this.forumId = forumId;
        this.topicId = topicId;
        this.forumName = forumName;
        this.title = title;
        this.posts = posts;
        this.page = page;
    }

    public List<PostView> getPosts() {
        return posts;
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
     * @return the forumName
     */
    public String getForumName() {
        return forumName;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return the page
     */
    public int getPage() {
        return page;
    }
    
}
