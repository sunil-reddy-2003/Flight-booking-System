package com.fbs.central_api.models;

public class ResponseCandidate {
    private ResponseContent content;
    private String finishReason;
    private double avgLogprobs;

    public ResponseCandidate() {
    }

    public ResponseCandidate(ResponseContent content, String finishReason, double avgLogprobs) {
        this.content = content;
        this.finishReason = finishReason;
        this.avgLogprobs = avgLogprobs;
    }

    public ResponseContent getContent() {
        return content;
    }

    public void setContent(ResponseContent content) {
        this.content = content;
    }

    public String getFinishReason() {
        return finishReason;
    }

    public void setFinishReason(String finishReason) {
        this.finishReason = finishReason;
    }

    public double getAvgLogprobs() {
        return avgLogprobs;
    }

    public void setAvgLogprobs(double avgLogprobs) {
        this.avgLogprobs = avgLogprobs;
    }
}
