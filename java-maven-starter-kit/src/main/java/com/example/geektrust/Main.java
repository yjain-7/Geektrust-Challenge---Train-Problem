package com.example.geektrust;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        try {

            FileInputStream fis = new FileInputStream(args[0]);
            Scanner sc = new Scanner(fis);

            String trainA_input = sc.nextLine();
            String trainB_input = sc.nextLine();

            Train trainA = new Train(trainA_input);
            Train trainB = new Train(trainB_input);

            RouteService route = new RouteService();

            trainA = new Train(route.updatedTrain(trainA));
            trainB = new Train(route.updatedTrain(trainB));

            String str1 = trainA.getTrain().stream().collect(Collectors.joining(" "));
            String str2 = trainB.getTrain().stream().collect(Collectors.joining(" "));
            System.out.println("ARIVAL " + str1);
            System.out.println("ARIVAL " + str2);

            Merging merge = new Merging();
            Train merTrain = new Train(merge.mergeBoogies(trainA, trainB));
            String str3 = merTrain.getTrain().stream().collect(Collectors.joining(" "));
            System.out.println("DEPARTURE " + str3);

            sc.close();
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }
}
