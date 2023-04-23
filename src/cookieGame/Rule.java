package cookieGame;

import java.util.Scanner;

public class Rule {
	
	public static void loseStamina(int value) {
		
		
		if (Player.getStamina()>value) {
			Player.setStamina(Player.getStamina()-value);
			Interface.message2("스테미나 "+value+" 을(를) 사용했습니다. / 현재 스테미나 : "+Player.getStamina());

		} else {
			Player.setStamina(0);
			Player.setHp(Player.getHp()-2*(value-Player.getStamina()));
			Interface.message2("체력 "+value+" 을(를) 사용했습니다. / 현재 체력 : "+Player.getHp());

		}
	}

	public static void levelUp() {
		if(Player.getFullExp() <= Player.getExp()) {
			Player.setExp(Player.getExp()-Player.getFullExp());
			Player.setLevel(Player.getLevel()+1);
			Interface.message("   !!!LEVEL UP!!!  ");
			Interface.message3("level : + "+Player.getLevel()+" 을(를) 달성했습니다.");
			//수정
			
			for(int i = 0; i<4; i++) {
				while (true) {
					Interface.message("포인트를 추가할 항목을 선택하세요. point : "+(4-i)+" / (포인트당 3 씩 증가)");
					Interface.message2("> 1. HP  : "+Player.getFullHp());
					Interface.message2("> 2. STR : "+Player.getStr());
					Interface.message2("> 3. DEF : "+Player.getDef());
					Interface.message2("> 4. DEX : "+Player.getDex());
					Interface.message2("> 5. SPD : "+Player.getSpd());
					Interface.message3("> 6. ACC : "+Player.getAccuracy());
					Scanner in = new Scanner(System.in);
					int point = in.nextInt();
					if (point == 1 || point == 2 || point ==3 || point==4||point==5||point==6) {
						switch(point) {
						case 1 -> Player.setFullHp(Player.getFullHp()+3);
						case 2 -> Player.setStr(Player.getStr()+3);
						case 3 -> Player.setDef(Player.getDef()+3);
						case 4 -> Player.setDex(Player.getDex()+3);
						case 5 -> Player.setSpd(Player.getSpd()+3);
						case 6 -> Player.setAccuracy(Player.getAccuracy()+3);
						}
						break;	
					} else {
						Interface.message(" ! 선택 오류. 다시 선택하세요. ! ");
						continue;
					}
				}	
			}
			
			Player.setFullExp(Player.getFullExp()+5); 
		}
	}
	public static void die() {
		if(Player.getHp()<=0) {
			Interface.message("체력이 부족한 "+Player.getName()+"은(는) 그 자리에서 쓰러졌다… ");
			Interface.message2("다른 쿠키 일행에게 도움을 요청하려 소리를 외쳤지만 소리는 나오지 않았다… ");
			Interface.message3("더 이상 움직일 수 없는 "+Player.getName()+"은 눈이 스르륵 감긴다…");
			System.out.println("\t         [          재도전 하시겠습니까?          ]");
			System.out.println("\t                      > 1. 종료.");
			System.out.println("\t                      > 2. 재도전.");
			Scanner a = new Scanner(System.in);
			
			while(true) {
				int b = a.nextInt();
				if(b == 1 || b ==2) {
					switch(b) {
						case 1 ->Interface.gameEnd();
						case 2 ->{
							GameData gamedata = new GameData();
							gamedata.teleportPositionMaker();
							gamedata.RoomMaker();
							Player.setCurFloor(0);
							Interface.gameStart();
						}
					}
				}
				
				continue;
				
			}
			
			
		}
	}
	
	public static void win() {
		if(Player.getVictory() == 1) {
			Interface.gameEnd();
			Scanner a = new Scanner(System.in);
			a.next();
		}
	}
	
}
