package threads;

public class CarThread extends Thread {

    private final int waitTime;
    private final int startTime;
    private final int parkedTime;
    private final Station station;
    private static int threadQty = 0;
    private final int number = ++threadQty;

    public int getWaitTime() {
        return waitTime;
    }

    public CarThread(int waitTime, int startTime, int parkedTime, Station station) {
        this.waitTime = waitTime;
        this.startTime = startTime;
        this.parkedTime = parkedTime;
        this.station = station;
        start();
    }


    @Override
    public void run() {
        try {
            wait(startTime);
            boolean isAccepted = station.accept(this);
            if (isAccepted) {
                wait(parkedTime);
                station.release(this);
            } else {
                System.out.println(this + "can't wait more");
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }

    public void wait(int seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000L);
    }

    @Override
    public String toString() {
        return "Thread number: " + number
                + " waitTime: " + waitTime
                + " startTime:" + startTime
                + " parkedTime:" + parkedTime
                + "\n";
    }

}