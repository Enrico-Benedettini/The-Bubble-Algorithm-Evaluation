import java.util.Arrays;
import java.util.List;
import java.util.Random;
import exp01.*;
public class BubbleSortComparison {

    public static void main(String[] args) {
        final int[] arraySizes = {1024, 2048, 4096};
        final int numberOfRuns = 3;

        List<Class<?>> dataTypes = Arrays.asList(Integer.class, Double.class, String.class);

        System.out.println("Different Data Types: ");
        System.out.println();
        for (Class<?> dataType : dataTypes) {
            
            System.out.println("Data Type: " + dataType.getSimpleName());

            for (int run = 1; run <= numberOfRuns; run++) {
                System.out.println("Run #" + run);

                Object[] randomArray = generateRandomArray(1024, dataType);

                runSortAndMeasureTime(randomArray, dataType);

                System.out.println();
            }
        }

        System.out.println("Different Arrays Sizes: ");
        System.out.println();
        for (int size : arraySizes) {
            System.out.println("Array Size: " + size);

            for (int run = 1; run <= numberOfRuns; run++) {
                System.out.println("Run #" + run);

                Object[] randomArray = generateRandomArray(size, Integer.class);

                runSortAndMeasureTime(randomArray, Integer.class);

                System.out.println();
            }
        }

        System.out.println("Different Initial Array States: ");
        System.out.println();

        System.out.println("Array Type: Random Order");
        for (int run = 1; run <= numberOfRuns; run++) {
            System.out.println("Run #" + run);

            Object[] randomArray = generateRandomArray(1024, Integer.class);

            runSortAndMeasureTime(randomArray, Integer.class);

            System.out.println();
        }

        System.out.println("Array Type: Sorted Order");
        for (int run = 1; run <= numberOfRuns; run++) {
            System.out.println("Run #" + run);
            
            Object[] sortedArray = generateSortedArray(1024, Integer.class);

            runSortAndMeasureTime(sortedArray, Integer.class);

            System.out.println();
        }
        
        System.out.println("Array Type: Inverted Sorted Order");
        for (int run = 1; run <= numberOfRuns; run++) {
            System.out.println("Run #" + run);
            
            Object[] invertedSortedArray = generateInvertedSortedArray(1024, Integer.class);

            runSortAndMeasureTime(invertedSortedArray, Integer.class);

            System.out.println();
        }
    }

    private static void runSortAndMeasureTime(Object[] array, Class<?> dataType) {
        
        BubbleSortWhileNeeded<?> bubbleSort1 = new BubbleSortWhileNeeded<>();
        BubbleSortUntilNoChange<?> bubbleSort2 = new BubbleSortUntilNoChange<>();
        BubbleSortPassPerItem<?> bubbleSort3 = new BubbleSortPassPerItem<>();

        if (dataType.equals(Integer.class)) {
            bubbleSort1 = (BubbleSortWhileNeeded<Integer>) bubbleSort1;
            bubbleSort2 = (BubbleSortUntilNoChange<Integer>) bubbleSort2;
            bubbleSort3 = (BubbleSortPassPerItem<Integer>) bubbleSort3;
        } else  if (dataType.equals(Double.class)) {
            bubbleSort1 = (BubbleSortWhileNeeded<Double>) bubbleSort1;
            bubbleSort2 = (BubbleSortUntilNoChange<Double>) bubbleSort2;
            bubbleSort3 = (BubbleSortPassPerItem<Double>) bubbleSort3;
        } else if (dataType.equals(String.class)) {
            bubbleSort1 = (BubbleSortWhileNeeded<String>) bubbleSort1;
            bubbleSort2 = (BubbleSortUntilNoChange<String>) bubbleSort2;
            bubbleSort3 = (BubbleSortPassPerItem<String>) bubbleSort3;
        } else {
            // throw new Exception("Unexpected data type provided");
        }

        long duration;

        Object[] copy1 = Arrays.copyOf(array, array.length);
        duration = performBubbleSort(copy1);
        System.out.println("BubbleSortWhileNeeded Time: " + duration + " nanoseconds");

        Object[] copy2 = Arrays.copyOf(array, array.length);
        duration = performBubbleSort(copy2);
        System.out.println("BubbleSortUntilNoChange Time: " + duration + " nanoseconds");

        Object[] copy3 = Arrays.copyOf(array, array.length);
        duration = performBubbleSort(copy3);
        System.out.println("BubbleSortPassPerItem Time: " + duration + " nanoseconds");

        System.out.println();
    }

    private static long performBubbleSort(Object[] array) {
        long startTime, endTime, duration = 0;
        if (array instanceof Integer[]) {
            BubbleSortWhileNeeded<Integer> bubbleSort = new BubbleSortWhileNeeded<>();
            startTime = System.nanoTime();
            bubbleSort.sort((Integer[]) array);
            endTime = System.nanoTime();
            duration = (endTime - startTime); // Duration in milliseconds
        } else if (array instanceof Double[]) {
            BubbleSortWhileNeeded<Double> bubbleSort = new BubbleSortWhileNeeded<>();
            startTime = System.nanoTime();
            bubbleSort.sort((Double[]) array);
            endTime = System.nanoTime();
            duration = (endTime - startTime); // Duration in milliseconds
        } else if (array instanceof String[]) {
            BubbleSortWhileNeeded<String> bubbleSort = new BubbleSortWhileNeeded<>();
            startTime = System.nanoTime();
            bubbleSort.sort((String[]) array);
            endTime = System.nanoTime();
            duration = (endTime - startTime); // Duration in milliseconds
        }
        return duration;
    }

        
    private static Object[] generateRandomArray(int size, Class<?> dataType) {
        Random random = new Random();
        Object[] array = (Object[]) java.lang.reflect.Array.newInstance(dataType, size);
        for (int i = 0; i < size; i++) {
            if (dataType.equals(Integer.class)) {
                array[i] = random.nextInt(size * 10);
            } else if (dataType.equals(Double.class)) {
                array[i] = random.nextDouble() * size * 10;
            } else if (dataType.equals(String.class)) {
                array[i] = "Element" + i;
            }
        }
        return array;
    }

    private static Object[] generateSortedArray(int size, Class<?> dataType) {
        Object[] array = (Object[]) java.lang.reflect.Array.newInstance(dataType, size);
        for (int i = 0; i < size; i++) {
            if (dataType.equals(Integer.class)) {
                array[i] = i;
            } else if (dataType.equals(Double.class)) {
                array[i] = (double) i;
            } else if (dataType.equals(String.class)) {
                array[i] = "Element" + i;
            }
        }
        return array;
    }

    private static Object[] generateInvertedSortedArray(int size, Class<?> dataType) {
        Object[] array = (Object[]) java.lang.reflect.Array.newInstance(dataType, size);
        int value = size;
        for (int i = 0; i < size; i++) {
            if (dataType.equals(Integer.class)) {
                array[i] = value--;
            } else if (dataType.equals(Double.class)) {
                array[i] = (double) value--;
            } else if (dataType.equals(String.class)) {
                array[i] = "Element" + (value--);
            }
        }
        return array;
    }
}
