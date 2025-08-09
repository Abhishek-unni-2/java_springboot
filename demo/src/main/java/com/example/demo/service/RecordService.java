package com.example.demo.service;

import com.example.demo.model.UserRecord;
import com.example.demo.repository.UserRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecordService {

    @Autowired
    private UserRecordRepository repository;

    public List<UserRecord> getAll() {
        return repository.findAll();
    }

    public Optional<UserRecord> getById(Long id) {
        return repository.findById(id);
    }

    public UserRecord create(UserRecord record) {
        return repository.save(record);
    }

    public UserRecord update(Long id, UserRecord record) {
        record.setId(id);
        return repository.save(record);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
