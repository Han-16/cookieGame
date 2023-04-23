package cookieGame;

import java.util.Scanner;

public class Object {
	
	public String Name;
	public int Index;
	public int Hp;
	public int FullExp;
	public int Exp;
	public int Str;
	public int Spd;
	public int Dex;
	public int Accuracy;
	public int Def;
	public int Category;
	public int FullHp;
	public int FullStamina;
	public int Crt;
	public int Wide;
	public int Stamina;
	public int Dmg;
	public int Dur;
	
	

	public static void getInfo(Object o) {
		if(o instanceof Item) {
			System.out.printf("||||               ITEM NAME    %s\n",o.getName());
			System.out.printf("||||            IND       :      %5d                           ||||\n",o.getIndex());
			System.out.printf("||||            HP        :      %5d                           ||||\n",o.getHp());
			System.out.printf("||||            EXP       :      %5d                           ||||\n",o.getExp());
			System.out.printf("||||            DMG(STR)  :      %5d                           ||||\n",o.getStr());
			System.out.printf("||||            DEF       :      %5d                           ||||\n",o.getDef());
		} else {
			System.out.printf("||||               MONSTER NAME    %s\n",o.getName());
			System.out.printf("||||            IND       :      %5d                           ||||\n",o.getIndex());
			System.out.printf("||||            HP        :      %5d                           ||||\n",o.getHp());
			System.out.printf("||||            SPD       :      %5d                           ||||\n",o.getSpd());
			System.out.printf("||||            DEX       :      %5d                           ||||\n",o.getDex());
			System.out.printf("||||            DMG(STR)  :      %5d                           ||||\n",o.getStr());
			System.out.printf("||||            DEF       :      %5d                           ||||\n",o.getDef());
		}
	}
	
	public static void viewList(Object o) {
		if(o instanceof Item) {
			for(int i = 0; i<GameData.ITEMLIST.length; i ++) {
				Item item = new Item(GameData.ITEMLIST[i][0]);
				Interface.message2(" (  INDEX :"+item.getIndex()+" )   "+item.getName() );
			}
		} else {
			for(int i = 0; i<GameData.ITEMLIST.length; i ++) {
				Item item = new Item(GameData.ITEMLIST[i][0]);
				Interface.message2(" (  INDEX :"+item.getIndex()+" )   "+item.getName() );
			}
		}

	}
	

	
	public String getName() {
		return Name;
	}
	public int geIndex() {
		return this.Index;
	}
	public int getHp() {
		return this.Hp;
	}

	public int getAccuracy() {
		// TODO Auto-generated method stub
		return this.Accuracy;
	}

	public int getDex() {
		// TODO Auto-generated method stub
		return this.Dex;
	}

	public int getExp() {
		// TODO Auto-generated method stub
		return this.Exp;
	}

	public int getFullHp() {
		// TODO Auto-generated method stub
		return this.FullHp;
	}

	public int getFullStamina() {
		// TODO Auto-generated method stub
		return this.FullStamina;
	}

	public int getSpd() {
		// TODO Auto-generated method stub
		return this.Spd;
	}

	public int getStamina() {
		// TODO Auto-generated method stub
		return this.Stamina;
	}

	public int getStr() {
		// TODO Auto-generated method stub
		return this.Str;
	}

	public int getDef() {
		// TODO Auto-generated method stub
		return this.Def;
	}

	public int getIndex() {
		// TODO Auto-generated method stub
		return this.Index;
	}
	public int getFullExp() {
		return this.FullExp;
	}
	
	///////////////////////////////////////////////
	

	public void setIndex(int index) {
		this.Index = index;
	}
	public void setHp(int hp) {
		this.Hp=hp;
	}
	public void setExp(int exp) {
		this.Exp=exp;
	}
	public void setStr(int str) {
		this.Str=str;
	}
	public void setSpd(int spd) {
		this.Spd=spd;
	}
	public void setDex(int dex) {
		this.Dex=dex;
	}
	public void setAccuracy(int acc) {
		this.Accuracy=acc;
	}
	public void setFullHp(int fullHp) {
		FullHp = fullHp;
	}
	public void setFullStamina(int fullstamina) {
		FullStamina = fullstamina;
	}
	public void setStamina(int stamina) {
		Stamina = stamina;
	}
	public void setFullExp(int fullexp) {
		FullExp = fullexp;
	}
	
	
}
