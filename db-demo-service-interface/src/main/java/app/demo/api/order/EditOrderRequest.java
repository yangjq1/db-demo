package app.demo.api.order;

import core.framework.api.validate.NotNull;
import core.framework.db.Column;

/**
 * @author Else
 */
public class EditOrderRequest {
    @NotNull
    @Column(name = "customer_id")
    public Long customerId;

    @Column(name = "description")
    public String description;
}
