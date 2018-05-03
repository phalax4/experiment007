package com.experiment;

import java.util.*;

public class Matching {
    //p1-1, p2 - 4, p3 =3, p4 -2
    //m0 - 1, m1-2, m2-0
    public void matchPeopleBasic(ArrayList<Person> proposers, ArrayList<Person> acceptors) {

        HashMap<String, Person> wHashMap = new HashMap();
        HashMap<String, Person> mHashMap = new HashMap();
        Queue<Person> q = new LinkedList<Person>();

        for (Person p : proposers) {
            mHashMap.put(p.getId(), p);
            q.add(p);
        }

        System.out.println("Items in queue: " + q.size());

        for (Person p : acceptors) {
            wHashMap.put(p.getId(), p);
        }

        while (!q.isEmpty()) {
            Person currMan = q.poll();
            Person unProposedW = wHashMap.get(currMan.getPref().get(currMan.unproposedIdx));
            currMan.unproposedIdx++;
            if (unProposedW.getEngagedTo() == null) {
                unProposedW.setEngagedTo(currMan.getId());
                currMan.setEngagedTo(unProposedW.getId());
            } else {
                String tempPId = unProposedW.preferredPerson(currMan.getId(), unProposedW.getEngagedTo());
                if (currMan.getId().equals(tempPId)) {

                    mHashMap.get(unProposedW.getEngagedTo()).setEngagedTo(null);
                    q.add(mHashMap.get(unProposedW.getEngagedTo()));
                    unProposedW.setEngagedTo(currMan.getId());
                    currMan.setEngagedTo(unProposedW.getId());

                }
            }
        }

        System.out.println("Results...");

        for (Map.Entry<String, Person> entry : mHashMap.entrySet()) {
            System.out.println(entry.getKey() + "...." + entry.getValue().getEngagedTo());
        }
        for (Map.Entry<String, Person> entry : wHashMap.entrySet()) {
            System.out.println(entry.getKey() + "...." + entry.getValue().getEngagedTo());
        }
    }


    public void matchPeopleHospitalResident(ArrayList<Person> proposers, ArrayList<Department> acceptors) {
        HashMap<String, Person> pHashMap = new HashMap();
        HashMap<String, Department> aHashMap = new HashMap();

        Queue<Person> q = new LinkedList<Person>();

        for(Department d: acceptors){
            aHashMap.put(d.getId(), d);
        }

        for(Person p : proposers){
            q.add(p);
            pHashMap.put(p.getId(), p);
        }

        while(!q.isEmpty()){
            Person proposer = q.poll();
            if(proposer.unproposedIdx == proposer.getPref().size()){
                System.out.println("Out of proposals for this person");
                continue;
            }
            Department currDept = aHashMap.get(proposer.getPref().get(proposer.unproposedIdx));
            proposer.unproposedIdx++;
               if(currDept.getRemainingSlots() > 0 ){
                    currDept.addToWaitList(proposer.getId());
                    proposer.setEngagedTo(currDept.getId());
               }else if(currDept.prefers(proposer)){ //Dept has filled up slots but prefers this higher ranked proposer
                    String removedId = currDept.removeAndReplaceLeastPrefered(proposer.getId());
                    proposer.setEngagedTo(currDept.getId());

                    pHashMap.get(removedId).setEngagedTo(null);
                    q.add(pHashMap.get(removedId));
               }

        }

    }
}
