package cookieGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Equip {
	
	public static void itemUse(int inventoryIndex) {
		
		int itemIndex =Inventory.itemIndexList.get(inventoryIndex).getIndex();
		if(itemIndex<100) {
			Interface.message("사용이 불가능한 아이템입니다.");
			Interface.message3("");
		} else if(itemIndex<200) {
			if(Player.getWeaponCount()<3) {
				Player.setWeaponCount(Player.getWeaponCount()+1);
				equip(inventoryIndex);
			} else {
				Interface.message("더이상 장착이 불가능 합니다.");
				Interface.message3("");
			}
		} else if(itemIndex<300) {
			//드랍 방어구
			if(Player.getArmorCount()<3) {
				Player.setArmorCount(Player.getArmorCount()+1);
				equip(inventoryIndex);
			} else {
				Interface.message("더이상 장착이 불가능 합니다.");
				Interface.message3("");
			}
		} else if(itemIndex<400) {
			//드랍 소비
			use(inventoryIndex);
			
		} else if(itemIndex<500) {
			//드랍 재료
			Interface.message("더이상 장착이 불가능 합니다.");
			Interface.message3("");
		} else if(itemIndex<600) {
			//조합 무기
			if(Player.getWeaponCount()<3) {
				Player.setWeaponCount(Player.getWeaponCount()+1);
				equip(inventoryIndex);
			} else {
				Interface.message("더이상 장착이 불가능 합니다.");
				Interface.message3("");
			}
		} else if(itemIndex<700) {
			//조합 방어구
			if(Player.getArmorCount()<3) {
				Player.setArmorCount(Player.getArmorCount()+1);
				equip(inventoryIndex);
			} else {
				Interface.message("더이상 장착이 불가능 합니다.");
				Interface.message3("");
			}
		} else if(itemIndex<800) {
			//조합 소비
			use(inventoryIndex);
		} 
		
	}
	
	static List<Item> equipList= new ArrayList<>();
	//각 무기마다 명중을 제외한 스탯을 일정 수치이상요구, 요구스텟은 1~3개, 최소요구에 미치지못하면 무기데미지 33%패널티
	
	//Inventory에서 아이템번호를 가져옴
	public static void equip(int inventoryIndex) {
		
		//아이템 없으면 나가지게해야함
		//장찫개수제한만들어야댐 Player에 추가
		
		Item item = Inventory.itemIndexList.get(inventoryIndex);
		//static으로 다 바꾸기
		//Item에 메소드추가
		//단어 통일하기
		////////////////////////////////////////////////////////////////////////////////////
		Player.setAccuracy(Player.getAccuracy() + item.getAccuracy());
		Player.setDex(Player.getDex() + item.getDex());
		Player.setExp(Player.getExp() + item.getExp());	
		Player.setFullHp(Player.getFullHp() + item.getFullHp());
		Player.setFullStamina(Player.getFullStamina() + item.getFullStamina());	
		if(Player.getHp() + item.getHp()>Player.getFullHp()) {
			Player.setHp(Player.getFullHp());
		} else {
			Player.setHp(Player.getHp() + item.getHp());
		}		
		Player.setSpd(Player.getSpd() + item.getSpd());
		if(Player.getStamina() + item.getStamina()>Player.getFullStamina()) {
			Player.setStamina(Player.getFullStamina());
		} else {
			Player.setStamina(Player.getStamina() + item.getStamina());
		}
		Player.setStr(Player.getStr() + item.getStr());
		/////////////////////////////////////////////////////////////////////////////////
		
		equipList.add(item);
		Inventory.itemIndexList.remove(inventoryIndex);
		
		System.out.printf("||||=====     ITEM NAME :   %s 을 장착하였다.\n",item.getName());
		System.out.printf("||||          HP        : %5d          ||                      ||||\n",item.getFullHp());
		System.out.printf("||||          STA       : %5d          ||                      ||||\n",item.getFullStamina());
		System.out.printf("||||          DMG(STR)  : %5d          ||                      ||||\n",item.getStr());
		System.out.printf("||||          DEF       : %5d          ||                      ||||\n",item.getDef());
		System.out.printf("||||          DEX       : %5d          ||                      ||||\n",item.getDex());
		System.out.printf("||||          SPD       : %5d          ||                      ||||\n",item.getSpd());
		System.out.printf("||||          ACC       : %5d          ||                      ||||\n",item.getAccuracy());

		
	}
	
public static void use(int inventoryIndex) {
		
		//최대 능력치 안넘어가게 해야함
		
		Item item = Inventory.itemIndexList.get(inventoryIndex);
		//다 추가해야댐//////////////////////////////////////////////////////////////////////
		Player.setAccuracy(Player.getAccuracy() + item.getAccuracy());
		Player.setDex(Player.getDex() + item.getDex());
		Player.setExp(Player.getExp() + item.getExp());	
		Player.setFullHp(Player.getFullHp() + item.getFullHp());
		Player.setFullStamina(Player.getFullStamina() + item.getFullStamina());	
		if(Player.getHp() + item.getHp()>Player.getFullHp()) {
			Player.setHp(Player.getFullHp());
		} else {
			Player.setHp(Player.getHp() + item.getHp());
		}		
		Player.setSpd(Player.getSpd() + item.getSpd());
		if(Player.getStamina() + item.getStamina()>Player.getFullStamina()) {
			Player.setStamina(Player.getFullStamina());
		} else {
			Player.setStamina(Player.getStamina() + item.getStamina());
		}
		Player.setStr(Player.getStr() + item.getStr());
		//////////////////////////////////////////////////////////////////////////////////
		Inventory.itemIndexList.remove(inventoryIndex);
		
		Interface.message(item.getName()+" 사용.");
		Interface.message2("  HP    + "+item.getHp());
		Interface.message3("  STA   + "+item.getStamina());
		
	}
	
	public static void takeOff(int equipIndex) {
		if(Player.getArmorCount()+Player.getWeaponCount()<=0) {
			Interface.message("해제할 아이템이 없습니다.");
			Interface.amukey();
		} else {
			for(Item item : equipList) {
				System.out.println(equipList.indexOf(item)+" : "+item.getName());
			}
			Interface.message("벗을 장비를 선택하세요.");
			Interface.message3("");
			Scanner in = new Scanner(System.in);
			int a = in.nextInt();
			
			
			////////////////////////////////////////////////////////////////////////////////////
			Player.setAccuracy(Player.getAccuracy() - equipList.get(a).getAccuracy());
			Player.setDex(Player.getDex() - equipList.get(a).getDex());
			Player.setExp(Player.getExp() - equipList.get(a).getExp());	
			Player.setFullHp(Player.getFullHp() - equipList.get(a).getFullHp());
			Player.setFullStamina(Player.getFullStamina() - equipList.get(a).getFullStamina());	
			Player.setHp(Player.getHp() - equipList.get(a).getHp());	
			Player.setSpd(Player.getSpd() - equipList.get(a).getSpd());
			Player.setStamina(Player.getStamina() - equipList.get(a).getStamina());
			Player.setStr(Player.getStr() - equipList.get(a).getStr());
			/////////////////////////////////////////////////////////////////////////////////
			
			
	
			Inventory.itemIndexList.add(equipList.get(a));
			
			int index = equipList.get(a).getIndex();
			if(index<200) {
				//드랍 무기
				Player.setWeaponCount(Player.getWeaponCount()-1);
			} else if(index<300) {
				//드랍 방어구
				Player.setArmorCount(Player.getArmorCount()-1);
			} else if(index<600) {
				//조합 무기
				Player.setWeaponCount(Player.getWeaponCount()-1);
			} else if(index<700) {
				//조합 방어구
				Player.setArmorCount(Player.getArmorCount()-1);
			} 		
			
			Interface.message(equipList.get(a).getName()+"의 장착을 해제합니다." );
			
			equipList.remove(a);
			Interface.amukey();
		}
	}
}