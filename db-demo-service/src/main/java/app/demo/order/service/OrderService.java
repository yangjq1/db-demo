package app.demo.order.service;

import app.demo.api.order.EditOrderRequest;
import app.demo.api.order.OrderView;
import app.demo.order.domain.Order;
import core.framework.db.Database;
import core.framework.db.Repository;
import core.framework.db.Transaction;
import core.framework.inject.Inject;

import java.time.LocalDateTime;

/**
 * @author Else
 */
public class OrderService {
    @Inject
    Database database;
    @Inject
    Repository<Order> orderRepository;

    public OrderView create(EditOrderRequest request){
        Order order = new Order();
        order.createdTime = LocalDateTime.now();
        order.customerId = request.customerId;
        order.description = request.description;
        try (Transaction transaction = database.beginTransaction()) {
            order.id = orderRepository.insert(order).orElseThrow();
            transaction.commit();
        }
        return view(order);
    }

    private OrderView view(Order order) {
        OrderView view = new OrderView();
        view.createdTime = order.createdTime;
        view.customerId = order.customerId;
        view.description = order.description;
        view.id = order.id;
        return view;
    }


}
