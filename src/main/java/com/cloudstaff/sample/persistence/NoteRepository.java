package com.cloudstaff.sample.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// Spring Java Persistence API
@Repository
public interface NoteRepository extends CrudRepository<Note, Long> {

    List<Note> findAll();
    Note findByTitle(String title);
    Note findAllById(Long id);
}