package app.demo.api.customer;

import core.framework.api.json.Property;
import core.framework.api.validate.NotBlank;
import core.framework.api.validate.NotNull;

/**
 * @author Else
 */
public class UpdateCustomerRequest {
    @NotNull
    @NotBlank
    @Property(name = "first_name")
    public String fistName;

    @NotNull
    @NotBlank
    @Property(name = "last_name")
    public  String lastName;
}
