package org.example.Impl;

import org.example.IntegerList;
import org.example.StringList;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class IntegerListImplTest {
    IntegerList integerList = new IntegerListImpl(10);

    Integer test1 = 1;
    Integer testNull = null;

    @Test
    void add() {
        Integer actual = integerList.add(test1);
        assertEquals(test1, actual);

    }
    @Test
    void shouldThrowExcedptionWhenItemIsNull() {
        assertThrows(NullPointerException.class, () -> integerList.add(null));
    }

    @Test
    void testAddIndex() {
        Integer actual = integerList.add(2, test1);
        assertEquals(test1, actual);
    }


    @Test
    void shouldThrow_Excedption_WhenIndex_AndIndexIsOutOfBound() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> integerList.add(10,test1));
    }

    @Test
    void set() {
        Integer actual = integerList.set(3, test1);
        assertEquals(test1,actual);
    }

    @Test
    void remove() {
        integerList.add(test1);
        Integer actual = integerList.remove(test1);
        assertEquals(test1, actual);
    }

    @Test
    void testRemove() {
        integerList.add(test1);
        Integer actual = integerList.remove(0);
        assertEquals(test1, actual);
    }

    @Test
    void shouldThrow_Excedption_When_ItemNotFound() {
        assertThrows(NoSuchElementException.class, () -> integerList.remove(Integer.valueOf("1")));
    }

    @Test
    void contains() {
        integerList.add(test1);
        boolean actual = integerList.contains(test1);
        assertEquals(true, actual);
    }

    @Test
    void indexOf() {
        integerList.add(test1);
        int actual = integerList.indexOf(test1);
        assertEquals(0, actual);
    }

    @Test
    void lastIndexOf() {
        integerList.add(test1);
        integerList.add(test1);
        int actual = integerList.lastIndexOf(test1);
        assertEquals(1, actual);
    }

    @Test
    void get() {
        integerList.add(test1);
        Integer actual = integerList.get(0);
        assertEquals(test1, actual);
    }

    @Test
    void testEquals() {
        IntegerList stringList1 = new IntegerListImpl(10);
        stringList1.add(test1);
        integerList.add(test1);
        boolean actual = integerList.equals(stringList1);
        assertEquals(true, actual);
    }

    @Test
    void size() {
        integerList.add(test1);
        int actual = integerList.size();
        assertEquals(1, actual);
    }

    @Test
    void isEmpty() {
        int actual = integerList.size();
        assertEquals(0, actual);
    }

    @Test
    void clear() {
        integerList.add(test1);
        integerList.clear();
        boolean actual = integerList.isEmpty();
        assertEquals(true, actual);
    }
}