package com.example.geektrust;

import java.util.ArrayList;
import java.util.Map;

public class RouteService {
    Merging merge = new Merging();

    RouteService() {
    }

    public ArrayList<String> updatedTrain(Train train) {
        ArrayList<String> train_list = train.getTrain();
        train_list = this.removeBoogies(train_list);
        return train_list;
    }

    private ArrayList<String> removeBoogies(ArrayList<String> train_list) {
        if (train_list.get(0).equals("TRAIN_A")) {
            Map<String, Integer> routeA = merge.getRouteA();
            for (int i = 2; i < train_list.size(); i++) {
                if (routeA.containsKey(train_list.get(i)) && routeA.get(train_list.get(i)) < routeA.get("HYB")) {
                    train_list.remove(train_list.get(i));
                    i--;
                }
            }
        }

        else {
            Map<String, Integer> routeB = merge.getRouteB();
            for (int i = 2; i < train_list.size(); i++) {
                if (routeB.containsKey(train_list.get(i)) && routeB.get(train_list.get(i)) < routeB.get("HYB")) {
                    train_list.remove(train_list.get(i));
                    i--;
                }
            }
        }
        return train_list;
    }

}
