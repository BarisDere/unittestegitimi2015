package com.barisdere.unittest.ornek;

import junit.framework.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class HesapMakinesiTest {

    @Test
    public void testTopla() {

        // GIVEN
        HesapMakinesi hesapMakinesi = new HesapMakinesi();
        int sayi1 = 5;
        int sayi2 = 19;

        // WHEN
        int toplam = hesapMakinesi.topla(sayi1, sayi2);

        // THEN
        assertEquals(24, toplam);

    }

    @Test
    public void testCikart() throws Exception {

        HesapMakinesi hesapMakinesi = new HesapMakinesi();

        assertEquals(15, hesapMakinesi.cikart(15, 0));
    }

    @Test
    public void testSifirdanCikincaEksiOlur() throws Exception {

        HesapMakinesi hesapMakinesi = new HesapMakinesi();

        assertEquals(-15, hesapMakinesi.cikart(0, 15));
    }

    @Test
    public void testSayidanSifirCikincaAyniSayiKalir() throws Exception {

        HesapMakinesi hesapMakinesi = new HesapMakinesi();

        assertEquals(15, hesapMakinesi.cikart(15, 0));
    }


}