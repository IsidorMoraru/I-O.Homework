package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.example.Athlete.*;
/* DESCRIPTION - Ski Biathlon Standings

        write a software that takes as an input a CSV file where every entry represents the results of a biathlon athlete
        based on the entries identify the first 3 places (Winner, Runner-up and Third Place)
        the rules are simple, each athlete has a time-results for the entire skiing session, and 3 shooting range results
        each shooting range has 5 shot results
        for every missed shot the athlete obtains a 10 second penalty which affects the final time-result
final standings are based on the time-results that have been updated with the shooting range results
        CSV example

        11,Umar Jorgson,SK,30:27,xxxox,xxxxx,xxoxo

        1,Jimmy Smiles,UK,29:15,xxoox,xooxo,xxxxo

        27,Piotr Smitzer,CZ,30:10,xxxxx,xxxxx,xxxxx

        COLUMNS

        AthleteNumber,AthleteName,CountryCode,SkiTimeResult(Minutes:Seconds),FirstShootingRange.SecondShooting,ThirdShooting

        every shooting range consists of 5 characters, where x means hit, o mean miss
        for every o there should be 10 seconds added to the final time
        RESULTS

        Winner - Piotr Smitzer 30:10 (30:10 + 0)

        Runner-up - Jimmy Smiles 30:15 (29:15 + 60)

        Third Place - Umar Jorgson 30:57 (30:27 + 30)

        TASK

        write tests for the CSV parsing and the standing calculation

        in the your tests you must not use real files

        make sure the CSVs are read from memory to keep the tests fast

        use Comparator / Comparable for sorting

        use at least 1 Enum (in any situation) and at least 2 Annotations (they don't need to be custom)*/

public class CSVReader {


    public static Athlete readFromCSV(){

        // Read from CSV
        List<String> rows= new ArrayList<>();
        try {
            BufferedReader bf = new BufferedReader( new FileReader("file.csv"));

            String line;
            while(bf.readLine()!=null) {
                line = bf.readLine();
                rows.add(line);
            }

        } catch (FileNotFoundException e) {
            System.err.println(e);
        } catch (IOException e) {
            System.err.println(e);
        }

        ////////////////////////////////////////////////////


        //List of arrays that contains split rows.


        String[] atSplit;
        List<Athlete> athletes=new ArrayList<>();
        for(String s:rows){
            atSplit=s.split(",");
             Athlete atlet =new Athlete();
             atlet.setAthleteNumber(atSplit[0]);
             atlet.setAthleteName(atSplit[1]);
             atlet.setCountryCode(atSplit[2]);
             atlet.setSkiTimeResult(atSplit[3]);
             atlet.setFirstShootingRange(atSplit[4]);
             atlet.setSecondShooting(atSplit[5]);
             atlet.setThirdShooting(atSplit[6]);
             athletes.add(atlet);
            System.out.println(atlet.toString());
        }

            for(Athlete atlet:athletes){
                String minutesString=atlet.getSkiTimeResult().substring(0,2);
                String secondsString=atlet.getSkiTimeResult().substring(atlet.getSkiTimeResult().length()-2);
                int minutes=Integer.parseInt(minutesString);
                int seconds=Integer.parseInt(secondsString);
                int totalSecond=minutes*60+seconds;

                String allShots=atlet.getFirstShootingRange()+atlet.getSecondShooting()+atlet.getThirdShooting();
                int count=0;
                for(int i=1; i<=allShots.length()-1; i++){
                    if(allShots.charAt(i)=='o'){
                        count++;
                    }
                }
                atlet.setSecondsPenality(count*10);
                int totalMiunutes=((totalSecond+ atlet.getSecondsPenality())-(totalSecond+ atlet.getSecondsPenality())%60)/60;
                int totalSeconds=(totalSecond+atlet.getSecondsPenality())%60;

                int totalTimeInSeconds=totalMiunutes*60+totalSeconds;

                atlet.setTotalTimeInSeconds(totalTimeInSeconds);
                System.out.println(totalMiunutes+":"+totalSeconds);
                atlet.setFinalTime(totalMiunutes+":"+totalSeconds);
            }

            athletes.sort(new Comparator<Athlete>() {
                @Override
                public int compare(Athlete o1, Athlete o2) {
                    return o1.getTotalTimeInSeconds()-o2.getTotalTimeInSeconds();
                }
            });

        System.out.println("Winner - "
                +athletes.get(0).getAthleteName()+" "
                +athletes.get(0).getFinalTime()+" ("
                + athletes.get(0).getFinalTime()+" +"
                + athletes.get(0).getSecondsPenality()+")");
        System.out.println("Runner-up - "
                +athletes.get(1).getAthleteName()+" "
                +athletes.get(1).getFinalTime()+" ("
                + athletes.get(1).getFinalTime()+" +"
                + athletes.get(1).getSecondsPenality()+")");
        System.out.println("Third Place - "
                +athletes.get(2).getAthleteName()+" "
                +athletes.get(2).getFinalTime()+" ("
                + athletes.get(2).getFinalTime()+" +"
                + athletes.get(2).getSecondsPenality()+")");



        return null;
    }
}
