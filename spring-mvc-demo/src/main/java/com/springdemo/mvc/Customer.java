package com.springdemo.mvc;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Customer {

    private String firstName;
    //not null message for InitBinder in the CustomerController or he will write - must not null
    @NotNull(message = "is required from @NotNull")
    @Size(min = 1, message = "is required from @Size")
    private String lastName;

    @Min(value = 0,message = "must be greater than or equal to zero")
    @Max(value = 10,message = "must be less than or equal to 10")
    private String freePasses;

    public String getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(String freePasses) {
        this.freePasses = freePasses;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
