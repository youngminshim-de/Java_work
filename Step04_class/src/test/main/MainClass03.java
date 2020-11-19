package test.main;

import java.io.PrintStream;

import test.mypac.MyUtil;

public class MainClass03 {

	public static void main(String[] args) {
		//static은 글꼴이 기울임체로 나타내어진다.
		MyUtil.playMusic();
		String name = MyUtil.owner;
		System.out.println();
	}

}
