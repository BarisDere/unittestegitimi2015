package com.barisdere.unittest.hamcrest;

import junit.framework.Assert;
import org.hamcrest.CoreMatchers;
import org.hamcrest.core.CombinableMatcher;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.core.CombinableMatcher.either;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;

import static org.hamcrest.CoreMatchers.*;

public class HamcrestTest {

    @Test
    public void testTemelEslestirmeler() throws Exception {

        String text1 = "Baris";
        String text2 = "Baris2";

        assertEquals("Baris", text1);

        assertThat(text1, is(equalTo("Baris")));

        assertThat(text1, is(notNullValue()));

        assertThat(text1, containsString("ris"));

        assertThat(text1, anyOf(containsString("ris"), containsString("Bar")));
    }

    @Test
    public void testListeler() throws Exception {

        List<String> sehirler = new ArrayList<String>(Arrays.asList("Istanbul", "Ankara", "Izmir"));

        assertThat(sehirler, hasItem("Istanbul"));

        assertThat(sehirler, hasItems("Istanbul", "Izmir"));

        assertThat(sehirler, allOf(hasItems("Istanbul", "Izmir"), not(hasItem("Bursa"))));

        assertThat(sehirler, either(hasItems("Istanbul", "Izmir")).or(not(hasItem("Bursa"))));



    }
}
