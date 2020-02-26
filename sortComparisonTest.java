import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @author Brian Farrell
 *  @version HT 2020
 */
@RunWith(JUnit4.class)
public class sortComparisonTest {

    //~ Constructor ........................................................
    @Test
    public void testConstructor() {
        new SortComparison();
    }
    @Test
    public void testEmpty()
    {
        double [] a = new double [] {};
        assertArrayEquals(new double[0], SortComparison.insertionSort(a), 0);
        assertArrayEquals(new double[0], SortComparison.selectionSort(a), 0);
        assertArrayEquals(new double[0], SortComparison.mergeSortIterative(a), 0);
        assertArrayEquals(new double[0], SortComparison.mergeSortRecursive(a), 0);
        assertArrayEquals(new double[0], SortComparison.quickSort(a), 0);
    }
    @Test
    public void testInsertionSort() {
        double[] a = new double[]{3.2, 5.1, 1.56, 2.34, 8.9, 6.12, 4.2};
        double[] b = new double[]{1.56, 2.34, 3.2, 4.2, 5.1, 6.12, 8.9};
        assertArrayEquals(SortComparison.insertionSort(a), b, 0);
        a = null;
        assertNull(SortComparison.insertionSort(a));
    }

    @Test
    public void testSelectionSort() {
        double[] a = new double[]{3.2, 5.1, 1.56, 2.34, 8.9, 6.12, 4.2};
        double[] b = new double[]{1.56, 2.34, 3.2, 4.2, 5.1, 6.12, 8.9};
        assertArrayEquals(SortComparison.selectionSort(a), b, 0);
        a = null;
        assertNull(SortComparison.insertionSort(a));
    }

    @Test
    public void testQuickSort() {
        double[] a = new double[]{3.2, 5.1, 1.56, 2.34, 8.9, 6.12, 4.2};
        double[] b = new double[]{1.56, 2.34, 3.2, 4.2, 5.1, 6.12, 8.9};
        assertArrayEquals(SortComparison.quickSort(a), b, 0);
        a = null;
        assertNull(SortComparison.insertionSort(a));
    }

    @Test
    public void testMergeSortIterative() {
        double[] a = new double[]{3.2, 5.1, 1.56, 2.34, 8.9, 6.12, 4.2};
        double[] b = new double[]{1.56, 2.34, 3.2, 4.2, 5.1, 6.12, 8.9};
        assertArrayEquals(SortComparison.mergeSortIterative(a), b, 0);
        a = null;
        assertNull(SortComparison.insertionSort(a));
    }

    @Test
    public void testMergeSortRecursive() {
        double[] a = new double[]{3.2, 5.1, 1.56, 2.34, 8.9, 6.12, 4.2};
        double[] b = new double[]{1.56, 2.34, 3.2, 4.2, 5.1, 6.12, 8.9};
        assertArrayEquals(SortComparison.mergeSortRecursive(a), b, 0);
        a = null;
        assertNull(SortComparison.insertionSort(a));
    }
    public static void main(String[] args)
    {
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
                SortComparison.selectionSort(a);
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
                SortComparison.insertionSort(a);
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
                SortComparison.mergeSortIterative(a);
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
                SortComparison.mergeSortRecursive(a);
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
                SortComparison.quickSort(a);
                double end = System.nanoTime();
                double total = (end - start) / 1000000;
                System.out.println("It took " + total + "ms" + " to run " + file.split("/")[file.split("/").length - 1] + " using quickSort");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
