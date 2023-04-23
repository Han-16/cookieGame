package cookieGame;

import java.util.Scanner;

public class Search {
	
	// 찾은item 1~3개 Inventory에 저장

	public static void search(Room room) {

		if(room.getClearOX() != 0) {
			int searchPoint = GameData.allFloor.get(Player.getCurFloor()).get(Player.getCurRoom()).get(4);
			String msg1 = "방을 탐색하시겠습니까? ( "+searchPoint+" + 아이템 갯수 만큼 스테미나 사용)";
			
			Interface.message(msg1);
			Interface.message2("> 1. 탐색.");
			Interface.message3("> 2. 취소.");
			
			Scanner in = new Scanner(System.in);
			int a = in.nextInt();
				switch(a) {
					case 1 -> {
						Interface.message("방을 탐색합니다.");
						Rule.loseStamina(searchPoint);
						//stamina깍기
						int searchCount = RandomItemCount();
						for(int i=0;i<=searchCount;i++) {
							Rule.loseStamina(1);
							int randomItemNum = (int)(Math.random()*(GameData.ITEMLIST.length-1))+1;
							Item item =new Item(GameData.ITEMLIST[randomItemNum][0]);
							Inventory.itemIndexList.add(item);
							String msg2 = "인벤토리에 "+item.getName()+"(이)가 추가되었습니다.";	
							Interface.message2(msg2);
							GameData.allFloor.get(Player.getCurFloor()).get(Player.getCurRoom()).set(0, 5);
							}
						
						}
					case 2 -> {
						break;
					}
				}
			}	
		}	
	
	
	private int RandomItem() {
		int ranItem =(int)((Math.random())*(GameData.ITEMLIST.length));
		return ranItem;
	}
	
	private static int RandomItemCount() {
		
		int ranItemCount =(int)((Math.random())*(5));
		return ranItemCount;
	}


}
