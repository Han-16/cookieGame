package cookieGame;

import java.util.Random;
import java.util.Scanner;


public class Battle {
	private int monsterCount;
	//RoomMaker에서 생성된 몬스터 가져오기
	int mon1,mon2,mon3;
	public static void battle(int floor, int roomNum) {
		if(floor%10==0 && floor!=GameData.floorNum-1) {
			bossBattle(floor,roomNum);
		}else if(floor==GameData.floorNum-1){
			lastBossBattle(floor,roomNum);
		} else {
			//몬스터 수 없으면 몬스터가 없습니다.

			//그 리스트에서 몬스터 가져오기
			Monster monA = new Monster(GameData.allFloor.get(floor).get(roomNum).get(1));
			Monster monB = new Monster(GameData.allFloor.get(floor).get(roomNum).get(2));
			Monster monC = new Monster(GameData.allFloor.get(floor).get(roomNum).get(3));
			if((monA.getIndex()+monB.getIndex()+monC.getIndex()) != 0) {
				firstTurn(monA,monB,monC);
				fight(monA,monB,monC);
			} else {
				Interface.message("몬스터가 없습니다.");
				Interface.amukey2();
			}
		}
	
	}
	public static void bossBattle(int floor, int roomNum) {
		//보스 페이지
		GameData.allFloor.get(Player.getCurFloor()).get(Player.getCurRoom()).set(1, 2);
		GameData.allFloor.get(Player.getCurFloor()).get(Player.getCurRoom()).set(2, 0);
		GameData.allFloor.get(Player.getCurFloor()).get(Player.getCurRoom()).set(3, 0);
		Monster monA = new Monster(20+floor/10);
		Monster monB = new Monster(21);
		Monster monC = new Monster(22);
		Monster monD = new Monster(23);
		Monster monE = new Monster(24);
		Monster monF = new Monster(0);
		if((monA.getIndex()+monB.getIndex()+monC.getIndex()) != 0) {
			Interface.message("<<중간 보스방 입장>>");
			Interface.amukey2();
			Interface.message(Player.getName()+"은(는) "+monA.getName()+"을(를) 향해 다가간다…  ");
			Interface.amukey2();
			firstTurn(monA,monF,monF);
			Interface.message("소문으로 들은 것과 같이 "+monA.getName()+"은(는) 다른 케이크 군단과는 다른 기운이 느껴진다… ");
			Interface.message2("이번 전투는 더 많은 힘이 필요할 것 같다…");
			Interface.amukey2();
			fight(monA,monF,monF);

		} else {
			Interface.message3("몬스터가 없습니다.");
		}
	}
	public static void lastBossBattle(int floor, int roomNum) {
		//보스 페이지
		
		GameData.allFloor.get(Player.getCurFloor()).get(Player.getCurRoom()).set(1, 2);
		GameData.allFloor.get(Player.getCurFloor()).get(Player.getCurRoom()).set(2, 2);
		GameData.allFloor.get(Player.getCurFloor()).get(Player.getCurRoom()).set(3, 0);
			Monster monA = new Monster(21);
			Monster monB = new Monster(22);
			Monster monC = new Monster(23);
			Monster monD = new Monster(24);
			Monster monE = new Monster(25);
			Monster monF = new Monster(0);
			if((monA.getIndex()+monB.getIndex()+monC.getIndex()) != 0) {
				Interface.message("<<보스방 입장>>");
				Interface.message2("<<적을 모두 처치못하지 못하면 어둠마녀쿠기가 되살려낸다!..>>");
				Scanner in = new Scanner(System.in);
				Interface.amukey2();
				
				Interface.message(""+Player.getName()+"은(는) 드디어 꼭대기층에 도달하게 되었다… ");
				Interface.message2("눈 앞에는 “어둠마녀 쿠키”의 방의 표시가 보였다… ");
				Interface.message2(Player.getName()+"은(는) 방의 손잡이를 향해 손을 뻗었다…");
				Interface.amukey2();
				firstTurn(monA,monB,monC);	
				Interface.message("'어둠마녀 쿠키'와 맞서려면 그 전에 케이크 군단을 물리쳐야 한다… ");
				Interface.message2("방 가운데로 케이크 군단이 다가왔다… ");
				Interface.message2(Player.getName()+"은(는) 먼저 케이크 군단과 전투를 시작한다… ");
				Interface.amukey2();
				fight(monA,monB,monF);

				
				GameData.allFloor.get(Player.getCurFloor()).get(Player.getCurRoom()).set(1, 2);
				Interface.message("<<케이크군단 처치>>");
				Interface.message3("<<어둠마녀 쿠키 등장>>");
				Interface.message("쿠키 왕국의 평화를 되찾으려면 이 전투를 꼭 이겨야 한다…");
				Interface.message2("왕국의 쿠키들과 탑 아래의 쿠키 일행으로부터 신비한 기운이 느껴졌다… ");
				Interface.message2(Player.getName()+"은(는) 숨을 크게 들이쉬며 “어둠마녀 쿠키”를 향해 다가간다…");
				Interface.amukey2();
				firstTurn(monA,monF,monF);
				
				fight(monC,monF,monF);
				
				
				
				Player.setVictory(1);
				
			
				Interface.message("'어둠마녀 쿠키'를 물리치고 마녀의 탑에서 내려온 "+Player.getName()+"과(와) 쿠키 일행은 ");
				Interface.message2("왕국의 백성들에게 환호를 받으며 왕국으로 돌아왔다… ");
				Interface.message2("왕국을 위해 평화를 되찾은 쿠키 일행은 왕국의 위대한 기사단으로 선사 받아 백성들을 지키며 살아가게 된다… ");
				Interface.message3( "하지만 쿠키 왕국의 평화는 오랫동안 지켜질 것인가...? TO BE CONTINUED…");

				Rule.win();
				
				
			} else {
				Interface.message3("몬스터가 없습니다.");
			}
		
		
	}
	
	
	//완
	public static void firstHit(Monster mon) {
		if (mon.getIndex()!=0) {
			if(Player.getSpd() < mon.getSpd()) {
				Player.setHp(Player.getHp()-mon.getStr());
				Interface.message2(mon.getName()+"의 공격 / 데미지 : "+mon.getStr()+" -> 플레이어 체력 : "+Player.getHp());
			}
		}
	}
	
	public static void firstTurn(Monster mon1, Monster mon2, Monster mon3) {
		Interface.message("SPD가 빠른 쿠키가 선제 공격을 합니다.");
		firstHit(mon1);
		firstHit(mon2);
		firstHit(mon3);
		Interface.message3("");
		Rule.die();
	}
	public static void monstatus(Monster mon,int num) {
		if (mon.getIndex() != 0) {
			Interface.message2("<<"+num+">> => :       " + mon.getName());
			Interface.message2("		HP : "+mon.getHp());
			Interface.message2("		STR: "+mon.getStr());
			Interface.message2("		DEF: "+mon.getDef());
			Interface.message2("		DEX: "+mon.getDex());

		}
	}
	
	public static void fight(Monster mon1, Monster mon2, Monster mon3) {
		//index가 0 인 몬스터는 무시
		
		while ((mon1.getIndex()+mon2.getIndex()+mon3.getIndex()) != 0) {
			Scanner in = new Scanner(System.in);
			

			Interface.message(" 몬스터를 확인하세요. ");
			monstatus(mon1, 1);
			monstatus(mon2, 2);
			monstatus(mon3, 3);
			
			Interface.ticBarStatus();
			

			Interface.message("행동을 선택하세요.");
			Interface.message2("> 1. 공격.");
			Interface.message3("> 2. 도망가기.");
			int a = in.nextInt();
			switch(a) {
				case 1 -> {
					attack(mon1,mon2,mon3);
					monsterAttack(mon1,mon2,mon3);
					//제거 win
					Rule.win();
					Rule.levelUp();
					
				}
				case 2 -> {
					Move.out(); 
					break;
				}
			}			
		}		
	}
	

	public static void attack(Monster mon1, Monster mon2, Monster mon3) {
		Interface.message("몬스터를 선택하세요.");
		monstatus(mon1, 1);
		monstatus(mon2, 2);
		monstatus(mon3, 3);
		Interface.message3("");
		
		
		while(GameData.allFloor.get(Player.getCurFloor()).get(Player.getCurRoom()).get(0)!=5) {
			Scanner in = new Scanner(System.in);
			int a = in.nextInt();
			if(a == 1 || a == 2 || a == 3) {
				switch(a) {
				case 1 -> {
					if(GameData.allFloor.get(Player.getCurFloor()).get(Player.getCurRoom()).get(1)!=0) {
						hitPosition(mon1);
						break;
					}	else {
						Interface.message(" ! 선택 오류. 다시 선택하세요. ! ");
						monstatus(mon1, 1);
						monstatus(mon2, 2);
						monstatus(mon3, 3);
						Interface.message3("");
						continue;
						
					}
				}
				case 2 -> {
					if(GameData.allFloor.get(Player.getCurFloor()).get(Player.getCurRoom()).get(2)!=0) {
						hitPosition(mon2);
						break;
					}	else {
						Interface.message(" ! 선택 오류. 다시 선택하세요. ! ");
						monstatus(mon1, 1);
						monstatus(mon2, 2);
						monstatus(mon3, 3);
						Interface.message3("");
						continue;
					}
				}
				case 3 -> {
					if(GameData.allFloor.get(Player.getCurFloor()).get(Player.getCurRoom()).get(3)!=0) {
						hitPosition(mon3);
						break;
					}	else {
						Interface.message(" ! 선택 오류. 다시 선택하세요. ! ");
						monstatus(mon1, 1);
						monstatus(mon2, 2);
						monstatus(mon3, 3);
						Interface.message3("");
						continue;
					}
				}
			}
		
			
			killMonster(mon1);
			killMonster(mon2);
			killMonster(mon3);
			break;
			} else {
				Interface.message(" ! 선택 오류. 다시 선택하세요. ! ");
				monstatus(mon1, 1);
				monstatus(mon2, 2);
				monstatus(mon3, 3);
				Interface.message3("");
			}
		}
		
			
			
	}
	public static void killMonster(Monster mon) {
		if (mon.getHp() < 1 && mon.getIndex() != 0) { 
			Player.setExp(Player.getExp() + mon.getExp());
			mon.setIndex(0);
			GameData.allFloor.get(Player.getCurFloor()).get(Player.getCurRoom()).set(1, 0);
			Interface.message(mon.getName() + "를 처치하여 경험치 " + mon.getExp() + "을(를) 얻었습니다.");
			Interface.amukey2();
		}
	}
	
	public static void monsterHit(Monster mon) {
//		int hitP = (int)(mon.getAccuracy()+2648);
		int hitP = (int)((Math.random()*100))+(mon.getAccuracy()-Player.getDex());
//		int hitPower = mon.getStr()*2648;
		int hitPower = mon.getStr()-(Player.getDef())/10;
		if(hitP>50){
			if (mon.getIndex() != 0) {
				
				Interface.message(mon.getName() + " 의 공격 -> "+hitPower+"의 데미지");
				Player.setHp(Player.getHp() - hitPower);
				Interface.message2("플레이어의 현재 체력 : " + Player.getHp());
				Interface.amukey2();
			}
		} else {
			if (mon.getIndex() != 0) {
				Interface.message(mon.getName() + " 의 공격 -> 공격이 빗나갔습니다.");
				Interface.amukey2();
				
			}			
		}
		
	}
	
	public static void monsterAttack(Monster mon1, Monster mon2, Monster mon3) {
		monsterHit(mon1);
		monsterHit(mon2);
		monsterHit(mon3);
		Rule.die();
		//index가 0 인 몬스터는 무시
		
		//맞기//몬스터 수만큼
		//몬스터의 가격부위 설정(가격부위 확률 데미지)
	}
	public static void 	hit(Monster mon,double d) {
//		int dmg = (int)((Player.getStr())*d+8163);
		int dmg = (int)((Player.getStr()-(mon.getDef())/10)*d);
		mon.setHp(mon.getHp()-dmg);
		Interface.message(mon.getName() + "를 공격하여" + dmg + "의 데미지를 주었습니다.");
		if(mon.getHp()>0) {
			Interface.message2(mon.getName() + "의 현재 체력 : " + mon.getHp());
		}
		Interface.amukey2();
		
	}
	
	public static void hitPosition(Monster mon) {
		Scanner in = new Scanner(System.in);
		if(mon.getIndex()%2 != 0) {
			//머리 몸통 다리
			
			while(true) {
				Interface.message(mon.getName()+" 공격위치를 정하세요 <추가퍼센트("+(Player.getAccuracy()-mon.getDex())+")>");
				Interface.message2("> 1. 머리(10% 확률 데미지 X 2.5)");
				Interface.message2("> 2. 몸통(30% 확률, 데미지 X 2)");
				Interface.message3("> 3. 하체(70% 확률)");
				
				int a = in.nextInt();
				if (a == 1 || a == 2 || a==3) {
					switch(a) {
					case 1 -> {
						
						int p = (int)((Math.random())*(100))+(Player.getAccuracy()-mon.getDex());
						if(p>80) {
							hit(mon,2.5);
						} else {
							Interface.message(Player.getName()+" 의 공격이 빗나갔다.");
						}
					}
					case 2 -> {
						int p = (int)((Math.random())*(100))+(Player.getAccuracy()-mon.getDex());
						if(p>60) {
							hit(mon,2);
						} else {
							Interface.message(Player.getName()+" 의 공격이 빗나갔다.");
						}
					}
					case 3 -> {
						int p = (int)((Math.random())*(100))+(Player.getAccuracy()-mon.getDex());
						if(p>20) {
							hit(mon,1);
						} else {
							Interface.message(Player.getName()+" 의 공격이 빗나갔다.");
						}
					}
				}
					break;
				} else {
					Interface.message(" ! 선택 오류. 다시 선택하세요. ! ");
				}
				
			}
			
				
		} else {
			while(true) {
			//머리 몸통
			Interface.message(mon.getName()+" 공격위치를 정하세요 <추가퍼센트("+(Player.getAccuracy()-mon.getDex())+")>");
			Interface.message2("> 1. 머리(30% 확률, 데미지 X 2)");
			Interface.message3("> 2. 몸통(70% 확률)");
			int a = in.nextInt();
			if (a == 1 || a == 2) {
				switch(a) {
					case 1 -> {
						int p = (int)((Math.random())*(100))+(Player.getAccuracy()-mon.getDex());
						if(p>60) {
							hit(mon,2);
						} else {
							Interface.message(Player.getName()+" 의 공격 실패");
						}

					}
					case 2 -> {
						int p = (int)((Math.random())*(100))+(Player.getAccuracy()-mon.getDex());
						if(p>20) {
							hit(mon,1);
						} else {
							Interface.message(Player.getName()+" 의 공격 실패");
							
						}
					}
				}
				break;
			} else {
				Interface.message(" ! 선택 오류. 다시 선택하세요. ! ");
			}
		}
	}	
	}

	
}