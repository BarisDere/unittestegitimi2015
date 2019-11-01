package com.barisdere.unittest.customer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class MusteriServiceTest {

    private MusteriService musteriService;

    private MusteriRepositoryStub musteriRepository = new MusteriRepositoryStub();

    private BilgilendirmeService bilgilendirmeService;

    @Before
    public void setUp() throws Exception {
        musteriService = new MusteriService();
        bilgilendirmeService = Mockito.mock(BilgilendirmeService.class);
        musteriService.setMusteriRepository(musteriRepository);
        musteriService.setBilgilendirmeService(bilgilendirmeService);
    }

    @After
    public void after() {
        musteriRepository.herseyiSil();
    }

    @Test
    public void testMusteriSil() throws Exception {

        musteriService.musteriKaydet(new Musteri(1234));

        musteriService.musteriSil(1234);

        assertNull(musteriRepository.bul(1234));
    }

    @Test
    public void testMusteriKaydet() {

        Musteri musteri = new Musteri(1234);

        musteriService.musteriKaydet(musteri);

        assertEquals(musteri, musteriRepository.bul(musteri.getId()));
        Mockito.verify(bilgilendirmeService).yeniKayitMailGonder(new Musteri(543543));
    }




}