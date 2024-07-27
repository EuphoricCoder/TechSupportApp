package com.example.supportapplication.models;

public class StatusChange {
    private String status;
    private String changedBy;  // Email пользователя
    private long timestamp;

    public StatusChange() {
    }

    public StatusChange(String status, String changedBy, long timestamp) {
        this.status = status;
        this.changedBy = changedBy;
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getChangedBy() {
        return changedBy;
    }

    public void setChangedBy(String changedBy) {
        this.changedBy = changedBy;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
