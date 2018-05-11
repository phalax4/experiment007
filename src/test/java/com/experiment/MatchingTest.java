package com.experiment;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class MatchingTest {

    private Matching m = new Matching();

    @Before
    public void setup(){

    }

    @Test
    public void matchPeopleBasic1() throws Exception {
        //m0 - 1, m1-2, m2-0

        Person m0 = new Person("m0", new ArrayList(Arrays.asList("w1", "w0", "w2")));
        Person m1 = new Person("m1", new ArrayList(Arrays.asList("w2", "w1", "w0")));
        Person m2 = new Person("m2", new ArrayList(Arrays.asList("w0", "w2", "w1")));

        Person w0 = new Person("w0", new ArrayList(Arrays.asList("m1", "m0", "m2")));
        Person w1 = new Person("w1", new ArrayList(Arrays.asList("m2", "m1", "m0")));
        Person w2 = new Person("w2", new ArrayList(Arrays.asList("m0", "m2", "m1")));

        HashMap<String, String> result = m.matchPeopleBasic(
                new ArrayList<Person>(Arrays.asList(m0, m1, m2)),
                new ArrayList<Person>(Arrays.asList(w0, w1, w2)));
        HashMap<String, String> expected = new HashMap();
        expected.put("m0", "w1");
        expected.put("m1", "w2");
        expected.put("m2", "w0");

        assertEquals(result, expected);
    }

    @Test
    public void matchPeopleBasic2() throws Exception {
        //p1-1, p2 - 4, p3 =3, p4 -2

        Person p0 = new Person("p1", new ArrayList(Arrays.asList("a2", "a1", "a3", "a4")));
        Person p1 = new Person("p2", new ArrayList(Arrays.asList("a4", "a1", "a2", "a3")));
        Person p2 = new Person("p3", new ArrayList(Arrays.asList("a1", "a3", "a2","a4")));
        Person p3 = new Person("p4", new ArrayList(Arrays.asList("a2", "a3", "a1", "a4")));


        Person a0 = new Person("a1", new ArrayList(Arrays.asList("p1", "p3", "p2", "p4")));
        Person a1 = new Person("a2", new ArrayList(Arrays.asList("p3", "p4", "p1", "p2")));
        Person a2 = new Person("a3", new ArrayList(Arrays.asList("p4", "p2", "p3","p1")));
        Person a3 = new Person("a4", new ArrayList(Arrays.asList("p3", "p2", "p1", "p4")));

        HashMap<String, String> result = m.matchPeopleBasic(
                new ArrayList<Person>(Arrays.asList(p0, p1, p2, p3)),
                new ArrayList<Person>(Arrays.asList(a0, a1, a2,a3)));

        HashMap<String, String> expected = new HashMap();

        expected.put("p1", "a1");
        expected.put("p2", "a4");
        expected.put("p3", "a3");
        expected.put("p4", "a2");

        assertEquals(result, expected);
    }

    @Test
    public void matchResidentToHospital(){


        Person s0 = new Person("s1", new ArrayList(Arrays.asList("d2", "d1", "d3")));
        Person s1 = new Person("s2", new ArrayList(Arrays.asList("d1", "d3", "d2")));
        Person s2 = new Person("s3", new ArrayList(Arrays.asList("d1", "d3", "d2")));
        Person s3 = new Person("s4", new ArrayList(Arrays.asList("d2", "d1", "d3")));
        Person s4 = new Person("s5", new ArrayList(Arrays.asList("d1", "d3", "d2")));
        Person s5 = new Person("s6", new ArrayList(Arrays.asList("d1", "d3", "d2")));

        Department d0 = new Department("d1", new ArrayList(Arrays.asList("s2", "s5", "s3", "s6", "s1", "s4")), 2);
        Department d1 = new Department("d2", new ArrayList(Arrays.asList("s2", "s5", "s3", "s6", "s1", "s4")), 2);
        Department d2 = new Department("d3", new ArrayList(Arrays.asList("s1", "s4", "s2", "s5", "s3", "s6")), 2);

        HashMap<String, String> result = m.matchResidentToHospital(
                new ArrayList<Person>(Arrays.asList(s0, s1, s2, s3, s4, s5)),
                new ArrayList<Department>(Arrays.asList(d0, d1, d2)));

        HashMap<String, String> expected = new HashMap();

        expected.put("s2", "d1");
        expected.put("s5", "d1");
        expected.put("s1", "d2");
        expected.put("s4", "d2");
        expected.put("s3", "d3");
        expected.put("s6", "d3");

        assertEquals(result, expected);

    }

}