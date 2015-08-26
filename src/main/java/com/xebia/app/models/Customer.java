package com.xebia.app.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Customer implements Serializable{

    @Id
    @JsonProperty("id")
    private String id;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;

    public Customer(String firstName, String lastName){
        this.id = "1";
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
