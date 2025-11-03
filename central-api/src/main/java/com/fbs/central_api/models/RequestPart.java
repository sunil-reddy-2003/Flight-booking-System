package com.fbs.central_api.models;


public class RequestPart {
    private String text;

    public RequestPart() {
    }

    public RequestPart(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}