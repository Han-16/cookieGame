package cookieGame;

import java.util.ArrayList;
import java.util.List;

public class Player {

	//장착개수필드 추가
	private static int victory;
	private static int weaponCount;
	private static int armorCount;
	
	//층이내려갈수록 적들의 회피율 상승-이를 명중률로상쇄, 최대 95
	private static int turnCount = 0;
	private static int highFloor = 0;
	private static int level = 0;
	private static int curFloor = 0;
	private static int curRoom = 0;
	private static String Name;
	private static int FullHp;
	private static int Hp;
	private static int FullStamina;
	private static int Stamina;
	private static int FullExp;
	private static int Exp;
	//치명타확률 공격력
	private static int Str;
	//추가공격확률 공격력
	private static int Spd;
	//회피율 공격력
	private static int Dex;
	//명중률 스탯 1 당 2%의 명중률
	private static int Accuracy;
	//방어
	private static int Def;
	

	public void Player(Ablility ablility) {
		this.Name =  ablility.Name;
		this.FullHp = ablility.FullHp;
		this.Hp = ablility.Hp;
		this.FullStamina = ablility.FullStamina;
		this.Stamina = ablility.Stamina;
		this.FullExp = ablility.FullExp;
		this.Exp = ablility.Exp;
		this.Str = ablility.Str;
		this.Spd = ablility.Spd;
		this.Dex = ablility.Dex;
		this.Accuracy = ablility.Accuracy;
		this.Def = ablility.Def;
	}
	

	//get
	public static int getHightFloor() {
		return highFloor;
	}
	public static int getLevel() {
		return level;
	}
	public static String getName() {
		return Name;
	}
	public static int getFullHp() {
		return FullHp;
	}
	public static int getHp() {
		return Hp;
	}
	public static int getFullStamina() {
		return FullStamina;
	}
	public static int getStamina() {
		return Stamina;
	}
	public static int getFullExp() {
		return FullExp;
	}
	public static int getExp() {
		return Exp;
	}
	public static int getStr() {
		return Str;
	}
	public static int getSpd() {
		return Spd;
	}
	public static int getDex() {
		return Dex;
	}
	public static int getDef() {
		return Def;
	}
	public static int getAccuracy() {
		return Accuracy;
	}
	public static int getCurFloor() {
		return curFloor;
	}
	public static int getCurRoom() {
		return curRoom;
	}
	public static int getWeaponCount() {
		return weaponCount;
	}
	public static int getArmorCount() {
		return armorCount;
	}
	
	//set
	public static void setHightFloor(int floor) {
		highFloor =  floor;
	}
	public static void setLevel(int lev) {
		level = lev;
	}
	public static void setName(String name) {
		Name = name;
	}
	public static void setFullHp(int fullHp) {
		FullHp = fullHp;
	}
	public static void setHp(int hp) {
		Hp = hp;
	}
	public static void setFullStamina(int fullstamina) {
		FullStamina = fullstamina;
	}
	public static void setStamina(int stamina) {
		Stamina = stamina;
	}
	public static void setFullExp(int fullexp) {
		FullExp = fullexp;
	}
	public static void setExp(int exp) {
		Exp = exp;
	}
	public static void setStr(int str) {
		Str = str;
	}
	public static void setSpd(int spd) {
		Spd = spd;
	}
	public static void setDex(int dex) {
		Dex = dex;
	}
	public static void setAccuracy(int accuracy) {
		Accuracy = accuracy;
	}
	public static void setCurFloor(int floor) {
		curFloor = floor;
	}
	public static void setCurRoom(int roomNum) {
		curRoom = roomNum;
	}
	public static void setWeaponCount(int weaponcount) {
		weaponCount = weaponcount;
	}
	public static void setArmorCount(int armorcount) {
		armorCount = armorcount;
	}

	public static void setDef(int def) {
		Def = def;
	}

	public static void setVictory(int i) {
		 victory = i;
		
	}
	public static int getVictory() {
		 return victory;
		
	}
}