import org.junit.Test;

import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.File;

public class MinHelperTest {
    @Test
    public void printHeapArray() throws Exception {
        MinHeap mH = new MinHeap();
        mH.setDefaultArrayList();
        mH.buildHeap();
        String expected = "heapArr: [1, 2, 4, 5, 3, 7, 9, 8, 6, 10]\n\n";

        // assign the existing PrintStream to a variable.
        PrintStream oldStream = System.out;
        // instantiate a BAOS object.
        ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        // give a new PrintStream the BAOS object as input.
        PrintStream ps = new PrintStream(myOut);
        // send the system output to the new PrintStream object.
        System.setOut(ps);

        // the print method goes to system out.
        MinHelper.printHeapArray(mH.getHeapArr().toString());

        // the BAOS object gets the output data.
        String actual = myOut.toString();
        assertEquals(expected, actual);

        // return the former system output to normal.
        System.out.flush();
        System.setOut(oldStream);
    }

    @Test
    public void printSortedArray() throws Exception {
        MinHeap mH = new MinHeap();
        mH.setDefaultArrayList();
        mH.buildHeap();
        mH.heapSort();
        String expected = "sortedArr: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]\n\n";

        // assign the existing PrintStream to a variable.
        PrintStream oldStream = System.out;
        // instantiate a BAOS.
        ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        // give a new PrintStream the BAOS object as input.
        PrintStream ps = new PrintStream(myOut);
        // send the system output to the new PrintStream object.
        System.setOut(ps);

        // the print method goes to system out.
        MinHelper.printSortedArray(mH.getSortedArr().toString());

        // the BAOS object gets the output data.
        String actual = myOut.toString();
        assertEquals(expected, actual);

        // return the former system output to normal.
        System.out.flush();
        System.setOut(oldStream);
    }

    @Test
    public void serializeArrayList() throws Exception {
        MinHeap mH = new MinHeap();
        mH.setDefaultArrayList();
        File dFile;
        String filename = "serArrTest.ser";
        dFile = new File(filename);
        MinHelper.serializeArrayList();
        assertTrue(dFile.exists());
    }

    @Test
    public void serializeMinHeap() throws Exception {
        MinHeap mH = new MinHeap();
        mH.setDefaultArrayList();
        File dFile;
        String filename = "serMinHeapTest.ser";
        dFile = new File(filename);
        MinHelper.serializeMinHeap();
        assertTrue(dFile.exists());
    }

}