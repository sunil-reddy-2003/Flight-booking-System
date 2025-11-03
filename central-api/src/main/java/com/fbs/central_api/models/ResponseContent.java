package com.fbs.central_api.models;


import java.util.List;

public class ResponseContent {
    private List<ResponsePart> parts;
    private String role;

    public ResponseContent() {
    }

    public ResponseContent(List<ResponsePart> parts, String role) {
        this.parts = parts;
        this.role = role;
    }

    public List<ResponsePart> getParts() {
        return parts;
    }

    public void setParts(List<ResponsePart> parts) {
        this.parts = parts;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}