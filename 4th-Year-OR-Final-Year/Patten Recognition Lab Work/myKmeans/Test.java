package myKmeans;

import java.util.ArrayList;
import java.util.List;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<String>> listOfLists = new ArrayList<List<String>>(3);
		for(int i = 0; i < 3; i++)  {
	        listOfLists.add(new ArrayList<String>());
	        //listOfLists.get(0).add("foobar");
	    }
		/*listOfLists.get(0).add("asadasd");
		listOfLists.get(0).add("sdddasdasd");
		listOfLists.add(new ArrayList<String>());
		listOfLists.get(0).add("asad");
		listOfLists.get(1).add("asad");
		listOfLists.get(2).add("asad");
		System.out.println(listOfLists.get(2));*/
		
		List<String>list =new ArrayList<String>(3);
		list.add("adsas");
		list.add("adsas2");
		list.add("adsas3");
		list.add("adsas4");
		//System.out.println(list.get(0));
		List<List<String>> listOfLists2 = new ArrayList<List<String>>(3);
		for(int i = 0; i < 3; i++)  {
	        listOfLists2.add(new ArrayList<String>());
	    }
		listOfLists2.get(0).add("dsn");
		listOfLists2.get(0).add("dsn2");
		listOfLists2.get(0).add("dsn3");	
		listOfLists2.get(1).add("dsn");
		listOfLists2.get(1).add("dsn2");
		listOfLists2.get(1).add("dsn3");
		listOfLists2.get(2).add("dsn");
		listOfLists2.get(2).add("dsn2");
		listOfLists2.get(2).add("dsn3");
		System.out.println(listOfLists2.get(0).get(0));
	}

}
