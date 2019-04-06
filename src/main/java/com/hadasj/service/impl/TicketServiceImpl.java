package com.hadasj.service.impl;

import com.hadasj.dao.TicketDao;
import com.hadasj.entity.Ticket;
import com.hadasj.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketDao ticketDao;

    // TODO: move state to application context!!
    private long counter;

    @Override
    public Ticket generate() {
        Optional<Ticket> lastTicket = ticketDao.getLast();
        final Long lastOrder = lastTicket.map(Ticket::getOrder).orElse(0L);

        Ticket ticket = new Ticket();
        ticket.setId(++counter);
        ticket.setCreateTime(LocalDateTime.now());
        ticket.setOrder(lastOrder + 1);
        return ticket;

        // TODO: persist !!!
    }

    @Override
    public Optional<Ticket> getActual() {
        return Optional.empty();
    }
}
