package com.skypro.integerlist;

import com.skypro.integerlist.service.IntegerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IntegerTest {
    private IntegerService integerService;

    private final static Integer TEST = 125;
    private final static Integer TEST_2 = 255;
    private final static int INDEX = 1;
    private final static Integer TEST_3 = 355;
    private final static Integer TEST_4 = 455;

    @BeforeEach
    public void setUp() {
        integerService = new IntegerService(4);
        integerService.add(TEST);
        integerService.add(TEST_2);

    }

    @Test
    public void add(){
        assertSame(integerService.add(TEST), TEST);
    }

    @Test
    public void addWithIndex() {
        assertEquals(integerService.add(INDEX, TEST_2), TEST_2);
    }

    @Test
    public void setItem() {
        assertEquals(integerService.set(INDEX, TEST_3),TEST_3);
    }

    @Test
    public void remove() {
        assertEquals(integerService.remove(TEST), TEST);
    }

    @Test
    public void removeWithIndex() {
        integerService.remove(INDEX);
    }

    @Test
    public void containsTrue() {
        integerService.add(TEST_4);
        assertTrue(integerService.contains(TEST_4));
    }

    @Test
    public void containsFalse() {
        assertFalse(integerService.contains(0));
    }

    @Test
    public void indexOf() {
        assertEquals(1, integerService.indexOf(TEST_2));
    }

    @Test
    public void lastIndexOf() {
        assertEquals(1, integerService.lastIndexOf(TEST_2));
    }

    @Test
    public void get() {
        assertEquals(TEST_2, integerService.get(INDEX));
    }

    @Test
    public void equals() {
        IntegerService test = new IntegerService(4);
        test.add(TEST_4);
        test.add(TEST_3);
        assertFalse(integerService.equals(test));
    }

    @Test
    public void size() {
        assertEquals(2, integerService.size());
    }

    @Test
    public void isEmpty() {
        assertFalse( integerService.isEmpty());
    }

    @Test
    public void clear() {
        integerService.clear();
        assertEquals(0, integerService.size());
    }

    @Test
    public void toArray() {
        Integer[] test = new Integer[] {TEST, TEST_2};
        assertArrayEquals(test, integerService.toArray());
    }

    @Test
    public void sortSelection() {
        Integer[] list = {TEST, TEST_2, TEST_3, TEST_4};
        integerService.sortSelection(list);

    }
}
