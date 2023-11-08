package com.ualr.recyclerviewassignment.model;;

public class Inbox {
    private String from;
    private String email;
    private String name;
    private int image;
    private String message;
    private String date;
    private boolean selected;

    public Inbox() {
        this.selected = false;
    }

    public String getFrom() {
        return from;
    }


    public void setFrom(String from) {
        this.from = from;
    }

    public String getName() {
        return name;
    }


    public int getImage() { return this.image; }

    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public void toggleSelection() {
        this.selected = !this.selected;
    }
}