package lab1;

import java.util.ArrayList;

public class SparseDataFrame extends DataFrame {
	String hidelement;

private ArrayList<Kol> sdf = new ArrayList<Kol>();

public SparseDataFrame(String[] nazwy, String[] typy, String hide){
	super(nazwy, typy);
	hidelement = hide;
	}


public SparseDataFrame(Kol[] Kolumny){
	super(Kolumny);
	}
//size = df.size
//Kol get = df. Kol get
public void add(Object[] wartosci,int kolumna){
	//dodawanie obiektow z list do kolumny o wskazanym indeksie
	for(int i=0;i<wartosci.length;i++) {
		if(wartosci[i]!=hidelement) {
			COOValue tmp = new COOValue(i,wartosci[i]);
			sdf.get(kolumna).list.add(tmp);
		}
		sdf.get(kolumna).AnotherOneHidelement();
	}
    
	}
public DataFrame toDense(SparseDataFrame sparse) {
    Kol[] kolumny = new Kol[sdf.size()];
    int l =0;
	for(Kol kol:sdf) {
		int tmp=kol.getKolSize();
		Kol ktmp= new Kol(kol.getNazwa(),kol.getTyp());
		for(int i=0;i<kol.getDfsize()-tmp;i++) {
			ktmp.list.add(hidelement);
		for(int j=0;j<tmp;j++){
			ktmp.list.add(((COOValue) kol.list.get(j)).getIndex(),((COOValue) kol.get(j)).getWartosc());
			}
		
		}
		kolumny[l]=ktmp;
		l++;
	
	}
	DataFrame df = new DataFrame(kolumny);
	return df;
	
}

public SparseDataFrame(DataFrame dataf, String hide) {
	super(dataf);
	hidelement = hide;
	for(int i=0;i<dataf.df.size();i++){
		Kol ktmp= new Kol(dataf.get(i).getNazwa(),dataf.get(i).getTyp());
		for(int j=0;j<dataf.df.get(0).getKolSize();j++) {
			if(dataf.df.get(i).get(j)!=hide) {
				COOValue tmpc = new COOValue(j,dataf.df.get(i).get(j));
				ktmp.list.add(tmpc);
			}
		}
		
		sdf.add(ktmp);
	}
	
}




}




