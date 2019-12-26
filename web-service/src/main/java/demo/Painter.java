package demo;

import core.framework.inject.Inject;
import core.framework.log.Markers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Else
 */
public class Painter {
    private final Logger logger = LoggerFactory.getLogger(Painter.class);
    @Inject
    Brush brush;

    public void draw() {
        logger.warn(Markers.errorCode("PAINTER_WARN"), "drawing picture...");
        brush.print();
    }
}
