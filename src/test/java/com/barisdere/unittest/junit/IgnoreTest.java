package com.barisdere.unittest.junit;

import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by baris on 11/03/15.
 */
@Ignore
public class IgnoreTest {

    @Test
    public void testMerhaba() throws Exception {
        System.out.println("Merhaba");
    }

    @Test
    @Ignore("Bu method daha sonra kullanilacak")
    public void testMerhaba2() throws Exception {
        System.out.println("Merhaba 2");
    }
}
