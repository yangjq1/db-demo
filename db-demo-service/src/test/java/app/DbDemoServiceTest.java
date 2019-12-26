package app;

import app.demo.api.customer.CreateCustomerRequest;
import app.demo.api.customer.CustomerView;
import app.demo.customer.service.CustomerService;
import core.framework.inject.Inject;
import org.junit.jupiter.api.Test;


/**
 * @author neo
 */
class DbDemoServiceTest extends IntegrationTest {

    @Inject
    CustomerService customerService;

    @Test
    void create() {
        CreateCustomerRequest request = new CreateCustomerRequest();
        request.email = "else@changtuo.com";
        request.fistName = "y";
        request.lastName = "jin";
        customerService.create(request);

    }

    @Test
    void get() {
       CustomerView customer = customerService.get(1l);
       System.out.println(customer.email);
    }
}
