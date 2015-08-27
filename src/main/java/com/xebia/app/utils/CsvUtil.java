package com.xebia.app.utils;


import com.xebia.app.exceptions.CustomerNotFoundException;
import com.xebia.app.models.Customer;
import lombok.AllArgsConstructor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class CsvUtil {

    private String csvName;

    public List<Customer> read()throws IOException, CustomerNotFoundException{
        BufferedReader br = new BufferedReader(new FileReader("src//main//resources//"+csvName));
        String line = null;
        List<Customer> customers = new ArrayList<>();
        String[] data = null;
        while ((line = br.readLine()) != null) {
            try {
                 data = line.split(",");
            }catch (ArrayIndexOutOfBoundsException e){
                throw new CustomerNotFoundException("no records found in the csv");
            }
            Customer c = new Customer(data[0],data[1]);
            customers.add(c);
        }
        return customers;
    }
}
