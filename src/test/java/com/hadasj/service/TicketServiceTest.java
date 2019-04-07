package com.hadasj.service;

import com.hadasj.dao.impl.TicketDaoImpl;
import com.hadasj.entity.Ticket;
import com.hadasj.service.impl.TicketServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class TicketServiceTest {

    @Mock
    private TicketDaoImpl ticketDao;

    @InjectMocks
    private TicketServiceImpl service;

    @Test
    public void generateWithEmptyQueueTest() {
        when(ticketDao.next()).thenReturn(6L);

        Ticket result = service.create();

        assertNotNull(result);
        assertNotNull(result.getId());
        assertEquals(6, result.getId().longValue());
        assertNotNull(result.getCreateTime());
        assertEquals(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS), result.getCreateTime().truncatedTo(ChronoUnit.SECONDS));
        assertNotNull(result.getOrder());
        assertEquals(1, result.getOrder().longValue());
    }

    @Test
    public void generateWithNonEmptyQueueTest() {
        when(ticketDao.next()).thenReturn(7L);
        Ticket last = new Ticket();
        last.setOrder(1L);
        when(ticketDao.getLast()).thenReturn(Optional.of(last));

        Ticket result = service.create();

        assertNotNull(result);
        assertNotNull(result.getId());
        assertEquals(7, result.getId().longValue());
        assertNotNull(result.getCreateTime());
        assertEquals(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS), result.getCreateTime().truncatedTo(ChronoUnit.SECONDS));
        assertNotNull(result.getOrder());
        assertEquals(2, result.getOrder().longValue());
    }

    @Test
    public void getFromEmptyQueueTest() {
        Optional<Ticket> actual = service.getActual();

        assertNotNull(actual);
        assertFalse(actual.isPresent());
    }

    @Test
    public void getFromNonEmptyQueueTest() {
        Ticket first = new Ticket();
        first.setId(8L);
        first.setCreateTime(LocalDateTime.now());
        first.setOrder(3L);
        when(ticketDao.getFirst()).thenReturn(Optional.of(first));

        Optional<Ticket> actual = service.getActual();

        assertNotNull(actual);
        assertTrue(actual.isPresent());
        assertEquals(8, actual.get().getId().longValue());
        assertNotNull(actual.get().getCreateTime());
        assertEquals(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS), actual.get().getCreateTime().truncatedTo(ChronoUnit.SECONDS));
        assertNotNull(actual.get().getOrder());
        assertEquals(3, actual.get().getOrder().longValue());
    }

    @Test
    public void deleteTest() {
        Ticket last = new Ticket();
        last.setId(5L);
        when(ticketDao.getLast()).thenReturn(Optional.of(last));

        service.deleteLast();

        verify(ticketDao).delete(5);
    }
}
