package app.demo;

import app.demo.api.OrderWebService;
import app.demo.order.domain.Order;
import app.demo.order.service.OrderService;
import app.demo.order.web.OrderWebServiceImpl;
import core.framework.module.Module;

/**
 * @author Else
 */
public class OrderModule extends Module {

    @Override
    protected void initialize() {
        db().repository(Order.class);
        bind(OrderService.class);
        api().service(OrderWebService.class, bind(OrderWebServiceImpl.class));
    }
}
