package com.barisdere.unittest.junit;

import com.barisdere.unittest.ornek.HesapMakinesi;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ParametreTest {

    private HesapMakinesi hesapMakinesi = new HesapMakinesi();

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {10, 2, 20},
                {20, 2, 40},
                {5,  2, 10},
                {24, 2, 48},
                {6,  2, 12}});
    }

    private int eni;
    private int boyu;
    private int toplamMetreKare;

    public ParametreTest(int eni, int boyu, int toplamMetreKare) {
        this.eni = eni;
        this.boyu = boyu;
        this.toplamMetreKare = toplamMetreKare;
    }

    @Test
    public void testMetreKareHesapla() throws Exception {

        assertEquals(toplamMetreKare, hesapMakinesi.metreKareHesapla(eni, boyu));

    }
}
