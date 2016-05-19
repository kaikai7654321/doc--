package com.lib.test;

public class StringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.print("kaka");
		String s = "123.txt";
		String []ss = s.split("\\.");
		System.out.println("the ss: "+ss[0]);
		for(int i = 0; i < ss.length; i++)
		{
			System.out.println("the ss: "+ss[i]);
		}
	}

}
