package polymorphism;

abstract class  Phone {

    private int year;

     Phone(int year) {
        this.year = year;
    }

    abstract void call(int outputNumber);

    abstract void ring(int inputNumber);

}
