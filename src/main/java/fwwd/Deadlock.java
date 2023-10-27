package fwwd;

public class Deadlock {

    public static void main(String[] args) {
        Plane plane1 = new Plane(235);
        Plane plane2 = new Plane(532);

        Thread th1 = new Thread(() -> {
            plane1.takeOff(plane2);
        });

        Thread th2 = new Thread(() -> {
            plane2.land(plane1);
        });

        th1.start();
        th2.start();
    }
}

class Plane {
    private int board;

    public Plane(int board) {
        this.board = board;
    }

    public synchronized void takeOff() {
        System.out.printf("Plane board: %s is taking off\n", board);
    }
    public synchronized void takeOff(Plane plane) {
        takeOff();
        plane.takeOff();
    }

    public synchronized void land() {
        System.out.printf("Plane board: %s is landing\n", board);
    }
    public synchronized void land(Plane plane) {
        land();
        plane.land();
    }
}