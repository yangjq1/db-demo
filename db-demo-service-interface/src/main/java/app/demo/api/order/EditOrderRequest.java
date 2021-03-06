package app.demo.api.order;

import core.framework.api.json.Property;
import core.framework.api.validate.NotNull;

/**
 * @author Else
 */
public class EditOrderRequest {
    @NotNull
    @Property(name = "customer_id")
    public Long customerId;

    @Property(name = "description")
    public String description;
}
