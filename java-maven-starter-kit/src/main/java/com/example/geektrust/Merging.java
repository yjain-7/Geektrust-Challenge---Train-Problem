package com.example.geektrust;

import java.util.ArrayList;
import java.util.Map;
import java.util.LinkedHashMap;

public class Merging {
    private Map<String, Integer> routeA;
    private Map<String, Integer> routeB;

    public Merging() {
        routeA = new LinkedHashMap<String, Integer>();
        routeA.put("CHN", 0);
        routeA.put("SLM", 350);
        routeA.put("BLR", 550);
        routeA.put("KRN", 900);
        routeA.put("HYB", 1200);
        routeA.put("NGP", 1600);
        routeA.put("ITJ", 1900);
        routeA.put("BPL", 2000);
        routeA.put("AGA", 2500);
        routeA.put("NDL", 2700);
        
        routeB = new LinkedHashMap<String, Integer>();
        routeB.put("TVC", 0);
        routeB.put("SRR", 300);
        routeB.put("MAQ", 600);
        routeB.put("MAO", 1000);
        routeB.put("PNE", 1400);
        routeB.put("HYB", 2000); 
        routeB.put("NGP", 1600);
        routeB.put("ITJ", 1900);
        routeB.put("BPL", 2000);
        routeB.put("PTA", 3800);
        routeB.put("NJP", 4200);
        routeB.put("GHY", 4700);
    }

    public ArrayList<String> mergeBoogies(Train trainA, Train trainB) {
        ArrayList<String> train_a = trainA.getTrain();
        ArrayList<String> train_b = trainB.getTrain();
        ArrayList<String> mergedTrain = new ArrayList<>();
        mergedTrain.add(0, "TRAIN_AB");
        mergedTrain.add(1, "ENGINE");
        mergedTrain.add(2, "ENGINE");

        ArrayList<String> keys_A = new ArrayList<String>(routeA.keySet());
        ArrayList<String> keys_B = new ArrayList<String>(routeB.keySet());

        int i = keys_A.size() - 1;
        int j = keys_B.size() - 1;
        while (i > 4 && j > 5) {
            String station_A = keys_A.get(i);
            String station_B = keys_B.get(j);
            if (routeA.get(station_A) > routeB.get(station_B)) {

                while (train_a.contains(station_A)) {
                    mergedTrain.add(station_A);
                    train_a.remove(station_A);
                }
                while (train_b.contains(station_A)) {
                    mergedTrain.add(station_A);
                    train_b.remove(station_A);
                }
                i--;
            } else {
                while (train_a.contains(station_B)) {
                    mergedTrain.add(station_B);
                    train_a.remove(station_B);
                }
                while (train_b.contains(station_B)) {
                    mergedTrain.add(station_B);
                    train_b.remove(station_B);
                }
                j--;

            }
        }

        return mergedTrain;

    }

    public Map<String, Integer> getRouteA() {
        return routeA;
    }

    public Map<String, Integer> getRouteB() {
        return routeB;
    }
}
