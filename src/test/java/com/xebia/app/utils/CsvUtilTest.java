package com.xebia.app.utils;

import com.xebia.app.models.Customer;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CsvUtilTest extends TestCase {
    CsvUtil csvUtil = new CsvUtil("customers.csv");

    @Test
    public void shouldReadCustomersCsvToCreateCustomerList(){
        List<Customer> customers = null;
        try {
            customers = csvUtil.read();
        }catch (Exception e){

        }
        assertEquals(customers.get(0).getFirstName(), "Amit");
    }

}