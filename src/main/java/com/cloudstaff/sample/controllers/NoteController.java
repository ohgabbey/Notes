package com.cloudstaff.sample.controllers;

import com.cloudstaff.sample.persistence.Note;
import com.cloudstaff.sample.services.NoteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NoteController {

    private NoteService noteService;
    private List<Note> noteToReturn;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    // idempotent
    @GetMapping("/notes")
    public List<Note> viewAllNotes() {
        return noteService.viewAllNotes();
    }

    @PostMapping("/notes")
    public Note createNote(@RequestBody Note note) {
        return noteService.saveNote(note);
    }

    @PutMapping("/notes/id")
    public Note editNoteById(@RequestParam(required = true) Long id, @RequestBody Note note) {
        Note noteById = noteService.findNoteById(id);
        noteById.setTitle(note.getTitle());
        noteById.setBody(note.getBody());
        noteById.setTags(note.getTags());
        return noteService.saveNote(noteById);
    }

    @DeleteMapping("/notes")
    public String deleteAllNotes() {
         noteService.deleteAllNotes();
         return "Successfully deleted all notes!";
    }

    @DeleteMapping("/notes/id")
    public String deleteNoteById(@RequestParam(required = true) Long id) {
        noteService.deleteNoteById(id);
        return "Successfully delete note with ID: " + id + ".";
    }

    @GetMapping("/notes/notes")
    public List<Note> findNoteByTag(@RequestParam(required=false) String title, @RequestParam(required=false) String tag){
        if(!tag.isEmpty())
            noteToReturn = noteService.findAllByTag(tag);
        else if(!title.isEmpty())
            noteToReturn = noteService.findAllByTitle(title);
        return noteToReturn;
    }

}
