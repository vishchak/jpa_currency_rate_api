package com.gmail.vishchak.denis.crudcurrency;

import com.gmail.vishchak.denis.datasource.ConversionRate;
import com.gmail.vishchak.denis.entity.Currency;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Scanner;

public class CurrencyCRUD {
    public static void addCurrency(EntityManager em, Scanner sc) {
        System.out.print("Enter base currency: ");
        String baseCurrency = sc.nextLine();
        System.out.print("Enter conversion currencies separated by commas: ");
        String conversionCurrencies = sc.nextLine();

        em.getTransaction().begin();
        try {
            for (Currency cur :
                    (ConversionRate.conversionRateToday(baseCurrency, conversionCurrencies.split(",")))) {
                em.persist(cur);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        }
    }

    public static void viewCurrencies(EntityManager em) {
        Query query = em.createQuery(
                "SELECT c FROM Currency c", Currency.class);
        List<Currency> list = (List<Currency>) query.getResultList();

        for (Currency c : list)
            System.out.println(c);
    }
}
