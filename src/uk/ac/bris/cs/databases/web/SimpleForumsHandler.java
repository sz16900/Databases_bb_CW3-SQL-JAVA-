package uk.ac.bris.cs.databases.web;

import java.util.List;
import uk.ac.bris.cs.databases.api.APIProvider;
import uk.ac.bris.cs.databases.api.Result;
import uk.ac.bris.cs.databases.api.SimpleForumSummaryView;

/**
* The simplified forums handler (no topic info at all).
 * path: /forums0
 * 
 * @author csxdb
 */
public class SimpleForumsHandler extends SimpleHandler {

    @Override
    RenderPair simpleRender(String p) throws RenderException {
        APIProvider api = ApplicationContext.getInstance().getApi();
        Result<List<SimpleForumSummaryView>> r = api.getSimpleForums();
        return new RenderPair("SimpleForumsView.ftl", ListWrapper.wrap(r));
    }

    @Override boolean needsParameter() { return false; }
}
