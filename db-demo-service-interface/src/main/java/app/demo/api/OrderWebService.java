package app.demo.api;

import app.demo.api.order.EditOrderRequest;
import app.demo.api.order.OrderView;
import core.framework.api.web.service.POST;
import core.framework.api.web.service.Path;

/**
 * @author Else
 */
public interface OrderWebService {

//    @POST
//    @Path("/order")
//    OrderView create(EditOrderRequest request);
    @POST
    @Path("/order")
    OrderView create();
}
