import java.util.Arrays;
import java.util.List;
import java.util.Random;
import exp01.*;
public class BubbleSortComparison {

    public static void main(String[] args) {
        final int[] arraySizes = {1024, 2048, 4096};
        final int numberOfRuns = 4;

        List<Class<?>> dataTypes = Arrays.asList(Integer.class, Double.class, String.class);

        System.out.println("Different Data Types: ");
        System.out.println();
        for (Class<?> dataType : dataTypes) {
            
            System.out.println("Data Type: " + dataType.getSimpleName());
            Long[][] values = new Long[3][numberOfRuns];

            for (int run = 1; run <= numberOfRuns; run++) {
                System.out.println("Run #" + run);

                Object[] randomArray = generateRandomArray(1024, dataType);

                Long [] attempt = runSortAndMeasureTime(randomArray, dataType);
                
                for (int i=0; i<values.length; i++) {
                    values[i][run-1] = attempt[i];
                }
                System.out.println();
            }
            for (int i=0; i<values.length; i++) {
                Arrays.sort(values[i]);
                System.out.println("Minimum: " + values[i][0]);
                System.out.println("1st quartile: " + (values[i][0] + values[i][1])/2); // assumes numberOfRuns = 4 for simplicity
                System.out.println("Median: " + (values[i][1] + values[i][2])/2); // assumes numberOfRuns = 4 for simplicity
                System.out.println("3rd quartile: " + (values[i][2] + values[i][3])/2); // assumes numberOfRuns = 4 for simplicity
                System.out.println("Maximum: " + values[i][numberOfRuns-1]);
                System.out.println();
            }
            System.out.println();

        }

        System.out.println("Different Arrays Sizes: ");
        System.out.println();
        for (int size : arraySizes) {
            System.out.println("Array Size: " + size);
            Long[][] values = new Long[3][numberOfRuns];

            for (int run = 1; run <= numberOfRuns; run++) {
                System.out.println("Run #" + run);

                Object[] randomArray = generateRandomArray(size, Integer.class);

                Long[] attempt = runSortAndMeasureTime(randomArray, Integer.class);

                for (int i=0; i<values.length; i++) {
                    values[i][run-1] = attempt[i];
                }

                System.out.println();
            }
            for (int i=0; i<values.length; i++) {
                Arrays.sort(values[i]);
                System.out.println("Minimum: " + values[i][0]);
                System.out.println("1st quartile: " + (values[i][0] + values[i][1])/2); // assumes numberOfRuns = 4 for simplicity
                System.out.println("Median: " + (values[i][1] + values[i][2])/2); // assumes numberOfRuns = 4 for simplicity
                System.out.println("3rd quartile: " + (values[i][2] + values[i][3])/2); // assumes numberOfRuns = 4 for simplicity
                System.out.println("Maximum: " + values[i][numberOfRuns-1]);
                System.out.println();
            }
            System.out.println();
        }

        System.out.println("Different Initial Array States: ");
        System.out.println();

        System.out.println("Array Type: Random Order");
        Long[][] values1 = new Long[3][numberOfRuns];
        for (int run = 1; run <= numberOfRuns; run++) {
            System.out.println("Run #" + run);

            Object[] randomArray = generateRandomArray(1024, Integer.class);

            Long[] attempt = runSortAndMeasureTime(randomArray, Integer.class);
            
            for (int i=0; i<values1.length; i++) {
                values1[i][run-1] = attempt[i];
            }

            System.out.println();
        }
        for (int i=0; i<values1.length; i++) {
            Arrays.sort(values1[i]);
            System.out.println("Minimum: " + values1[i][0]);
            System.out.println("1st quartile: " + (values1[i][0] + values1[i][1])/2); // assumes numberOfRuns = 4 for simplicity
            System.out.println("Median: " + (values1[i][1] + values1[i][2])/2); // assumes numberOfRuns = 4 for simplicity
            System.out.println("3rd quartile: " + (values1[i][2] + values1[i][3])/2); // assumes numberOfRuns = 4 for simplicity
            System.out.println("Maximum: " + values1[i][numberOfRuns-1]);
            System.out.println();
        }

        System.out.println("Array Type: Sorted Order");
        Long[][] values2 = new Long[3][numberOfRuns];
        for (int run = 1; run <= numberOfRuns; run++) {
            System.out.println("Run #" + run);
            
            Object[] sortedArray = generateSortedArray(1024, Integer.class);

            Long[] attempt = runSortAndMeasureTime(sortedArray, Integer.class);

            for (int i=0; i<values2.length; i++) {
                values2[i][run-1] = attempt[i];
            }

            System.out.println();
        }
        for (int i=0; i<values2.length; i++) {
            Arrays.sort(values2[i]);
            System.out.println("Minimum: " + values2[i][0]);
            System.out.println("1st quartile: " + (values2[i][0] + values2[i][1])/2); // assumes numberOfRuns = 4 for simplicity
            System.out.println("Median: " + (values2[i][1] + values2[i][2])/2); // assumes numberOfRuns = 4 for simplicity
            System.out.println("3rd quartile: " + (values2[i][2] + values2[i][3])/2); // assumes numberOfRuns = 4 for simplicity
            System.out.println("Maximum: " + values2[i][numberOfRuns-1]);
            System.out.println();
        }
        
        System.out.println("Array Type: Inverted Sorted Order");
        Long[][] values3 = new Long[3][numberOfRuns];
        for (int run = 1; run <= numberOfRuns; run++) {
            System.out.println("Run #" + run);
            
            Object[] invertedSortedArray = generateInvertedSortedArray(1024, Integer.class);

            Long[] attempt = runSortAndMeasureTime(invertedSortedArray, Integer.class);

            for (int i=0; i<values3.length; i++) {
                values3[i][run-1] = attempt[i];
            }

            System.out.println();
        }
        for (int i=0; i<values3.length; i++) {
            Arrays.sort(values3[i]);
            System.out.println("Minimum: " + values3[i][0]);
            System.out.println("1st quartile: " + (values3[i][0] + values3[i][1])/2); // assumes numberOfRuns = 4 for simplicity
            System.out.println("Median: " + (values3[i][1] + values3[i][2])/2); // assumes numberOfRuns = 4 for simplicity
            System.out.println("3rd quartile: " + (values3[i][2] + values3[i][3])/2); // assumes numberOfRuns = 4 for simplicity
            System.out.println("Maximum: " + values3[i][numberOfRuns-1]);
            System.out.println();
        }
    }

    private static Long [] runSortAndMeasureTime(Object[] array, Class<?> dataType) {
        Long [] durations = {0L,0L,0L};
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
        durations[0] = duration;

        Object[] copy2 = Arrays.copyOf(array, array.length);
        duration = performBubbleSort(copy2);
        System.out.println("BubbleSortUntilNoChange Time: " + duration + " nanoseconds");
        durations[1] = duration;

        Object[] copy3 = Arrays.copyOf(array, array.length);
        duration = performBubbleSort(copy3);
        System.out.println("BubbleSortPassPerItem Time: " + duration + " nanoseconds");
        durations[2] = duration;

        System.out.println();
        return durations;
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
