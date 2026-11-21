package com.notetaking.lettered.client;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

public final class LocalJsonNoteStore implements NoteStore {

    private final Path notesFile;
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public LocalJsonNoteStore(Path notesFile) {
        this.notesFile = notesFile;
    }

    @Override
    public List<Note> loadNotes() {
        if (Files.notExists(notesFile)) {
            return new ArrayList<>();
        }

        try {
            String jsonText = Files.readString(
                    notesFile,
                    StandardCharsets.UTF_8
            );

            if (jsonText.isBlank()) {
                return new ArrayList<>();
            }

            //Read notesFile.
            //Convert its JSON into Note objects.
            Type noteListType = new TypeToken<List<Note>>() {}.getType();
            //Return those objects.
            List<Note> notes = gson.fromJson(jsonText, noteListType);
            return notes != null ? notes : new ArrayList<>();
        }
        catch (Exception e) {
            throw new IllegalStateException(
                    "Could not load notes from" + notesFile,
                    e
            );
        }

    }

    @Override
    public void saveNotes(List<Note> notes) {
        //Convert the Note object into JSON.
        //Write that JSON to notesFile
        String jsonText = gson.toJson(notes);



    }
}
