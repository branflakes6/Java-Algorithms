// -------------------------------------------------------------------------

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
        for (int i = 1; i < a.length; ++i) {
            double temp = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > temp)
            {
            a[j+1] = a[j];
            j = j - 1;
            }
            a[j+1] = temp;
        }
        return a;
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
        for (int i = 0; i < a.length-1; i++)
        {
            int index = i;
            for (int j = i+1; j < a.length; j++)
            {
                if (a[j] < a[index])
                {
                index = j;
                }
            }
            double temp = a[index];
            a[index] = a[i];
            a[i] = temp;
        }
    return a;
    }

    /**
     * Sorts an array of doubles using Quick Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] quickSort (double a[]){
        quickSort(a, 0, a.length - 1);
        return a;
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

    static double[] mergeSortIterative (double a[]) {


        return a;
    }



    /**
     * Sorts an array of doubles using recursive implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */
    static double[] mergeSortRecursive (double a[]) {


        return a;
    }



    public static void main(String[] args) {

    }

}
