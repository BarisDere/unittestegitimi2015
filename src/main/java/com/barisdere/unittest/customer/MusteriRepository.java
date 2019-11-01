package com.barisdere.unittest.customer;

/**
 * Gercek Oracle Musteri Repository
 */
public class MusteriRepository {

    public void kaydet(Musteri musteri) {
        System.out.println("Oracle DB kaydedildi");
    }

    public void sil(Integer musteriId) {
        System.out.println("Oracle DB  musteri silindi");
    }

    public Musteri bul(Integer musteriId) {
        System.out.println("Oracle DB bul");
        return null;
    }

}
