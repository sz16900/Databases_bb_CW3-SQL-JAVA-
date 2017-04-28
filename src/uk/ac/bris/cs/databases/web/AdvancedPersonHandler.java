package uk.ac.bris.cs.databases.web;

import uk.ac.bris.cs.databases.api.APIProvider;
import uk.ac.bris.cs.databases.api.AdvancedPersonView;
import uk.ac.bris.cs.databases.api.Result;

/**
 * Advanced version of the person handler.
 * PATH /person2/:id
 * @author csxdb
 */
public class AdvancedPersonHandler extends SimpleHandler {

    @Override
    RenderPair simpleRender(String p) throws RenderException {
        APIProvider api = ApplicationContext.getInstance().getApi();
        Result<AdvancedPersonView> r = api.getAdvancedPersonView(p);
        return new RenderPair("AdvancedPersonView.ftl", r);
    }
} 
