package app.demo.order.web;

import app.demo.api.OrderWebService;
import app.demo.api.order.EditOrderRequest;
import app.demo.api.order.OrderView;
import app.demo.api.order.SimpleOrderView;
import app.demo.order.service.OrderService;
import core.framework.inject.Inject;
import core.framework.log.ActionLogContext;

/**
 * @author Else
 */
public class OrderWebServiceImpl implements OrderWebService {
    @Inject
    OrderService orderService;

    @Override
    public SimpleOrderView create(EditOrderRequest request) {
        ActionLogContext.put("customerId", request.customerId);
        return orderService.create(request);
    }

    @Override
    public OrderView get(Long id) {
        return orderService.get(id);
    }
}
