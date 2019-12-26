package app.demo.api;

import app.demo.api.product.EditProductRequest;
import app.demo.api.product.ProductView;
import core.framework.api.http.HTTPStatus;
import core.framework.api.web.service.DELETE;
import core.framework.api.web.service.GET;
import core.framework.api.web.service.POST;
import core.framework.api.web.service.PUT;
import core.framework.api.web.service.Path;
import core.framework.api.web.service.PathParam;
import core.framework.api.web.service.ResponseStatus;

/**
 * @author Else
 */
public interface ProductWebService {
    @GET
    @Path("/product/:id")
    ProductView get(@PathParam("id") String id);

    @POST
    @Path("/product")
    @ResponseStatus(HTTPStatus.CREATED)
    ProductView create(EditProductRequest request);

    @PUT
    @Path("/product/:id")
    ProductView update(@PathParam("id") String id,EditProductRequest request);

    @DELETE
    @Path("/product/:id")
    void delete(@PathParam("id") String id);

}
