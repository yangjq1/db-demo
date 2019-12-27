package app.demo.api.order;

import core.framework.api.json.Property;
import core.framework.db.Column;

import java.time.LocalDateTime;

/**
 * @author Else
 */
public class OrderView {
    @Property(name = "id")
    @Column(name = "id")
    public Long id;

    @Property(name = "customer_id")
    @Column(name = "customer_id")
    public Long customerId;

    @Property(name = "description")
    @Column(name = "description")
    public String description;

    @Property(name = "created_time")
    @Column(name = "created_time")
    public LocalDateTime createdTime;

    @Property(name = "email")
    @Column(name = "email")
    public String email;
}
