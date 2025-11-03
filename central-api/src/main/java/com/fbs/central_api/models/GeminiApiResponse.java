package com.fbs.central_api.models;


import java.util.List;

public class GeminiApiResponse {
    private List<ResponseCandidate> candidates;
    private String modelVersion;
    private String responseId;

    public GeminiApiResponse() {
    }

    public GeminiApiResponse(List<ResponseCandidate> candidates, String modelVersion, String responseId) {
        this.candidates = candidates;
        this.modelVersion = modelVersion;
        this.responseId = responseId;
    }

    public List<ResponseCandidate> getCandidates() {
        return candidates;
    }

    public void setCandidates(List<ResponseCandidate> candidates) {
        this.candidates = candidates;
    }

    public String getModelVersion() {
        return modelVersion;
    }

    public void setModelVersion(String modelVersion) {
        this.modelVersion = modelVersion;
    }

    public String getResponseId() {
        return responseId;
    }

    public void setResponseId(String responseId) {
        this.responseId = responseId;
    }
}