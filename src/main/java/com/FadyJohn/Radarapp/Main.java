package com.FadyJohn.Radarapp;

import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Radar radar = new Radar();

        radar.addRule(new SeatbeltRule());
        radar.addRule(new PrivateCarSpeedRule());
        radar.addRule(new TruckSpeedRule());

        Observation obs1 = new Observation("priv1234", "2026-07-23", CarType.PRIVATE, 94, false);
        Observation obs2 = new Observation("TRK9999", "2026-07-23", CarType.TRUCK, 65, true);
        Observation obs3 = new Observation("priv0000", "2026-07-23", CarType.PRIVATE, 70, true);

        System.out.println("--- Processing Observations ---");
        radar.processObservation(obs1);
        radar.processObservation(obs2);
        radar.processObservation(obs3);

        System.out.println("--- All Possible Fines ---");
        Map<String, Integer> allFines = radar.getAllPossibleFines();
        allFines.forEach((plate, total) -> System.out.println("Plate: " + plate + " | Total Outstanding: " + total + " EGP"));

        System.out.println("\n--- Violated Rules Count ---");
        Map<String, Integer> rulesCount = radar.getViolatedRulesCount();
        rulesCount.forEach((rule, count) -> System.out.println(rule + ": " + count + " times"));
    }
}
