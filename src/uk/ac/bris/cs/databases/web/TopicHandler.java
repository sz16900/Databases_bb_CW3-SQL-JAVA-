package uk.ac.bris.cs.databases.web;

import uk.ac.bris.cs.databases.api.APIProvider;
import uk.ac.bris.cs.databases.api.Result;
import uk.ac.bris.cs.databases.api.TopicView;

/**
 *
 * @author csxdb
 */
public class TopicHandler extends SimpleHandler {

    @Override
    public RenderPair simpleRender(String p) {
        
        long id = Long.parseLong(p);
        APIProvider api = ApplicationContext.getInstance().getApi();
        Result<TopicView> r = api.getTopic(id, 0);
        return new RenderPair("TopicView.ftl", r);
    }
}
