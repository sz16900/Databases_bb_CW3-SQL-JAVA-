package uk.ac.bris.cs.databases.web;

import uk.ac.bris.cs.databases.api.APIProvider;
import uk.ac.bris.cs.databases.api.AdvancedForumView;
import uk.ac.bris.cs.databases.api.Result;

/**
 * Handler for the advanced view of a single forum.
 * path: /forum2/$id
 * 
 * @author csxdb
 */
public class AdvancedForumHandler extends SimpleHandler {

    @Override
    RenderPair simpleRender(String p) throws RenderException {
        long id = Long.parseLong(p);
        APIProvider api = ApplicationContext.getInstance().getApi();
        Result<AdvancedForumView> r = api.getAdvancedForum(id);
        return new RenderPair("AdvancedForumView.ftl", r);
    }
}
