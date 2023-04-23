package cookieGame;

import java.util.Scanner;

public class Move {
	
	public static void move() {
		while (true) {
			String msg = "어디로 이동하시겠습니까?";
			System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
			System.out.printf("||||    message    :    %-37s\n",msg);
//			System.out.println("||||");
			Interface.message2("> 0. up.");
			Interface.message2("> 1. down.");
			Interface.message2("> 2. enter.");
			Interface.message2("> 3. teleport.");
			Interface.message3("> 4. 취소.");
			Scanner in = new Scanner(System.in);
			int a =in.nextInt();
			
			if (a == 0 || a == 1 || a == 2 || a == 3 || a == 4 ) {
				switch(a) {
				case 0 -> up();
				case 1 -> down();
				case 2 -> enter();
				case 3 -> Interface.teleport();
				case 4 -> Interface.basisInterface();
				};
				break;
			} else {
				Interface.message(" ! 선택 오류. 다시 선택하세요. ! ");
				continue;
			}
		}
	}
	
	public static void up() {
		//위의층 몬스터 확인
		//올라갈지 안올라갈지 결정
		//(보스룸이면 확인출려문 나오고 위 아래 선택)
		
		Interface.message("이동하여 스테미너를 소비합니다.");
		Rule.loseStamina(1);
		Player.setCurFloor(Player.getCurFloor()+1);
		if(Player.getCurFloor() >= Player.getHightFloor()) {
			Player.setHightFloor(Player.getCurFloor());
			
		}
		Battle.battle(Player.getCurFloor(),Player.getCurRoom());
		Rule.win();
		Interface.basisInterface();

	}
	
	public static void down() {
		//0이하층 못가게
		if(Player.getCurFloor() == 0 ) {
//			System.out.println("최 하층 입니다. 아래로 이동불가");
			Interface.basisInterface("최하층 입니다. 더이상 아래로 이동할 수 없습니다.");
		} else {
			Interface.message("이동하여 스테미너를 소비합니다.");
			Rule.loseStamina(1);
			
			Player.setCurFloor(Player.getCurFloor()-1);
			Interface.basisInterface();
			
		}
	
	}
	//
	public static void enter() {
		
		if(GameData.allFloor.get(Player.getCurFloor()).get(1).get(0)==0 && GameData.allFloor.get(Player.getCurFloor()).get(2).get(0)==0 && GameData.allFloor.get(Player.getCurFloor()).get(3).get(0)==0) {
			Interface.basisInterface("현재 층에는 방이 없습니다.");
		} else {
			Interface.message("이동하여 스테미너를 소비합니다.");
			Rule.loseStamina(1);
			
			Interface.message("방을 선택하세요.");
			System.out.print("||||               :");
			for(int i = 1; i <=3; i++) {
				int roomOX = GameData.allFloor.get(Player.getCurFloor()).get(i).get(0);
				
				if(roomOX != 0) {
					System.out.print(i+"번방   ");
				} else {
					System.out.print("        ");
				}
				
			}
			System.out.println("");
			Interface.message3("");
			
			
			
			while(true) {
				Scanner in = new Scanner(System.in);
				int a = in.nextInt();
				if((a==1||a==2||a==3)&&GameData.allFloor.get(Player.getCurFloor()).get(a).get(0) !=0) {
					Player.setCurRoom(a);
					if(GameData.allFloor.get(Player.getCurFloor()).get(a).get(0) !=5 ){
						GameData.allFloor.get(Player.getCurFloor()).get(a).set(0, 4);
					}
					

					Room room = new Room(Player.getCurFloor(),Player.getCurRoom());
					if(room.getClearOX() == 0) {
						
						Search.search(room);
						Player.setCurRoom(0);
						//인터페이스 바꿔야함
						Interface.basisInterface("방이 비어있습니다.");
						break;
					} else {
						Battle.battle(Player.getCurFloor(),Player.getCurRoom());
						Search.search(room);
						Interface.amukey();
						room.setClearOX(0);
						break;
						
					}
				} else {
					Interface.message(" 선택오류 들어 갈 수 있는 방을 선택하세요");
					System.out.print("||||               :");
					for(int i = 1; i <=3; i++) {
						int roomOX = GameData.allFloor.get(Player.getCurFloor()).get(i).get(0);
						
						if(roomOX != 0) {
							System.out.print(i+"번방   ");
						} else {
							System.out.print("        ");
						}
						
					}
					System.out.println("");
					Interface.message3("");
					continue;
				}
			}
			
		}
	}
	
	public static void out() {
		
		Rule.loseStamina(1);
		//0번위치의 방으로의 이동이면 아래층의 0번위치 방으로 이동
		if(Player.getCurRoom()==0) {
			Player.setCurFloor(Player.getCurFloor()-1);
			Player.setCurRoom(0);
			Interface.basisInterface(Player.getCurFloor()+"층으로 이동했습니다.");
			
		} else {
			Player.setCurRoom(0);
			Interface.basisInterface();
			//0번반의 몬스터가 없어지는이유는 이것때문임
		}
		
		//아니면  0번위치방으로이동
		
		
	}
	
	public static void teleport() {
				
			Rule.loseStamina(2);		
			Scanner in = new Scanner(System.in);
			Interface.message("이용가능한 층은 "+Player.getHightFloor()+"까지 입니다.");
			for(int i = 0; i<=Player.getHightFloor(); i++) {
				if(GameData.teleportPosition.get(i)==1) {
					Interface.message2(i);				
				}
			}
			while(true) {
				Interface.message("층을 입력하세요.");
				Interface.message3("");
				int floor = in.nextInt();
				if(floor<=Player.getHightFloor() && floor!=Player.getCurFloor()) {
					Player.setCurFloor(floor);
					Player.setCurRoom(0);
					Interface.basisInterface(floor+"층으로 이동했습니다.");
					break;
				} else {
					Interface.message("이용 불가한 층입니다. 다시 입력해주세요.");
					Interface.message3("");
				}
			}
		

	}
	

}
