package uk.ac.bris.cs.databases.web;

import java.util.List;
import uk.ac.bris.cs.databases.api.APIProvider;
import uk.ac.bris.cs.databases.api.AdvancedForumSummaryView;
import uk.ac.bris.cs.databases.api.Result;

/**
 * Advanced view of forums.
 * path: /forums2
 * 
 * @author csxdb
 */
public class AdvancedForumsHandler extends SimpleHandler {

    @Override
    SimpleHandler.RenderPair simpleRender(String p) throws RenderException {
        APIProvider api = ApplicationContext.getInstance().getApi();
        Result<List<AdvancedForumSummaryView>> r = api.getAdvancedForums();
        return new SimpleHandler.RenderPair("AdvancedForumsView.ftl", ListWrapper.wrap(r));
    }

    @Override boolean needsParameter() { return false; }
}
