package com.hadasj.service;

import com.hadasj.entity.Ticket;

import java.util.Optional;

public interface TicketService {

    /**
     * @return new initialized persisted ticket
     */
    Ticket create();

    /**
     * @return actual waiting ticket
     */
    Optional<Ticket> getActual();

    /**
     * delete last ticket
     */
    void deleteLast();
}
