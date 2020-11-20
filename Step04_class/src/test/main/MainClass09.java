package test.main;

import test.mart.*;

public class MainClass09 {

	public static void main(String[] args) {
		/*
		 *  [ 프로그래밍의 목적]
		 *  
		 * 	1. 게임을 한다.
		 *  2. oli999@naver.com 으로 이메일을 보낸다.
		 *  
		 */
		
		Cpu cpu = new Cpu();
		Memory memory = new Memory();
		HardDisk hardDisk = new HardDisk();
		String email = "oli999@naver.com";
		
		Computer computer = new Computer(cpu, memory, hardDisk);
		computer.playGame();
		computer.sendEmail("email");

	}

}
