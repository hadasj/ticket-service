package com.hadasj.rest;

import com.hadasj.dto.TicketDto;
import com.hadasj.entity.Ticket;
import com.hadasj.service.impl.TicketServiceImpl;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {

    @Autowired
    private TicketServiceImpl ticketService;

    @Autowired
    private DozerBeanMapper mapper;

    @RequestMapping(value = "/ticket", method = RequestMethod.POST)
    public TicketDto generate() {
        Ticket newTicket = ticketService.generate();
        return mapper.map(newTicket, TicketDto.class);
    }
}
