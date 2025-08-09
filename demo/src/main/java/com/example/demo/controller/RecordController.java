package com.example.demo.controller;

import com.example.demo.model.UserRecord;
import com.example.demo.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/records")
public class RecordController {

    @Autowired
    private RecordService service;

    @GetMapping
    public List<UserRecord> getAll() {
        return service.getAll();
    }

    @PostMapping
    public UserRecord create(@RequestBody UserRecord record) {
        return service.create(record);
    }

    @GetMapping("/{id}")
    public UserRecord getById(@PathVariable Long id) {
        return service.getById(id).orElseThrow();
    }

    @PutMapping("/{id}")
    public UserRecord update(@PathVariable Long id, @RequestBody UserRecord record) {
        return service.update(id, record);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
