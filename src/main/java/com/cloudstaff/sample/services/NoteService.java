package com.cloudstaff.sample.services;

import com.cloudstaff.sample.persistence.Note;

import java.util.List;

public interface NoteService {

    Note saveNote(Note note);
    Note findNoteById(Long id);
    void deleteNoteById(Long id);
    void deleteAllNotes();
    List<Note> viewAllNotes();
    List<Note> findAllByTags(String[] tag);
    List<Note> findAllByTitle(String title);

}
