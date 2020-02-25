import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @author Brian Farrell
 *  @version HT 2020
 */
@RunWith(JUnit4.class)
public class sortComparisonTest
{

    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
        new SortComparison();
    }

    @Test
    public void testInsertionSort()
    {
        double[] a = new double[] {3.2,5.1,1.56,2.34,8.9,6.12,4.2} ;
        double[] b = new double[] {1.56,2.34,3.2,4.2,5.1,6.12,8.9} ;
        assertArrayEquals(SortComparison.insertionSort(a),b, 0);
    }
    @Test
    public void testSelectionSort()
    {
        double[] a = new double[] {3.2,5.1,1.56,2.34,8.9,6.12,4.2} ;
        double[] b = new double[] {1.56,2.34,3.2,4.2,5.1,6.12,8.9} ;
        assertArrayEquals(SortComparison.selectionSort(a),b, 0);
    }
    @Test
    public void testQuickSort()
    {
        double[] a = new double[] {3.2,5.1,1.56,2.34,8.9,6.12,4.2} ;
        double[] b = new double[] {1.56,2.34,3.2,4.2,5.1,6.12,8.9} ;
        assertArrayEquals(SortComparison.quickSort(a),b, 0);
    }
    @Test
    public void testMergeSortIterative()
    {
        double[] a = new double[] {3.2,5.1,1.56,2.34,8.9,6.12,4.2} ;
        double[] b = new double[] {1.56,2.34,3.2,4.2,5.1,6.12,8.9} ;
        assertArrayEquals(SortComparison.mergeSortIterative(a),b, 0);
    }
    @Test
    public void testMergeSortRecursive()
    {
        double[] a = new double[] {3.2,5.1,1.56,2.34,8.9,6.12,4.2} ;
        double[] b = new double[] {1.56,2.34,3.2,4.2,5.1,6.12,8.9} ;
        assertArrayEquals(SortComparison.mergeSortRecursive(a),b, 0);
    }
}
