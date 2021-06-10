package com.ksk578;

import java.io.IOException;
import java.util.ArrayList;

public class RequestStructure {
    // цель класса - создать итоговый запрос к БД
    protected String sel1 = "select";
    protected String sel2;
    protected String sel3 = " from ROUTECONTEXT r, ORG o, DOC w, DOCTYPE d, DOCSTATE g where r.ORGID = o.ORGID and r.DOCID = w.DOCID and d.DOCTYPEID = w.DOCTYPEID and w.DOCSTATEID = g.DOCSTATEID and ";
    protected String sel4;
    protected String sel5;
    protected String sel6;
    protected String select;
    protected int fiedSel;
    protected int ident;
    ArrayList<String> list = new ArrayList<>();
//формирование итогового запроса к БД
    protected String quest () throws IOException {
        Introducer intr = new Introducer();
        ident = intr.inputer();
        if (ident == 1){
            sel4 = " w.GLOBALDOCID in ('";
        }
        else {
            sel4 = " r.ROUTECONTEXTID in ('";
        }
        list = intr.listing();
        sel5 = list.get(0);
        if (list.size() > 1) {
            for (int i = 1; i < list.size(); i++) {
                String selprom = list.get(i);
                sel5 = sel5 + "' ,'" + selprom;
            }
        }
        sel5 = sel5 + "')";
        sel6 = " order by r.ROUTECONTEXTID";
        FieldsView fiel = new FieldsView();
        sel2 = fiel.view();
        fiedSel = fiel.fied;
        select = sel1 + sel2 + sel3 + sel4 + sel5 + sel6;
        //отладка программы
        //System.out.println(select);
        return select;
        }
//геттер идентификатора количества выводимых полей в ответе от БД
        protected int getfied(){
        return fiedSel;
        }
    }

