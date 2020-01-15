package card;

public class Poker {
	private String color;
	private String num;
	private String info;
	
	public String getInfo() {
		return this.info;
	}
	
	public void setInfo(String info) {
		this.info = info;
	}
	
	public Poker(String color, String num) {
		this.color = color;
		this.num = num;
	}
	
	public Poker(String color, String num, String info) {
		this.color = color;
		this.num = num;
		this.info = info;
	}
	
	
	public String toString() {
		return String.valueOf(this.color) + " " + this.num;
	}
	
	public String getColor() {
		return this.color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getNum() {
		return this.num;
	}
	
	public void setNum(String num) {
		this.num = num;
	}
}
