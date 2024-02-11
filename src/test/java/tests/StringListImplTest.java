package tests;

import org.example.StringList;
import org.example.StringListImpl;
import org.example.exceptions.InvalidIndexException;
import org.example.exceptions.ItemIsNullException;
import org.example.exceptions.ItemNotFoundExeption;
import org.example.exceptions.StorageIsFullException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;
import static tests.TestConstants.*;


public class StringListImplTest {

    private final StringList out = new StringListImpl();
    private final StringList otherList = new StringListImpl();

    private void initArray(){
        for (int i = 0; i < DEFAULT_STORAGE_SIZE; i++) {
            out.add(TEST_STRING);
        }
    }

    @Test
    public void addOneParameterPositiveTest(){
        Assertions.assertEquals(TEST_STRING, out.add(TEST_STRING));
    }
    @Test
    public void addOneParameterNegativeTest(){
        initArray();
        Assertions.assertThrows(StorageIsFullException.class, () -> out.add(TEST_STRING));
        Assertions.assertThrows(ItemIsNullException.class, () -> out.add(null));
    }
    @Test
    public void addTwoParametersPositiveTest(){
        Assertions.assertEquals(TEST_STRING, out.add(0, TEST_STRING));
    }
    @Test
    public void addTwoParametersNegativeTest(){
        Assertions.assertThrows(InvalidIndexException.class, () -> out.add(1, TEST_STRING));
        Assertions.assertThrows(ItemIsNullException.class, () -> out.add(0, null));
        initArray();
        Assertions.assertThrows(StorageIsFullException.class, () -> out.add(0, TEST_STRING));
    }
    @Test
    public void setPositiveTest(){
        Assertions.assertEquals(TEST_STRING, out.set(0, TEST_STRING));
    }
    @Test
    public void setNegativeTest(){
        Assertions.assertThrows(InvalidIndexException.class, () -> out.set(1, TEST_STRING));
        Assertions.assertThrows(ItemIsNullException.class, () -> out.set(0, null));
    }
    @Test
    public void removeItemPositiveTest(){
        initArray();
        Assertions.assertEquals(TEST_STRING, out.remove(TEST_STRING));
    }
    @Test
    public void removeItemNegativeTest(){
        Assertions.assertThrows(ItemIsNullException.class, () -> out.remove(null));
        Assertions.assertThrows(ItemNotFoundExeption.class, () -> out.remove(TEST_STRING));
    }
    @Test
    public void removeByIndexPositiveTest(){
        initArray();
        Assertions.assertEquals(TEST_STRING, out.remove(0));
    }
    @Test
    public void removeByIndexNegativeTest(){
        Assertions.assertThrows(InvalidIndexException.class, () -> out.remove(1));

    }
    @Test
    public void containsPositiveTest(){
        Assertions.assertEquals(false, out.contains(TEST_STRING));
        initArray();
        Assertions.assertEquals(true, out.contains(TEST_STRING));
    }
    @Test
    public void containsNegativeTest(){
        Assertions.assertThrows(ItemIsNullException.class, () -> out.contains(null));
    }
    @Test
    public void indexOfPositiveTest(){
        initArray();
        Assertions.assertEquals(-1, out.indexOf(TEST_STRING_2));
        Assertions.assertEquals(0, out.indexOf(TEST_STRING));
    }
    @Test
    public void indexOfNegativeTest(){
        Assertions.assertThrows(ItemIsNullException.class, () -> out.indexOf(null));
    }
    @Test
    public void lastIndexOfPositiveTest(){
        initArray();
        Assertions.assertEquals(-1, out.lastIndexOf(TEST_STRING_2));
        Assertions.assertEquals(9, out.lastIndexOf(TEST_STRING));
    }
    @Test
    public void lastIndexOfNegativeTest() {
        Assertions.assertThrows(ItemIsNullException.class, () -> out.lastIndexOf(null));
    }
    @Test
    public void getPositiveTest(){
        initArray();
        Assertions.assertEquals(TEST_STRING, out.get(0));
    }
    @Test
    public void getNegativeTest(){
        Assertions.assertThrows(InvalidIndexException.class, () -> out.get(1));
    }
    @Test
    public void equalsTest(){
        initArray();
        for (int i = 0; i < DEFAULT_STORAGE_SIZE; i++) {
            otherList.add(TEST_STRING);
        }
        Assertions.assertEquals(true, out.equals(otherList));
        for (int i = 0; i < DEFAULT_STORAGE_SIZE; i++) {
            otherList.set(i, TEST_STRING_2);
        }
        Assertions.assertEquals(false, out.equals(otherList));
    }
    @Test
    public void sizeTest(){
        initArray();
        Assertions.assertEquals(DEFAULT_STORAGE_SIZE, out.size());
    }
    @Test
    public void isEmpty(){
        Assertions.assertEquals(true, out.isEmpty());
        initArray();
        Assertions.assertEquals(false, out.isEmpty());
    }
}
