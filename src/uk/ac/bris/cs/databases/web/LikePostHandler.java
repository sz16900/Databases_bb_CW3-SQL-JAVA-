package uk.ac.bris.cs.databases.web;

import fi.iki.elonen.NanoHTTPD;
import fi.iki.elonen.router.RouterNanoHTTPD;
import java.util.Map;
import uk.ac.bris.cs.databases.api.APIProvider;
import uk.ac.bris.cs.databases.api.Result;

/**
 *
 * @author csxdb
 */
public class LikePostHandler extends AbstractHandler {

    @Override
    public View render(RouterNanoHTTPD.UriResource uriResource,
                       Map<String,String> params,
                       NanoHTTPD.IHTTPSession session) {
        
        System.out.println("[LikePostHandler] render " + session.getUri());
        
        
        String topic = params.get("topic");
        String post = params.get("number");
        String like = params.get("like");
        
        if (topic == null || post == null || like == null ||
            topic.equals("") || post.equals("") || like.equals("")) {
            return new View(404, "Missing parameter.");
        }

        long topicId = Long.parseLong(topic);
        int postNumber = Integer.parseInt(post);
        boolean isLike = Integer.parseInt(like) == 1;
        
        NanoHTTPD.CookieHandler h = session.getCookies();
        String user = h.read("user");
        
        if (user == null || user.equals("")) {
            return new View(400, "You must be logged in to like posts.");
        }
        
        APIProvider api = ApplicationContext.getInstance().getApi();
        System.out.println("LikePost(" + user + ", " + topicId + ", " +
                           postNumber + ", " + isLike + ")");
        Result r = api.likePost(user, topicId, postNumber, isLike);
        
        if (r.isSuccess()) {
            return renderView("Success.ftl", new ValueHolder("Success."), user);
        } else if (r.isFatal()) {
            return new View(500, "Fatal error - " + r.getMessage());
        } else {
            return new View(400, "Error - " + r.getMessage());
        }
    }
}
