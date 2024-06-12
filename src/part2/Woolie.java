package part2;

/*
@ASSESSME.USERID: 7514@rit.edu
@ASSESSME.AUTHOR: Guifei Teng
@ASSESSME.LANGUAGE: JAVA
@ASSESSME.DESCRIPTION: ASS10.1
@ASSESSME.ANALYZE: YES
*/

public class Woolie implements Runnable {

    private String name;
    private final int crossingTime;
    private final City startCity;
    private final City destinationCity;
    private final Bridge bridge; // new add bridge

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

    public Woolie(String name, int crossingTime, City startCity, City destinationCity, Bridge bridge) {
        this.name = name;
        this.crossingTime = crossingTime;
        this.startCity = startCity;
        this.destinationCity = destinationCity;
        this.bridge = bridge; // add bridge

    }

    @Override
    public void run() {
        try {
            while (!bridge.enterBridge()) {
                Thread.sleep(500);
            }
            System.out.println(name + " has arrived at the bridge at " + startCity + ".");
            System.out.println(name + " is starting to cross.");
            for (int i = 1; i <= crossingTime; i++) {
                Thread.sleep(1000);
                System.out.println("\t" + name + ": " + i + " second" + (i > 1 ? "s." : "."));
            }
            System.out.println(name + " arrives at " + destinationCity + ".");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bridge.leaveBridge();
        }
    }

}