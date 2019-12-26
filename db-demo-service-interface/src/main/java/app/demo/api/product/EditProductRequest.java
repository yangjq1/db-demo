package app.demo.api.product;

import core.framework.api.json.Property;
import core.framework.api.validate.NotBlank;
import core.framework.api.validate.NotNull;

/**
 * @author Else
 */
public class EditProductRequest {
    @NotNull
    @NotBlank
    @Property(name = "name")
    public String name;
}
