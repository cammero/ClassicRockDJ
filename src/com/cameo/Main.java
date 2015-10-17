package com.cameo;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        //Created string variables so the song names wouldn't have to be continuously retyped
        String stairway = "Stairway to Heaven";
        String ace = "Ace of Spades";
        String dark = "Dark Side of the Moon";
        String hotel = "Hotel California";

        // HashMap of Songs
        HashMap<String, Integer> recordList = new HashMap<String, Integer>();
        recordList.put(stairway, 0);
        recordList.put(ace, 0);
        recordList.put(dark, 0);
        recordList.put(hotel, 0);

        //Create set of the songs
        Set<Map.Entry<String, Integer>> set = recordList.entrySet();
        System.out.println(set);

        int previousRecord = 0;
        //Assuming 30 records can be played in 24 hours
        for (int i = 0; i < 30; i++) {
            System.out.println("Hey DJ! What album would you like to play next?");
            System.out.println("Enter 1 for " + stairway + ", 2 for " + ace + ", 3 for " + dark + ", 4 for " + hotel);
            /*TODO Ask Clara-the following code didn't work because hashmaps aren't indexed. Other than the line of code
            above, how would you recommend assigning a number to each element?*/
//        int increment = 1;
//        for (Map.Entry<String, Integer> record : set){
//            System.out.println("Enter " + increment + " for " + record.getKey());
//            increment++;
//        }

            Scanner s = new Scanner(System.in);
            int recordChoice = s.nextInt();
            if (recordChoice < 1 || recordChoice > 4){
                System.out.println("You have not entered a valid album number. Choose a different one.");
            }
            if (previousRecord == recordChoice) {
                System.out.println("You just played this record. Choose a different one.");
            } else {
                switch (recordChoice) {
                    case 1:
                        okToPlay(stairway, recordList);
                        break;
                    case 2:
                        okToPlay(ace, recordList);
                        break;
                    case 3:
                        okToPlay(dark, recordList);
                        break;
                    case 4:
                        okToPlay(hotel, recordList);
                        break;
                }
                previousRecord = recordChoice;
            }
        }
    }

    public static void okToPlay(String record, HashMap recordList) {

        int timesPlayed = (int) recordList.get(record);

        Collection values = recordList.values();

        int smallestNumberTimesPlayed = (int) Collections.min(values);
        if (timesPlayed < (smallestNumberTimesPlayed + 4)) {
            System.out.println("Now playing: " + record + "\n");
            recordList.put(record, timesPlayed + 1);
        } else {
            System.out.println("You are overplaying this album. You must choose another.");
        }
    }
}
