package com.melashvili.customerservice.services;

import com.melashvili.customerservice.model.dto.request.CustomerRequest;
import com.melashvili.customerservice.model.entities.Customer;
import com.melashvili.customerservice.model.mapper.CustomerMapper;
import com.melashvili.customerservice.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void addCustomer(CustomerRequest request) {
        Customer customer = CustomerMapper.toCustomer(request);
        customerRepository.save(customer);
    }

    public void updateCustomer(CustomerRequest request) {
        Customer customer = CustomerMapper.toCustomer(request);
        customerRepository.save(customer);
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
