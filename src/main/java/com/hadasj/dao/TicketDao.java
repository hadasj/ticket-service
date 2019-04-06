package com.hadasj.dao;

import com.hadasj.entity.Ticket;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TicketDao extends Dao<Ticket> {

    /**
     * @return last ticket ordered by order property ascending
     */
    Ticket getLast();
}
