import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class MinHelper {
    public static void printHeapArray(String arr) {
        System.out.println("heapArr: " + arr + "\n");
    }

    public static void printSortedArray(String arr) {
        System.out.println("sortedArr: " + arr + "\n");
    }

    /**
     * serializeArrayList() method
     * - serialize and deserialize an ArrayList was successful.
     * @return serHeapArr
     */
    public static ArrayList<Integer> serializeArrayList() {
        MinHeap mH1 = new MinHeap();
        mH1.setDefaultArrayList();

        String arrfilename = "serArrTest.ser";
        try {
            FileOutputStream fos = new FileOutputStream(arrfilename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(mH1.getHeapArr());
            oos.close();
            fos.close();
            System.out.println("ArrayList mH1.heapArr has been serialized " +
                    "separately to file arrtest.ser");
            System.out.println("mH1.getHeapArr(): " + mH1.getHeapArr());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        ArrayList<Integer> serHeapArr = new ArrayList<Integer>();
        try {
            FileInputStream fis = new FileInputStream(arrfilename);
            ObjectInputStream ois = new ObjectInputStream(fis);
            serHeapArr = (ArrayList<Integer>) ois.readObject();
            ois.close();
            fis.close();
            System.out.println("ArrayList mH1.heapArr has been deserialized " +
                    "from file arrtest.ser into ArrayList serHeapArr");
            System.out.println("serHeapArr: " + serHeapArr);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return serHeapArr;
    }


    /**
     * serializeMinHeap() method
     * - serialize and deserialize a MinHeap object failed to
     *      include the ArrayList member variable.  Both halves
     *      are commented out for now.
     * - serialize and deserialize an ArrayList was successful.
     * @return mH2
     */
    public static MinHeap serializeMinHeap() {
        MinHeap mH1 = new MinHeap();
        mH1.setDefaultArrayList();

        mH1.setMessage("This message was set in mH1.");
        String filename = "serMinHeapTest.ser";
        try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(mH1);
            out.close();
            fileOut.close();
            System.out.println("Object mH1 has been serialized to file test.ser");
            System.out.println("mH1.getHeapArr(): " + mH1.getHeapArr());
            System.out.println("mH1.getArrSize(): " + mH1.getArrSize());
            System.out.println("mH1.getTestMessage(): " + mH1.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        MinHeap mH2 = null;
        try {
            FileInputStream fileIn  = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            mH2 = (MinHeap)in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Object mH1 has been deserialized " +
                    "from file test.ser into Object mH2.");
            System.out.println("mH2.getHeapArr(): " + mH2.getHeapArr());
            System.out.println("mH2.getArrSize(): " + mH2.getArrSize());
            System.out.println("mH2.getTestMessage(): " + mH2.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return mH2;
    }
}
