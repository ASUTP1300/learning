package stepic.pattern;

public class Examlp {
}
interface SMSService {
    void sendSMS(User user);
}

interface EmailService {

    void sendEmail(User user);
}
// create NotificationStrategy interface and Notifier class here
interface NotificationStrategy {
    void notifyCustomer(User user);
}

class Notifier {
    private NotificationStrategy strategy;

    public Notifier(NotificationStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(NotificationStrategy strategy) {
        this.strategy = strategy;
    }

    public void send(User user) {
        strategy.notifyCustomer(user);
    }
}

class Application2 {

    private EmailService emailService;
    private SMSService smsService;

    public Application2(EmailService emailService, SMSService smsService) {
        this.emailService = emailService;
        this.smsService = smsService;
    }

    public void run(User user) {
        NotificationStrategy sendEmail = u -> emailService.sendEmail(u);
        NotificationStrategy sendSMS = u -> smsService.sendSMS(u);

        Notifier notifier = new Notifier(emailService::sendEmail);
        notifier.send(user);
        notifier.setStrategy(sendSMS);
        notifier.send(user);

        // write your code here
    }
}

class User {
    private final String email;
    private final String phoneNumber;

    User(String email, String phoneNumber) {
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}