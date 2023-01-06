package com.example.geektrust;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sorting {
  private HashMap<String, Integer> routeA;
  private HashMap<String, Integer> routeB;

  public Sorting() {
    routeA = new HashMap<>();
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

    // prepare route B
    routeB = new HashMap<>();
    routeB.put("TVC", 0);
    routeB.put("SRR", 300);
    routeB.put("MAQ", 600);
    routeB.put("MAO", 1000);
    routeB.put("PNE", 1400);
    routeB.put("HYB", 2000);
    routeB.put("NGP", 2400);
    routeB.put("ITJ", 2700);
    routeB.put("BPL", 2800);
    routeB.put("PTA", 3800);
    routeB.put("NJP", 4200);
    routeB.put("GHY", 4700);
  }


  public ArrayList<String> sorArrayListbyHashmap(List<String> list){
    List<String> subList1 = list.subList(0, 2);
    List<String> subList2 = list.subList(3, list.size());
    HashMap<String, Integer> map;
    
    if(list.get(0).equals("TRAIN_A")){
      map = routeA;
    }else{
      map = routeB;
    }
    Collections.sort(subList2, (a, b) -> map.get(a) - map.get(b));
    // Collections.sort(subList2, (a, b) -> Math.abs(map.get(a).compareTo(map.get("HYB"))) - Math.abs(map.get(b).compareTo(map.get("HYB"))));
    // Collections.sort(subList2, new Comparator<String>() {
      // @Override
      // public int compare(String s1, String s2) {
        // return routeA.get(s1).compareTo(routeA.get(s2));
      // }
    // });
    ArrayList<String> ans_list = new ArrayList<String>();
    ans_list.addAll(subList1);
    ans_list.addAll(subList2);
    return ans_list;
    
  }

  public ArrayList<String> mergeBoogies(Train trainA, Train trainB) {
    ArrayList<String> train_a = trainA.getTrain();
    ArrayList<String> train_b = trainB.getTrain();
    ArrayList<String> mergedTrain = new ArrayList<>();
    mergedTrain.add(0, "TRAIN_AB");
    mergedTrain.add(1, "ENGINE");
    mergedTrain.add(2, "ENGINE");

    int i = 2;
    int j = 2;

    while (i < train_a.size() && j < train_b.size()) {
      if (routeA.get(train_a.get(i)) > routeB.get(train_b.get(j))) {
        mergedTrain.add(train_a.get(i));
        i++;
      } else {
        mergedTrain.add(train_b.get(j));
        j++;
      }
    }
    while(i < train_a.size()){
      mergedTrain.add(train_a.get(i));
      i++;
    }
    while(j < train_b.size()){
      mergedTrain.add(train_b.get(j));
      j++;
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
