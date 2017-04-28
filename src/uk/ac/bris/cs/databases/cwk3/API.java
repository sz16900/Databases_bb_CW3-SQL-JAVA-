package uk.ac.bris.cs.databases.cwk3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


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
	   } catch (SQLException e) {
	      //handle exception
	      return Result.fatal(e.getMessage());
	   }
    }

    @Override //DONE
    public Result<List<SimpleForumSummaryView>> getSimpleForums() {

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


    }

    @Override
    public Result<Integer> countPostsInTopic(long topicId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Result<List<PersonView>> getLikers(long topicId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Result<SimpleTopicView> getSimpleTopic(long topicId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

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
