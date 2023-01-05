package com.example.geektrust;

import java.util.ArrayList;
import java.util.Arrays;

public class Train {
    private ArrayList<String> train;

    public Train(String boogies) {
        String[] station = boogies.split("\\s+");
        train = new ArrayList<>(Arrays.asList(station));
    }

    public Train(ArrayList<String> boogies){
        this.train = boogies;
    }
    
    public ArrayList<String> getTrain() {
        return train;
    }
    
    public void setTrain(ArrayList<String> train) {
        this.train = train;
    }
    
    @Override
    public String toString() {
        return "Train [train=" +(train) + "]";
    }
}
