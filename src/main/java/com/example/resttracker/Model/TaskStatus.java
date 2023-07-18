package com.example.resttracker.Model;

public enum TaskStatus {
    TODO("Открыт"),
    INWORK("В работе"),
    CLOSED("Закрыт");

    private final String genreTextDisplay;

    TaskStatus(String text) {
        this.genreTextDisplay = text;
    }

    public String getGenreTextDisplay() {
        return this.genreTextDisplay;
    }
}
