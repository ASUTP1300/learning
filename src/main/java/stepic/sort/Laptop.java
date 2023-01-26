package stepic.sort;

import java.util.*;
import java.util.function.IntPredicate;

public class Laptop {
    private final String brand;
    private final int numberOfCores;
    private final double displaySize;

    public Laptop(String brand, int numberOfCores, double displaySize) {
        this.brand = brand;
        this.numberOfCores = numberOfCores;
        this.displaySize = displaySize;
    }

    public String getBrand() {
        return brand;
    }

    public int getNumberOfCores() {
        return numberOfCores;
    }

    public double getDisplaySize() {
        return displaySize;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "brand='" + brand + '\'' +
                ", numberOfCores=" + numberOfCores +
                ", displaySize=" + displaySize +
                '}';
    }
}



class Account {
    private String owner;
    private final boolean locked;
    private double balance;


    public Account(String owner, boolean locked, double balance) {
        this.owner = owner;
        this.locked = locked;
        this.balance = balance;
    }

    public String getOwner() {
        return owner;
    }

    public boolean isLocked() {
        return locked;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "owner='" + owner + '\'' +
                ", locked=" + locked +
                ", balance=" + balance +
                '}';
    }
}

class LongRange {
    private final long left;
    private final long right;

    public static Comparator<LongRange> getComparator() {
        // write your code her
        Comparator<LongRange> longRangeComparator = Comparator.comparingLong(r -> r.getLeft() - r.getRight());

        return longRangeComparator.thenComparing(LongRange::getLeft);
        //Comparator.comparing( r -> r.getLeft() - r.getRight()).thenComparing(LongRange::getLeft);
    }

    public LongRange(long left, long right) {
        this.left = left;
        this.right = right;
    }

    public long getLeft() {
        return left;
    }

    public long getRight() {
        return right;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        LongRange longRange = (LongRange) other;
        return left == longRange.left &&
                right == longRange.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }

    @Override
    public String toString() {
        return String.format("%d %d", left, right);
    }
}
class Main {
    public static void main(String[] args) {

        learn(x -> System.out.println("Число:" +  x));

        List<Integer> spendings = List.of(12, 1, 345, 1);
        System.out.println("Сумма - " + spendings.stream().reduce(Integer::sum).get());
        List<Laptop> laptops = new ArrayList<>(List.of(
                new Laptop("HP", 4, 15.6),
                new Laptop("HP", 3, 15.6),
                new Laptop("Apple", 6, 15.6),
                new Laptop("Asus", 4, 14.1),
                new Laptop("Dell", 8, 17.0),
                new Laptop("OLD but work", 1, 15.1)));


        System.out.println(Math.pow(4, 2));
        Comparator<Laptop> laptopComparator = Comparator.comparing(Laptop::getBrand);
        Set<Laptop> laptopSet = new TreeSet<Laptop>(laptopComparator);
        laptopSet.addAll(laptops);

        /*
            FOURTH CHANGE!!!



         */
//        Arrays.stream().


        laptopSet.forEach(x -> System.out.println("Set item " + x));


          //          Collector<Laptop, Laptop, TreeSet<Laptop>>
//

        IntPredicate predicate = x -> true;
//        predicate.



//        List<String> strings = new ArrayList<>(List.of("Mother", "I", "Brother", "Sister", "Son"));
//        Comparator<String> stringComparator1 = (s1, s2) -> Integer.compare(s2.length(), s1.length());
//
//        strings.sort(stringComparator1);
//        System.out.println("First way:");
//        strings.forEach(System.out :: println);
//        System.out.println("-----\n");
//
//        strings.sort(Comparator.naturalOrder());
//        System.out.println("Second way:");
//        strings.forEach(System.out :: println);
//        System.out.println("-----\n");
//
//        strings.sort(Comparator.comparingInt(String::length));
//        System.out.println("Third way:");
//        strings.forEach(System.out :: println);
//        System.out.println("-----\n");
//
//        //This method sorts laptops by number of cores descending and if number is the same for several objects,
//        //also sorts them by display size ascending
//        laptops.sort(Comparator
//                .comparing(Laptop::getNumberOfCores, Comparator.reverseOrder())
//                .thenComparingDouble(Laptop::getDisplaySize));
//        System.out.println("Sort by cores and display size:");
//        laptops.forEach(System.out::println);
//        System.out.println("-----\n");

//
//        //ACCOUNTS
//        List<Account> accounts = new ArrayList<>(List.of(
//                new Account("Ruslan", true, 1),
//                new Account("Dima", true, 1),
//                new Account("Avik", true, 1)
//        ));
//
//        //Sort by locked
//        accounts.sort(Comparator.comparing(Account::isLocked, Comparator.reverseOrder())
//                .thenComparing(Account::getBalance, Comparator.reverseOrder())
//                .thenComparing(Account::getOwner));
//        accounts.forEach(System.out :: println);
//
//        System.out.println(Integer.compare((6), 4));


    }
    static void learn(Example example){
        example.test(12);
    }

    interface Example {
        void test(Integer num);
    }
}
