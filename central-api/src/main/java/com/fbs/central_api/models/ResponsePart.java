package com.fbs.central_api.models;

public class ResponsePart {
    private String text;

    public ResponsePart() {
    }

    public ResponsePart(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
