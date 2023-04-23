package cookieGame;

public class Application {

	public static void main(String[] args) {
		
//		Item item1 = new Item(33);
//		Item item2 = new Item(37);
		Item item3 = new Item(3);
	
//		Inventory.itemIndexList.add(item1);
//		Inventory.itemIndexList.add(item2);
//		Inventory.itemIndexList.add(item1);
//		Inventory.itemIndexList.add(item2);
//		Inventory.itemIndexList.add(item1);
		Inventory.itemIndexList.add(item3);
		Inventory.itemIndexList.add(item3);
		Inventory.itemIndexList.add(item3);
		
		GameData gamedata = new GameData();
		
		gamedata.teleportPositionMaker();
		gamedata.RoomMaker();
		
		
		Interface.gameStart();
		
		
		Interface.gameEnd();
	}

}
