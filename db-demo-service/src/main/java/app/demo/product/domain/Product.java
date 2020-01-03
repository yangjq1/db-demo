package app.demo.product.domain;

import core.framework.mongo.Collection;
import core.framework.mongo.Field;
import core.framework.mongo.Id;

import java.time.ZonedDateTime;

/**
 * @author Else
 */
@Collection(name = "products")
public class Product {
    @Id
    public String id;

    @Field(name = "name")
    public String name;

    @Field(name = "desc")
    public String desc;

    @Field(name = "pno")
    public String pno;

    @Field(name = "created_time")
    public ZonedDateTime createdTime;
}
