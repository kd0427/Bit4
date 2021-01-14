package testPackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class TestClass {

	public static void main(String[] args) {
		System.out.println("Test Class");
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		int sum = 0;
		for(int i = 0; i < 100; i++) {
			sum += i;
			arr.add(sum);
		}
		
		System.out.println(arr.toString());
		
		Iterator<Integer> it = arr.iterator();
		while(it.hasNext()) {
			int n = it.next();
			System.out.print(n+"  ");
		}
		
		Collections.sort(arr, new CompareDesc());
		for(Integer i : arr) {
			i.toString();
		}
		
		ArrayList str = new ArrayList();
		str.add("ㅁㅁ");
		str.add(1);
		str.add("ㄴㄴ");
		str.add(0);
		
		System.out.println(str.toString());
	}
	class CompareDesc implements Comparator<number>{
		public int compare(Integer n, Integer n2) {
			return (n. < n2)? -1 : (n == n2)? 0 : 1;
		}
	}
	public class number{
		public void number() {
			int n = 1;
			int n2 = 2;
		}
	}

}
