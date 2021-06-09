package com.ksk578;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FieldsView {
    //цель класса - определить вид выводимого результата, в частности количество полей в ответе от БД
    protected int fied;
    protected String selfield;

    protected String view() throws IOException {
        System.out.println("Выберите количество выводимых полей в запросе:\nКраткая форма: 8 полей (введите - 1): \nДата создания | Сист имя | Документ | Глоб статус | СВР | Организация | Идентификатор БД | Глобальный идентификатор\n \nПолная форма: 15 полей (введите - 2):\nДата создания | Сист имя | Документ | Глоб статус | Сист имя глоб статуса | СВР | Организация | Глоб стат | Лок стат | Глоб верс | Лок верс | Идентификатор БД | Глобальный идентификатор | ORGID | DOCID");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        fied = Integer.parseInt(reader.readLine());
        if (fied != 1 && fied != 2) {
            int a = 0;
            while (fied != 1 && fied != 2) {
                if (a < 1) {
                    System.out.println("Введите правильный код выбора полей таблицы");
                    fied = Integer.parseInt(reader.readLine());
                } else {
                    System.out.println("Слушай, ну достал уже, в самом деле! \nВведите корректный код выбора:");
                    fied = Integer.parseInt(reader.readLine());
                }
                a++;
            }
        }
        if (fied ==1){
            selfield = " w.createdate \"Дата создания\", d.SYSTEMNAME \"Сист имя\", d.NAME \"Документ\", g.DESCRIPTION \"Глоб статус\", o.SYSTEMNAME \"СВР\", o.NAME \"Организация\", r.ROUTECONTEXTID \"Идентификатор БД\", w.GLOBALDOCID \"Глобальный идентификатор\"";
        }
        if (fied ==2){
            selfield = " w.createdate \"Дата создания\", d.SYSTEMNAME \"Сист имя\", d.NAME \"Документ\",  g.DESCRIPTION \"Глоб статус\", g.systemname \"Сист имя глоб статуса\", o.SYSTEMNAME \"СВР\", o.NAME \"Организация\", w.docstateid \"Глоб стат\", r.localdocstateid \"Лок стат\", w.docstate_version \"Глоб верс\",  r.docstate_version \"Лок верс\", r.ROUTECONTEXTID \"Идентификатор БД\", w.GLOBALDOCID \"Глобальный идентификатор\", r.ORGID, w.DOCID";
        }
        return selfield;
    }

}

