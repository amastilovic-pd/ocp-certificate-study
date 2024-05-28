package chapter13;

public class CheckResult {

    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            for (int i = 0; i < 5000000; i++) {
                CheckResult.counter++;
            }
        }).start();

        while (CheckResult.counter < 4000000) {
            System.out.println("Not reached yet");
            Thread.sleep(1);
        }

        System.out.println("Out of the main thread");
    }
}
