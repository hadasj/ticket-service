package com.hadasj.service;

import com.hadasj.entity.Ticket;

public interface TicketService {

    /**
     * @return new initialized persisted ticket
     */
    Ticket generate();
}
