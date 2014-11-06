import java.util.Random;

public class Case1 {

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        CaseObject object = new CaseObject();
        boolean result = true;
        while (result) {
            result = object.execute(random.nextInt(1000));
            Thread.sleep(2000);
        }
    }

}

