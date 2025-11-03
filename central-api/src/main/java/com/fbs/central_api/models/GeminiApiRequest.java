package com.fbs.central_api.models;

import java.util.List;

public class GeminiApiRequest {
    private List<RequestContent> contents;

    public GeminiApiRequest(List<RequestContent> contents) {
        this.contents = contents;
    }

    public List<RequestContent> getContents() {
        return contents;
    }

    public void setContents(List<RequestContent> contents) {
        this.contents = contents;
    }

    public GeminiApiRequest() {
    }
}
