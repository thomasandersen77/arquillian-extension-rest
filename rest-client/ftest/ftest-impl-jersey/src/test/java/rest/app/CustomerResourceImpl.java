/*
 * JBoss, Home of Professional Open Source
 * Copyright 2011 Red Hat Inc. and/or its affiliates and other contributors
 * as indicated by the @authors tag. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package rest.app;

import rest.app.model.Customer;

import javax.ws.rs.PathParam;
import java.util.Arrays;
import java.util.List;

/**
 * A REST service for retrieving Customer records
 */
public class CustomerResourceImpl implements CustomerResource {

    @Override
    public List<Customer> getAllCustomers()
    {
        return findAllCustomers();
    }

    /**
     * This method responds to a GET request that supports the content type application/xml or application/json and returns the
     * requested customer resource.
     * <p/>
     * <p>
     * The customer is retrieved by id. A representation of the customer is then written into the response in the requested
     * format. The id value is taken from the final path segment.
     * </p>
     * <p/>
     * <a class="citation" href= "javacode://com.acme.jaxrs.CustomerResource#getCustomerById(long)" />
     */
    @Override
    public Customer getCustomerById(@PathParam("id") long id)
    {
        System.out.println("Handling resource request for /customer/" + id);
        return findCustomerById(id);
    }

    @Override
    public Customer createCustomer(Customer customer)
    {
        customer.setId(777L);
        return customer;
    }

    private List<Customer> findAllCustomers()
    {
        return Arrays.asList(new Customer("Jack"), new Customer("Ron"));
    }

    private Customer findCustomerById(long id)
    {
        final Customer customer = new Customer("Acme Corporation");
        customer.setId(id);
        return customer;
    }
}
