package com.hadasj.rest;

import com.hadasj.dto.TicketDto;
import com.hadasj.entity.Ticket;
import com.hadasj.service.impl.TicketServiceImpl;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class TicketController {

    @Autowired
    private TicketServiceImpl ticketService;

    @Autowired
    private DozerBeanMapper mapper;

    @RequestMapping(value = "/ticket", method = RequestMethod.POST)
    public TicketDto generate() {
        Ticket newTicket = ticketService.create();
        return mapper.map(newTicket, TicketDto.class);
    }

    @RequestMapping(value = "/ticket", method = RequestMethod.GET)
    public TicketDto get() {
        final Optional<Ticket> actualTicket = ticketService.getActual();
        if(actualTicket.isPresent())
            return mapper.map(actualTicket.get(), TicketDto.class);
        else
            throw new IllegalStateException("Ticket queue is empty");
    }

    @RequestMapping(value = "/ticket", method = RequestMethod.DELETE)
    public void delete() {
        ticketService.deleteLast();
    }
}
