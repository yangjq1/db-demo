package app.demo.order.service;

import app.demo.api.order.EditOrderRequest;
import app.demo.api.order.OrderView;
import app.demo.api.order.SimpleOrderView;
import app.demo.order.domain.Order;
import core.framework.db.Database;
import core.framework.db.Repository;
import core.framework.db.Transaction;
import core.framework.inject.Inject;
import core.framework.web.exception.NotFoundException;

import java.time.LocalDateTime;

/**
 * @author Else
 */
public class OrderService {
    @Inject
    Database database;
    @Inject
    Repository<Order> orderRepository;

    public SimpleOrderView create(EditOrderRequest request) {
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

    public OrderView get(Long id) {
        OrderView orderView = database.selectOne("select o.id,o.description,o.created_time,c.email from orders as o ,customer as c where c.id = o.customer_id and o.id=?", OrderView.class, id)
            .orElseThrow(() -> new NotFoundException("order not found, id = " + id));
        return orderView;
    }

    private SimpleOrderView view(Order order) {
        SimpleOrderView view = new SimpleOrderView();
        view.createdTime = order.createdTime;
        view.customerId = order.customerId;
        view.description = order.description;
        view.id = order.id;
        return view;
    }
}
