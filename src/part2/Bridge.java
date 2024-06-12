package part2;

/*
@ASSESSME.USERID: 7514@rit.edu
@ASSESSME.AUTHOR: Guifei Teng
@ASSESSME.LANGUAGE: JAVA
@ASSESSME.DESCRIPTION: ASS10.1
@ASSESSME.ANALYZE: YES
*/

public class Bridge {

    private boolean pasBridge = true;

    public synchronized boolean enterBridge() {
        if (pasBridge) {
            pasBridge = false;
            return true;
        }
        return false;
    }

    public synchronized void leaveBridge() {
        pasBridge = true;
        notifyAll();
    }

}