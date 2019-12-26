package app;

import demo.Brush;
import core.framework.inject.Inject;
import org.junit.jupiter.api.Test;


/**
 * @author neo
 */
class WebserviceTest extends IntegrationTest {
    @Inject
    Brush brush;

    @Test
    void test() {
        brush.print();
    }
}
