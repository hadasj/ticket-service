package com.hadasj.service;

import com.hadasj.Application;
import com.hadasj.entity.Ticket;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Calendar;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class TicketServiceTest {

    @Autowired
    private TicketService service;

    @Test
    public void generateTest() {
        generate(5);
        Ticket result = service.generate();

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
        // TODO
    }

    private void generate(final int count) {
        for (int i = 0; i < count; i++)
            service.generate();
    }
}
