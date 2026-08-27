package com.todoapi;

import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final Map<Long, Task> tasks = new LinkedHashMap<>();
    private final AtomicLong idCounter = new AtomicLong();

    @GetMapping
    public Collection<Task> getAll() {
        return tasks.values();
    }

    @GetMapping("/{id}")
    public Task getOne(@PathVariable Long id) {
        return tasks.get(id);
    }

    @PostMapping
    public Task create(@RequestBody Task task) {
        long id = idCounter.incrementAndGet();
        task.setId(id);
        tasks.put(id, task);
        return task;
    }

    @PutMapping("/{id}")
    public Task update(@PathVariable Long id, @RequestBody Task updated) {
        updated.setId(id);
        tasks.put(id, updated);
        return updated;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        tasks.remove(id);
    }
}
