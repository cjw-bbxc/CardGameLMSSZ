package card;

import java.util.LinkedList;
import java.util.Random;

public class Shuffle
{
	LinkedList<Poker> pokers;
	int Plength;
	
	public LinkedList<Poker> createPoker() {
		pokers = new LinkedList<>();
		String[] colors = { "梅花", "方块", "黑桃", "红桃" };
		String[] nums = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
		String[] info = {
			
			"<html>指定任何一个人喝</html>", 
			"<html>小姐牌(谁被罚喝都得陪着一起喝,直到下一个抽到2的人为止)</html>", 
			"<html>逛三园(星期天,逛三园,什么园？植物园/动物园/水果园或其他,接下去的人就开始说园内的东西,说不出来者,重复者,反应慢者都要被罚酒!)</html>", 
			"<html>找人划拳</html>", 
			"<html>照相机(说照相机时<br/>任何人不准动,谁动谁喝酒)</html>", 
			"<html>几棵柳树扭几扭</html>", 
			"<html>七和七的倍数</html>", 
			"<html>厕所牌</html>", 
			"<html>见9喝酒</html>", 
			"<html>“我是神经病”</html>", 
			"<html>左J右Q,左边人喝酒</html>", 
			"<html>左J右Q,右边人喝酒</html>", 
			"<html>第一个喝半杯,指定下一个喝几杯</html>"
			};
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < colors.length; j++) {
				pokers.add(new Poker(colors[j], nums[i], info[i]));
			}
		} 
		Plength = pokers.size();
		System.out.println(Plength);
		return pokers;
	}
	
	public int getPlength() {
	return Plength;
	}

	public void ruffleCard() {
		Random random = new Random();
		for (int i = 0; i < 100; i++) {
			int a = random.nextInt(Plength);
			int b = random.nextInt(Plength);
			Poker p1 = pokers.get(a);
			Poker p2 = pokers.get(b);
			pokers.set(a, p2);
			pokers.set(b, p1);
		} 
	}
	
	public Poker getPoker(int index) {
	return pokers.get(index);
	}
	
	public void display() {
	for (int i = 0; i < pokers.size(); i++) {
		System.out.print((new StringBuilder()).append(pokers.get(i)).append("  ").toString());
		if (i % 4 == 1) {
		System.out.println();
		}
	} 
	System.out.println();
	}
}
