package com.fbs.central_api.models;


import java.util.List;

public class RequestContent {
    private List<RequestPart> parts;

    public RequestContent() {
    }

    public RequestContent(List<RequestPart> parts) {
        this.parts = parts;
    }

    public List<RequestPart> getParts() {
        return parts;
    }

    public void setParts(List<RequestPart> parts) {
        this.parts = parts;
    }
}