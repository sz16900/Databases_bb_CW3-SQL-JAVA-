package uk.ac.bris.cs.databases.api;

import java.util.List;

/**
 * Detail view of a single forum, advanced version (more topic info).
 * @author csxdb
 */
public class AdvancedForumView {
    
    /* The id of this forum. */
    private final long id;
    
    /* The title of this forum. */
    private final String title;
    
    /* The topics in this forum ordered by most recent post.
     * If none, an empty list (never null).
     */
    private final List<TopicSummaryView> topics;

    public AdvancedForumView(long id,
                     String title,
                     List<TopicSummaryView> topics) {
        this.id = id;
        this.title = title;
        this.topics = topics;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return the topics
     */
    public List<TopicSummaryView> getTopics() {
        return topics;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }
    
}
