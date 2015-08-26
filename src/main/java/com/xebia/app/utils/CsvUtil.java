package com.xebia.app.utils;


import com.xebia.app.models.Customer;
import lombok.AllArgsConstructor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class CsvUtil {

    private String csvName;

    public List<Customer> read()throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("src//main//resources//"+csvName));
        String line = null;
        List<Customer> customers = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            Customer c = new Customer(data[0],data[1]);
            customers.add(c);
        }
        return customers;
    }

    public static void main(String []a) throws Exception{
        CsvUtil c = new CsvUtil("customers.csv");
        List<Customer> customers = c.read();
        System.out.println(customers);
    }
}
