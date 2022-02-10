import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.IntStream;

public class Main { public static void main(String[] args) throws InterruptedException {

    Total shop1 = new Total(4, 100);
    int[] report1 = shop1.shopReport();
    Total shop2 = new Total(5, 50);
    int[] report2 = shop2.shopReport();
    Total shop3 = new Total(10, 700);
    int[] report3 = shop3.shopReport();

    LongAdder revenueTotalResult = new LongAdder();

    report(report1, revenueTotalResult);
    report(report2, revenueTotalResult);
    report(report3, revenueTotalResult);

    System.out.println("\nTotal Result " + revenueTotalResult.sum() + "\n");
}

    public static void report(int[] report, LongAdder stat) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        IntStream.range(0, report.length)
                .forEach(i -> executorService.submit(() -> stat.add(report[i])));
        executorService.awaitTermination(1, TimeUnit.SECONDS);
        executorService.shutdown();
    }
}
