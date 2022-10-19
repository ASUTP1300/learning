package polymorphism;

public class ThomasEdisonPhone extends  Phone {

    ThomasEdisonPhone(int year) {
        super(year);
    }

    @Override
    void call(int outputNumber) {
        System.out.println("Вращайте ручку");
        System.out.println("-Сообщите номер сэр!-");
    }

    @Override
    void ring(int inputNumber) {
        System.out.println("Телефон звонит");
    }
}
