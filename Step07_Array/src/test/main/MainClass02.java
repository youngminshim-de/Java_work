package test.main;

public class MainClass02 {

	public static void main(String[] args) {
		int[] nums= {10,20,30,40,50,60,70,80,90};
		for(int e:nums) {
			System.out.println(e);
		}
		
		String[] names= {"김구라","해골","원숭이","주뎅이","덩어리"};
		
		for(int i=0; i<names.length; i++) {
			String tmp=names[i];
			System.out.println(tmp);
		}
		//for-each 구문
		for(String str:names) {
			System.out.println(str);
		}

	}

}
