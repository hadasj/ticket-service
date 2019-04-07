package com.hadasj.service.impl;

import com.hadasj.dao.TicketDao;
import com.hadasj.entity.Ticket;
import com.hadasj.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Transactional
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketDao ticketDao;

    @Override
    public Ticket create() {
        Optional<Ticket> lastTicket = ticketDao.getLast();
        final Long lastOrder = lastTicket.map(Ticket::getOrder).orElse(0L);

        Ticket ticket = new Ticket();
        ticket.setId(ticketDao.next());
        ticket.setCreateTime(LocalDateTime.now());
        ticket.setOrder(lastOrder + 1);

        ticketDao.insert(ticket);
        return ticket;
    }

    @Override
    public Optional<Ticket> getActual() {
        return ticketDao.getFirst();
    }

    @Override
    public void deleteLast() {
        Optional<Ticket> last = ticketDao.getLast();
        last.ifPresent(ticket -> ticketDao.delete(ticket.getId()));
    }
}
