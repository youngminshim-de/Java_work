package test.mart;


public class Computer {
	
	private Cpu cpu;
	private Memory memory;
	private HardDisk hardDisk;
	
	public Computer(Cpu cpu, Memory memory, HardDisk hardDisk) {
		this.cpu=cpu;
		this.memory=memory;
		this.hardDisk=hardDisk;
	}
	public void playGame() {
		System.out.println("게임을 해요!");
	}
	public void sendEmail(String addr) {
		System.out.println(addr+" 이라는 주소로 이메일을 보냈습니다.");
	}
}
