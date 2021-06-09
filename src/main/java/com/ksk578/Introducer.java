package com.ksk578;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class Introducer {
    // цель класса - определить параметры отбора записей в запрос, получить данные для запроса,
    // удалить дубли и выполнить проверки на корректность вводимых данных
    protected int ident;
    ArrayList<String> list = new ArrayList<>();
    ArrayList<String> list2;

    protected int inputer() throws IOException {
        System.out.println("\nВыберите параметр поиска:\nguid - введите 1,\tИдентификатор БД - введите 2");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ident = Integer.parseInt(reader.readLine());
        if (ident != 1 && ident != 2) {
            int a = 0;
            while (ident != 1 && ident != 2) {
                if (a < 1) {
                    System.out.println("Введите правильный код выбора параметра");
                    ident = Integer.parseInt(reader.readLine());
                } else {
                    System.out.println("Да сколько уже можно издеваться надо мной! \nВведите корректный код выбора:");
                    ident = Integer.parseInt(reader.readLine());
                }
                a++;
            }
        }
        return ident;
    }

    protected ArrayList<String> listing () throws IOException {
        if (ident == 1) {
            System.out.println("Введите guid по порядку:");
            fillingGuid();
        } else {
            System.out.println("Введите Идентификаторы БД по порядку:");
            fillingBD();
        }
        eliminationOfDuplicates(list);
        return list2;
    }

    protected ArrayList<String> fillingGuid() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String guid;
        while (true) {
            guid = reader.readLine();
            if (guid.length() == 0) break;
            if (guid.length() == 36) {
                list.add(guid);
            } else {
                System.out.println("Введите корректный guid");
            }
        }
        if (list.size() == 0) {
            System.out.println("Guid не введен \nРабота программы завершена досрочно\nДо новых встреч!");
            System.exit(1);
        }
        return list;
    }

    protected ArrayList<String> fillingBD() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String idBD;
        while (true) {
            idBD = reader.readLine();
            if (idBD.length() == 0) break;
            if (idBD.length() >= 20) break;;
            //int idBDint = Integer.parseInt(idBD);
            long idBDlong = Long.parseLong(idBD);
            if (idBD.length() <= 9 &&  idBD.length() >= 7 && idBDlong > 0) {
                list.add(idBD);
            } else {
                System.out.println("Введите корректный Идентификатор БД");
            }
        }
        if (list.size() == 0) {
            System.out.println("Идентификатор БД не введен или введен ошибочный\nРабота программы завершена досрочно\nДо новых встреч!");
            System.exit(1);
        }
        return list;
    }

    protected ArrayList<String> eliminationOfDuplicates(ArrayList<String> a) {
        Set<String> set = new LinkedHashSet<String>(a);
        list2 = new ArrayList<String>(set);
        return list2;
    }
}




