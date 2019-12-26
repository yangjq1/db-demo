package app.demo.product.service;

import app.demo.api.product.EditProductRequest;
import app.demo.api.product.ProductView;
import app.demo.product.domain.Product;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import core.framework.inject.Inject;
import core.framework.mongo.MongoCollection;
import core.framework.web.exception.NotFoundException;

import java.time.ZonedDateTime;
import java.util.UUID;

/**
 * @author Else
 */
public class ProductService {
    @Inject
    MongoCollection<Product> collection;

    public ProductView create(EditProductRequest request) {
        Product product = new Product();
        product.name = request.name;
        product.createdTime = ZonedDateTime.now();
        product.id = UUID.randomUUID().toString();
        collection.insert(product);
        return view(product);
    }

    public ProductView get(String id) {
        Product product = collection.get(id).orElseThrow(()-> new NotFoundException("product not found,id=" + id));
        return view(product);
    }

    public ProductView replace(String id,EditProductRequest request){
        Product product = new Product();
        product.name = request.name;
        product.id = id;
        product.createdTime = ZonedDateTime.now();
        collection.replace(product);
        return view(product);
    }

    public ProductView update(String id,EditProductRequest request){
        long updatedCount = collection.update(Filters.eq("_id", id), Updates.set("name", request.name));
        if(updatedCount == 0){
            throw new NotFoundException("product not found,id=" + id);
        }
        return get(id);
    }


    public void delete(String id){
        boolean flag = collection.delete(id);
        if(!flag){
            throw new NotFoundException("product not found,id=" + id);
        }
    }

    private ProductView view(Product product) {
        ProductView view = new ProductView();
        view.id = product.id;
        view.name = product.name;
        view.createdTime = product.createdTime;
        return view;
    }
}
