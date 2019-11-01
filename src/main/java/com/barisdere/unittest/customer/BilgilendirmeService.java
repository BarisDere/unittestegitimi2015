package com.barisdere.unittest.customer;

import com.barisdere.unittest.customer.exception.MailServerUnavailableException;

/**
 * Created by baris on 05/03/15.
 */
public class BilgilendirmeService {

    public void yeniKayitMailGonder(Musteri musteri) {
        System.out.println("Mail gonderildi");
    }

    public void haftalikMailGonder() {
        throw new MailServerUnavailableException("mail server hata veriyor");
    }

}
