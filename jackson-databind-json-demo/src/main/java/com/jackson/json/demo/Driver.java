package com.jackson.json.demo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

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

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
