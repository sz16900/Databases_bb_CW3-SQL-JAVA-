package uk.ac.bris.cs.databases.api;

import uk.ac.bris.cs.databases.util.Params;

/**
 * Summary of a single forum.
 * @author csxdb
 */
public class ForumSummaryView {
    
    /* The title of this forum. */
    private final String title;
    
    /* The id of this forum. */
    private final long id;
    
    /* The last topic in which a post was made in this forum
     * or NULL if this forum contains no entries.
     */
    private final SimpleTopicSummaryView lastTopic;

    public ForumSummaryView(long id, 
                            String title,
                            SimpleTopicSummaryView lastTopic) {
        Params.cannotBeEmpty(title);
        
        this.id = id;
        this.title = title;
        this.lastTopic = lastTopic;
    }
    
    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }  

    /**
     * @return the lastTopic
     */
    public SimpleTopicSummaryView getLastTopic() {
        return lastTopic;
    }
    
}
