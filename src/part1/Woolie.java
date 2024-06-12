package part1;

/*
@ASSESSME.USERID: userID
@ASSESSME.AUTHOR: author, list of authors
@ASSESSME.LANGUAGE: JAVA
@ASSESSME.DESCRIPTION: ASS10.1
@ASSESSME.ANALYZE: YES
*/

public class Woolie implements Runnable {

    private final String name;
    private final int crossingTime;
    private final City startCity;
    private final City destinationCity;

    public enum City {
        COURTWALD, GLASSDELL;

        @Override
        public String toString() {
            switch (this) {
                case COURTWALD:
                    return "Courtwald";
                case GLASSDELL:
                    return "Glassdell";
                default:
                    try {
                        throw new IllegalAccessException();
                    } catch (IllegalAccessException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
            }
            return null;
        }
    }

    public Woolie(String name, int crossingTime, City startCity, City destinationCity) {
        this.name = name;
        this.crossingTime = crossingTime;
        this.startCity = startCity;
        this.destinationCity = destinationCity;

    }

    @Override
    public void run() {
        System.out.println(name + " has arrived at the bridge at " + startCity + ".");
        System.out.println(name + " is starting to cross.");
        for (int i = 1; i <= crossingTime; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("\t" + name + ": " + i + " second" + (i > 1 ? "s." : "."));

        }
        System.out.println(name + " arrives at " + destinationCity + ".");
    }

    public static void main(String[] args) {
        Woolie woolie1 = new Woolie("Ahmed", 5, City.COURTWALD, City.GLASSDELL);
        Woolie woolie2 = new Woolie("Chris", 6, City.GLASSDELL, City.COURTWALD);
        Woolie woolie3 = new Woolie("Bruce", 7, City.COURTWALD, City.GLASSDELL);
        Woolie woolie4 = new Woolie("Bobby", 8, City.GLASSDELL, City.COURTWALD);

        Thread t1 = new Thread(woolie1);
        Thread t2 = new Thread(woolie2);
        Thread t3 = new Thread(woolie3);
        Thread t4 = new Thread(woolie4);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }

}