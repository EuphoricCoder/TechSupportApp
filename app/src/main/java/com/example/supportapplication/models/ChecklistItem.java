package com.example.supportapplication.models;

public class ChecklistItem {
    private String description;
    private boolean isChecked;

    public ChecklistItem() {
    }

    public ChecklistItem(String description, boolean isChecked) {
        this.description = description;
        this.isChecked = isChecked;
    }

    // Getters and setters for each field
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public boolean isChecked() { return isChecked; }
    public void setChecked(boolean checked) { isChecked = checked; }
}
