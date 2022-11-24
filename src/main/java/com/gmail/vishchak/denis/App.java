package com.gmail.vishchak.denis;

import com.gmail.vishchak.denis.crudcurrency.CurrencyCRUD;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.Scanner;

public class App {
    static EntityManagerFactory emf;
    static EntityManager em;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        emf = Persistence.createEntityManagerFactory("CurrencyJPA");
        em = emf.createEntityManager();

        while (true) {
            System.out.println("1: add currency");
            System.out.println("2: view rates");
            System.out.print("-> ");

            String s = sc.nextLine();
            switch (s) {
                case "1":
                    CurrencyCRUD.addCurrency(em, sc);
                    break;
                case "2":
                    CurrencyCRUD.viewCurrencies(em);
                    break;
                default:
                    return;
            }
        }

    }
}