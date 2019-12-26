package app.demo.product.web;

import app.demo.api.ProductWebService;
import app.demo.api.product.EditProductRequest;
import app.demo.api.product.ProductView;
import app.demo.product.service.ProductService;
import core.framework.inject.Inject;

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
        return productService.create(request);
    }

//    @Override
//    public ProductView replace( String id) {
//        EditProductRequest request = new EditProductRequest();
//        request.name = "world";
//        return productService.replace(id,request);
//    }

    @Override
    public ProductView update(String id, EditProductRequest request) {
        return productService.update(id, request);
    }

    @Override
    public void delete(String id) {
        productService.delete(id);
    }
}
