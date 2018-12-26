package com.cloudstaff.sample.services;

import com.cloudstaff.sample.persistence.NoteRepository;
import com.cloudstaff.sample.persistence.Note;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NoteServiceImpl implements NoteService {

    private NoteRepository repository;

    public NoteServiceImpl(NoteRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Note> viewAllNotes() {
        return repository.findAll();
    }

    @Override
    public List<Note> findAllByTags(String[] tag) {
/*        List<Note> allNotes = repository.findAll();
        return allNotes.stream()
                .filter(x -> x.getTags().contains(tag))
                .collect(Collectors.toList());*/
        List<Note> totalNotes = new ArrayList<>();
        for(String s : tag) {
            totalNotes.addAll(repository.findAll().stream().filter(x -> x.getTags().contains(s)).collect(Collectors.toList()));
        }
        return totalNotes;
    }

    @Override
    public List<Note> findAllByTitle(String title) {
        List<Note> allNotes = repository.findAll();
        return allNotes.stream()
                .filter(x -> x.getTitle().equals(title))
                .collect(Collectors.toList());
    }

    @Override
    public Note saveNote(Note note) {
        return repository.save(note);
    }

    @Override
    public Note findNoteById(Long id) {
        return repository.findAllById(id);
    }

    @Override
    public void deleteNoteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteAllNotes() {
        repository.deleteAll();
    }
}
