package app.demo.customer.web;

import app.demo.api.CustomerWebService;
import app.demo.api.customer.CreateCustomerRequest;
import app.demo.api.customer.CustomerView;
import app.demo.api.customer.SearchCustomerRequest;
import app.demo.api.customer.SearchCustomerResponse;
import app.demo.api.customer.UpdateCustomerRequest;
import app.demo.customer.service.CustomerService;
import core.framework.inject.Inject;
import core.framework.log.ActionLogContext;

/**
 * @author Else
 */
public class CustomerWebServiceImpl implements CustomerWebService {
    @Inject
    CustomerService customerService;

    @Override
    public CustomerView get(Long id) {
        return customerService.get(id);
    }

    @Override
    public CustomerView create(CreateCustomerRequest request) {
        ActionLogContext.put("email", request.email);
        ActionLogContext.put("fistName", request.fistName);
        ActionLogContext.put("lastName", request.lastName);
        return customerService.create(request);
    }

    @Override
    public CustomerView update(Long id, UpdateCustomerRequest request) {
        ActionLogContext.put("customerId", request.fistName);
        ActionLogContext.put("fistName", request.fistName);
        ActionLogContext.put("lastName", request.lastName);
        return customerService.update(id, request);
    }

    @Override
    public void delete(Long id) {
        ActionLogContext.put("customerId", id);
        customerService.delete(id);
    }

    @Override
    public SearchCustomerResponse search(SearchCustomerRequest request) {
        return customerService.search(request);
    }
}
