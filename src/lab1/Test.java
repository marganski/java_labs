package lab1;

public class Test {
    public static void main(String[] args) {
    	DataFrame df = new  DataFrame(new String[]{"kol1","kol2","kol3"},
                new String[]{"int","double","MyCustomType"});
    	df.size();
    	df.get("kol1");
    	df.get(new String[]{"kol2", "kol3"}, true);
    	df.add(new Object[]{1,2,3});
    	df.add(new Object[]{4.5,6.7,8.9});
    	df.add(new Object[]{"qwe","asd","zxc"});
    	df.iloc(0);
    	df.iloc(1,2);
    	df.print();
    	System.out.println(" ");
    	//df.addonposition(2, 99);
    	df.print();

    	
    }
}