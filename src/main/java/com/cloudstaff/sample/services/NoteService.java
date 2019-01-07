package com.cloudstaff.sample.services;

import com.cloudstaff.sample.persistence.Note;

import java.util.List;
import java.util.Set;

public interface NoteService {

    Note saveNote(Note note);
    Note findNoteById(Long id);
    void deleteNoteById(Long id);
    void deleteAllNotes();
    List<Note> viewAllNotes();
    Set<Note> findAllByTags(String[] tag);
    List<Note> findAllByTitle(String title);

}
