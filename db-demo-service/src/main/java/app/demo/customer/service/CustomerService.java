package app.demo.customer.service;

import app.demo.api.customer.CreateCustomerRequest;
import app.demo.api.customer.CustomerView;
import app.demo.api.customer.SearchCustomerRequest;
import app.demo.api.customer.SearchCustomerResponse;
import app.demo.api.customer.UpdateCustomerRequest;
import app.demo.customer.domain.Customer;
import app.demo.customer.domain.CustomerStatus;
import core.framework.db.Query;
import core.framework.db.Repository;
import core.framework.inject.Inject;
import core.framework.util.Strings;
import core.framework.web.exception.ConflictException;
import core.framework.web.exception.NotFoundException;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Else
 */
public class CustomerService {
    @Inject
    Repository<Customer> customerRepository;

    public SearchCustomerResponse search(SearchCustomerRequest request) {
        SearchCustomerResponse response = new SearchCustomerResponse();
        Query<Customer> query = customerRepository.select();
        query.skip(request.skip);
        query.limit(request.limit);
        if (!Strings.isBlank(request.email)) {
            query.where("email = ?", request.email);
        }
        if (!Strings.isBlank(request.firstName)) {
            query.where("first_name like ?", Strings.format("%{}%", request.firstName));
        }
        if (!Strings.isBlank(request.lastName)) {
            query.where("last_name like ?", Strings.format("" + "%{}%", request.lastName));
        }
        response.customers = query.fetch().stream().map(item -> view(item)).collect(Collectors.toList());
        response.total = query.count();
        return response;
    }

    public CustomerView get(Long id) {
        Customer customer = customerRepository.get(id).orElseThrow(() -> new NotFoundException("customer not found,id=" + id));
        return view(customer);
    }

    public CustomerView create(CreateCustomerRequest request) {
        Optional<Customer> dbCustomer = customerRepository.selectOne("email = ?", request.email);
        if (dbCustomer.isPresent()) {
            throw new ConflictException("customer already exists, email=" + request.email);
        }

        Customer customer = new Customer();
        customer.status = CustomerStatus.ACTIVE;
        customer.email = request.email;
        customer.firstName = request.fistName;
        customer.lastName = request.lastName;
        customer.updatedTime = LocalDateTime.now();
        customer.id = customerRepository.insert(customer).orElseThrow();

        return view(customer);
    }

    public CustomerView update(Long id, UpdateCustomerRequest request) {
        Customer customer = customerRepository.get(id).orElseThrow(() -> new NotFoundException("customer not found,id=" + id));
        customer.updatedTime = LocalDateTime.now();
        customer.lastName = request.lastName;
        customer.firstName = request.fistName;
        customerRepository.partialUpdate(customer);
        return view(customer);
    }

    public void delete(Long id) {
        customerRepository.delete(id);
    }

    public CustomerView view(Customer customer) {
        CustomerView view = new CustomerView();
        view.id = customer.id;
        view.email = customer.email;
        view.firstName = customer.firstName;
        view.lastName = customer.lastName;
        view.updatedTime = customer.updatedTime;
        return view;
    }


}
