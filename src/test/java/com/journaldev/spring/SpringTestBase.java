package com.journaldev.spring;

import org.junit.After;
import org.junit.Before;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.journaldev.spring.service.EmployeeService;

public class SpringTestBase
{
    protected ClassPathXmlApplicationContext ctx;
    protected EmployeeService employeeService;

    @Before
    public void setUp()
    {
        ctx = new ClassPathXmlApplicationContext("spring.xml");
        employeeService = ctx.getBean("employeeService", EmployeeService.class);
    }

    @After
    public void tearDown()
    {
        ctx.close();
    }

}