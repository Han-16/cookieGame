package cookieGame;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Inventory {
	
	static List<Item> itemIndexList= new ArrayList<>();
	
	public static void getInventory() {
		for(Item item : itemIndexList) {
			Item.getInfo(item);
		}
	}

	public static void viewInventory() {
		//index 보이게 수정
		StringBuilder sb = new StringBuilder();
		int i=0 ;
		for(Item item : Inventory.itemIndexList) {
			sb.append("\n");
			sb.append("||||               :   "+i+"  "+item.getName()+"    (  INDEX : "+item.getIndex()+"   )");
			
			i++;
		}
		System.out.println(sb.toString());
		Interface.message3("");
	}
	
}
