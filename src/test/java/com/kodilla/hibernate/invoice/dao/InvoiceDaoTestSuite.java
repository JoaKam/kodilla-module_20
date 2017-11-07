package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    InvoiceDao invoiceDao;

    @Test
    public void testInvoiceDaoSave() {
        //Given
        
        Product prodApple = new Product(1, "Apple");
        Product prodBanana = new Product(2, "Banana");
        Product prodOrange = new Product(3, "Orange");

        Item itemApple = new Item(5, prodApple, new BigDecimal(5), 4, new BigDecimal(20));
        Item itemApple2 = new Item(5, prodApple, new BigDecimal(6), 3, new BigDecimal(18));
        Item itemBanana = new Item(5, prodBanana, new BigDecimal(4), 2, new BigDecimal(8));
        Item itemOrange = new Item(5, prodOrange, new BigDecimal(3), 1, new BigDecimal(3));

        Invoice invoiceAppleApple2 = new Invoice(0, "1/11/2017", Arrays.asList(itemApple, itemApple2));
        Invoice invoiceAppleOrangeBanana = new Invoice(2, "1/11/2017", Arrays.asList(itemApple, itemOrange, itemBanana));

        prodApple.setItems(Arrays.asList(itemApple, itemApple2));
        prodBanana.setItems(Arrays.asList(itemBanana));
        prodOrange.setItems(Arrays.asList(itemOrange));

        //When
        invoiceDao.save(invoiceAppleApple2);
        invoiceDao.save(invoiceAppleOrangeBanana);
        int idInvAppleApple2 = invoiceAppleApple2.getId();
        int idInvAppleOrangeBanana = invoiceAppleOrangeBanana.getId();

        //Then
        Assert.assertNotEquals(0, idInvAppleApple2);
        Assert.assertNotEquals(2, idInvAppleOrangeBanana);

        //CleanUp
        invoiceDao.delete(idInvAppleApple2);
        invoiceDao.delete(idInvAppleOrangeBanana);
    }
}
