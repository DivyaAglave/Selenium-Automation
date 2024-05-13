package com.orangehrm.automation;

public class AutomationTesting {
    public void main(String[] args)
    {
        SoftWareTesting testing = (var1,var2)-> {
            System.out.println("this is  selenium method");
                  return  "Returned value";

        };
        System.out.println(testing.selenium("java",2));

    }
}
