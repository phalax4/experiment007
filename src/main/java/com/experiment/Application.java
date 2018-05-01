package com.experiment;

import java.util.*;

public class Application {

    public static void main(String[]args){
        System.out.println("Starting application");

        Person m0 = new Person("m0", new ArrayList(Arrays.asList("w1", "w0", "w2")));
        Person m1 = new Person("m1", new ArrayList(Arrays.asList("w2", "w1", "w0")));
        Person m2 = new Person("m2", new ArrayList(Arrays.asList("w0", "w2", "w1")));

        Person w0 = new Person("w0", new ArrayList(Arrays.asList("m1", "m0", "m2")));
        Person w1 = new Person("w1", new ArrayList(Arrays.asList("m2", "m1", "m0")));
        Person w2 = new Person("w2", new ArrayList(Arrays.asList("m0", "m2", "m1")));

        HashMap<String, Person> wHashMap = new HashMap();
        wHashMap.put(w0.getId(), w0);
        wHashMap.put(w1.getId(), w1);
        wHashMap.put(w2.getId(), w2);


        HashMap<String, Person> mHashMap = new HashMap();
        wHashMap.put(m0.getId(), m0);
        wHashMap.put(m1.getId(), m1);
        wHashMap.put(m2.getId(), m2);

        Queue<Person> q = new LinkedList<Person>();
        q.add(m0);
        q.add(m1);
        q.add(m2);

        while(!q.isEmpty()){
            Person currMan = q.poll();
            Person unProposedW = wHashMap.get(currMan.getPref().get(currMan.unproposedIdx));
            currMan.unproposedIdx++;
            if(unProposedW.getEngagedTo() == null){
                unProposedW.setEngagedTo(currMan.getId());
                currMan.setEngagedTo(unProposedW.getId());
            }else{
                String tempPId = unProposedW.preferredPerson(currMan.getId(), unProposedW.getEngagedTo());
                if(currMan.getId().equals(tempPId)){
                    q.add(mHashMap.get(unProposedW.getEngagedTo()));
                    unProposedW.setEngagedTo(currMan.getId());
                    currMan.setEngagedTo(unProposedW.getId());

                }
            }
        }

        for(Map.Entry<String,Person> entry: wHashMap.entrySet()){
            System.out.println(entry.getKey() + "...." + entry.getValue());
        }
        for(Map.Entry<String,Person> entry: mHashMap.entrySet()){
            System.out.println(entry.getKey() + "...." + entry.getValue());
        }
    }
}
