package com.orangehrm.automation;

import org.checkerframework.checker.units.qual.Acceleration;
import   org.testng.annotations.*;
public class TaskTest {

    @BeforeGroups(groups = "sanity")
    public void beforesanitygroups()
    {
       System.out.println("this is before sanity groups methods");
    }

    @BeforeGroups(groups = "regression")
    public void beforeregressiongroup()
    {
        System.out.println("this is regression groups methods");
    }

    @BeforeSuite(groups = "regression")
        public void beforesuite()
        {
            System.out.println("this is before suite method");
        }

        @BeforeTest(groups = "regression")
        public void beforetest()
        {
            System.out.println("before test method");
        }

        @AfterTest(groups = "regression")
    public void aftertest()
        {
            System.out.println("this is a after test method");
        }

        @AfterSuite(groups = "regression")
    public void aftersuite()
        {
            System.out.println("this is a after suite method'");
        }

        @BeforeMethod(groups = "regression")
    public void beforemethod()
        {
            System.out.println("this is beforemethod");
        }

        @AfterMethod(groups = "regression")
    public void aftermethod()
        {
            System.out.println("this is a after meethod");
        }
          @BeforeClass(groups = "regression")
    public void beforeclass()
          {
              System.out.println("this is a beforre class method");
          }
        @AfterClass(groups = "regression")
    public void afterclass()
        {
            System.out.println("this is a after class method");
        }
       @Test(groups = "regression")
         public  void test()
       {
           System.out.println("this is  test .........  method ");
       }
       @Test (groups = {"sanity","regression"})
    public void test1()
       {
           System.out.println("this is test1......... method ");
       }
    }


