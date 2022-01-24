package com.asint.javap1_beans;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
        PropertyDescriptor[] names = PropertyUtils.getPropertyDescriptors(TypicalPOJOPerson.class);
        
        List<String> dispNames = new ArrayList<String>();
        
        for (PropertyDescriptor name: names) {
        	dispNames.add(name.getName());
        }
        
        System.out.println(dispNames);
        
        names = PropertyUtils.getPropertyDescriptors(TypicalBeanPerson.class);
        
        dispNames = new ArrayList<String>();
        
        for (PropertyDescriptor name: names) {
        	dispNames.add(name.getName());
        }
        
        System.out.println(dispNames);
    }
}