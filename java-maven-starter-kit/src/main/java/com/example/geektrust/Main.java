package com.example.geektrust;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
        // try {
     
        //     FileInputStream fis = new FileInputStream(args[0]);
        //     Scanner sc = new Scanner(fis); // file to be scanned
            
        //     String trainA_input = sc.nextLine();
        //     String trainB_input = sc.nextLine();

        //     Train trainA = new Train(trainA_input);
        //     Train trainB = new Train(trainB_input);

        //     RouteService route = new RouteService();

        //     trainA = new Train(route.updatedTrain(trainA));
        //     trainB = new Train(route.updatedTrain(trainB));

        //     System.out.println(trainA.toString());
        //     System.out.println(trainB.toString());


        //     sc.close(); // closes the scanner
        // } catch (IOException e) {

        // }


        String trainA_input = "TRAIN_A  ENGINE NDL NDL KRN GHY SLM NJP NGP BLR";
        String trainB_input = "TRAIN_B  ENGINE NJP GHY AGA PNE MAO BPL PTA";
        // String trainA_input = "TRAIN_A ENGINE NGP ITJ BPL AGA NDL  CHN SLM BLR KRN HYB ";
        // String trainB_input = "TRAIN_B ENGINE TVC SRR MAQ MAO PNE HYB NGP ITJ BPL PTA NJP GHY";

        Train trainA = new Train(trainA_input);
        Train trainB = new Train(trainB_input);

        // System.out.println(train1.toString());
        // System.out.println(train2.toString());

        RouteService route = new RouteService();

        trainA = new Train(route.updatedTrain(trainA));
        trainB = new Train(route.updatedTrain(trainB));

        System.out.println(trainA.toString());
        System.out.println(trainB.toString());
        Sorting sort = new Sorting();
        
        Train merTrain = new Train(sort.mergeBoogies(trainA, trainB));
        System.out.println(merTrain.toString());
    }
}
