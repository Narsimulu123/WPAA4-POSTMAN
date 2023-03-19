package testNG_Practice;

import org.testng.annotations.Test;

public class Dependency_On_Groups {
	@Test(groups="smoke")
	public void test1() {
		System.out.println("smoke");
		
	}
	@Test(groups="smoke")
	public void test2() {
		System.out.println("smoke");
	}
	
@Test(groups="smoke")
public void test3() {
	System.out.println("smoke");
}

	

@Test(groups="Sanity")
public void test4() {
	System.out.println("Sanity");
}
@Test(groups="Sanity")
public void test5() {
	System.out.println("sanity");
}
@Test(groups="Regression") 
public void test6() {
	System.out.println("Regression");
}
@Test(groups="Regression")
public void test7() {
	System.out.println("Regression");
}
@Test(dependsOnGroups={"smoke","Sanity","Regression"})
public void test0() {
System.out.println("Main test");

}}