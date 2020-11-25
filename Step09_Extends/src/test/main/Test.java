package test.main;

class Box{
	public void simPleWrap() {System.out.println("Simple Wrap");}
	public void wrap() {simPleWrap();}
}
class PaperBox extends Box{
	public void paperWrap() {System.out.println("Paper Wrap");}
	public void wrap() {paperWrap();}
}
class GoldPaperBox extends Box{
	public void goldPaperWrap() {System.out.println("GoldPaper Wrap");}
	public void wrap() {goldPaperWrap();}
}

public class Test {
	public static void wrapBox(Box box) {
//		if(box instanceof PaperBox) {
//			((PaperBox) box).paperWrap();
//		}
//		else if(box instanceof GoldPaperBox) {
//			((GoldPaperBox)box).goldPaperWrap();
//		}
//		else
//			box.simPleWrap();
		box.wrap();
	}

	public static void main(String[] args) {
	Box box1=new Box();
	PaperBox box2=new PaperBox();
	GoldPaperBox box3=new GoldPaperBox();
	
	wrapBox(box1);
	wrapBox(box2);
	wrapBox(box3);
	}

}
