package app.demo.api.product;

import core.framework.api.json.Property;
import core.framework.api.validate.NotBlank;
import core.framework.api.validate.NotNull;
import org.bson.types.ObjectId;

import java.time.ZonedDateTime;

/**
 * @author Else
 */
public class ProductView {
    @NotNull
    @Property(name = "id")
    public String id;

    @NotNull
    @NotBlank
    @Property(name = "name")
    public String name;

    @NotNull
    @Property(name = "created_time")
    public ZonedDateTime createdTime;
}
