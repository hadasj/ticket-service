package com.hadasj.dao.impl;

import com.hadasj.dao.TicketDao;
import com.hadasj.entity.Ticket;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.function.Supplier;

@Component
public class TicketDaoImpl implements TicketDao {

// TODO: sorted tree map -> get actual order!!
    private SortedMap<Long, Ticket> store;

    @PostConstruct
    public void init() {
        store = new TreeMap<>();
    }

    @Override
    public void insert(Ticket record) {
        throw new IllegalStateException("unimplemented");
    }

    private Optional<Ticket> get(Supplier<Long> idSupplier) {
        if (store.isEmpty())
            return Optional.empty();
        return Optional.of(store.get(idSupplier.get()));
    }

    @Override
    public Optional<Ticket> getLast() {
        return get(store::lastKey);
    }

    @Override
    public Optional<Ticket> getFirst() {
        return get(store::firstKey);
    }

    @Override
    public void delete(long id) {
        throw new IllegalStateException("unimplemented");
    }
}
