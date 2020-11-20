package test.main;

import test.war.*;
public class MainClass08 {

	public static void main(String[] args) {
		/*
		 *  [ 프로그래밍의 목적] 
		 *  
		 *  1. 사령부에서 전쟁을 선언하고
		 *  2. 마린을 이동시킨다.
		 *  3. 마린을 공격시킨다.
		 *  4. 사령부에서 전쟁을 종결시킨다.
		 *  
		 */
		
		Marine marine1 = new Marine();
		Pentagon.startWar();
		marine1.move();
		marine1.attack();
		Pentagon.endWar();

	}

}
