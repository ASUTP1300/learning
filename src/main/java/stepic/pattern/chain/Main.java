package stepic.pattern.chain;

import java.security.MessageDigest;
import java.util.Base64;
import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.*;

public class Main {
}
class ChainOfResponsibilityDemo {

    /**
     * Accepts a request and returns new request with data wrapped in the tag <transaction>...</transaction>
     */
    static RequestHandler wrapInTransactionTag = req ->
            new Request(String.format("<transaction>%s</transaction>", req.getData()));

    /**
     * Accepts a request and returns a new request with calculated digest inside the tag <digest>...</digest>
     */
    static RequestHandler createDigest = req -> {
        String digest = "";
        try {
            final MessageDigest md5 = MessageDigest.getInstance("MD5");
            final byte[] digestBytes = md5.digest(req.getData().getBytes("UTF-8"));
            digest = new String(Base64.getEncoder().encode(digestBytes));
        } catch (Exception ignored) {
            System.out.println("An error occurred");
        }
        return new Request(req.getData() + String.format("<digest>%s</digest>", digest));
    };

    /**
     * Accepts a request and returns a new request with data wrapped in the tag <request>...</request>
     */
    static RequestHandler wrapInRequestTag = req ->
            new Request(String.format("<request>%s</request>", req.getData()));

    /**
     * It should represent a chain of responsibility combined from another handlers.
     * The format: commonRequestHandler = handler1.setSuccessor(handler2.setSuccessor(...))
     * The combining method setSuccessor may have another name
     */
    static RequestHandler commonRequestHandler = createDigest.compose(wrapInTransactionTag.compose(wrapInRequestTag));
        // !!! write a combination of existing handlers here

    /**
     * It represents a handler and has two methods: one for handling requests and other for combining handlers
     */
    @FunctionalInterface
    interface RequestHandler {

        Request handle(Request request);

        // !!! write a method handle that accept request and returns new request here
        // it allows to use lambda expressions for creating handlers below

        // !!! write a default method for combining this and other handler single one
        // the order of execution may be any but you need to consider it when composing handlers
        // the method may has any name


//        default <V> Function<V, R> compose(Function<? super V, ? extends T> before) {
//            Objects.requireNonNull(before);
//            return (V v) -> apply(before.apply(v));
//        }

        default RequestHandler compose(RequestHandler handler){
            return request -> handle(handler.handle(request));
        }
    }
    /**
     * Immutable class for representing requests.
     * If you need to change the request data then create new request.
     */
    static class Request {
        private final String data;

        public Request(String requestData) {
            this.data = requestData;
        }

        public String getData() {
            return data;
        }
    }

    // Don't change the code below
    public static void main(String[] args) throws Exception {
        Object o1 = null;
        Object o2 = null;


        System.out.println("o1 equals o2 " + o1.equals(o2));


//        final Scanner scanner = new Scanner(System.in);
//        final String requestData = scanner.nextLine();
//        final Request notCompletedRequest = new Request(requestData);
//        System.out.println(commonRequestHandler.handle(notCompletedRequest).getData());
        Function<String, String> function = addExtension(
                reportName -> reportName.contains("report"),
                logsName -> logsName.contains("logs")
        );

        String file = function.apply("main_report");

        int arg1 = 2;
        int arg2 = 2;

        System.out.println(powInt(arg1, arg2));

        IntFunction<IntFunction<IntFunction<Integer>>> f = arg11 -> arg22 -> arg33 ->
                (arg11 << 2) +arg22 + arg33;
    }


    static Integer powInt(int arg1, int arg2) {
        return arg1 >> arg2;
    }

    static Function<String, String> addExtension(Predicate<String> predicate1, Predicate<String> predicate2) {
        return string -> {
            if(predicate1.test(string)){
                return string + ".xml";
            } else if(predicate2.test(string)){
                return string + ".json";
            }
            return string;
        };
    }

    static Function<String, String> addExtension2(Predicate<String> predicate1, Predicate<String> predicate2) {
        return string -> predicate1.test(string) ?
                string.concat(".xml") : predicate2.test(string) ?
                string.concat(".json"): string;

    }
}