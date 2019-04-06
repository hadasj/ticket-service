package com.hadasj.dao.impl;

import com.hadasj.dao.TicketDao;
import com.hadasj.entity.Ticket;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TicketDaoImpl implements TicketDao {

// TODO: sorted tree map -> get actual order!!


    @Override
    public void insert(Ticket record) {
        throw new IllegalStateException("unimplemented");
    }

    @Override
    public List<Ticket> list() {
        throw new IllegalStateException("unimplemented");
    }

    @Override
    public Ticket get(long id) {
        throw new IllegalStateException("unimplemented");
    }

    @Override
    public Ticket getLast() {
        throw new IllegalStateException("unimplemented");
    }

    @Override
    public void delete(long id) {
        throw new IllegalStateException("unimplemented");
    }
}
