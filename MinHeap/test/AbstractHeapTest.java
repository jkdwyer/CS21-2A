import org.junit.Test;

import static org.junit.Assert.*;
import java.util.ArrayList;


public class AbstractHeapTest {
    @Test
    public void getArrSize() throws Exception {
        MinHeap mH = new MinHeap();
        int size = mH.getArrSize();
        assertSame(size, 0);
        mH.setDefaultArrayList();
        size = mH.getArrSize();
        // JUnit4 has different methods, but assertEquals still works.
        assertSame(size, 10);
    }

    @Test
    public void getArrMaxPos() throws Exception {
        MinHeap mH = new MinHeap();
        mH.setDefaultArrayList();
        int max = mH.getArrMaxPos();
        assertSame(max, 9);
    }

    @Test
    public void getHeapSize() throws Exception {
        MinHeap mH = new MinHeap();
        mH.setDefaultArrayList();
        int size = mH.getHeapSize();
        assertEquals(size, 0);
        mH.buildHeap();
        size = mH.getHeapSize();
        assertEquals(size, 10);
    }

    @Test
    public void getHeapifiedSize() throws Exception {
        MinHeap mH = new MinHeap();
        mH.setDefaultArrayList();
        int size = mH.getHeapifiedSize();
        assertEquals(size, 0);
        mH.heapify(4);
        size = mH.getHeapifiedSize();
        assertEquals(size, 5);
    }

    @Test
    public void getArrAtPos() throws Exception {
        MinHeap mH = new MinHeap();
        mH.setDefaultArrayList();
        int value = mH.getArrAtPos(3);
        assertEquals(value, 1);
        value = mH.getArrAtPos(6);
        assertEquals(value, 9);
    }

    @Test
    public void setArrAtPos() throws Exception {
        MinHeap mH = new MinHeap();
        mH.setDefaultArrayList();
        int value = mH.getArrAtPos(3);
        assertEquals(value, 1);
        mH.setArrAtPos(3, 5);
        value = mH.getArrAtPos(3);
        assertEquals(value, 5);
    }

    @Test
    public void getHeapArr() throws Exception {
        MinHeap mH = new MinHeap();
        mH.setDefaultArrayList();
        mH.buildHeap();
        ArrayList<Integer> newArr = mH.getHeapArr();
        assertEquals(newArr.toString(), mH.getHeapArr().toString());
    }

    @Test
    public void getSortedArr() throws Exception {
        MinHeap mH = new MinHeap();
        mH.setDefaultArrayList();
        mH.buildHeap();
        mH.heapSort();
        ArrayList<Integer> newArr = mH.getSortedArr();
        assertEquals(newArr.toString(), mH.getSortedArr().toString());
    }

    @Test
    public void getIsHeap() throws Exception {
        MinHeap mH = new MinHeap();
        mH.setDefaultArrayList();
        boolean value = mH.getIsHeap();
        assertEquals(value, false);
        mH.buildHeap();
        boolean value2 = mH.getIsHeap();
        assertEquals(value2, true);
    }

    @Test
    public void getIsHeapified() throws Exception {
        MinHeap mH = new MinHeap();
        mH.setDefaultArrayList();
        boolean value = mH.getIsHeapified();
        assertEquals(value, false);
        mH.heapify(4);
        boolean value2 = mH.getIsHeapified();
        assertEquals(value2, true);
    }

    @Test
    public void getIsSorted() throws Exception {
        MinHeap mH = new MinHeap();
        mH.setDefaultArrayList();
        boolean value = mH.getIsSorted();
        assertEquals(value, false);
        mH.buildHeap();
        mH.heapSort();
        value = mH.getIsHeap();
        assertEquals(value, true);
    }

    @Test
    public void getSortAtPos() throws Exception {
        MinHeap mH = new MinHeap();
        mH.setDefaultArrayList();
        int value = mH.getArrAtPos(4);
        assertEquals(value, 2);
        value = mH.getArrAtPos(7);
        assertEquals(value, 8);
    }

    @Test
    public void getTop() throws Exception {
        MinHeap mH = new MinHeap();
        mH.setDefaultArrayList();
        int value = mH.getTop();
        assertEquals(value, 5);
        mH.buildHeap();
        value = mH.getTop();
        assertEquals(value, 1);
    }

    @Test
    public void parent() throws Exception {
        MinHeap mH = new MinHeap();
        mH.setDefaultArrayList();
        int parentOfPos0 = mH.parent(0);
        assertEquals(0, parentOfPos0);
        int parentOfPos1 = mH.parent(1);
        assertEquals(0, parentOfPos1);
        int parentOfPos2 = mH.parent(2);
        assertEquals(0, parentOfPos2);
        int parentOfPos3 = mH.parent(3);
        assertEquals(1, parentOfPos3);
        int parentOfPos4 = mH.parent(4);
        assertEquals(1, parentOfPos4);
        int parentOfPos5 = mH.parent(5);
        assertEquals(2, parentOfPos5);
        int parentOfPos6 = mH.parent(6);
        assertEquals(2, parentOfPos6);
        int parentOfPos7 = mH.parent(7);
        assertEquals(3, parentOfPos7);
        int parentOfPos8 = mH.parent(8);
        assertEquals(3, parentOfPos8);
        int parentOfPos9 = mH.parent(9);
        assertEquals(4, parentOfPos9);
    }

    @Test
    public void leftChild() throws Exception {
        MinHeap mH = new MinHeap();
        mH.setDefaultArrayList();
        int leftChildOfPos0 = mH.leftChild(0);
        assertEquals(1, leftChildOfPos0);
        int leftChildOfPos1 = mH.leftChild(1);
        assertEquals(3, leftChildOfPos1);
        int leftChildOfPos2 = mH.leftChild(2);
        assertEquals(5, leftChildOfPos2);
        int leftChildOfPos3 = mH.leftChild(3);
        assertEquals(7, leftChildOfPos3);
        int leftChildOfPos4 = mH.leftChild(4);
        assertEquals(9, leftChildOfPos4);
        // pos5, pos6, pos7, pos8 and pos9 have no leftChild.
    }

    @Test
    public void rightChild() throws Exception {
        MinHeap mH = new MinHeap();
        mH.setDefaultArrayList();
        int rightChildOfPos0 = mH.rightChild(0);
        assertEquals(2, rightChildOfPos0);
        int rightChildOfPos1 = mH.rightChild(1);
        assertEquals(4, rightChildOfPos1);
        int rightChildOfPos2 = mH.rightChild(2);
        assertEquals(6, rightChildOfPos2);
        int rightChildOfPos3 = mH.rightChild(3);
        assertEquals(8, rightChildOfPos3);
        // pos4, pos5, pos6, pos7, pos8 and pos9 have no rightChild.
    }

    @Test
    public void swap() throws Exception {
        MinHeap mH = new MinHeap();
        mH.setDefaultArrayList();
        mH.swap(5,2);
        int newPos2val = mH.getArrAtPos(2);
        int newPos5val = mH.getArrAtPos(5);
        assertEquals(4, newPos2val);
        assertEquals(7, newPos5val);
    }

    @Test
    public void heapify() throws Exception {
        MinHeap mH = new MinHeap();
        mH.setDefaultArrayList();
        mH.heapify(4);
        String expectedArr = "[1, 2, 7, 5, 3, 4, 9, 8, 6, 10]";
        String actualArr = mH.getHeapArr().toString();
        assertEquals(expectedArr, actualArr);
    }

    @Test
    public void buildHeap() throws Exception {
        MinHeap mH = new MinHeap();
        mH.setDefaultArrayList();
        mH.buildHeap();
        String expectedArr = "[1, 2, 4, 5, 3, 7, 9, 8, 6, 10]";
        String actualArr = mH.getHeapArr().toString();
        assertEquals(expectedArr, actualArr);
    }

    @Test
    public void extractTop() throws Exception {
        MinHeap mH = new MinHeap();
        mH.setDefaultArrayList();
        mH.buildHeap();
        int top = mH.extractTop();
        assertEquals(top, 1);
    }

    @Test
    public void extractTop_Exception() throws Exception {
        MinHeap mH = new MinHeap();
        mH.setDefaultArrayList();
        String message = "";
        String expected = "Error: extractTop() can only be used on a completed heap.";
        try {
            mH.extractTop();
        } catch (Exception e) {
            message = e.getMessage();
        }
        assertEquals(expected, message);
    }

    @Test
    public void heapSort() throws Exception {
        MinHeap mH = new MinHeap();
        mH.setDefaultArrayList();
        mH.buildHeap();
        mH.heapSort();
        int value;
        value = mH.getSortAtPos(0);
        assertEquals(1, value);
        value = mH.getSortAtPos(1);
        assertEquals(2, value);
        value = mH.getSortAtPos(2);
        assertEquals(3, value);
        value = mH.getSortAtPos(3);
        assertEquals(4, value);
        value = mH.getSortAtPos(4);
        assertEquals(5, value);
        value = mH.getSortAtPos(5);
        assertEquals(6, value);
        value = mH.getSortAtPos(6);
        assertEquals(7, value);
        value = mH.getSortAtPos(7);
        assertEquals(8, value);
        value = mH.getSortAtPos(8);
        assertEquals(9, value);
        value = mH.getSortAtPos(9);
        assertEquals(10, value);
    }

    @Test
    public void heapSort_Exception() throws Exception {
        MinHeap mH = new MinHeap();
        mH.setDefaultArrayList();
        String message = "";
        String expected = "Error: heapSort() can only be used on a completed heap.";
        try {
            mH.heapSort();
        } catch (Exception e) {
            message = e.getMessage();
        }
        assertEquals(expected, message);
    }

    @Test
    public void heapInsert() throws Exception {
        MinHeap mH = new MinHeap();
        mH.setDefaultArrayList();
        mH.heapify(4);
        mH.heapInsert(7);
        String expected = "[1, 2, 7, 5, 3, 8, 4, 9, 6, 10]";
        assertEquals(expected, mH.getHeapArr().toString());
    }


    @Test
    public void heapInsert_Exception() throws Exception {
        MinHeap mH = new MinHeap();
        mH.setDefaultArrayList();
        String message = "";
        String expected = "Error:  heapInsert() can only be used on a partial heap.";
        try {
            mH.heapInsert(8);
        } catch (Exception e) {
            message = e.getMessage();
        }
        assertEquals(expected, message);
    }

    @Test
    public void heapAddNewValue() throws Exception {
        MinHeap mH = new MinHeap();
        mH.setDefaultArrayList();
        mH.buildHeap();
        String expected = "[1, 2, 4, 5, 3, 7, 9, 8, 6, 10, 12]";
        int newVal = 12;
        mH.heapAddNewValue(newVal);
        assertEquals(expected, mH.getHeapArr().toString());
    }


    @Test
    public void heapAddNewValue_Exception() throws Exception {
        MinHeap mH = new MinHeap();
        mH.setDefaultArrayList();
        int newVal = 12;
        String message = "";
        String expected = "Error: heapAddNewValue() can only be used on a completed heap.";
        try {
            mH.heapAddNewValue(newVal);
        } catch (Exception e) {
            message = e.getMessage();
        }
        assertEquals(expected, message);
    }
}