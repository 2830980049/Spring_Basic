package com.edu.Template;

import java.util.Date;

public class Selection {
    private int sid;
    private int cid;
    private Date selection_time;
    private int score;

    public Selection() {
    }


    public Date getSelection_time() {
        return selection_time;
    }

    public void setSelection_time(Date selection_time) {
        this.selection_time = selection_time;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getSid() {
        return sid;
    }

    @Override
    public String toString() {
        return "Selection{" +
                "sid=" + sid +
                ", cid=" + cid +
                ", selection_time=" + selection_time +
                ", score=" + score +
                '}';
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public Selection(int sid, int cid, Date selection_time, int score) {
        this.sid = sid;
        this.cid = cid;
        this.selection_time = selection_time;
        this.score = score;
    }
}
