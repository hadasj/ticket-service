package com.hadasj.service;

import com.hadasj.Application;
import com.hadasj.entity.Ticket;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class TicketServiceTest {

    @Autowired
    private TicketService service;

    @Test
    public void generateTest() {
        Ticket result = service.generate();

        assertNotNull(result);
        assertNotNull(result.getId());
        assertNotNull(result.getCreateTime());
        assertNotNull(result.getOrder());
    }
}
