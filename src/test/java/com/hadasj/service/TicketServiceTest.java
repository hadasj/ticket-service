package com.hadasj.service;

import com.hadasj.Application;
import com.hadasj.dao.impl.TicketDaoImpl;
import com.hadasj.entity.Ticket;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class TicketServiceTest {

    // TODO: mock dao
    @Autowired
    private TicketService service;

    @Autowired
    private TicketDaoImpl ticketDao;

    @Before
    public void setUp() {
        ticketDao.init();
    }

    @Test
    public void generateTest() {
        generate(5);
        Ticket result = service.create();

        assertNotNull(result);
        assertNotNull(result.getId());
        assertEquals(6, result.getId().longValue());
        assertNotNull(result.getCreateTime());
        assertEquals(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS), result.getCreateTime().truncatedTo(ChronoUnit.SECONDS));
        assertNotNull(result.getOrder());
        assertEquals(6, result.getOrder().longValue());
    }

    @Test
    public void getTest() {
        generate(4);

        Optional<Ticket> actual = service.getActual();
        assertNotNull(actual);
        assertTrue(actual.isPresent());
        assertEquals(1, actual.get().getId().longValue());
        assertNotNull(actual.get().getCreateTime());
        assertEquals(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS), actual.get().getCreateTime().truncatedTo(ChronoUnit.SECONDS));
        assertNotNull(actual.get().getOrder());
        assertEquals(1, actual.get().getOrder().longValue());
    }

    @Test
    public void deleteTest() {
        generate(1);

        Optional<Ticket> actual = service.getActual();
        assertNotNull(actual);
        assertTrue(actual.isPresent());

        service.deleteLast();
        actual = service.getActual();
        assertNotNull(actual);
        assertFalse(actual.isPresent());
    }

    private void generate(final int count) {
        for (int i = 0; i < count; i++)
            service.create();
    }
}
