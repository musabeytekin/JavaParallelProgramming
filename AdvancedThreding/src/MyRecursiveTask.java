import java.util.concurrent.RecursiveTask;

public class MyRecursiveTask extends RecursiveTask<Integer> {
    private static final int THRESHOLD = 10;
    private int[] array;
    private int start;
    private int end;

    public MyRecursiveTask(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (end - start <= THRESHOLD) {
            // Eğer iş parçacığı eşiği (threshold) altında bir iş varsa, doğrudan işi yap ve sonucu döndür.
            int sum = 0;
            for (int i = start; i < end; i++) {
                sum += array[i];
            }
            return sum;
        } else {
            // Eğer iş parçacığı eşiğini geçen bir iş varsa, işi daha küçük alt görevlere böl (fork) ve paralel olarak çalıştır.
            int middle = (start + end) / 2;
            MyRecursiveTask leftTask = new MyRecursiveTask(array, start, middle);
            MyRecursiveTask rightTask = new MyRecursiveTask(array, middle, end);

            leftTask.fork();
            rightTask.fork();

            // Alt görevlerin sonuçlarını birleştir (join)
            int leftResult = leftTask.join();
            int rightResult = rightTask.join();

            // Sonuçları birleştir ve dön
            return leftResult + rightResult;
        }
    }
}
