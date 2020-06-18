package com.example.interviews.model;

public class Candidates {
    private int id;
    private String name;
    private String  date;
    private String fromHour;
    private String toHour;
    private String subject;

    public Candidates() {
    }

    public Candidates(int id, String name, String date, String fromHour, String toHour, String subject) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.fromHour = fromHour;
        this.toHour = toHour;
        this.subject = subject;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFromHour() {
        return fromHour;
    }

    public void setFromHour(String fromHour) {
        this.fromHour = fromHour;
    }

    public String getToHour() {
        return toHour;
    }

    public void setToHour(String toHour) {
        this.toHour = toHour;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidates that = (Candidates) o;
        return id == id &&
                name.equals(that.name) &&
                date.equals(that.date) &&
                fromHour.equals(that.fromHour) &&
                fromHour.equals(that.fromHour) &&
                toHour.equals(that.toHour) &&
                subject.equals(that.subject);
    }
}

