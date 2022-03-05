package com.test.orangehrm;

import org.testng.annotations.DataProvider;

public class DataLoginIn {
   @DataProvider(name="LoginTest")
    public Object[][] getData(){
       return new Object[][]{
               {"Admin","wrongPassword","Invalid credentials"},
               {"wrongUsername","admin123","Invalid credentials"},
               {"wrongUsername","wrongPassword","Invalid credentials"}

       };
   }
}
