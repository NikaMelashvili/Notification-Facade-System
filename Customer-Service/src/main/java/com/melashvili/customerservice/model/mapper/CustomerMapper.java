package com.melashvili.customerservice.model.mapper;

import com.melashvili.customerservice.model.dto.request.CustomerRequest;
import com.melashvili.customerservice.model.dto.response.CustomerResponse;
import com.melashvili.customerservice.model.entities.Customer;

public class CustomerMapper {
    public static Customer toCustomer(CustomerRequest request) {
        Customer customer = new Customer();

        customer.setFirstName(request.getFirstName());
        customer.setLastName(request.getLastName());
        customer.setEmail(request.getEmail());
        customer.setPhone(request.getPhone());
        customer.setAddress(request.getAddress());

        return customer;
    }

    public static CustomerResponse toCustomerRequest(Customer customer) {
        CustomerResponse response = new CustomerResponse();

        response.setCustomerId(customer.getId());
        response.setFirstName(customer.getFirstName());
        response.setLastName(customer.getLastName());
        response.setEmail(customer.getEmail());
        response.setPhone(customer.getPhone());
        response.setAddress(customer.getAddress());

        return response;
    }
}
