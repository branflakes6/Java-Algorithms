// -------------------------------------------------------------------------
/**
 It took 0.0203ms to run numbers10.txt using selectionSort
 It took 0.2157ms to run numbers100.txt using selectionSort
 It took 15.4067ms to run numbers1000.txt using selectionSort
 It took 3.4795ms to run numbers1000Duplicates.txt using selectionSort
 It took 0.8138ms to run numbersNearlyOrdered1000.txt using selectionSort
 It took 1.0482ms to run numbersReverse1000.txt using selectionSort
 It took 0.9378ms to run numbersSorted1000.txt using selectionSort


 It took 0.0132ms to run numbers10.txt using insertionSort
 It took 0.1439ms to run numbers100.txt using insertionSort
 It took 11.7273ms to run numbers1000.txt using insertionSort
 It took 0.7021ms to run numbers1000Duplicates.txt using insertionSort
 It took 0.3868ms to run numbersNearlyOrdered1000.txt using insertionSort
 It took 4.8198ms to run numbersReverse1000.txt using insertionSort
 It took 0.0062ms to run numbersSorted1000.txt using insertionSort


 It took 0.1232ms to run numbers10.txt using mergeSortIterative
 It took 0.1579ms to run numbers100.txt using mergeSortIterative
 It took 1.0051ms to run numbers1000.txt using mergeSortIterative
 It took 0.408ms to run numbers1000Duplicates.txt using mergeSortIterative
 It took 0.341ms to run numbersNearlyOrdered1000.txt using mergeSortIterative
 It took 0.3421ms to run numbersReverse1000.txt using mergeSortIterative
 It took 0.287ms to run numbersSorted1000.txt using mergeSortIterative


 It took 0.0395ms to run numbers10.txt using mergeSortRecursive
 It took 0.2225ms to run numbers100.txt using mergeSortRecursive
 It took 1.6326ms to run numbers1000.txt using mergeSortRecursive
 It took 0.5246ms to run numbers1000Duplicates.txt using mergeSortRecursive
 It took 0.357ms to run numbersNearlyOrdered1000.txt using mergeSortRecursive
 It took 0.3488ms to run numbersReverse1000.txt using mergeSortRecursive
 It took 0.3132ms to run numbersSorted1000.txt using mergeSortRecursive


 It took 0.0227ms to run numbers10.txt using quickSort
 It took 0.0582ms to run numbers100.txt using quickSort
 It took 0.8999ms to run numbers1000.txt using quickSort
 It took 0.9868ms to run numbers1000Duplicates.txt using quickSort
 It took 0.2611ms to run numbersNearlyOrdered1000.txt using quickSort
 It took 2.84ms to run numbersReverse1000.txt using quickSort
 It took 3.2433ms to run numbersSorted1000.txt using quickSort


 a. Which of the sorting algorithms does the order of input have an impact on? Why?
    When comparing the run times of the tests all of the algorithms have some impact from order of input but
    the greatest impact is seen in insertionSort and selectionSort which have massive differences in time
    between nummbers1000 and reverseNumbers1000. Of these two Selection Sort has the biggest difference.

 b. Which algorithm has the biggest difference between the best and worst performance, based
 on the type of input, for the input of size 1000? Why?
    Selection sort has the largest differnece between its worst and best run, Insertion Sort is close and is noticable as it is very slow for files of size 1000
    expcepted for in the case where the fie is already sorted in which case it is the fastest algorithm.

 c. Which algorithm has the best/worst scalability, i.e., the difference in performance time
 based on the input size? Please consider only input files with random order for this answer.
    Selection Sort as it has the worst run time for the largest input file.

 d. Did you observe any difference between iterative and recursive implementations of merge
 sort? There is very little noticeable difference between the two

 e. Which algorithm is the fastest for each of the 7 input files?
 For numnbers10.txt the fastest is insertionSort
 For numnbers100.txt the fastest is quickSort
 For numnbers1000.txt the fastest is quickSort
 For numnbers1000Duplicates.txt the fastest is quickSort
 for numbersNearlyOrdered1000.txt the fastest is quickSort
 For numnbersReverse1000.txt the fastest is mergeSortIterative
 For numnbersSorted1000.txt the fastest is insertionSort
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
}
