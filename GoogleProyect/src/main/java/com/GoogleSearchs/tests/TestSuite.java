package com.GoogleSearchs.tests;

import org.junit.jupiter.api.Test;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;

public class TestSuite {


    @org.testng.annotations.Test
    public void testTestNGProgramatically(){
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        testng.setTestClasses(new Class[] {GoogleSearchTests.class, HomePageTests.class});
        testng.addListener(tla);
        testng.run();
    }
}
