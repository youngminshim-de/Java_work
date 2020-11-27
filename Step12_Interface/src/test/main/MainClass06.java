package test.main;

import test.mypac.Calculator;

public class MainClass06 {
	public static void main(String[] args) {
		Calculator add=(double a, double b)->{
			return a+b;
		};
		// 간략히
		Calculator sub=(a,b)->{return a-b;};
		// 더 간략히     수행할 코드가 한줄이면 {} 생략가능
		Calculator mul=(a,b)-> a*b;
		Calculator div=(a,b)->a/b;
		
		useCalculator(add);
		useCalculator(sub);
		useCalculator(mul);
		useCalculator(div);
		useCalculator((a,b)->a%b);
	}
	public static void useCalculator(Calculator cal) {
		double result =cal.exec(20, 10);
		System.out.println(result);
	}
}
