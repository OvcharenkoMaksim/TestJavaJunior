package com.ksk578;

import java.io.IOException;
import java.sql.SQLException;

public class Start {
    public static void main( String[] args ) throws IOException, SQLException, ClassNotFoundException {
        // Приветствие и запуск программы
        System.out.println("Добрый день! \n Вы делаете комбинированный запрос-select к БД УФОС, таблицам: Routecontext, Org, Doc, Doctype, Docstate. \n Это основной запрос при разборе ошибок, связанных с ПОИБом");

        ConnectBD conBD = new ConnectBD();
        conBD.databaseSelection();

        System.out.println( "  \nРабота программы завершена успешно. \n Пишите письма.\n    С любовью Ваша Java." );
    }
}
