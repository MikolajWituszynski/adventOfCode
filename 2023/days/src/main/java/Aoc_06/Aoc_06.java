package Aoc_06;

import java.util.ArrayList;
import java.util.List;

public class Aoc_06
{

    public static void main(String[] args) {
            int timeFixed = 7;
            int distanceRecord = 9;
            int startingTime = timeFixed;
            Boat boatOne = new Boat(timeFixed);
            List<Integer> distances = new ArrayList<>();
            for(int i = 0; i <= timeFixed; i++) {
                System.out.println("time to hold: " + i + "time: " + startingTime);
                int distance = boatOne.speed(startingTime,i);
                System.out.println("distance: " + distance);
                if(distance >  distanceRecord) {
                    distances.add(distance);
                }
                System.out.println("disnces update: " + distances);

                startingTime--;
            }
        System.out.println("distance: " + distances);
            int waysToBeatRecord = distances.size();
        System.out.println("Ways to beat record: " + waysToBeatRecord);
    }

    public static class Boat {

        int time;

        public Boat(int time) {

            this.time = time;
        }

        public int speed(int time, int distance) {
            return distance*time;
        }

        public int waysToBeatRecord() {

        }


    }

}
