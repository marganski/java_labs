package lab1;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;


public class DataFrame {
    private ArrayList<Kol> Ramka = new ArrayList<Kol>();

    public DataFrame(String[] Nazwy, String[] Typy){
        for (int i=0; i<Nazwy.length; i++)
        {
            Ramka.add(new Kol(Nazwy[i],Typy[i]));
        }
    }

    public DataFrame(Kol[] Kolumny){
        for (int i=0; i<Kolumny.length; i++) {
            Ramka.add(Kolumny[i]);
        }
    }
    
   
    public void add(Object[] wartosci){
        int i = 0;
        for (Kol col:Ramka){
            col.list.add(wartosci[i++]);
        }
    }
    //public void addonposition(int index, Object wartosc){
    //	Ramka.get(index).list.add(wartosc);
    //}

    public int size(){
        return this.Ramka.get(0).getKolSize();
    }

     public  Kol get(String colname){
        for (Kol col:Ramka){
            if (col.getNazwa()==colname){
            	return col;
            }
        }
        throw new RuntimeException("Kol not found!");
        
    }

    public DataFrame get(String [] cols, boolean copy){
        Kol[] tmp = new Kol[cols.length];
        for (int i=0; i<tmp.length; i++){
           
            if (copy){ 
            	tmp[i] = new Kol(get(cols[i]));
            }
            else{ 
            	tmp[i] = this.get(cols[i]);
            }
        }
        DataFrame dataFrame = new DataFrame(tmp);
        return dataFrame;
    }

    public DataFrame iloc(int a, int b){
        
        int size = Ramka.size();
        String[] types = new String[size];
        String[] names = new String[size];
        for (int i=0; i<size; i++){
            types[i] = Ramka.get(i).getTyp();
            names[i] = Ramka.get(i).getNazwa();
        }
        DataFrame NowaRamka = new DataFrame(names,types);
        Object[] tmp = new Object[Ramka.size()];
        for (int i=a; i<=b; i++){
            for (int j=0; j<tmp.length; j++){
        
                tmp[j] = Ramka.get(j).list.get(i);
            }
            NowaRamka.add(tmp);

        }
        return NowaRamka;
    }
    
    public DataFrame iloc(int i){
        return iloc(i,i);
    }

    
    public void print(){
        for (int i=0; i<size(); i++){
            for (Kol col:Ramka){
                System.out.print(col.list.get(i)+" ");
            }
            System.out.println();
        }
    }

}