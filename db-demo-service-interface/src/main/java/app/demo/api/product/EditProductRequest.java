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

    @NotBlank
    @Property(name = "desc")
    public String desc;

    @NotNull
    @NotBlank
    @Property(name = "pno")
    public String pno;
}
