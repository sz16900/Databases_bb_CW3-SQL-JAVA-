package uk.ac.bris.cs.databases.web;

import java.util.List;
import uk.ac.bris.cs.databases.api.APIProvider;
import uk.ac.bris.cs.databases.api.ForumSummaryView;
import uk.ac.bris.cs.databases.api.Result;

/**
* The normal forums handler (reduced info).
 * path: /forums
 * 
 * @author csxdb
 */
public class ForumsHandler extends SimpleHandler {

    @Override
    RenderPair simpleRender(String p) throws RenderException {
        APIProvider api = ApplicationContext.getInstance().getApi();
        Result<List<ForumSummaryView>> r = api.getForums();
        return new RenderPair("ForumsView.ftl", ListWrapper.wrap(r));
    }

    @Override boolean needsParameter() { return false; }
}
