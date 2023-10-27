package usa;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

//You are playing a game where your character jumps fences. The values in the array mean how many fences the character must jump, moving forward, starting from that index. For example,
// in the array [2, 1, 0], from index zero you must jump to index two, from index one you must jump to index two, from index two you must stay where you are. You can swap elements in the array. And outside the whole array is an abyss from which you can't climb out.
//
//        To win, the character has to go from index zero to the last. Output true if it is possible to win the game, otherwise false.
//
//        Input:
//
//        fences - is an array of jump lengths. The character starts with a zero index, 1<length(fences)<=20, 10<=fences[i]<=15
//        Output:
//
//        boolean - is it possible to win. It is impossible to win, if even with permutations of elements in the array it will be impossible for the character to reach the last index in the array
//        Example 1:
//
//        fences = [0, 2, 4, 1, 6, 2]
//        getResult(fences) = True // One of the possible options: [1, 4, 2, 0, 6, 2]. The hero jumped from index 0 to index 1 and immediately managed to jump to the last index - he won
//        Example 2:
//
//        fences = [2,-1,0,2]
//        getResult(fences) = True // Option of the victory: [2, 2, -1, 0]. The hero jumped from index 0 to index 2, then back to index 1 and then to the last index 2 - he won
public class Main {

    static String text = """
               Фрэш Фиш
               ТПП МЕРКУРИЙ OOO
               Alfa Telecom
               ОСС Урал
               Волготелком
            """;


    public static void main(String[] args) throws IOException {
    }

    static int jump(int[] a, int l, int h) {
        if (l == h) {
            return 0;
        }

        int n = 0;

        for (int i = l + 1; i + l < a.length && i <= a[l]; i++) {
            n = 1 + jump(a, i, h);
        }
        return n;
    }


    static boolean jumpBoolean(int[] a, int l, int h) {
        if (l == h) {
            return true;
        }
        return l + a[l] < a.length && jumpBoolean(a, l + a[l], h);
    }

    static String tests =
            """
                                    assertAll( "Test match actionId",
                                        { assertEquals(1, workLists[0].actionId, "actionId 0 is wrong") },
                                        { assertEquals(2, workLists[1].actionId, "actionId 1 is wrong") },
                                        { assertEquals(3, workLists[2].actionId, "actionId 2 is wrong") },
                                        { assertEquals(4, workLists[3].actionId, "actionId 3 is wrong") },
                                        { assertEquals(5, workLists[4].actionId, "actionId 4 is wrong") }
                                    )
                                    assertAll("Test match contractId",
                                        { assertEquals(2593212, workLists[0].contractId, "contractId 0 is wrong") },
                                        { assertEquals(2654779, workLists[1].contractId, "contractId 1 is wrong") },
                                        { assertEquals(2750287, workLists[2].contractId, "contractId 2 is wrong") },
                                        { assertEquals(2877055, workLists[3].contractId, "contractId 3 is wrong") },
                                        { assertEquals(2464106, workLists[4].contractId, "contractId 4 is wrong") },
                                    )
                                    assertAll("Test match contractNumber",
                                        { assertEquals("DC336", workLists[0].contractNumber, "contractNumber 0 is wrong") },
                                        { assertEquals("FO238", workLists[1].contractNumber, "contractNumber 1 is wrong") },
                                        { assertEquals("IL937", workLists[2].contractNumber, "contractNumber 2 is wrong") },
                                        { assertEquals("KU818", workLists[3].contractNumber, "contractNumber 3 is wrong") },
                                        { assertEquals("CAAGI.", workLists[4].contractNumber, "contractNumber 4 is wrong") },
                                    )
                                    assertAll("Test match contractName",
                                        { assertEquals("\\"ТД \\"Лайтпак\\", ООО", workLists[0].contractName, "contractName 0 is wrong") },
                                        { assertEquals("ЗАО \\"МирТелеКом имени Э.К. Первышина\\"", workLists[1].contractName,
                                            "contractName 1 is wrong") },
                                        { assertEquals("ТСЖ \\"Грань\\", ТСЖ", workLists[2].contractName, "contractName 2 is wrong") },
                                        { assertEquals("Zolali Alireza Soleiman", workLists[3].contractName,
                                            "contractName 3 is wrong") },
                                        { assertEquals("ООО \\"Элемент\\"", workLists[4].contractName, "contractName 4 is wrong") }
                                    )
                                    assertAll("Test match owner",
                                        { assertEquals("Петровская Анастасия Владимировна", workLists[0].owner, "owner 0 is wrong") },
                                        { assertEquals("Петровская Анастасия Владимировна", workLists[1].owner, "owner 1 is wrong") },
                                        { assertEquals("Петровская Анастасия Владимировна", workLists[2].owner, "owner 2 is wrong") },
                                        { assertEquals("Акчурина Елена Сергеевна", workLists[3].owner, "owner 3 is wrong") },
                                        { assertEquals("Акчурина Елена Сергеевна", workLists[4].owner, "owner 4 is wrong") }
                                    )
                                    assertAll("Test match companyGroup",
                                        { assertEquals("Фрэш Фиш"  , workLists[0].companyGroup, "companyGroup 0 is wrong") },
                                        { assertEquals("ТПП МЕРКУРИЙ OOO", workLists[1].companyGroup, "companyGroup 1 is wrong") },
                                        { assertEquals("Alfa Telecom", workLists[2].companyGroup, "companyGroup 2 is wrong") },
                                        { assertEquals("ОСС Урал", workLists[3].companyGroup, "companyGroup 3 is wrong") },
                                        { assertEquals("Волготелком", workLists[4].companyGroup, "companyGroup 4 is wrong") },
                                    )
                                    assertAll("Test match type",
                                        { assertEquals("Звонок", workLists[0].type, "type 0 is wrong") },
                                        { assertEquals("Звонок", workLists[1].type, "type 1 is wrong") },
                                        { assertEquals("Звонок", workLists[2].type, "type 2 is wrong") },
                                        { assertEquals("Звонок", workLists[3].type, "type 3 is wrong") },
                                        { assertEquals("Звонок", workLists[4].type, "type 4 is wrong") }
                                    )
                                    assertAll("Test match status",
                                        { assertEquals("RUNNING", workLists[0].status, "status 0 is wrong") },
                                        { assertEquals("OPEN", workLists[1].status, "status 1 is wrong") },
                                        { assertEquals("OPEN", workLists[2].status, "status 2 is wrong") },
                                        { assertEquals("CLOSED", workLists[3].status, "status 3 is wrong") },
                                        { assertEquals("CLOSED", workLists[4].status, "status 4 is wrong") }
                                    )
                                    assertAll("Test match result",
                                        { assertEquals("Повторная коммуникация", workLists[0].result, "result 0 is wrong") },
                                        { assertEquals("Повторная коммуникация", workLists[1].result, "result 1 is wrong") },
                                        { assertEquals("Повторная коммуникация", workLists[2].result, "result 2 is wrong") },
                                        { assertEquals("Повторная коммуникация", workLists[3].result, "result 3 is wrong") },
                                        { assertEquals("Повторная коммуникация", workLists[4].result, "result 4 is wrong") }
                                    )
                                    assertAll("Test match actualStartDate",
                                        { assertEquals(LocalDateTime.parse("2023-06-01 00:00:01.000", localDateTimeFormatter).atZone(ZoneId.systemDefault()), workLists[0].actualStartDate, "actualStartDate 0 is wrong") },
                                        { assertEquals(LocalDateTime.parse("2023-06-02 00:00:00.000", localDateTimeFormatter).atZone(ZoneId.systemDefault()), workLists[1].actualStartDate, "actualStartDate 1 is wrong") },
                                        { assertEquals(LocalDateTime.parse("2023-06-03 00:00:00.000", localDateTimeFormatter).atZone(ZoneId.systemDefault()), workLists[2].actualStartDate, "actualStartDate 2 is wrong") },
                                        { assertEquals(LocalDateTime.parse("2023-05-04 00:00:00.000", localDateTimeFormatter).atZone(ZoneId.systemDefault()), workLists[3].actualStartDate, "actualStartDate 3 is wrong") },
                                        { assertEquals(LocalDateTime.parse("2023-05-05 00:00:00.000", localDateTimeFormatter).atZone(ZoneId.systemDefault()), workLists[4].actualStartDate, "actualStartDate 4 is wrong") }
                                    )
                                    assertAll("Test match actualEndDate",
                                        { assertEquals(LocalDateTime.parse("2023-07-26 00:00:01.000", localDateTimeFormatter).atZone(ZoneId.systemDefault()), workLists[0].actualEndDate, "actualEndDate 0 is wrong") },
                                        { assertEquals(LocalDateTime.parse("2023-07-20 00:00:02.000", localDateTimeFormatter).atZone(ZoneId.systemDefault()), workLists[1].actualEndDate, "actualEndDate 1 is wrong") },
                                        { assertEquals(LocalDateTime.parse("2023-07-19 00:00:03.000", localDateTimeFormatter).atZone(ZoneId.systemDefault()), workLists[2].actualEndDate, "actualEndDate 2 is wrong") },
                                        { assertEquals(LocalDateTime.parse("2023-06-21 07:12:04.000", localDateTimeFormatter).atZone(ZoneId.systemDefault()), workLists[3].actualEndDate, "actualEndDate 3 is wrong") },
                                        { assertEquals(LocalDateTime.parse("2023-06-24 08:45:05.000", localDateTimeFormatter).atZone(ZoneId.systemDefault()), workLists[4].actualEndDate, "actualEndDate 4 is wrong") }
                                    )
                                    assertAll("Test match createdOn",
                                        { assertEquals(LocalDate.parse("2023-08-01 12:40:05.894", localDateTimeFormatter), workLists[0].createdOn, "createdOn 0 is wrong") },
                                        { assertEquals(LocalDate.parse("2023-08-02 12:40:05.894", localDateTimeFormatter), workLists[1].createdOn, "createdOn 1 is wrong") },
                                        { assertEquals(LocalDate.parse("2023-08-03 12:40:05.894", localDateTimeFormatter), workLists[2].createdOn, "createdOn 2 is wrong") },
                                        { assertEquals(LocalDate.parse("2023-08-04 12:40:05.000", localDateTimeFormatter), workLists[3].createdOn, "createdOn 3 is wrong") },
                                        { assertEquals(LocalDate.parse("2023-08-05 12:40:06.894", localDateTimeFormatter), workLists[4].createdOn, "createdOn 4 is wrong") }
                                    )
                                    assertAll("Test match borderDate",
                                        { assertEquals(LocalDate.parse("2023-07-11 09:10:00.000", localDateTimeFormatter), workLists[0].borderDate, "borderDate 0 is wrong") },
                                        { assertEquals(LocalDate.parse("2023-07-11 09:10:00.000", localDateTimeFormatter), workLists[1].borderDate, "borderDate 1 is wrong") },
                                        { assertEquals(LocalDate.parse("2023-07-11 09:00:00.000", localDateTimeFormatter), workLists[2].borderDate, "borderDate 2 is wrong") },
                                        { assertEquals(LocalDate.parse("2023-06-23 09:10:00.000", localDateTimeFormatter), workLists[3].borderDate, "borderDate 3 is wrong") },
                                        { assertEquals(LocalDate.parse("2023-06-23 09:10:00.000", localDateTimeFormatter), workLists[4].borderDate, "borderDate 4 is wrong") }
                                    )
                                    assertAll("Test match strategy",
                                        { assertEquals("Миграция - передача в КА", workLists[0].strategy, "strategy 0 is wrong") },
                                        { assertEquals("Миграция - передача в КА", workLists[1].strategy, "strategy 1 is wrong") },
                                        { assertEquals("Миграция - отключение", workLists[2].strategy, "strategy 2 is wrong") },
                                        { assertEquals("Миграция - стратегия без шагов", workLists[3].strategy, "strategy 3 is wrong") },
                                        { assertEquals("Передача в КА для отключенных", workLists[4].strategy, "strategy 4 is wrong") }
                                    )
                                    assertAll("Test match amountStart",
                                        { assertEquals(1655.23f, workLists[0].amountStart, "amountStart 0 is wrong") },
                                        { assertEquals(206919.98f, workLists[1].amountStart, "amountStart 1 is wrong") },
                                        { assertEquals(573.72f, workLists[2].amountStart, "amountStart 2 is wrong") },
                                        { assertEquals(22200.00f, workLists[3].amountStart, "amountStart 3 is wrong") },
                                        { assertEquals(1020.10f, workLists[4].amountStart, "amountStart 4 is wrong") },
                                    )
                                    assertAll("Test match amountFinish",
                                        { assertEquals(1.00f, workLists[0].amountFinish, "amountFinish 0 is wrong") },
                                        { assertEquals(2.00f, workLists[1].amountFinish, "amountFinish 1 is wrong") },
                                        { assertEquals(3.00f, workLists[2].amountFinish, "amountFinish 2 is wrong") },
                                        { assertEquals(4.00f, workLists[3].amountFinish, "amountFinish 3 is wrong") },
                                        { assertEquals(5.00f, workLists[4].amountFinish, "amountFinish 4 is wrong") },
                                    )
                                    assertAll("Test match salesPoint",
                                        { assertEquals("Екатеринбург", workLists[0].salesPoint, "salesPoint 0 is wrong") },
                                        { assertEquals("Москва", workLists[1].salesPoint, "salesPoint 1 is wrong") },
                                        { assertEquals("Хабаровск", workLists[2].salesPoint, "salesPoint 2 is wrong") },
                                        { assertEquals("Москва", workLists[3].salesPoint, "salesPoint 3 is wrong") },
                                        { assertEquals("Воронеж", workLists[4].salesPoint, "salesPoint 4 is wrong") }
                                    )
                                    assertAll("Test match timeZone",
                                        { assertEquals("(UTC + 05:00) Уральское (RTZ 4)", workLists[0].timeZone, "timeZone 0 is wrong") },
                                        { assertEquals("(UTC + 03:00) Москва, Санкт-Петербург, Волгоградская (RTZ 2)", workLists[1].timeZone, "timeZone 1 is wrong") },
                                        { assertEquals("(UTC + 10:00) Владивосток Магадан (RTZ 9)", workLists[2].timeZone, "timeZone 2 is wrong") },
                                        { assertEquals("(UTC + 03:00) Москва, Санкт-Петербург, Волгоградская (RTZ 2)", workLists[3].timeZone, "timeZone 3 is wrong") },
                                        { assertEquals("(UTC + 03:00) Москва, Санкт-Петербург, Волгоградская (RTZ 2)", workLists[4].timeZone, "timeZone 4 is wrong") }
                                    )
                                    assertAll("Test match isAuto",
                                        { assertEquals("MANUAL", workLists[0].isAuto, "isAuto 0 is wrong") },
                                        { assertEquals("MANUAL",workLists[1].isAuto, "isAuto 1 is wrong") },
                                        { assertEquals("MANUAL",workLists[2].isAuto, "isAuto 2 is wrong") },
                                        { assertEquals("MANUAL", workLists[3].isAuto, "isAuto 3 is wrong") },
                                        { assertEquals("MANUAL", workLists[4].isAuto, "isAuto 4 is wrong") }
                                    )
                                    assertAll("Test match title",
                                        { assertEquals("Коммуникация с клиентом", workLists[0].title, "title 0 is wrong") },
                                        { assertEquals("Коммуникация с клиентом",workLists[1].title, "title 1 is wrong") },
                                        { assertEquals("Повторная коммуникация",workLists[2].title, "title 2 is wrong") },
                                        { assertEquals("Повторная коммуникация", workLists[3].title, "title 3 is wrong") },
                                        { assertEquals("Повторная коммуникация", workLists[4].title, "title 4 is wrong") }
                                    )
                                   
                                
                    """;
}
