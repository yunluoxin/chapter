package com.dadong.test;

import java.util.ArrayList;

/**
 * Created by dadong on 2018/7/25.
 */
public class Interview {
	private Integer a ;
	public static void main(String args[]){
		System.out.println((3*0.1) == 0.3); // false -----

		System.out.println((1*0.3) == 0.3); // true

		System.out.println((0.1*3) == 0.3); // false -----

		System.out.println((0.3*1) == 0.3); // true

		System.out.println((0.2*2) == 0.4); // true

		System.out.println((2*0.2) == 0.4); // true

		System.out.println((0.5*1) == 0.5);
		System.out.println((1*0.5) == 0.5);
		System.out.println((5*0.1) == 0.5);
		System.out.println((0.1*5) == 0.5);

		System.out.println((3*0.2) == 0.6);
		System.out.println((3*0.3) == 0.9);
		ArrayList<Integer> list = new ArrayList<Integer>() ;
		list.add(3) ;
		list.add(4) ;
		list.add(5) ;
		list.add(6) ;
		int count = list.size() ;
		for (int i = count - 1 ; i >= 0; i-- ){
			if (i == 2){
				list.remove(list.get(i)) ;
			}
		}
		System.out.println(list);

		Interview interview = new Interview() ;
		interview.equals(new Interview()) ;


		String s1 = "Programming";
		String s2 = new String("Programming");
		String s3 = "Program" + "ming";
		System.out.println(s1 == s2);
		System.out.println(s1 == s3);
		System.out.println(s1 == s1.intern());

	}

//	@Override
//	public boolean equals(Object o) {
//		if (this == o) return true;
//		if (o == null || getClass() != o.getClass()) return false;
//
//		Interview interview = (Interview) o;
//
//		return a != null ? a.equals(interview.a) : interview.a == null;
//	}

	@Override
	public int hashCode() {
		return a != null ? a.hashCode() : 0;
	}
}
