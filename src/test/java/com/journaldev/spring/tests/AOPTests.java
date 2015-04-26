package com.journaldev.spring.tests;

import com.journaldev.spring.SpringTestBase;
import org.junit.Assert;
import org.junit.Test;

public class AOPTests extends SpringTestBase
{
    @Test(expected=RuntimeException.class)
    public void testThrowRuntimeException() {
        employeeService.getEmployee().throwException();
    }

    @Test
    public void testGetDefaultName() {
        String stubDefaultName = employeeService.getEmployee().getName();
        System.out.println("Default name=" + employeeService.getEmployee().getName());
        Assert.assertEquals("", "Dummy Name", stubDefaultName);
    }

    @Test
    public void testSetName() {
        String stubNewName = "John Smith";
        employeeService.getEmployee().setName(stubNewName);
        String retrievedName = employeeService.getEmployee().getName();
        System.out.println("Test name=" + retrievedName);
        Assert.assertEquals("Verify name can be changed to '" + stubNewName + "'.", stubNewName, retrievedName);
    }
}