package com.jackson.json.demo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.Arrays;

public class Driver {
    public static void main(String[] args) {

        try {
            //create object mapper
            ObjectMapper mapper =  new ObjectMapper();
            //read json file and map/convert to java POJO
            // data/sample-lite.json
            Student student = mapper.readValue(new File("data/sample-full.json"), Student.class);

            //print first last name
            System.out.println(student.getFirstName());
            System.out.println(student.getLastName());

            //print adress
            Address address = student.getAddress();
            System.out.println("street= " + address.getStreet());
            System.out.println("city= " + address.getCity());

            //print languages
            System.out.println("languages: ");
            Arrays.stream(student.getLanguages()).forEach(System.out::println);

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
