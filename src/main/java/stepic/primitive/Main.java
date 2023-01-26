package stepic.primitive;

import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

//Scanner sc = new Scanner(System.in);
//        List<Application> applications = Stream.iterate(1, i -> sc.hasNextLine(), i -> i + 1)
//        .map(i -> sc.nextLine().split("\\s+"))
//        .map(s -> new Application(s[0], Boolean.valueOf(s[1])))
//        .collect(Collectors.toList());
//        Partitioner.getPartition(applications).forEach((k, v) -> System.out.println(k + " = " + v));


public class Main {
    public static void main(String[] args) {
        LongStream longStream = LongStream.of();

//        Collectors.counting()
        LongSummaryStatistics statistics = longStream.summaryStatistics();

        System.out.printf("sum is %s, count is %s, average is %s min is %s\n", statistics.getSum(), statistics.getCount(), statistics.getAverage(), statistics.getMin());

        List<String> strings = List.of("Руслан", "Эльмира", "Тимур", "Адам", "Руслан");

        strings.stream().collect(Collectors.groupingBy(String::length));


        List<Tweet> tweets = List.of(
                new Tweet("100", 1000, "en", List.of("Wow!2", "So cute2")),
                new Tweet("101", 22, "en", List.of("Take a screenshot", "It's my first comment")),
                new Tweet("102", 1300, "ru", List.of("Поздравляю!", "Спасибо")),
                new Tweet("103", 22, "fr", List.of("c'est le meilleur endroit!"))
        );


        Map<String, Long> counts = tweets.stream()
                .collect(Collectors.groupingBy(Tweet::getLang,
                        Collectors.flatMapping(tweet -> tweet.getComments().stream().filter(str -> str.contains("2")), Collectors.counting())));

        System.out.println(counts);
    }
}
