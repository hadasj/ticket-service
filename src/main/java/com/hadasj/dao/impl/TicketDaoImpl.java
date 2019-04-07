package com.hadasj.dao.impl;

import com.hadasj.dao.TicketDao;
import com.hadasj.entity.Ticket;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Supplier;

@Component
public class TicketDaoImpl implements TicketDao {

    private AtomicLong sequence;
    private SortedMap<Long, Ticket> store;

    @PostConstruct
    public void init() {
        sequence = new AtomicLong();
        store = new TreeMap<>();
    }

    @Override
    public void insert(Ticket record) {
        store.put(record.getId(), record);
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
        store.remove(id);
    }

    @Override
    public long next() {
        return sequence.incrementAndGet();
    }

    private Optional<Ticket> get(Supplier<Long> idSupplier) {
        if (store.isEmpty())
            return Optional.empty();
        return Optional.of(store.get(idSupplier.get()));
    }
}
