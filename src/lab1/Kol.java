package lab1;

import java.util.ArrayList;

public class Kol {

    private String typ,nazwa;
    public ArrayList list;

    public int getKolSize() {
        return list.size();
    }

    public String getTyp(){
        return typ;
    }

    public String getNazwa(){
        return nazwa;
    }

  
    public Kol(String nazwa, String typ){
    	this.typ = typ;
        this.nazwa = nazwa;
        this.list = new ArrayList();
    }

    public Kol(Kol kol){
    	this.typ = new String(kol.getTyp());
        this.nazwa = new String(kol.getNazwa());
        this.list = new ArrayList(kol.list);
    }

}