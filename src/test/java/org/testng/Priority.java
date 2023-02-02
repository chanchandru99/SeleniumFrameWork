package org.testng;

import org.testng.annotations.Test;

public class Priority {
	@Test (priority = 0)
	private void test1() {
		System.out.println(1);
	}
	@Test(priority = 2)
	private void test2() {
		System.out.println(2);
	}
	@Test(priority = 4)
	private void test3() {
		System.out.println(3);
	}
	@Test(priority = 5)
	private void test4() {
		System.out.println(4);
		}
	@Test(priority = 3)
	private void test5() {
		System.out.println(5);
	}
	@Test(priority = 1)
	private void test6() {
		System.out.println(6);
	}
	

}
