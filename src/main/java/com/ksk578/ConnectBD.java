package com.ksk578;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ConnectBD {
    // цель класса - выполнить подключение к одной из трех БД, реализовать селект и вывести в консоль отформатированный ответ
    protected int standSelection;
// выбор стенда, к БД которого делаем запрос
    protected void databaseSelection () throws IOException, SQLException, ClassNotFoundException {
        System.out.println("Выберите стенд к БД которого выполняем подключение: \n TSE-TEST - 1 \n TSE-DEMO - 2 \n TSE-RLS - 3 ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        standSelection = Integer.parseInt(reader.readLine());
        if (standSelection != 1 && standSelection != 2 && standSelection != 3) {
            int a = 0;
            while (standSelection != 1 && standSelection != 2 && standSelection != 3) {
                if (a < 1) {
                    System.out.println("Введите правильный код выбора стенда");
                    standSelection = Integer.parseInt(reader.readLine());
                } else {
                    System.out.println("Я вот сейчас как обижусь и ничего у вас не получится! \nВведите корректный код выбора:");
                    standSelection = Integer.parseInt(reader.readLine());
                }
                a++;
            }
        }
        if (standSelection == 1) {
            connectTSE_Test();
        }
        else if (standSelection == 2) {
            connectTSE_Demo();
        }
        else if (standSelection == 3) {
            connectTSE_Rls();
        }

    }
    // подключаемся к БД TSE-TEST
    protected void connectTSE_Test() throws SQLException, ClassNotFoundException, IOException {
        String url = "jdbc:postgresql://eb-tse-test-poi-db.otr.ru:5432/UFOS_TSE";
        String username = "UFOS_TSE";
        String password = "Postgres55";

        Class.forName("org.postgresql.Driver");

        Connection con= DriverManager.getConnection(url, username, password);
        Statement stmt=con.createStatement();
        if (stmt== null){
            System.out.println("Сбой в подключении к БД");
        }
        RequestStructure req = new RequestStructure();
        String query = req.quest();

        System.out.println("Запрос к БД \n" + query + "\n");
        System.out.println("БД стенда: " + "TSE-TEST");
        System.out.println( "Время запроса: " + new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime()) );

        ResultSet res=stmt.executeQuery(query);
        int fieldSelect = req.getfied();

        // вывод в консоль для варианта полей краткого и полного
        if (fieldSelect == 1){
            System.out.format("%25s%25s%80s%25s%12s%60s%20s%40s%5s","Дата создания |", "Сист имя |", "Документ |", "Глоб статус |", "СВР |", "Организация |", "Идентификатор БД |", "Глобальный идентификатор |", "\n");
                    while(res.next()){
                        System.out.format("%25s%25s%80s%25s%12s%60s%20s%40s%5s", res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7), res.getString(8), "\n");
                    }
        }
        else {
            System.out.format("%25s%25s%80s%25s%35s%12s%60s%12s%12s%12s%12s%20s%40s%20s%20s%8s", "Дата создания |", "Сист имя |", "Документ |", "Глоб статус |", "Сист имя глоб статуса |", "СВР |", "Организация |", "Глоб стат |", "Лок стат |", "Глоб верс |", "Лок верс |", "Идентификатор БД |", "Глобальный идентификатор |", "ORGID |", "DOCID |", "\n");
                  while(res.next()){
                      System.out.format("%25s%25s%80s%25s%35s%12s%60s%12s%12s%12s%12s%20s%40s%20s%20s%8s", res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7), res.getString(8), res.getString(9), res.getString(10), res.getString(11), res.getString(12), res.getString(13), res.getString(14), res.getString(15), "\n");
                  }
        }
        con.close();
    }

    // подключаемся к БД TSE-DEMO
    protected void connectTSE_Demo() throws SQLException, ClassNotFoundException, IOException {
        String url = "jdbc:postgresql://eb-tse-demo-poi-db.otr.ru:5432/tse_ufos_wl2";
        String username = "ufos";
        String password = "Oracle33";

        Class.forName("org.postgresql.Driver");

        Connection con= DriverManager.getConnection(url, username, password);
        Statement stmt=con.createStatement();
        if (stmt== null){
            System.out.println("Сбой в подключении к БД");
        }
        RequestStructure req = new RequestStructure();
        String query = req.quest();

        System.out.println("Запрос к БД \n" + query + "\n");
        System.out.println("БД стенда: " + "TSE-DEMO");
        System.out.println( "Время запроса: " + new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime()) );

        ResultSet res=stmt.executeQuery(query);
        int fieldSelect = req.getfied();

        // вывод в консоль для варианта полей краткого и полного
        if (fieldSelect == 1){
            System.out.format("%25s%25s%80s%25s%12s%60s%20s%40s%5s","Дата создания |", "Сист имя |", "Документ |", "Глоб статус |", "СВР |", "Организация |", "Идентификатор БД |", "Глобальный идентификатор |", "\n");
            while(res.next()){
                System.out.format("%25s%25s%80s%25s%12s%60s%20s%40s%5s", res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7), res.getString(8), "\n");
            }
        }
        else {
            System.out.format("%25s%25s%80s%25s%35s%12s%60s%12s%12s%12s%12s%20s%40s%20s%20s%8s", "Дата создания |", "Сист имя |", "Документ |", "Глоб статус |", "Сист имя глоб статуса |", "СВР |", "Организация |", "Глоб стат |", "Лок стат |", "Глоб верс |", "Лок верс |", "Идентификатор БД |", "Глобальный идентификатор |", "ORGID |", "DOCID |", "\n");
            while(res.next()){
                System.out.format("%25s%25s%80s%25s%35s%12s%60s%12s%12s%12s%12s%20s%40s%20s%20s%8s", res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7), res.getString(8), res.getString(9), res.getString(10), res.getString(11), res.getString(12), res.getString(13), res.getString(14), res.getString(15), "\n");
            }
        }
        con.close();
    }
    // подключаемся к БД TSE-RLS
    protected void connectTSE_Rls() throws SQLException, ClassNotFoundException, IOException {
        String url = "jdbc:postgresql://eb-tse-rls-poi-db.otr.ru:5432/tse_ufos_wl";
        String username = "ufos";
        String password = "Postgres55";

        Class.forName("org.postgresql.Driver");

        Connection con= DriverManager.getConnection(url, username, password);
        Statement stmt=con.createStatement();
        if (stmt== null){
            System.out.println("Сбой в подключении к БД");
        }
        RequestStructure req = new RequestStructure();
        String query = req.quest();

        System.out.println("Запрос к БД \n" + query + "\n");
        System.out.println("БД стенда: " + "TSE-RLS");
        System.out.println( "Время запроса: " + new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime()) );

        ResultSet res=stmt.executeQuery(query);
        int fieldSelect = req.getfied();

        // вывод в консоль для варианта полей краткого и полного
        if (fieldSelect == 1){
            System.out.format("%25s%25s%80s%25s%12s%60s%20s%40s%5s","Дата создания |", "Сист имя |", "Документ |", "Глоб статус |", "СВР |", "Организация |", "Идентификатор БД |", "Глобальный идентификатор |", "\n");
            while(res.next()){
                System.out.format("%25s%25s%80s%25s%12s%60s%20s%40s%5s", res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7), res.getString(8), "\n");
            }
        }
        else {
            System.out.format("%25s%25s%80s%25s%35s%12s%60s%12s%12s%12s%12s%20s%40s%20s%20s%8s", "Дата создания |", "Сист имя |", "Документ |", "Глоб статус |", "Сист имя глоб статуса |", "СВР |", "Организация |", "Глоб стат |", "Лок стат |", "Глоб верс |", "Лок верс |", "Идентификатор БД |", "Глобальный идентификатор |", "ORGID |", "DOCID |", "\n");
            while(res.next()){
                System.out.format("%25s%25s%80s%25s%35s%12s%60s%12s%12s%12s%12s%20s%40s%20s%20s%8s", res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7), res.getString(8), res.getString(9), res.getString(10), res.getString(11), res.getString(12), res.getString(13), res.getString(14), res.getString(15), "\n");
            }
        }
        con.close();
    }


}
