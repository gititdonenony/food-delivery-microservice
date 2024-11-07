package com.food_delivery_app.service;

import com.food_delivery_app.dto.CustomerRequest;
import com.food_delivery_app.dto.CustomerResponse;

import java.util.List;

public interface CustomerService {
    CustomerResponse createCustomer(CustomerRequest request);

    CustomerResponse getCustomerById(String id);

    List<CustomerResponse> getAllCustomers();

    CustomerResponse updateCustomer(String id, CustomerRequest request);

    void deleteCustomer(String id);
}
