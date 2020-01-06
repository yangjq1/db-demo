package app.demo.product.web;

import app.demo.api.ProductWebService;
import app.demo.api.product.EditProductRequest;
import app.demo.api.product.ProductView;
import app.demo.product.service.ProductService;
import core.framework.inject.Inject;
import core.framework.log.ActionLogContext;

/**
 * @author Else
 */
public class ProductWebServiceImpl implements ProductWebService {
    @Inject
    ProductService productService;

    @Override
    public ProductView get(String id) {
        return productService.get(id);
    }

    @Override
    public ProductView create(EditProductRequest request) {
        ActionLogContext.put("productName", request.name);
        return productService.create(request);
    }

    @Override
    public ProductView update(String id, EditProductRequest request) {
        ActionLogContext.put("productId", id);
        ActionLogContext.put("productName", request.name);
        return productService.update(id, request);
    }

    @Override
    public void delete(String id) {
        productService.delete(id);
    }
}
