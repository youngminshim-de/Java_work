package test.main;

import test.mypac.MyUtil;
import test.mypac.MyUtil.User;

public class MainClass02 {
	public static void main(String[] args) {
		MyUtil mu1=new MyUtil();
		User u1=mu1.new User();
		u1.doSomething();
	}
}
