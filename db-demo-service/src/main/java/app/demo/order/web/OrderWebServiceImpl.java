package app.demo.order.web;

import app.demo.api.OrderWebService;
import app.demo.api.order.EditOrderRequest;
import app.demo.api.order.OrderView;
import app.demo.order.service.OrderService;
import core.framework.inject.Inject;

/**
 * @author Else
 */
public class OrderWebServiceImpl implements OrderWebService {
    @Inject
    OrderService orderService;

//    @Override
//    public OrderView create(EditOrderRequest request) {
//        return orderService.create(request);
//    }

    @Override
    public OrderView create() {
        EditOrderRequest request = new EditOrderRequest();
        request.customerId = 2L;
        request.description ="hello world";
        return orderService.create(request);
    }
}
