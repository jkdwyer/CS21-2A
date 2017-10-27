import java.util.ArrayList;

/**
 * AbstractHeap class
 * - provides member variables and get/set methods for min or max heap.
 * - for MaxHeap, no child may have a higher value than its parent.
 * - for MinHeap, no child may have a lower value than its parent.
 * @author Jan Dwyer
 * @version 1.0         10/23/2017
 */
public abstract class AbstractHeap {

        protected int stopPosition = 0;
        protected int arrSize = 0;
        protected int arrMaxPos = 0;
        protected int heapSize = 0;
        protected ArrayList<Integer> heapArr = new ArrayList<Integer>();
        protected ArrayList<Integer> sortedArr = new ArrayList<Integer>();
        protected boolean isHeap = false;
        protected boolean isHeapified = false;
        protected boolean isSorted = false;
        protected int heapifiedSize = 0;

        public AbstractHeap() {
        }

        public AbstractHeap(ArrayList<Integer> arr) {
            heapArr = arr;
            arrSize = heapArr.size();
            arrMaxPos = (arrSize-1);
        }

        public int getArrSize() {
            return arrSize;
        }

        public int getArrMaxPos() {
            return arrMaxPos;
        }

        public int getHeapSize() {
            return heapSize;
        }

        public int getHeapifiedSize() {
            return heapifiedSize;
        }

        public int getArrAtPos(int index) {
            return heapArr.get(index);
        }

        public void setArrAtPos(int index, int value) {
            heapArr.set(index, value);
        }

        public ArrayList<Integer> getHeapArr() {
            return heapArr;
        }

        public ArrayList<Integer> getSortedArr() {
            return sortedArr;
        }

        public boolean getIsHeap() {
            return isHeap;
        }

        public boolean getIsHeapified() {
            return isHeapified;
        }

        public boolean getIsSorted() {
            return isSorted;
        }

        public int getSortAtPos(int index) {
            return sortedArr.get(index);
        }

        /**
         * getTop() method
         * - does not alter data, so it can be used on any ArrayList.
         * @return  element in first position of ArrayList.
         */
        public int getTop() {
            return heapArr.get(0);
        }

        /**
         * parent() method
         * - parent calculation for arrays starting at position zero.
         * @param pos
         * @return int
         */
        public int parent(int pos) {
            // Math.floor() only accepts double.
            double parentCalc = ((pos-1)/2);
            // Double can be converted to an intValue.
            Double parentDbl = Math.floor(parentCalc);
            // then return an int position.
            int parentPos = parentDbl.intValue();
            return parentPos;
        }


        /**
         * leftChild() method
         * - left child calculation for arrays starting at position zero.
         * @param pos
         * @return int
         */
        public int leftChild(int pos) {
            int leftPos = ((2*pos)+1);
            return leftPos;
        }


        /**
         * rightChild() method
         * - right child calculation for arrays starting at position zero.
         * @param pos
         * @return
         */
        public int rightChild(int pos) {
            int rightPos = ((2*pos)+2);
            return rightPos;
        }


        /**
         * swap() method
         * - exchanges value in pos1 with value in pos2 of ArrayList.
         * @param pos1
         * @param pos2
         */
        public void swap(int pos1, int pos2) {
            int val1 = heapArr.get(pos1);
            int val2 = heapArr.get(pos2);
            heapArr.set(pos1, val2);
            heapArr.set(pos2, val1);
        }


        /**
         * heapify() method
         * - gets called once with any position in array, then
         *      creates a partial heap from position zero to incomingPos,
         *      leaving position incomingPos+1 through arrMaxPos untouched.
         * @param incomingPos
         */
        public void heapify(int incomingPos) {
            // initialize end position to leftChild of first element.
            int endPos = leftChild(stopPosition);
            while (endPos <= incomingPos) {
                sift(endPos);
                endPos++;
            }
            isHeapified = true;
            heapifiedSize = (incomingPos+1);
        }


        /**
         * buildHeap() method
         * - gets called once and creates a complete heap from heapArr.
         */
        public void buildHeap() {
            // initialize end position to leftChild of first element.
            int endPos = leftChild(stopPosition);
            while (endPos <= arrMaxPos) {
                sift(endPos);
                endPos++;
            }
            isHeap = true;
            heapSize = arrSize;
        }


        /**
         * sift() method
         * - does a partial, recursive sort from any position in the ArrayList.
         * - (this was supposed to be an abstract method with no method body.)
         * @param endPos
         */
        public void sift(int endPos) {
            // TODO:  remove this output.
            // System.out.println("sift - endPos: " + endPos + " heapArr: " + heapArr + "\n");
            int childPos = endPos;
            while (childPos > stopPosition) {
                int parentPos = parent(childPos);
                if (heapArr.get(childPos) > heapArr.get(parentPos)) {
                    swap(parentPos, childPos);
                    childPos = parentPos;
                    // TODO:  remove this output.
                    // System.out.println("recursive call");
                    // recursive call.
                    sift(childPos);
                } else {
                    childPos = parentPos;
                    // no swap needed.
                }
            }
        }


        public int extractTop() throws Exception {
            if (isHeap) {
                int top = heapArr.get(0);
                heapArr.remove(0);
                // reset size and max position, then re-build the heap.
                arrSize = heapArr.size();
                arrMaxPos = (arrSize-1);
                buildHeap();
                return top;
            } else {
                throw new Exception("Error: extractTop() can only be used on a completed heap.");
            }
        }


        /**
         * heapSort() method
         * - take the heap and process each element into a sorted array.
         * - method should only be allowed to work on a completed heap.
         */
        public void heapSort() throws Exception {
            if (isHeap) {
                int maxPos = arrMaxPos;
                for (int i = 0; i <= maxPos; i++) {
                    int topVal = extractTop();
                    sortedArr.add(i, topVal);
                }
                isSorted = true;
            } else {
                throw new Exception("Error: heapSort() can only be used on a completed heap.");
            }
        }


        /**
         * heapInsert() method
         * - method is adding elements from end of heapArr to partial heap
         *      in the same array, so it accepts a position argument.
         * - method should only be allowed to work on a partial heap.
         * @param pos
         */
        public void heapInsert(int pos) throws Exception {
            if (isHeapified) {
                if (pos == heapifiedSize) {
                    // pos is next element.
                    heapify(heapifiedSize);
                } else {
                    // pos is any subsequent element.
                    int desVal = heapArr.get(pos);
                    int hsVal = heapArr.get(heapifiedSize);
                    heapArr.set(heapifiedSize, desVal);
                    int j = 1;
                    int nextVal = hsVal;
                    while ((heapifiedSize+j) <= pos) {
                        hsVal = heapArr.get(heapifiedSize+j);
                        heapArr.set((heapifiedSize+j), nextVal);
                        nextVal = hsVal;
                        j++;
                    }
                    // TODO:  remove this output.
                    // System.out.println("heapArr: " + heapArr + "\n");
                    // now that desVal is the next element...
                    heapify(heapifiedSize);
                }
            } else {
                throw new Exception ("Error:  heapInsert() can only be used on a partial heap.");
            }
        }


        /**
         * heapAddNewValue() method
         * - method takes a new element value from an outside source
         *      and adds it to a completed heap.
         * - method should only be allowed to work on a completed heap.
         * @param value
         */
        public void heapAddNewValue(int value) throws Exception {
            if (isHeap) {
                heapArr.add(value);
                arrSize = heapArr.size();
                arrMaxPos = (arrSize-1);
                buildHeap();
            } else {
                throw new Exception("Error: heapAddNewValue() can only be used on a completed heap.");
            }
        }
}   // end AbstractHeap class.
