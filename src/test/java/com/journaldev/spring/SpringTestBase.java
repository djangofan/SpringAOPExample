package com.journaldev.spring;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.journaldev.spring.service.EmployeeService;

public class SpringTestBase
{
    protected ClassPathXmlApplicationContext ctx;
    protected EmployeeService employeeService;

    @BeforeMethod
    public void setUp()
    {
        ctx = new ClassPathXmlApplicationContext("spring.xml");
        employeeService = ctx.getBean("employeeService", EmployeeService.class);
    }

    @AfterMethod
    public void tearDown()
    {
        ctx.close();
    }
}