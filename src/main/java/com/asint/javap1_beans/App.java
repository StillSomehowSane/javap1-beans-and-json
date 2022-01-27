package com.asint.javap1_beans;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args)
    {
        
        Animal doggie = new Animal();
        
        doggie.setId(1);
        doggie.setName("Pupper");
        doggie.setBreed("Husky");
        doggie.setAge(2);
        
        Animal doggo = new Animal();
        
        doggo.setId(2);
        doggo.setName("Missy");
        doggo.setBreed("Golden Retriever");
        doggo.setAge(1);
        
        ObjectMapper mapper = new ObjectMapper();
        
        Animal[] animals = { doggie, doggo };
        
        try {
			String animalsJsonified = mapper.writeValueAsString(animals);
			
			System.out.println(animalsJsonified);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
    }
}