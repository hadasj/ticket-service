package com.hadasj.service.impl;

import com.hadasj.dao.TicketDao;
import com.hadasj.entity.Ticket;
import com.hadasj.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketDao ticketDao;

    // TODO: move state to application context!!
    private long counter;

    @Override
    public Ticket generate() {
        Ticket lastTicket = ticketDao.getLast();

        Ticket ticket = new Ticket();
        ticket.setId(++counter);
        ticket.setCreateTime(LocalDateTime.now());
        ticket.setOrder(lastTicket.getOrder() + 1);
        return ticket;

        // TODO: persist !!!
    }

}
