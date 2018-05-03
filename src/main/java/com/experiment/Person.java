package com.experiment;

import java.util.ArrayList;

public class Person {
    private String id;
    private ArrayList<String> pref;
    private String engagedTo = null;
    public int unproposedIdx = 0;

    public Person(String id, ArrayList<String> pref) {
        this.id = id;
        this.pref = pref;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<String> getPref() {
        return pref;
    }

    public void setPref(ArrayList<String> pref) {
        this.pref = pref;
    }

    public String getEngagedTo() {
        return engagedTo;
    }

    public void setEngagedTo(String engagedTo) {
        this.engagedTo = engagedTo;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", pref=" + pref +
                ", engagedTo='" + engagedTo + '\'' +
                ", unproposedIdx=" + unproposedIdx +
                '}';
    }

    public String preferredPerson(String p0Id, String p1Id){
        for(String p: pref){
            if(p.equals(p0Id) || p.equals(p1Id)){
                return p;
            }
        }
        System.out.println("returned null");
        return null;

    }


}
