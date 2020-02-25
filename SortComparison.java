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

    static double[] mergeSortIterative(double[] a) {
        if (a != null) {
            int low = 0;
            int high = a.length - 1;
            double[] temp = new double[a.length];
            for(int i = 0; i < a.length; i++)
            {
                temp[i] = a[i];
            }

            for (int m = 1; m <= high - low; m = 2 * m) {
                for (int bottom = low; bottom < high; bottom += 2 * m) {
                    int mid = bottom + m - 1;
                    int top = bottom + 2 * m - 1;

                    merge(a, temp, bottom, mid, (top < high) ? top : high);
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
        mergeSortRecursive(a, 0, a.length-1);
        return a;
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
        double leftArr[] = new double [n1];
        double rightArr[] = new double [n2];
        for (int i=0; i<n1; ++i)
        {
            leftArr[i] = a[left + i];
        }
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

    }

}
