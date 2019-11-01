package com.barisdere.unittest.assertj;

import org.assertj.core.api.Condition;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomerTest {

    List<String> turkSehirlerListesi = new ArrayList<String>(Arrays.asList("Istanbul", "Ankara", "Izmir"));
    List<String> yabanciSehirlerListesi = new ArrayList<String>(Arrays.asList("Amsterdam", "Paris", "Londra"));

    @Test
    public void testStrings() throws Exception {

        String text1 = "Istanbul";

        assertThat(text1)
                .describedAs("bu bir hata")
                .isEqualTo("Istanbul")
                .startsWith("Ist")
                .endsWith("bul")
                .contains("tan")
                .isNotEmpty()
                .isNotNull()
                .doesNotContain("baris")
                .containsOnlyOnce("tan");

    }

    @Test
    public void testDuzListeler() throws Exception {

        List<String> sehirler = new ArrayList<String>(Arrays.asList("Istanbul", "Ankara", "Izmir"));

        assertThat(sehirler)
                .describedAs("bu bir hata")
                .contains("Ankara")
                .doesNotContain("Bursa")
                .containsExactly("Istanbul", "Ankara", "Izmir")
                .doesNotHaveDuplicates();

        //listemde sadece turk sehirleri olsun
        List<String> sehirler2 = new ArrayList<String>(Arrays.asList("Istanbul", "Ankara", "Izmir"));

        assertThat(sehirler2)
                .have(turkSehirler());

        //listemde sadece yabanci sehirleri olsun
        List<String> sehirler3 = new ArrayList<String>(Arrays.asList("Amsterdam", "Paris", "Londra"));

        assertThat(sehirler3)
                .have(yabanciSehirler());

        //listemde 2 turk 3 yabanci sehirler olsun
        List<String> sehirler4 = new ArrayList<String>(Arrays.asList("Amsterdam", "Istanbul", "Paris", "Izmir", "Londra"));

        assertThat(sehirler4)
                .haveExactly(2, turkSehirler())
                .haveExactly(3, yabanciSehirler());

    }

    private Condition<? super String> turkSehirler() {
        return new Condition<String>() {
            @Override
            public boolean matches(String s) {
                return turkSehirlerListesi.contains(s);
            }
        };
    }

    private Condition<? super String> yabanciSehirler() {
        return new Condition<String>() {
            @Override
            public boolean matches(String s) {
                return yabanciSehirlerListesi.contains(s);
            }
        };
    }


}
