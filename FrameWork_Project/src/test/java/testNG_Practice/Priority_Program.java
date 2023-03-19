package testNG_Practice;

import org.testng.annotations.Test;

public class Priority_Program {
	@Test(priority=-1)
	public void createuser() {
		System.out.println("create user successfully");
	}
	@Test(priority=-2)
	public void modifyuser() {
		System.out.println("user modified successfully");
	}
	@Test(priority=-3)
	public void deleteuser() {
		System.out.println("user delete successfully");
		
	}

}
