package cookieGame;

import java.util.Scanner;

public class Interface {
	
	public static void message(String msg) {
		System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		System.out.printf("||||    message    :    %-40s\n",msg);
//		System.out.println("||||");		
	}
	public static void message2(String msg) {
		
		System.out.printf("||||               :    %-40s\n",msg);
//		System.out.println("||||");
	}
	public static void message2(int msg) {
		
		System.out.printf("||||               :    %-40s\n",msg);
//		System.out.println("||||");
	}
	public static void message3(String msg) {
		System.out.printf("||||               :    %-40s\n",msg);
//		System.out.println("||||");	
		System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
	}
	
	public static void gameStart() {
		Scanner in = new Scanner(System.in);
		System.out.println("\t         [          게임을 시작합니다.          ]");
		System.out.println();
		System.out.println("머나먼 옛날... 마녀의 오븐에서 탈출한 쿠키 일행은 근처 쿠키 왕국에 정착하여 편안한 삶을 지내고 있었다… ");
		System.out.println("하지만 평화도 잠시, 그동안 복수를 하기위해 갈고 닦은 “어둠마녀 쿠키”가 나타나 쿠키 왕국을 휩쓸었다... ");
		
		System.out.println("확인(아무키나 누르세요)");
		if(in.next() != "~!@#$%%^^&&*()_") {
		}
		System.out.println("일단 쿠키 일행들이 “어둠마녀 쿠키”와 케이크 군단을 막아내 후퇴를 시키는 데에 성공했다… ");
		System.out.println("더는 “어둠마녀 쿠키”의 만행을 지켜볼 수 없던 쿠키 일행은 퇴각한 “어둠마녀 쿠키” 군단이 휴식하는 마녀의 탑으로 향하게 된다… ");
		System.out.println("확인(아무키나 누르세요)");
		if(in.next() != "~!@#$%%^^&&*()_") {
		}
		System.out.println("과연 쿠키 일행은 험난한 탑의 여정을 거쳐 꼭대기 층인 30층에서 “어둠마녀 쿠키”를 물리치고, ");
		System.out.println("왕국과 나아가 쿠키 세계의 평화를 가져올 수 있을 것인가...!");
		System.out.println("확인(아무키나 누르세요)");
		if(in.next() != "~!@#$%%^^&&*()_") {
		}
		PlayerMaker.playerMaker();
		basisInterface();
	}
	
	public static void gameEnd() {
		System.out.println("\t         [          게임을 종료합니다.          ]");
	}
	
	
	
	public static void Inventory() {
		//index 보이게 수정
		Inventory.viewInventory();
		
		Scanner in = new Scanner(System.in);
		while (true) {
			message("어떤 행동을 선택할 것입니까?");
			message2("> 1. 아이템 장착 및 사용.");
			message2("> 2. 조합.");
			message3("> 3. 나가기.");
			Combine com = new Combine();
			int a = in.nextInt();
			if (a == 1 || a == 2 || a == 3) {
				switch(a) {
				case 1 -> equip();
				case 2 ->{
					if(GameData.teleportPosition.get(Player.getCurFloor())==2) {
						com.combine();
					} else {
						basisInterface("현재 층에는 조합대가 없습니다.");
					}
					
				}
				case 3 -> basisInterface();
				}	
				break;
			} else {
				message3(" ! 선택 오류. 다시 선택하세요. ! ");
				continue;
			}
		}
		
	}
	
	
	public static void viewItemInfo() {

		
		Scanner in = new Scanner(System.in);
		while (true) {
			Interface.message("행동을 선택하세요");
			Interface.message2("> 1. 전체 아이템 보기");
			Interface.message2("> 2. 아이템 조합식 확인");
			Interface.message2("> 3. 몬스터 확인");
			Interface.message3("> 4. 취소");
			
			int a = in.nextInt();
			if (a == 1 || a == 2 || a == 3 || a == 4) {
				System.out.println();
				switch(a) {
					case 1 -> {
//						message("");
						for(int i = 0; i<GameData.ITEMLIST.length; i ++) {
							Item item = new Item(GameData.ITEMLIST[i][0]);
							message2(" (  INDEX :"+item.getIndex()+" )   "+item.getName() );
						}
						
						
						message3("아이템 INDEX를 입력하세요.");
						int itemIndex = in.nextInt(); 
						for(int i = 0; i<GameData.ITEMLIST.length; i ++) {
							if(GameData.ITEMLIST[i][2]==itemIndex) {
								Item item = new Item(i);
								Object.getInfo(item);
								break;
								
							}
					 
						}
						
						
						while (true) {
							message("어떤 행동을 선택할 것입니까?");
							message2("> 1. 아이템 추가 확인.");
							message3("> 2. 나가기.");
							int b = in.nextInt();
							if (b == 1 || b == 2) {
								switch(b) {
								case 1 -> viewItemInfo();
								case 2 -> basisInterface();
								}
								break;
							} else {
								message3(" ! 선택 오류. 다시 선택하세요. ! ");
								continue;
							}
					}
					}
					case 2 -> {
						
						message("나무막대기 + 널리고 널린 널빤지 => 평범한 나무칼 ");
						message2("나무막대기 + 보통의 돌멩이 => 보통의 돌칼 ");
						message2("나무막대기 + 단단한 강철 => 단단한 철칼 ");
						message2("정화된 석류신목의 신성한 나뭇가지 + 단단한 강철 => 명예로운 기사의 검 ");
						message2("나무갑옷 + 단단한 강철 => 단단한 철갑옷 ");
						message2("나무갑옷 + 고슴도치의 뾰족 가시 => 가시갑옷 ");
						message2("단단한 철갑옷 + 강철장미의 가시 => 더욱 뾰족한 가시갑옷 ");
						message2("나무갑옷 + 보통의 돌멩이 => 보통의 돌갑옷 ");
						message2("갓 구운 크래커 + 각잡힌 각설탕 => 시럽뿌린 바삭바삭 크래커 ");
						message2("빛나는 빨간 체리 + 각잡힌 각설탕 => 시럽 철철 달콤 ");
						message2("단단한 강철 + 고슴도치의 뾰족 가시 => 강철 장미의 가시");
						message2("철갑상어의 뼛가루 + 철갑상어의 뼛가루  => 단단한 강철");
						message2("나무막대기 + 달빛 꿈의 정수  => 정화된 석류신목의 신성한 나뭇가지");
						message2("나무막대기 + 한줌의 천둥구름  => 번개막대");
						amukey2();
						viewItemInfo();
					}
					case 4 -> {
						basisInterface();
					}
					case 3 -> {
						message("");
						for(int i = 0; i<GameData.MONSTERLIST.length; i ++) {
							Monster monster = new Monster(GameData.ITEMLIST[i][0]);
							message2(" (  INDEX :"+monster.getIndex()+" )   "+monster.getName() );
						}
						
						
						message3("몬스터 INDEX를 입력하세요.");
						int Index = in.nextInt(); 
						for(int i = 0; i<GameData.MONSTERLIST.length; i ++) {
							if(GameData.MONSTERLIST[i][0]==Index) {
								Monster monster = new Monster(i);
								Object.getInfo(monster);
								break;
								
							}
					 
						}
						
						
						while (true) {
							message("어떤 행동을 선택할 것입니까?");
							message2("> 1. 몬스터 추가 확인.");
							message3("> 2. 나가기.");
							int b = in.nextInt();
							if (b == 1 || b == 2) {
								switch(b) {
								case 1 -> viewItemInfo();
								case 2 -> basisInterface();
								}
								break;
							} else {
								message3(" ! 선택 오류. 다시 선택하세요. ! ");
								continue;
							}
					}
					}
				};
			
				break;
			} else {
				message(" ! 선택 오류. 다시 선택하세요. ! ");
				continue;
			}
		}
		
		basisInterface();
	}


	public static void playerStatus() {
		System.out.printf("||||                  =====    %-10s  =====                ||||\n",Player.getName());
		System.out.printf("||||          HP  : %5d / %-3d          ||       %-15s||||\n",Player.getHp(),Player.getFullHp(),ticBar(Player.getHp(), Player.getFullHp()));
		System.out.printf("||||          STA : %5d / %-3d          ||       %-15s||||\n",Player.getStamina(),Player.getFullStamina(),ticBar(Player.getStamina(), Player.getFullStamina()));
		System.out.printf("||||          EXP : %5d / %-3d          ||       %-15s||||\n",Player.getExp(),Player.getFullExp(),ticBar(Player.getExp(), Player.getFullExp()));
		
	}
	public static void viewPlayerStatus() {
		
		playerStatus();
		for (Item item : Equip.equipList) {
			System.out.println(item.getName());
		}
		
		Scanner in = new Scanner(System.in);

		while (true) {
			message("어떤 행동을 선택할 것입니까?");
			message2("> 1. 장비 해제.");
			message3("> 2. 나가기.");
			int a = in.nextInt();
			if (a == 1 || a == 2) {
				switch(a) {
				case 1 -> Equip.takeOff(a);
				case 2 -> basisInterface();
				}
				break;
			} else {
				message3(" ! 선택 오류. 다시 선택하세요. ! ");
				continue;
			}
		}
		
		
	}
	
	public static void amukey() {
		Scanner in = new Scanner(System.in);
		message3("<<< 나가려면 아무 키나 누르십시오. >>>");
		if(in.next() != "~!@#$%%^^&&*()_") {
			basisInterface();
		}
	}
	public static void amukey2() {
		Scanner in = new Scanner(System.in);
		Interface.message3("확인(아무키나 누르세요)");
		if(in.next() != "~!@#$%%^^&&*()_") {
//			Interface.message2("");
		}
	}

	
	public static void viewMap() {
		Map.map();
		message("");
		amukey();
		
	}


	public static void equip() {
		message("아이템을 선택하세요.");
		Inventory.viewInventory();
		
		Scanner in = new Scanner(System.in);
		
		int a = in.nextInt();
		while(true) {
//			System.out.println(Inventory.itemIndexList.size());
			if(a >= Inventory.itemIndexList.size() || a<0) {
				Interface.message("잘못된 번호 입니다.");
				Interface.message3("다시 입력하세요.");
				a = in.nextInt();
				continue;
			} else {
				Equip.itemUse(a);
				break;
			}
		}
		
		
		
		while (true) {
			message("어떤 행동을 선택할 것입니까?");
			message2("> 1. 추가 장착/사용.");
			message3("> 2. 나가기.");
			int b = in.nextInt();
			if (b == 1 || b == 2) {
				switch(b) {
				case 1 -> equip();
				case 2 -> Inventory();
				}
				break;
			} else {
				message(" ! 선택 오류. 다시 선택하세요. ! ");
				message3("");
				continue;
			}
		}
	}
	
	public static void teleport() {
		
		if(GameData.teleportPosition.get(Player.getCurFloor())==1) {
			for(Item item : Inventory.itemIndexList) {	
				if(item.getIndex() == 1) {
					//아이템 삭제
					//텔레포트
					Scanner in = new Scanner(System.in);
					
					while (true) {
						message("스테미나 2 와 아이템 teleportItem 1개 를 사용하여 사용하시겠습니까?");
						message2("> 1. 사용.");
						message3("> 2. 사용 안함.");
						int a = in.nextInt();
						if (a == 1 || a == 2) {
							switch(a) {
							case 1 ->{
									Inventory.itemIndexList.remove(Inventory.itemIndexList.indexOf(item));
									Move.teleport();
								}
							case 2 -> basisInterface();
							}
							break;
						} else {
							message(" ! 선택 오류. 다시 선택하세요. ! ");
							message3("");
							continue;
						}
					}
					
					
					break;
				} else {
					continue;
					
				}
				
			}
			basisInterface("teleportItem이 없어 이용 할 수 없습니다.");
			

		} else {
		
			basisInterface("현재 층에는 텔레포트가 없습니다.");

		}
	}
	
	
	
	public static void basisInterface() {

		Map.curFloorMap();
		ticBarStatus();
		
		
		
		Scanner in = new Scanner(System.in);
		while (true) {
			message("어떤 행동을 선택할 것입니까?");
			message2("> 0. 맵.");
			message2("> 1. 플레이어 상태 보기.");
			message2("> 2. 아이템/몬스터 정보 보기.");
			message2("> 3. 인벤토리 보기.");
			message2("> 4. 이동.");
			message3("> 5. 휴식.");
			int a = in.nextInt();
			if (a == 0 || a == 1 || a == 2 || a == 3 || a == 4 || a==5) {
				switch(a) {
				case 0 -> viewMap();
				case 1 -> viewPlayerStatus();
				case 2 -> viewItemInfo();
				case 3 -> Inventory();
				case 4 -> Move.move();
				case 5 -> sleep();
				};
				break;
			} else {
				message(" ! 선택 오류. 다시 선택하세요. ! ");
				message3("");
				continue;
			}
		}

	}
		//이동 방 들어가면 roomInterface()		
	public static void sleep() {
		if(GameData.teleportPosition.get(Player.getCurFloor())==2) {
			Sleep.sleep();
			basisInterface();
		} else {
			basisInterface("현재 층에는 침대가 없습니다.");
		}
		
	}
	
	public static String ticBar(int a, int b) {
		int c = (int)((a * 10)/ b );
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<c;i++) {
			sb.append("+");
		}
		for(int j=0;j<10-c;j++) {
			sb.append("-");
		}
		return sb.toString();
	}
	
	public static void ticBarStatus() {
		System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		System.out.printf("||||                  =====    %-10s  =====                ||||\n",Player.getName());
		System.out.printf("||||          HP  : %5d / %-3d          ||       %-15s||||\n",Player.getHp(),Player.getFullHp(),ticBar(Player.getHp(), Player.getFullHp()));
		System.out.printf("||||          STA : %5d / %-3d          ||       %-15s||||\n",Player.getStamina(),Player.getFullStamina(),ticBar(Player.getStamina(), Player.getFullStamina()));
		System.out.printf("||||          EXP : %5d / %-3d          ||       %-15s||||\n",Player.getExp(),Player.getFullExp(),ticBar(Player.getExp(), Player.getFullExp()));
		System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
	}
	
	public static void basisInterface(String message) {
	
		Map.curFloorMap();
		ticBarStatus();
		message(message);


		Scanner in = new Scanner(System.in);
		while (true) {
			message("행동을 선택하세요.");
			message2("> 0. 맵.");
			message2("> 1. 플레이어 상태 보기.");
			message2("> 2. 아이템 정보 보기.");
			message2("> 3. 인벤토리 보기.");
			message2("> 4. 이동.");
			message3("> 5. 휴식.");
			int a = in.nextInt();
			if (a == 0 || a == 1 || a == 2 || a == 3 || a == 4 || a==5) {
				switch(a) {
				case 0 -> viewMap();
				case 1 -> viewPlayerStatus();
				case 2 -> viewItemInfo();
				case 3 -> Inventory();
				case 4 -> Move.move();
				case 5 -> sleep();
				};
				break;
			} else {
				message3(" ! 선택 오류. 다시 선택하세요. ! ");
				continue;
			}
		}
	}
}
