package stepic.optional;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        Account account1 = new Account("Account1", "pro");
        Account account2 = new Account("Account2", "pro");
        Account account3 = new Account("Account3", "simple");
        Set usersSet = new HashSet();


        usersSet.add(new User("User1", account1));
        usersSet.add(new User("User2", account2));
        usersSet.add(new User("User3", null));
        FindUserQuiz.printLoginIfPro(usersSet, "Account1");//print User1
        FindUserQuiz.printLoginIfPro(usersSet, "Account3");//doesn't print anything
        FindUserQuiz.printLoginIfPro(usersSet, "Account22");//doesn't print anything
    }

}

class FindUserQuiz {

    public static void printLoginIfPro(Set<User> users, String id) {
        // write your code here


        for (User user : users) {
            if (Optional.ofNullable(user.getAccount()).flatMap(User::getAccount).filter(u -> u.get().getId().equals(id) && u.get().getType().equals("pro")).isPresent())
                System.out.println(user.getLogin());
        }
    }

    public static Optional<User> findUserByAccountId(Set<User> users, String id) {
        // write your code here
        for (User user : users) {
            if (user.getAccount().isPresent()) {
                if (id.equals(user.getAccount().get().getId())) {
                    return Optional.of(user);
                }
            }
        }
        return Optional.empty();
    }
}

class Account {
    private String id;
    private String type;

    public Account(String id, String type) {
        this.id = id;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

}

class User {
    private final String login;
    private final Account account;

    public User(String login, Account account) {
        this.login = login;
        this.account = account;
    }

    public String getLogin() {
        return login;
    }

    public Optional<Account> getAccount() {
        return Optional.ofNullable(account);
    }
}