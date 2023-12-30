package org.example.Impl;

import org.example.StringList;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class StringListImplTest {
    StringList stringList = new StringListImpl(10);

    String test1 = "Semen";
    String testNull = null;

    @Test
    void add() {
        String actual = stringList.add(test1);
        assertEquals(test1, actual);

    }
    @Test
    void shouldThrowExcedptionWhenItemIsNull() {
        assertThrows(NullPointerException.class, () -> stringList.add(null));
    }

    @Test
    void testAddIndex() {
        String actual = stringList.add(2, test1);
        assertEquals(test1, actual);
    }


    @Test
    void shouldThrow_Excedption_WhenIndex_AndIndexIsOutOfBound() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> stringList.add(10,test1));
    }

    @Test
    void set() {
        String actual = stringList.set(3, test1);
        assertEquals(test1,actual);
    }

    @Test
    void remove() {
        stringList.add(test1);
        String actual = stringList.remove(test1);
        assertEquals(test1, actual);
    }

    @Test
    void testRemove() {
        stringList.add(test1);
        String actual = stringList.remove(0);
        assertEquals(test1, actual);
    }

    @Test
    void shouldThrow_Excedption_When_ItemNotFound() {
        assertThrows(NoSuchElementException.class, () -> stringList.remove("a"));
    }

    @Test
    void contains() {
        stringList.add(test1);
        boolean actual = stringList.contains(test1);
        assertEquals(true, actual);
    }

    @Test
    void indexOf() {
        stringList.add(test1);
        int actual = stringList.indexOf(test1);
        assertEquals(0, actual);
    }

    @Test
    void lastIndexOf() {
        stringList.add(test1);
        stringList.add(test1);
        int actual = stringList.lastIndexOf(test1);
        assertEquals(1, actual);
    }

    @Test
    void get() {
        stringList.add(test1);
        String actual = stringList.get(0);
        assertEquals(test1, actual);
    }

    @Test
    void testEquals() {
        StringList stringList1 = new StringListImpl(10);
        stringList1.add(test1);
        stringList.add(test1);
        boolean actual = stringList.equals(stringList1);
        assertEquals(true, actual);
    }

    @Test
    void size() {
        stringList.add(test1);
        int actual = stringList.size();
        assertEquals(1, actual);
    }

    @Test
    void isEmpty() {
        int actual = stringList.size();
        assertEquals(0, actual);
    }

    @Test
    void clear() {
        stringList.add(test1);
        stringList.clear();
        boolean actual = stringList.isEmpty();
        assertEquals(true, actual);
    }
}