package test.mypac;
/*
 *  아래와 같이 설계된 클래스를 Dto(Data Transfer Object) 라고 한다.
 *  
 *  [ 만드는 방법 ]
 *  1. 필드의 접근 지정자는 private 으로 지정
 *  2. 기본생성자와, 필드의 모든값을 전달받는 생성자 2개가 있어야 한다.
 *  3. 필드의 접근 메소드 setter, getter 메소드가 형식에 맞게 정의 되어 있어야 한다.
 *     (마우스 우클릭 -> source -> Generate Getters and Setters)
 *     
 *  DB에서 select 된 것을 dto에 많이 담는다.
 *  ex_ select num, name, addr from member where num=1; <-- 이걸 dto instance에 담는다.
 */

public class MemberDto {

	private int num;
	private String name;
	private String addr;
	
	//객체를 new 생성자() 로 생성한다. (Constructor)
	// return type 이 없으며 만들지 않아도 default로 생성된다.
	// 하지만 생성자를 만들었을 경우 default는 사라지게 되며 따라서 정의해줘야한다.
	// 클래스명과 동일하게 만들어야 한다. 메소드가 아니다.
	public MemberDto() {}
	
	public MemberDto(int num, String name, String addr) {
		this.num=num;
		this.name=name;
		this.addr=addr;
	}
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	
}
