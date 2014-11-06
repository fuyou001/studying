public class CaseObject{

    private  int sleepTotalTime=0;

    public boolean execute(int sleepTime) throws InterruptedException {
        System.out.println("sleep: "+sleepTime);
        sleepTotalTime+=sleepTime;
        Thread.sleep(sleepTime);
        return true;
    }

    public int getSleepTotalTime() {
        return sleepTotalTime;
    }

    public void setSleepTotalTime(int sleepTotalTime) {
        this.sleepTotalTime = sleepTotalTime;
    }
}

