package uk.ac.bris.cs.databases.cwk3;

import java.sql.Connection;
import java.sql.DriverManager;
<<<<<<< HEAD
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.lang.Long;
=======
import java.util.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

>>>>>>> 46ea1c569cf142e6efa4e5aea680316c900c0137

import uk.ac.bris.cs.databases.api.APIProvider;
import uk.ac.bris.cs.databases.api.AdvancedForumSummaryView;
import uk.ac.bris.cs.databases.api.AdvancedForumView;
import uk.ac.bris.cs.databases.api.ForumSummaryView;
import uk.ac.bris.cs.databases.api.ForumView;
import uk.ac.bris.cs.databases.api.AdvancedPersonView;
import uk.ac.bris.cs.databases.api.PostView;
import uk.ac.bris.cs.databases.api.Result;
import uk.ac.bris.cs.databases.api.PersonView;
import uk.ac.bris.cs.databases.api.SimpleForumSummaryView;
import uk.ac.bris.cs.databases.api.SimpleTopicView;
<<<<<<< HEAD
import uk.ac.bris.cs.databases.api.SimplePostView;
=======
>>>>>>> 46ea1c569cf142e6efa4e5aea680316c900c0137
import uk.ac.bris.cs.databases.api.TopicView;

/**
 *
 * @author csxdb
 */
public class API implements APIProvider {

    private final Connection c;

    public API(Connection c) {
        this.c = c;
    }

    /* level 1 */

<<<<<<< HEAD
    @Override
    public Result<Map<String, String>> getUsers() {
        String q = "SELECT username, name FROM Person;";
        Map<String, String> myMap = new HashMap<String, String>();

        try ( PreparedStatement s = this.c.prepareStatement(q) ) {
           ResultSet r = s.executeQuery();
           while(r.next()){
             String userName = r.getString("username");
             String name = r.getString("name");
             myMap.put(userName, name);
           }
           return Result.success(myMap);
        } catch (SQLException e) {
           //handle exception
           return Result.fatal(e.getMessage());
        }
    }

    @Override
    public Result<PersonView> getPersonView(String username) {
        String q = "SELECT * FROM Person WHERE username = ?";

	   try ( PreparedStatement s = this.c.prepareStatement(q) ) {
	      s.setString(1, username);
	      ResultSet r = s.executeQuery();
	      r.next();
	      String name     = r.getString("name");
        String userName = r.getString("username");
        String stuId    = r.getString("stuId");
        PersonView myPersonView = new PersonView(name,userName,stuId);
        return Result.success(myPersonView);
=======
    @Override //DONE
    public Result<Map<String, String>> getUsers() {
        // throw new UnsupportedOperationException("Not supported yet.");

        String q = "SELECT username, name FROM Person;";
        Map<String, String> myMap = new HashMap<String, String>();
        //Result myResult = new Result();
        try ( PreparedStatement s = this.c.prepareStatement(q) ) {

        ResultSet r = s.executeQuery();
        while(r.next()){
          String userName = r.getString("username");
          String name = r.getString("name");
          myMap.put(userName, name);
        }
        return Result.success(myMap);
        // do stuff

        } catch (SQLException e) {
        // // handle exception
        return Result.fatal(e.getMessage());
        }


    }

    @Override //DONE
    public Result<PersonView> getPersonView(String username) {
      String q = "SELECT * FROM Person WHERE username = ?";

	   try ( PreparedStatement s = this.c.prepareStatement(q) ) {
	   s.setString(1, username);
	   ResultSet r = s.executeQuery();
	   r.next();
	   String name     = r.getString("name");
           String userName = r.getString("username");
           String stuId    = r.getString("stuId");
           PersonView myPersonView = new PersonView(name,userName,stuId);

           return Result.success(myPersonView);
>>>>>>> 46ea1c569cf142e6efa4e5aea680316c900c0137
	   } catch (SQLException e) {
	      //handle exception
	      return Result.fatal(e.getMessage());
	   }
    }

<<<<<<< HEAD
    @Override
    public Result<List<SimpleForumSummaryView>> getSimpleForums() {
=======
    @Override //DONE
    public Result<List<SimpleForumSummaryView>> getSimpleForums() {

>>>>>>> 46ea1c569cf142e6efa4e5aea680316c900c0137
        String q = "SELECT * FROM Forum;";
        List<SimpleForumSummaryView> myList = new ArrayList<SimpleForumSummaryView>();
        try ( PreparedStatement s = this.c.prepareStatement(q) ) {

        ResultSet r = s.executeQuery();
        while(r.next()){
          long forumId = r.getLong("forumId");
          String title = r.getString("title");
          SimpleForumSummaryView SFSV = new SimpleForumSummaryView(forumId, title);
          myList.add(SFSV);
        }

        return Result.success(myList);
        // do stuff

        } catch (SQLException e) {
        // // handle exception
        return Result.fatal(e.getMessage());
        }
<<<<<<< HEAD
=======


>>>>>>> 46ea1c569cf142e6efa4e5aea680316c900c0137
    }

    @Override
    public Result<Integer> countPostsInTopic(long topicId) {
<<<<<<< HEAD
        String q = "SELECT postId FROM (SELECT topicId, title FROM Topic) AS table1 JOIN (SELECT topic, postNumber FROM Post) AS table2 ON table1.topicId = table2.topic WHERE table1.topicId = ? ORDER BY postNumber desc LIMIT 1;"

        try ( PreparedStatement s = this.c.prepareStatement(q) ) {
          ResultSet r = s.executeQuery();
          r.next();
          Integer result = r.getInt("postId");
        }
        return Result.success(result);
      } catch (SQLException e) {
        return Result.fatal(e.getMessage());
      }
=======
        throw new UnsupportedOperationException("Not supported yet.");
>>>>>>> 46ea1c569cf142e6efa4e5aea680316c900c0137
    }

    @Override
    public Result<List<PersonView>> getLikers(long topicId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Result<SimpleTopicView> getSimpleTopic(long topicId) {
<<<<<<< HEAD
        String q = "SELECT COUNT(*) FROM (SELECT topicId, title FROM Topic) AS table1 JOIN (SELECT topic, postId FROM Post) AS table2 ON table1.topicId = table2.topic WHERE table1.topicId = 1;"
        List<SimplePostView> myList = new ArrayList<SimplePostView>();
        String topic_title = "";
        String topicId_string = Long.toString(topicId);

      try ( PreparedStatement s = this.c.prepareStatement(q) ) {
         s.setString(1,topicId_string);
         ResultSet r = s.executeQuery();
         while(r.next()){
            String author   = r.getString("author");
            String postedAt = r.getString("postedAt");
            String text     = r.getString("text");
            String title    = r.getString("title");
            topic_title = title;
            int postId     = r.getInt("postId");

            SimplePostView mySimplePostView = new SimplePostView(postId, author, text, postedAt);
            myList.add(mySimplePostView);
         }
         SimpleTopicView mySimpleTopicView = new SimpleTopicView(topicId, topic_title, myList);
         return Result.success(mySimpleTopicView);
         } catch (SQLException e) {
            return Result.fatal(e.getMessage());
         }
      }
=======
        throw new UnsupportedOperationException("Not supported yet.");
    }
>>>>>>> 46ea1c569cf142e6efa4e5aea680316c900c0137

    /* level 2 */

    @Override
    public Result<PostView> getLatestPost(long topicId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Result<List<ForumSummaryView>> getForums() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Result createForum(String title) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Result createPost(long topicId, String username, String text) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Result addNewPerson(String name, String username, String studentId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Result<ForumView> getForum(long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Result<TopicView> getTopic(long topicId, int page) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Result likeTopic(String username, long topicId, boolean like) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /* level 3 */

    @Override
    public Result createTopic(long forumId, String username, String title, String text) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Result<List<AdvancedForumSummaryView>> getAdvancedForums() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Result<AdvancedPersonView> getAdvancedPersonView(String username) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Result<AdvancedForumView> getAdvancedForum(long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Result likePost(String username, long topicId, int post, boolean like) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
