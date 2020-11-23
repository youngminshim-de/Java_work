package test.main;

public class MainClass01 {
	/*
	 *  1. 배열을 어떻게 만드는지?
	 *  2. 배열의 데이터 type은 어떻게 선언하는지?
	 *  3. nums, nums2, truth, names 에 저장된값은 참조값인지? 아닌지?
	 *     (배열이 참조 데이터 type인지? 기본 데이터 type인지?)
	 *     -> 배열은 참조데이터 type, 그안에 data들은 data type에 따라 참조인지 기본인지 나뉨
	 *     ex) String[] names -> 배열 참조데이터 type, 각 각의 원소들도 참조데이터 type
	 */

	public static void main(String[] args) {
		int[] nums= {10,20,30,40,50};
		int[] nums2=new int[] {10,20,30,40,50};
		
		double[] nums3= {10.1, 10.2, 10.3, 10.4, 10.5};
		
		boolean[] truth= {true, false, false};
		
		String[] names= {"김구라", "해골", "원숭이"};
		
		Integer[] nums4= {10,20,30,40,50};
		
		int num1=nums[0]; // 10
		int num2=nums[1]; // 20
		int num3=nums[2]; // 30 각 각 value가 들어간다.
		
		String name1=names[0]; // 참조값이 들어간다. String type이므로
		String name2=names[1];
		String name3=names[2];
		
		int a=nums.length;
		int sum=0;
		for(int num:nums) {
			sum+=num;
		}
		System.out.println(sum);
	}

}
