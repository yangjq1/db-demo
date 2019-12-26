package app;

import demo.Brush;
import demo.Painter;
import core.framework.module.Module;

/**
 * @author Else
 */
public class DemoModule extends Module {
    @Override
    protected void initialize() {
        bind(Brush.class);
        bind(Painter.class);
        Painter painter = bean(Painter.class);
        painter.draw();
    }
}
