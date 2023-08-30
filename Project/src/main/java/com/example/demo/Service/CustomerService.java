package com.example.demo.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Customer;
import com.example.demo.repository.CustomerRepo;



@Service
public class CustomerService {
    @Autowired
    private CustomerRepo crepo;

    public List<Customer> getAllCustomers() {
        return crepo.findAll();
    }

    public Customer getCustomerById(long id) {
        return crepo.findById(id).orElse(null);
    }

    public Customer saveCustomer(Customer customer) {
        return crepo.save(customer);
    }

    public Customer updateCustomer(long id, Customer updatedCustomer) {
        Customer existingCustomer = crepo.findById(id).orElse(null);
        if (existingCustomer != null) {
            existingCustomer.setFirstName(updatedCustomer.getFirstName());
            existingCustomer.setLastName(updatedCustomer.getLastName());
            existingCustomer.setEmail(updatedCustomer.getEmail());
            return crepo.save(existingCustomer);
        }
        return null;
    }

    public void deleteCustomer(long id) {
        crepo.deleteById(id);
    }

    public List<Customer> sortCustomersByAsc(String firstName) {
        return crepo.findAll(Sort.by(firstName).ascending());
    }

    
}