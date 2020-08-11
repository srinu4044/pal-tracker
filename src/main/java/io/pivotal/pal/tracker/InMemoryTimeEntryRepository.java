package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository{

    Long counter=0l;
    HashMap<Long,TimeEntry> repo=new HashMap<>();



    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        ++counter;
        timeEntry.setId(counter);
        repo.put(counter,timeEntry);
        return timeEntry;
    }

    @Override
    public TimeEntry find(long id) {
        return repo.get(id);
    }

    @Override
    public List<TimeEntry> list() {
        return new ArrayList<>(repo.values());
    }

    @Override
    public TimeEntry update(long id, TimeEntry timeEntry) {
        timeEntry.setId(id);
        repo.replace(id, timeEntry);
        return find(id);
    }

    @Override
    public void delete(long id) {
        repo.remove(id);
    }
}
