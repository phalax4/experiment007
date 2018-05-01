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


        Person p0 = new Person("p1", new ArrayList(Arrays.asList("a2", "a1", "a3", "a4")));
        Person p1 = new Person("p2", new ArrayList(Arrays.asList("a4", "a1", "a2", "a3")));
        Person p2 = new Person("p3", new ArrayList(Arrays.asList("a1", "a3", "a2","a4")));
        Person p3 = new Person("p4", new ArrayList(Arrays.asList("a2", "a3", "a1", "a4")));


        Person a0 = new Person("a1", new ArrayList(Arrays.asList("p1", "p3", "p2", "p4")));
        Person a1 = new Person("a2", new ArrayList(Arrays.asList("p3", "p4", "p1", "p2")));
        Person a2 = new Person("a3", new ArrayList(Arrays.asList("p4", "p2", "p3","p1")));
        Person a3 = new Person("a4", new ArrayList(Arrays.asList("p3", "p2", "p1", "p4")));



        Matching m = new Matching();
        m.matchPeople(new ArrayList<Person>(Arrays.asList(m0, m1, m2)),new ArrayList<Person>(Arrays.asList(w0, w1, w2)));
        m.matchPeople(new ArrayList<Person>(Arrays.asList(p0, p1, p2, p3)), new ArrayList<Person>(Arrays.asList(a0, a1, a2,a3)));
    }


}
