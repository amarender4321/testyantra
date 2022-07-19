package org.vtiger.practice;

import java.util.HashSet;
import java.util.Iterator;

public class IntetoerExampleUsingWhileLop {

	public static void main(String[] args) {
HashSet set = new HashSet<>();
set.add("Hi");
set.add("Amar");
set.add("Good Morning");
set.add("Have a great Day");
set.add("Bangolre");

Iterator<String>itr=set.iterator();
while(itr.hasNext()) {
	System.out.println(itr.next());
}
	}

}
