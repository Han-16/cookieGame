package cookieGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Combine {
	// 조합목록선택
	// ~~프로의 확률로 아이템이 생성됩니다 하시겠습니까? ox
	// 조합할 아이템을 입력하세요
	// 현제 추가한 아이템 출력
	// 아이템 추가, 조합, 취소 선택
	// 아이템 추가할때마다 combineList에 추가
	// 조합 -> 인벤토리에서 conbineList에 있는 아이템 삭제, (성공 실패 출력) 인벤토리에 아이템 추가
	// 다음행동 선택
	private static List<Integer> combineList = new ArrayList<>();
	//static때믄에 오류날수도
	public static int findItem(int itemindex) {
		int itemlocation = 0;
		for(int i=0;i<GameData.ITEMLIST.length;i++) {
			if(GameData.ITEMLIST[i][2] == itemindex) {
				itemlocation = i;
			} else {
				continue;
			}
		}
		return itemlocation;
	}

	public void combine() {
	
		
		while(true) {
			
			Scanner in = new Scanner(System.in);
			
			Interface.message("행동을 선택하세요.");
			Interface.message2("> 1. 조합 아이템 선택.");
			Interface.message2("> 2. 조합하기.");
			Interface.message3("> 3. 취소.");
			int a = in.nextInt();
			
			if (a == 1 || a == 2 || a ==3) {
				
				switch(a) {
					case 1 -> {
						Inventory.viewInventory();
						Interface.message("추가할 아이템을 선택하세요.");
						Interface.message3("");
						int itemIndex = in.nextInt();
						while(true) {
							if(itemIndex >= Inventory.itemIndexList.size() || itemIndex < 0) {
								Interface.message("잘못된 번호 입니다.");
								Interface.message3("다시 입력하세요.");
								itemIndex = in.nextInt();
								continue;
							} else {
								combineList.add(Inventory.itemIndexList.get(itemIndex).getIndex());
								System.out.print("                    << ");
								for(int i : combineList) {
									System.out.print(i+" ");
								}
								System.out.println(" >>");
								System.out.println();
								Inventory.itemIndexList.remove(itemIndex);
								break;
							}
						}
						
						
					}
					case 2 -> {
						int ran =(int)((Math.random())*(10));	//80프로의 확률			
						if(ran>2) {
							
							if(compare(combineList)==0) {
								Interface.message(" ! 조합식 오류. 조합 아이템을 확인하세요. ! ");
								Interface.message3("");
							} else {
								Item newItem = new Item(findItem(compare(combineList)));
								Inventory.itemIndexList.add(newItem);
								Interface.message("인벤토리에 "+newItem.getName()+" 이(가) 추가되었습니다.");
								Interface.amukey2();
								combineList.clear();
							}
							
						} else {
							Interface.message("아이템 조합 실패.");
							Interface.amukey2();
							combineList.clear();
							combine();
						}		
					}
					case 3 -> {
	//					System.out.println(findItem2(combineList));
						for(int i : combineList) {
							
							Item item = new Item(GameData.ITEMLIST[findItem(i)][0]);
							Inventory.itemIndexList.add(item);
							
						}
						combineList.clear();
						Interface.basisInterface();
						break;
					}	
				}
			} else {
				Interface.message(" ! 선택 오류. 다시 선택하세요. ! ");
				continue;
			}
		}
	}

	public static int findItem2(int itemindex) {
		int itemlocation = 0;
		for(int i=0;i<Inventory.itemIndexList.size();i++) {
			if(GameData.ITEMLIST[i][2] == itemindex) {
				itemlocation = GameData.ITEMLIST[i][0];
			}										
		}
		return itemlocation;
	}
		//받은 아이템 리스트로 만들고 인덱스 순으로 정렬
		//switch문으로 그에 맞는 아이템 출력
		//조건에맞는 아이템 인벤토리에 추가
		
	
	////////////////////////////////////////////////
	public static void combine(int... combinelist) {
		//		combinelist 크기순으로 정렬
		//길이에따라 스위치문
		//조건에 맞는 아이템 인벤토리에 추가
	}
	
	public static int compare(List<Integer> combineList) {
		int itemIndex = 0;
		while(true) {
			if(combineList.size()<2) {
				Interface.message("조합식 오류!");
				Interface.message3("");
				break;
			} else {
				combineList.sort(null);
				if(combineList.get(0) == 0 && combineList.get(1) == 0 && combineList.get(3) == 0) {
					itemIndex = 1;
				} else if(combineList.get(0) == 701 && combineList.get(1) == 705) {
					itemIndex = 100;
				} else if(combineList.get(0) == 701 && combineList.get(1) == 702) {
					itemIndex = 101;
				} else if(combineList.get(0) == 701 && combineList.get(1) == 402) {
					itemIndex = 102;
				} else if(combineList.get(0) == 402 && combineList.get(1) == 403) {
					itemIndex = 103;
				} else if(combineList.get(0) == 101 && combineList.get(1) == 107) {
					itemIndex = 104;
				} else if(combineList.get(0) == 102 && combineList.get(1) == 708) {
					itemIndex = 105;
				} else if(combineList.get(0) == 102 && combineList.get(1) == 404) {
					itemIndex = 106;
				} else if(combineList.get(0) == 402 && combineList.get(1) == 801) {
					itemIndex = 201;
				} else if(combineList.get(0) == 709 && combineList.get(1) == 801) {
					itemIndex = 202;
				} else if(combineList.get(0) == 201 && combineList.get(1) == 401) {
					itemIndex = 205;
				} else if(combineList.get(0) == 702 && combineList.get(1) == 801) {
					itemIndex = 206;
				} else if(combineList.get(0) == 613 && combineList.get(1) == 614) {
					itemIndex = 302;
				} else if(combineList.get(0) == 402 && combineList.get(1) == 703) {
					itemIndex = 401;
				} else if(combineList.get(0) == 703 && combineList.get(1) == 703) {
					itemIndex = 402;
				} else if(combineList.get(0) == 706 && combineList.get(1) == 901) {
					itemIndex = 403;
				} else if(combineList.get(0) == 704 && combineList.get(1) == 901) {
					itemIndex = 404;
				} else {
					
					itemIndex = 0;
				}
				
				break;
			}
		} 
		return itemIndex;
		
	}
}

