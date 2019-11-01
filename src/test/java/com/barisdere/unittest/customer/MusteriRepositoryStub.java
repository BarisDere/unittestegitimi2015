package com.barisdere.unittest.customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by baris on 07/03/15.
 */
public class MusteriRepositoryStub extends MusteriRepository {

    private Map<Integer, Musteri> musteriListesi = new HashMap<Integer, Musteri>();

    @Override
    public void kaydet(Musteri musteri) {
        musteriListesi.put(musteri.getId(), musteri);
    }

    @Override
    public void sil(Integer musteriId) {
        musteriListesi.remove(musteriId);
    }

    @Override
    public Musteri bul(Integer musteriId) {
        return musteriListesi.get(musteriId);
    }

    public void herseyiSil() {
        musteriListesi.clear();
    }
}
