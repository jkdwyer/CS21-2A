import org.junit.Test;

import static org.junit.Assert.*;

public class MinHeapTest {
    @Test
    public void setDefaultArrayList() throws Exception {
        MinHeap mH = new MinHeap();
        mH.setDefaultArrayList();
        String expectedArr = "[5, 3, 7, 1, 2, 4, 9, 8, 6, 10]";
        String actualArr = mH.getHeapArr().toString();
        assertEquals(expectedArr, actualArr);
    }

    @Test
    public void getMessage() throws Exception {
        String expectedMsg = "testMessage from MinHeap subclass";
        MinHeap mH = new MinHeap();
        String actualMsg = mH.getMessage();
        assertEquals(expectedMsg, actualMsg);

        mH.setDefaultArrayList();
        expectedMsg = "\nName:  Jan Dwyer\n";
        actualMsg = mH.getMessage();
        assertEquals(expectedMsg, actualMsg);
    }

    @Test
    public void setMessage() throws Exception {
        String newMsg = "New message";
        MinHeap mH = new MinHeap();
        mH.setDefaultArrayList();
        mH.setMessage(newMsg);
        String actualMsg = mH.getMessage();
        assertEquals(newMsg, actualMsg);
    }

    @Test
    public void sift() throws Exception {
        MinHeap mH = new MinHeap();
        mH.setDefaultArrayList();
        mH.sift(5);
        String expectedArr = "[4, 3, 5, 1, 2, 7, 9, 8, 6, 10]";
        String actualArr = mH.getHeapArr().toString();
        assertEquals(expectedArr, actualArr);
    }

}