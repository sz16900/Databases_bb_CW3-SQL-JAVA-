package uk.ac.bris.cs.databases.api;

import java.util.List;
import java.util.Map;

/**
 * This is the main interface that you have to implement.
 * @author csxdb
 */
public interface APIProvider {
    
    /*
     * Level 1 - simple views. Every group is expected to implement these.
     */

    /**
     * Get a list of all users in the system as a map username -> name.
     * @return A map with one entry per user of the form username -> name
     * (note that usernames are unique).
     */
    public Result<Map<String, String>> getUsers();
    
    /**
     * Get a PersonView for the person with the given username.
     * @param username - the username to search for, cannot be empty.
     * @return If a person with the given username exists, a fully populated
     * PersonView. Otherwise, failure (or fatal on a database error).
     */
    public Result<PersonView> getPersonView(String username);
         
    /**
     * Get the "main page" containing a list of forums ordered alphabetically
     * by title. Simple version that does not return any topic information.
     * @return the list of all forums; an empty list if there are no forums.
     */
    public Result<List<SimpleForumSummaryView>> getSimpleForums();
    
    /**
     * Count the number of posts in a topic (without fetching them all).
     * @param topicId - the topic to look at.
     * @return The number of posts in this topic if it exists, otherwise a
     * failure.
     */
    public Result<Integer> countPostsInTopic(long topicId);
    
    /**
     * Get all people who have liked a particular topic, ordered by name
     * alphabetically.
     * @param topicId The topic id. Must exist.
     * @return Success (even if the list is empty) if the topic exists,
     * failure if it does not, fatal in case of database errors.
     */
    public Result<List<PersonView>> getLikers(long topicId);
    
    /**
     * Get a simplified view of a topic.
     * @param topicId - the topic to get.
     * @return The topic view if one exists with the given id,
     * otherwise failure or fatal on database errors. 
     */
    public Result<SimpleTopicView> getSimpleTopic(long topicId);
    
    /* 
     * Level 2 - standard difficulty. Most groups should get all of these.
     * They require a little bit more thought than the level 1 API though.
     */
        
    /**
     * Get the latest post in a topic.
     * @param topicId The topic. Must exist.
     * @return Success and a view of the latest post if one exists,
     * failure if the topic does not exist, fatal on database errors.
     */
    public Result<PostView> getLatestPost(long topicId);
    
    /**
     * Get the "main page" containing a list of forums ordered alphabetically
     * by title.
     * @return the list of all forums, empty list if there are none.
     */
    public Result<List<ForumSummaryView>> getForums();
    
    /**
     * Create a new forum.
     * @param title - the title of the forum. Must not be null or empty and
     * no forum with this name must exist yet.
     * @return success if the forum was created, failure if the title was
     * null, empty or such a forum already existed; fatal on other errors.
     */
    public Result createForum(String title);
    
    /**
     * Create a post in an existing topic.
     * @param topicId - the id of the topic to post in. Must refer to
     * an existing topic.
     * @param username - the name under which to post; user must exist.
     * @param text - the content of the post, cannot be empty.
     * @return success if the post was made, failure if any of the preconditions
     * were not met and fatal if something else went wrong.
     */
    public Result createPost(long topicId, String username, String text);
    
    /**
     * Create a new person.
     * @param name - the person's name, cannot be empty.
     * @param username - the person's username, cannot be empty.
     * @param studentId - the person's student id. May be either NULL if the
     * person is not a student or a non-empty string if they are; can not be
     * an empty string.
     * @return Success if no person with this username existed yet and a new
     * one was created, failure if a person with this username already exists,
     * fatal if something else went wrong.
     */
    public Result addNewPerson(String name, String username, String studentId);
    
    /**
     * Get the detailed view of a single forum.
     * @param id - the id of the forum to get.
     * @return A view of this forum if it exists, otherwise failure.
     */
    public Result<ForumView> getForum(long id);
    
    /**
     * Get the detailed view of a topic.
     * @param topicId - the topic to get.
     * @param page - if 0, fetch all posts, if n > 0, fetch posts
     * 10*(n-1)+1 up to 10*n, where the first post is number 1.
     * @return The topic view if one exists with the given id and range,
     * (i.e. for getTopic(tid, 3) there must be at least 31 posts)
     * otherwise failure (or fatal on database errors). 
     */
    public Result<TopicView> getTopic(long topicId, int page);
    
    /**
     * Like or unlike a topic. A topic is either liked or not, when calling this
     * twice in a row with the same parameters, the second call is a no-op (this
     * function is idempotent).
     * @param username - the person liking the topic (must exist).
     * @param topicId - the topic to like (must exist).
     * @param like - true to like, false to unlike.
     * @return success (even if it was a no-op), failure if the person or topic
     * does not exist and fatal in case of db errors.
     */
    public Result likeTopic(String username, long topicId,
                            boolean like);
    
    /*
     * Level 3 - more complex queries. Leave these until last.
     */

    /**
     * Create a new topic in a forum.
     * @param forumId - the id of the forum in which to create the topic. This
     * forum must exist.
     * @param username - the username under which to make this post. Must refer
     * to an existing username.
     * @param title - the title of this topic. Cannot be empty.
     * @param text - the text of the initial post. Cannot be empty.
     * @return failure if any of the preconditions are not met (forum does not
     * exist, user does not exist, title or text empty);
     * success if the post was created and fatal if something else went wrong.
     */
    public Result createTopic(long forumId, String username, String title,
            String text);
    
    /**
     * Get the "main page" containing a list of forums ordered alphabetically
     * by title. Advanced version.
     * @return the list of all forums.
     */
    public Result<List<AdvancedForumSummaryView>> getAdvancedForums();

    /**
     * Get an AdvancedPersonView for the person with the given username.
     * @param username - the username to search for, cannot be empty.
     * @return If a person with the given username exists, a fully populated
     * AdvancedPersonView. Otherwise, failure (or fatal on a database error).
     * 
     */
    public Result<AdvancedPersonView> getAdvancedPersonView(String username);

    /**
     * Get the detailed view of a single forum, advanced version.
     * @param id - the id of the forum to get.
     * @return A view of this forum if it exists, otherwise failure.
     */
    public Result<AdvancedForumView> getAdvancedForum(long id);
    
    /**
     * Like or unlike a post. Liking a post that you have already liked
     * (or unliking a post you haven't liked) is a no-op, not an error.
     * @param username - the person liking/unliking the post. Must exist.
     * @param topicId - the topic with the post to (un)like. Must exist.
     * @param post - the index of the post to (un)like. Must exist.
     * @param like - true to like, false to unlike.
     * @return failure if the person or post referenced to not exist,
     * success if the (un)like succeeded, fatal in case of other errors.
     */
    public Result likePost(String username,
                           long topicId, int post,
                           boolean like);
}
