// -------------------------------------------------------------------------
/**
 It took 0.0108ms to run numbers10.txt using selectionSort
 It took 0.2259ms to run numbers100.txt using selectionSort
 It took 14.2167ms to run numbers1000.txt using selectionSort
 It took 2.4777ms to run numbers1000Duplicates.txt using selectionSort
 It took 2.3665ms to run numbersNearlyOrdered1000.txt using selectionSort
 It took 3.9727ms to run numbersReverse1000.txt using selectionSort
 It took 9.203ms to run numbersSorted1000.txt using selectionSort


 It took 0.0129ms to run numbers10.txt using insertionSort
 It took 0.1356ms to run numbers100.txt using insertionSort
 It took 6.7589ms to run numbers1000.txt using insertionSort
 It took 2.344ms to run numbers1000Duplicates.txt using insertionSort
 It took 0.4139ms to run numbersNearlyOrdered1000.txt using insertionSort
 It took 2.9756ms to run numbersReverse1000.txt using insertionSort
 It took 0.0083ms to run numbersSorted1000.txt using insertionSort


 It took 0.0902ms to run numbers10.txt using mergeSortIterative
 It took 0.0938ms to run numbers100.txt using mergeSortIterative
 It took 0.7587ms to run numbers1000.txt using mergeSortIterative
 It took 0.6657ms to run numbers1000Duplicates.txt using mergeSortIterative
 It took 2.6084ms to run numbersNearlyOrdered1000.txt using mergeSortIterative
 It took 0.2925ms to run numbersReverse1000.txt using mergeSortIterative
 It took 0.2562ms to run numbersSorted1000.txt using mergeSortIterative


 It took 0.0285ms to run numbers10.txt using mergeSortRecursive
 It took 0.1321ms to run numbers100.txt using mergeSortRecursive
 It took 1.2591ms to run numbers1000.txt using mergeSortRecursive
 It took 0.4936ms to run numbers1000Duplicates.txt using mergeSortRecursive
 It took 0.353ms to run numbersNearlyOrdered1000.txt using mergeSortRecursive
 It took 0.3211ms to run numbersReverse1000.txt using mergeSortRecursive
 It took 0.3439ms to run numbersSorted1000.txt using mergeSortRecursive


 It took 0.0213ms to run numbers10.txt using quickSort
 It took 0.0483ms to run numbers100.txt using quickSort
 It took 1.2804ms to run numbers1000.txt using quickSort
 It took 0.2371ms to run numbers1000Duplicates.txt using quickSort
 It took 0.8098ms to run numbersNearlyOrdered1000.txt using quickSort
 It took 4.6526ms to run numbersReverse1000.txt using quickSort
 It took 1.6836ms to run numbersSorted1000.txt using quickSort

 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *  This class contains static methods that implementing sorting of an array of numbers
 *  using different sort algorithms.
 *
 *  @author Brian Farrell
 *  @version HT 2020
 */

class SortComparison {

    /**
     * Sorts an array of doubles using InsertionSort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order.
     *
     */
    static double [] insertionSort (double a[])
    {
        if(a != null) {
            for (int i = 1; i < a.length; ++i) {
                double temp = a[i];
                int j = i - 1;
                while (j >= 0 && a[j] > temp) {
                    a[j + 1] = a[j];
                    j = j - 1;
                }
                a[j + 1] = temp;
            }
            return a;
        }
        return null;
    }

    /**
     * Sorts an array of doubles using Selection Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] selectionSort (double a[])
    {
        if(a != null) {
            for (int i = 0; i < a.length - 1; i++) {
                int index = i;
                for (int j = i + 1; j < a.length; j++) {
                    if (a[j] < a[index]) {
                        index = j;
                    }
                }
                double temp = a[index];
                a[index] = a[i];
                a[i] = temp;
            }
            return a;
        }
        return null;
    }

    /**
     * Sorts an array of doubles using Quick Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] quickSort (double a[]){
        if(a!=null) {
            quickSort(a, 0, a.length - 1);
            return a;
        }
        return null;
    }

    private static void quickSort(double a[], int lo, int hi)
    {
        if (lo < hi)
        {
            int piv = partition(a, lo, hi);
            quickSort(a, lo, piv-1);
            quickSort(a, piv+1, hi);
        }
    }

    private static int partition(double a[], int lo, int hi)
    {
        double pivot = a[hi];
        int i = (lo-1);
        for (int j=lo; j<hi; j++)
        {
            if (a[j] < pivot)
            {
                i++;
                double temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        double temp = a[i+1];
        a[i+1] = a[hi];
        a[hi] = temp;
        return i+1;
    }


    /**
     * Sorts an array of doubles using Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    /**
     * Sorts an array of doubles using iterative implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */

    static double[] mergeSortIterative(double[] a) {
        if (a != null) {
            int low = 0;
            int high = a.length - 1;
            double[] temp = new double[a.length];
            System.arraycopy(a, 0, temp, 0, a.length);
            for (int m = 1; m <= high - low; m = 2 * m) {
                for (int bottom = low; bottom < high; bottom += 2 * m) {
                    int mid = bottom + m - 1;
                    int top = bottom + 2 * m - 1;
                    merge(a, temp, bottom, mid, Math.min(top, high));
                }
            }
            return a;
        } else {
            return null;
        }
    }

    private static void merge(double[] a, double[] temp, int bottom, int mid, int top) {
        int k = bottom, i = bottom, j = mid + 1;
        while (i <= mid && j <= top) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        while (i <= mid && i < a.length) {
            temp[k++] = a[i++];
        }
        for (i = bottom; i <= top; i++) {
            a[i] = temp[i];
        }
    }


    /**
     * Sorts an array of doubles using recursive implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */
    static double[] mergeSortRecursive (double a[])
    {
        if(a != null) {
            mergeSortRecursive(a, 0, a.length - 1);
            return a;
        }
        return null;
    }
    private  static void mergeSortRecursive (double[] a,  int lo, int hi)
    {
        if (lo < hi)
        {
            int mid = (lo+hi)/2;
            mergeSortRecursive(a, lo, mid);
            mergeSortRecursive(a , mid+1, hi);
            merge(a, lo, mid, hi);
        }
    }
    private static void merge(double a[], int left, int mid, int right)
    {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        double[] leftArr = new double [n1];
        double[] rightArr = new double [n2];
        System.arraycopy(a, left, leftArr, 0, n1);
        for (int j=0; j<n2; ++j)
        {
            rightArr[j] = a[mid + 1 + j];
        }
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2)
        {
            if (leftArr[i] <= rightArr[j])
            {
                a[k] = leftArr[i];
                i++;
            }
            else
             {
                a[k] = rightArr[j];
                j++;
             }
                k++;
        }
        while (i < n1)
        {
            a[k] = leftArr[i];
            i++;
            k++;
        }
        while (j < n2)
        {
            a[k] = rightArr[j];
            j++;
            k++;
        }
    }
    public static void main(String[] args) {
        String[] tests = new String[]{"C:/Users/brian/Downloads/assignment input data files/numbers10.txt",
                "C:/Users/brian/Downloads/assignment input data files/numbers100.txt",
                "C:/Users/brian/Downloads/assignment input data files/numbers1000.txt",
                "C:/Users/brian/Downloads/assignment input data files/numbers1000Duplicates.txt",
                "C:/Users/brian/Downloads/assignment input data files/numbersNearlyOrdered1000.txt",
                "C:/Users/brian/Downloads/assignment input data files/numbersReverse1000.txt",
                "C:/Users/brian/Downloads/assignment input data files/numbersSorted1000.txt"};
            for (String file : tests) {
            ArrayList<Double> numbers = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line = br.readLine();
                while (line != null) {
                    line = br.readLine();
                    if (line != null) numbers.add(Double.parseDouble(line));
                }
                double[] a = new double[numbers.size()];
                for (int j = 0; j < a.length; j++) {
                    a[j] = numbers.get(j);
                }
                double start = System.nanoTime();
                selectionSort(a);
                double end = System.nanoTime();
                double total = (end - start) / 1000000;
                System.out.println("It took " + total + "ms" + " to run " + file.split("/")[file.split("/").length - 1] + " using selectionSort");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            System.out.println("\n");
        for (String file : tests) {
            ArrayList<Double> numbers = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line = br.readLine();
                while (line != null) {
                    line = br.readLine();
                    if (line != null) numbers.add(Double.parseDouble(line));
                }
                double[] a = new double[numbers.size()];
                for (int j = 0; j < a.length; j++) {
                    a[j] = numbers.get(j);
                }
                double start = System.nanoTime();
                insertionSort(a);
                double end = System.nanoTime();
                double total = (end - start) / 1000000;
                System.out.println("It took " + total + "ms" + " to run " + file.split("/")[file.split("/").length - 1] + " using insertionSort");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\n");
        for (String file : tests) {
            ArrayList<Double> numbers = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line = br.readLine();
                while (line != null) {
                    line = br.readLine();
                    if (line != null) numbers.add(Double.parseDouble(line));
                }
                double[] a = new double[numbers.size()];
                for (int j = 0; j < a.length; j++) {
                    a[j] = numbers.get(j);
                }
                double start = System.nanoTime();
                mergeSortIterative(a);
                double end = System.nanoTime();
                double total = (end - start) / 1000000;
                System.out.println("It took " + total + "ms" + " to run " + file.split("/")[file.split("/").length - 1] + " using mergeSortIterative");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\n");
        for (String file : tests) {
            ArrayList<Double> numbers = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line = br.readLine();
                while (line != null) {
                    line = br.readLine();
                    if (line != null) numbers.add(Double.parseDouble(line));
                }
                double[] a = new double[numbers.size()];
                for (int j = 0; j < a.length; j++) {
                    a[j] = numbers.get(j);
                }
                double start = System.nanoTime();
                mergeSortRecursive(a);
                double end = System.nanoTime();
                double total = (end - start) / 1000000;
                System.out.println("It took " + total + "ms" + " to run " + file.split("/")[file.split("/").length - 1] + " using mergeSortRecursive");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\n");
        for (String file : tests) {
            ArrayList<Double> numbers = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line = br.readLine();
                while (line != null) {
                    line = br.readLine();
                    if (line != null) numbers.add(Double.parseDouble(line));
                }
                double[] a = new double[numbers.size()];
                for (int j = 0; j < a.length; j++) {
                    a[j] = numbers.get(j);
                }
                double start = System.nanoTime();
                quickSort(a);
                double end = System.nanoTime();
                double total = (end - start) / 1000000;
                System.out.println("It took " + total + "ms" + " to run " + file.split("/")[file.split("/").length - 1] + " using quickSort");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
