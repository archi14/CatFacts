package com.example.architamittal.retrofit;

public class Facts {
    int id;
    String text;
    String source;
    Boolean used;
    String type;

    public Facts(int id, String text, String source, Boolean used, String type) {
        this.id = id;
        this.text = text;
        this.source = source;
        this.used = used;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Boolean getUsed() {
        return used;
    }

    public void setUsed(Boolean used) {
        this.used = used;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
