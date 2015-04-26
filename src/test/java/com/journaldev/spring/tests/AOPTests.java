package com.journaldev.spring.tests;

import com.journaldev.spring.SpringTestBase;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class AOPTests extends SpringTestBase
{
    @Test(expectedExceptions=RuntimeException.class)
    public void testThrowRuntimeException() {
        Reporter.log("Testing an exception thrown from Employee...");
        employeeService.getEmployee().throwException();
    }

    @Test
    public void testGetDefaultName() {
        String stubDefaultName = employeeService.getEmployee().getName();
        Reporter.log("The value of the default name is '" + employeeService.getEmployee().getName() + "'.");
        Assert.assertEquals("Dummy Name", stubDefaultName, "The default Employee name was not '" + stubDefaultName + "'.");
    }

    @Test
    public void testSetName() {
        String stubNewName = "John Smith";
        employeeService.getEmployee().setName(stubNewName);
        String retrievedName = employeeService.getEmployee().getName();
        Reporter.log("Value of name after setting Employee name is '" + retrievedName + "'.");
        Assert.assertEquals(stubNewName, retrievedName, "The Employee name could not be changed to '" + stubNewName + "'.");
    }
}