package bank;


import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<String> timeList = List.of("9:00 9:30", "9:45 10:30", "10:15 10:45");
        List<Visit> visits = new ArrayList<>();

        timeList.stream().map( x -> new Visit(x, getAbsoluteMinutes(x.split(" ")[0]), getAbsoluteMinutes(x.split(" ")[1])))
                .forEach(visits::add);
        visits.forEach(System.out :: println);


        Map<String, Integer> mapCount = new HashMap<>();

        int count = 0;
        for(Visit v : visits){
            for(Visit v2 : visits){
                if(v.timeIn <= v2.timeIn && v.timeOut >= v2.timeIn || v.timeIn <= v2.timeOut && v.timeOut >= v2.timeIn){
                    count++;
                }
            }
            mapCount.put(v.period, count);
            count = 0;
        }
        System.out.println(mapCount);
    }

    public static Integer getAbsoluteMinutes(String watchTime){
        String[] strings = watchTime.split(":");
        return Stream.of(strings).map(Integer :: parseInt).reduce(0, (x,y) -> x * 60 + y);
    }

    static class Visit {

        private final String period;

        private Integer timeIn;
        private Integer timeOut;

        public Visit(String period, Integer timeIn, Integer timeOut){
            this.period = period;
            this.timeIn = timeIn;
            this.timeOut = timeOut;
        }

        public Integer getTimeIn(){
            return timeIn;
        }

        public Integer getTimeOut() {
            return timeOut;
        }

        public String getPeriod() {
            return period;
        }

        public void setTimeIn(Integer timeIn){
            this.timeIn = timeIn;
        }

        public void setTimeOut(Integer timeOut){
            this.timeOut = timeOut;
        }

        @Override
        public String toString() {
            return "Visit:\n" +
                    "\tPeriod: " + period + "\n" +
                    "\tTime come(minutes): " + timeIn + "\n" +
                    "\tTime out(minutes) : " + timeOut + "\n" ;
        }
    }
}