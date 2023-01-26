package stepic.bygroup;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) {
        List<XmlFile> xmlFiles = List.of(
                new XmlFile("1", "UTF-8", List.of(new Tag("function"), new Tag("load"))),
                new XmlFile("2", "UTF-8", List.of(new Tag("table"), new Tag("main"))),
                new XmlFile("3", "ASCII", List.of(new Tag("row"), new Tag("column"))),
                new XmlFile("4", "ASCII", List.of(new Tag("sheet"), new Tag("row"))),
                new XmlFile("5", "ASCII", List.of(new Tag("sheet"), new Tag("column")))
        );

        Map<String, Long> map1 = xmlFiles.stream().collect(Collectors.groupingBy(XmlFile::getEncoding, Collectors.counting()));
        System.out.println(map1);

        Predicate<List<Tag>> predicate = list -> list.stream().anyMatch(tag -> tag.getName().equals("sheet"));
        Map<String, Long> map2 = xmlFiles.stream().collect(Collectors.groupingBy(XmlFile::getEncoding,
                Collectors.mapping(XmlFile::getTags,
                        Collectors.filtering(predicate,
                                Collectors.flatMapping(Collection::stream,
                                        Collectors.counting())))));
        System.out.println(map2);


        Map<String, Long> map3 = xmlFiles.stream().collect(Collectors.groupingBy(XmlFile::getEncoding,
                Collectors.mapping(XmlFile::getTags,
                        Collectors.filtering(predicate,
                                Collectors.flatMapping(Collection::stream,
                                        Collectors.counting())))));
        System.out.println(map3);


        System.out.println(countAllByTagName(xmlFiles, "sheet"));







        Reader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        Map<String,Long> map= bufferedReader.lines().map(String::toLowerCase)
                .flatMap(s -> Stream.of(s.split("[^а-яА-Яa-zA-Z0-9]{1,}")))
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));


        Stream<Map.Entry<String, Long>> stream = (map.entrySet().stream());

        stream.sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(10)
                .map(Map.Entry::getKey)
                .forEach(System.out :: println);

    }

    public static Map<String, Long> countAllByTagName(List<XmlFile> files, String tagName) {
        Predicate<List<Tag>> predicate = list -> list.stream().anyMatch(tag -> tag.getName().equals(tagName));

        return files.stream().collect(
                Collectors.groupingBy(XmlFile::getEncoding,
                        Collectors.mapping(XmlFile::getTags,
                                Collectors.filtering(predicate,
                                        Collectors.flatMapping(Collection::stream,
                                                Collectors.counting())))));
    }
}

class Tag {
    private final String name;

    public Tag(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class XmlFile {
    private final String id;
    private final String encoding;
    private final List<Tag> tags;

    public XmlFile(String id, String encoding, List<Tag> tags) {
        this.id = id;
        this.encoding = encoding;
        this.tags = tags;
    }

    public String getId() {
        return id;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public String getEncoding() {
        return encoding;
    }
}