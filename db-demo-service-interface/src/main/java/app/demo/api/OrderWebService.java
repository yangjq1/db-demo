package app.demo.api;

import app.demo.api.order.EditOrderRequest;
import app.demo.api.order.OrderView;
import app.demo.api.order.SimpleOrderView;
import core.framework.api.web.service.GET;
import core.framework.api.web.service.POST;
import core.framework.api.web.service.Path;
import core.framework.api.web.service.PathParam;

/**
 * @author Else
 */
public interface OrderWebService {

    @POST
    @Path("/order")
    SimpleOrderView create(EditOrderRequest request);

    @GET
    @Path("/order/:id")
    OrderView get(@PathParam("id") Long id);
}
