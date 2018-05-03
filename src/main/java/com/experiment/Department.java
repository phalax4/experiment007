package com.experiment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Department extends Person{
    //Person id and their rank
    private HashMap<String, Integer> waitList = new HashMap<String, Integer>();
    private Integer maxSlots;

    public Department(String id, ArrayList<String> pref, Integer maxSlots) {
        super(id, pref);
        this.maxSlots = maxSlots;

    }

    public void addToWaitList(String id){
        waitList.put(id, this.getPref().indexOf(id));
    }

    public String removeAndReplaceLeastPrefered(String id){
        String maxId = "";
        int maxRank = -1;

        for(Map.Entry<String, Integer> entry: waitList.entrySet()){
            if(entry.getValue() >= maxRank){
                maxId = entry.getKey();
                maxRank = entry.getValue();
            }
        }

        waitList.remove(maxId);
        this.addToWaitList(id);

        return maxId;
    }

    public HashMap<String, Integer> getWaitList() {
        return waitList;
    }

    public void setWaitList(HashMap<String, Integer> waitList) {
        this.waitList = waitList;
    }

    public Integer getMaxSlots() {
        return maxSlots;
    }

    public void setMaxSlots(Integer maxSlots) {
        this.maxSlots = maxSlots;
    }

    public Integer getRemainingSlots() {
        return maxSlots - waitList.size();
    }

    public boolean prefers(Person p){
        int idxRank = this.getPref().indexOf(p.getId());
        for(Map.Entry<String, Integer> entry: waitList.entrySet()){
            if(entry.getValue() > idxRank){
                return true;
            }
        }
        return false;
    }

}
