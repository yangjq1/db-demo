package app.demo.api.order;

import core.framework.api.json.Property;
import core.framework.api.validate.NotNull;
import core.framework.db.Column;
import core.framework.db.PrimaryKey;

import java.time.LocalDateTime;

/**
 * @author Else
 */
public class OrderView {
    @PrimaryKey(autoIncrement = true)
    @Property(name = "id")
    public Long id;

    @NotNull
    @Property(name = "customer_id")
    public Long customerId;

    @Property(name = "description")
    public String description;

    @NotNull
    @Property(name = "created_time")
    public LocalDateTime createdTime;
}
