package com.catzhang.greedy;

import java.util.*;

/**
 * @author: crazycatzhang
 * @date: 2020/8/6 5:49 PM
 * @description: Solve the problem of broadcasting station coverage through greedy algorithm
 */
public class Greedy {
    public static void main(String[] args) {
        HashMap<String, HashSet<String>> radioStations = constructRadioStations();
        HashSet<String> allAreas = new HashSet<>();
        for (HashSet value :
                radioStations.values()) {
            Iterator iterator = value.iterator();
            while (iterator.hasNext()) {
                allAreas.add((String) iterator.next());
            }
        }
        ArrayList<String> greedyList = greedy(radioStations, allAreas);
        System.out.println(greedyList);
    }

    //Define a collection of radio stations
    public static HashMap<String, HashSet<String>> constructRadioStations() {
        HashMap<String, HashSet<String>> radioStations = new HashMap<>();
        HashSet<String> areas1 = new HashSet<>();
        HashSet<String> areas2 = new HashSet<>();
        HashSet<String> areas3 = new HashSet<>();
        HashSet<String> areas4 = new HashSet<>();
        HashSet<String> areas5 = new HashSet<>();
        areas1.add("北京");
        areas1.add("上海");
        areas1.add("天津");

        areas2.add("广州");
        areas2.add("北京");
        areas2.add("深圳");

        areas3.add("成都");
        areas3.add("上海");
        areas3.add("杭州");

        areas4.add("上海");
        areas4.add("天津");

        areas5.add("杭州");
        areas5.add("大连");

        radioStations.put("k1", areas1);
        radioStations.put("k2", areas2);
        radioStations.put("k3", areas3);
        radioStations.put("k4", areas4);
        radioStations.put("k5", areas5);

        return radioStations;
    }

    //Define Greedy method
    public static ArrayList<String> greedy(HashMap<String, HashSet<String>> radioStations, HashSet<String> allAreas) {
        ArrayList<String> selects = new ArrayList<>();
        HashSet<String> tempSet = new HashSet<>();
        String maxKey;
        int maxSize;
        while (!allAreas.isEmpty()) {
            maxKey = null;
            maxSize = 0;
            for (String key :
                    radioStations.keySet()) {
                tempSet.clear();
                HashSet<String> areas = radioStations.get(key);
                tempSet.addAll(areas);
                tempSet.retainAll(allAreas);
                if (tempSet.size() > 0 && (maxKey == null || tempSet.size() > maxSize)) {
                    maxKey = key;
                    maxSize = tempSet.size();
                }
            }
            if (maxKey != null) {
                selects.add(maxKey);
                allAreas.removeAll(radioStations.get(maxKey));
                radioStations.remove(maxKey);
            }
        }
        return selects;
    }
}
