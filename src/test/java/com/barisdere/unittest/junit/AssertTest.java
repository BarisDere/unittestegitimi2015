package com.barisdere.unittest.junit;

import static org.junit.Assert.*;
import org.junit.Test;

public class AssertTest {

    @Test
    public void testAssertions() throws Exception {

        String[] arr1 = new String[]{"1", "2", "3"};
        String[] arr2 = new String[]{"1", "2"};

        assertSame(arr1, arr2);
    }

    private static class Dummy {

        private int id;

        public int getId() {
            return id;
        }

        public Dummy(int id) {
            this.id = id;
        }

        @Override
        public boolean equals(Object obj) {
            return this.id == ((Dummy) obj).getId();
        }
    }
}
