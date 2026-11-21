package com.notetaking.lettered.client;

import java.util.List;

public interface NoteStore {
    List<Note> loadNotes();
    void saveNotes(List<Note> notes);
}
