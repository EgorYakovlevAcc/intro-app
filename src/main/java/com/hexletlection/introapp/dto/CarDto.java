package com.hexletlection.introapp.dto;

import java.util.List;

public class CarDto {
    private String name;
    private DocumentDto document;
    private List<BoxDto> boxes;

    public DocumentDto getDocument() {
        return document;
    }

    public void setDocument(DocumentDto document) {
        this.document = document;
    }

    public List<BoxDto> getBoxes() {
        return boxes;
    }

    public void setBoxes(List<BoxDto> boxes) {
        this.boxes = boxes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
