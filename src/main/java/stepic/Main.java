package stepic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.function.*;
import java.math.*;
public class Main {

    Function<String, String> stringConsumer = String::toLowerCase;

    public static void main(String[] args) throws ParseException {
        List<String> stringList = List.of("A33", "B333", "C3333");
        List<String> strings = new ArrayList<>(stringList);
        //stringList.remove(0);
        SimpleDateFormat TEXT_FORMATTER = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date date1 = TEXT_FORMATTER.parse("15-03-2020 10:20:34");
        Date date2 = TEXT_FORMATTER.parse("14-03-2020 10:20:34");


        String str = "Hello, my name is Ruslan Manasipov";
        System.out.println(str.substring(0,30));
        strings.replaceAll(s -> s.substring(0, 2));

        System.out.printf("[%s]",str);



    }

}
class Book {
        private String title;
        private String isbn;

        public Book(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getIsbn() {
            return isbn;
        }

        public void setIsbn(String isbn) {
            this.isbn = isbn;
        }

        public static Book releaseBook(Book book, String isbn) {
            if (Objects.isNull(book.isbn)) {
                book.setIsbn(isbn);
            }
            return book;
        }

        public String getTitleAndIsbnWithSeparator(String separator) {
            return title + separator + isbn;
        }
    }
