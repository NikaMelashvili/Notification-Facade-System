package com.melashvili.userend.service;

import com.melashvili.userend.model.dto.request.CustomerRequest;
import com.melashvili.userend.model.entitites.Customer;
import com.melashvili.userend.model.mapper.CustomerMapper;
import com.melashvili.userend.repository.CustomerRepository;
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
