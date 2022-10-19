package stepic;

import java.util.*;
import java.util.function.BiFunction;


class Main2 {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        List<PhoneNumber> avikPhoneNumbers = new ArrayList<>();
        avikPhoneNumbers.add(new PhoneNumber(PhoneNumberType.HOME, "723324324"));
        avikPhoneNumbers.add(new PhoneNumber(PhoneNumberType.WORK, "000000000"));
        avikPhoneNumbers.add(new PhoneNumber(PhoneNumberType.MOBILE, "88888888"));

        List<PhoneNumber> dimaPhoneNumbers1 = List.of(
                new PhoneNumber(PhoneNumberType.HOME, "84953923473")
        );

        List<PhoneNumber> dimaPhoneNumbers2 = List.of(
                new PhoneNumber(PhoneNumberType.WORK, "11111111111"),
                new PhoneNumber(PhoneNumberType.MOBILE, "89151074532")
        );

        List<PhoneNumber> dimaPhoneNumbers3 = new ArrayList<>();
        dimaPhoneNumbers3.addAll(dimaPhoneNumbers1);
        dimaPhoneNumbers3.addAll(dimaPhoneNumbers2);

        phoneBook.addNewPhoneNumbers("Avik", avikPhoneNumbers);
        phoneBook.addNewPhoneNumbers("Dima", dimaPhoneNumbers1);
        phoneBook.addNewPhoneNumbers("Dima", dimaPhoneNumbers2);

        phoneBook.printPhoneBook();
    }
}


class PhoneBook {
    private final Map<String, Collection<PhoneNumber>> nameToPhoneNumbersMap = new HashMap<>();

    public void addNewPhoneNumbers(String name, Collection<PhoneNumber> numbers) {
//        TODO МОЁ РЕШЕНИЕ
//        Collection<PhoneNumber> modifyList = new ArrayList<>(numbers);
//        BiFunction<Collection<PhoneNumber>,
//                Collection<PhoneNumber>,
//                Collection<PhoneNumber>> phoneNumberBiFunction = (x, y) ->
//        {
//            x.addAll(y);
//            return x;
//        };

//        nameToPhoneNumbersMap.merge(name, modifyList, phoneNumberBiFunction);

//        TODO ЧУЖОЕ РЕШЕНИЕ
//        nameToPhoneNumbersMap.computeIfAbsent(name, k -> new ArrayList<>()).addAll(numbers);


    }

    public void printPhoneBook() {
        // write your code here
        nameToPhoneNumbersMap.forEach((k, v) -> {
            System.out.printf("%s\n", k);
            v.forEach(phoneNumber ->
                    System.out.printf("%s: %s%n", phoneNumber.getType(), phoneNumber.getNumber()));
        });
    }
}

enum PhoneNumberType {
    MOBILE, HOME, WORK,
}

class PhoneNumber {

    private PhoneNumberType type;
    private String number;

    public PhoneNumber(PhoneNumberType type, String number) {
        this.type = type;
        this.number = number;
    }

    public PhoneNumberType getType() {
        return type;
    }

    public String getNumber() {
        return number;
    }
}