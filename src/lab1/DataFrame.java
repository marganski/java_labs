package lab1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;


public class DataFrame {
    protected ArrayList<Kol> df = new ArrayList<Kol>();

    public DataFrame(String[] Nazwy, String[] Typy){
        for (int i=0; i<Nazwy.length; i++)
        {
            df.add(new Kol(Nazwy[i],Typy[i]));
        }
    }
    public DataFrame(String plik,String[] Typy,boolean header) throws Exception{
    	FileInputStream fstream = new FileInputStream(plik);
    	BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
    	String strLine;
    	
    	if(header==true) {
    		String pierwszaLinia = br.readLine();
    		String[] nazwy = pierwszaLinia.split(",");
    		for (int i=0; i<nazwy.length; i++)
            {
                df.add(new Kol(nazwy[i],Typy[i]));
            }    		
    	}
    	while ((strLine = br.readLine()) != null)   {
    		String[] tmp = strLine.split(",");
    		Object[] tmpo = new Object[tmp.length];
    		for(int i=0;i<tmp.length;i++) {
    			tmpo[i]=tmp[i];
    		}
    		this.add(tmpo);
    	}
    	
    	br.close();
	  
    }
    
    public DataFrame(Kol[] Kolumny){
        for (int i=0; i<Kolumny.length; i++) {
            df.add(Kolumny[i]);
        }
    }
    public DataFrame(DataFrame dataf) {
    	//bez tego df to sparse nie dzia³a
    }
    
    public int size(){
        return this.df.get(0).getKolSize();
    }
   

     public  Kol get(String colname){
        for (Kol col:df){
            if (col.getNazwa()==colname){
            	return col;
            }
        }
        throw new RuntimeException("Kol not found!");
        
    }
    public Kol get(int i) {
    	return df.get(i);
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

    public void add(Object[] wartosci){
        int i = 0;
        for (Kol col:df){
            col.list.add(wartosci[i++]);
        }
    }
    public void add(Object[] wartosci,int kolumna){
    	//dodawanie obiektow z list do kolumny o wskazanym indeksie
    	for(int i=0;i<wartosci.length;i++) {
    			df.get(kolumna).list.add(wartosci[i]);
    		}
    		
    	}
        
    public DataFrame iloc(int a, int b){
        
        int size = df.size();
        String[] types = new String[size];
        String[] names = new String[size];
        for (int i=0; i<size; i++){
            types[i] = df.get(i).getTyp();
            names[i] = df.get(i).getNazwa();
        }
        DataFrame Nowadf = new DataFrame(names,types);
        Object[] tmp = new Object[df.size()];
        for (int i=a; i<=b; i++){
            for (int j=0; j<tmp.length; j++){
        
                tmp[j] = df.get(j).list.get(i);
            }
            Nowadf.add(tmp);

        }
        return Nowadf;
    }
    
    public DataFrame iloc(int i){
        return iloc(i,i);
    }

    
    public void print(){
        for (int i=0; i<size(); i++){
            for (Kol col:df){
                System.out.print(col.list.get(i)+" ");
            }
            System.out.println();
        }
    }

}