package cookieGame;

import java.util.Scanner;

public class Item extends Object {
	
	@Override
	public String getName() {
		return "(item)"+Name;
	}


	public Item(int itemIndex) {
		this.Category = GameData.ITEMLIST[itemIndex][1];
		this.Index = GameData.ITEMLIST[itemIndex][2];
		this.Hp = GameData.ITEMLIST[itemIndex][3];
		this.FullHp = GameData.ITEMLIST[itemIndex][4];
		this.FullStamina = GameData.ITEMLIST[itemIndex][5];
		this.Stamina = GameData.ITEMLIST[itemIndex][6];
		this.Exp = GameData.ITEMLIST[itemIndex][7];
		this.Spd = GameData.ITEMLIST[itemIndex][8];
		this.Str = GameData.ITEMLIST[itemIndex][9];
		this.Dmg = GameData.ITEMLIST[itemIndex][10];
		this.Dex = GameData.ITEMLIST[itemIndex][11];
		this.Crt = GameData.ITEMLIST[itemIndex][12];
		this.Dur = GameData.ITEMLIST[itemIndex][13];
		this.Def = GameData.ITEMLIST[itemIndex][14];
		this.Wide = GameData.ITEMLIST[itemIndex][15];
		this.Accuracy = GameData.ITEMLIST[itemIndex][16];
		
		this.Name = switch(GameData.ITEMLIST[itemIndex][2]) {
		case 0 -> "--";
		case 1 -> "telelportItem";
		case 2 -> "telelportItem";
		case 3 -> "telelportItem";
		case 100 -> "평범한 나무칼";
		case 101 -> "보통의 돌칼";
		case 102 -> "단단한 철칼";
		case 103 -> "명예로운 기사의 검";
		case 201 -> "단단한 철갑옷";
		case 202 -> "가시갑옷";
		case 205 -> "더욱 뾰족한 가시갑옷";
		case 206 -> "보통의 돌갑옷";
		case 301 -> "시럽뿌린 바삭바삭 크래커";
		case 302 -> "시럽 철철 달콤 체리";
		case 401 -> "강철 장미의 가시";
		case 402 -> "단단한 강철";
		case 403 -> "정화된 석류신목의 신성한 나뭇가지";
		case 404 -> "번개막대";
		case 601 -> "닻에 걸린 다시마";
		case 602 -> "깨진 눈꽃사탕";
		case 603 -> "달달한 사탕수수";
		case 604 -> "초코 쇠똥구리의 비상식량";
		case 605 -> "새벽꽃버섯의 분홍 갓";
		case 606 -> "코코아버터";
		case 607 -> "심해홍합의 쫀쫀한 속살";
		case 608 -> "알록달록 일곱빛깔 포도";
		case 609 -> "지하감옥 창살캔디";
		case 610 -> "쫄깃한 불가사리";
		case 611 -> "쌓이고 쌓인 쌀가루";
		case 612 -> "과자 부스러기";
		case 613 -> "갓 구운 크래커";
		case 614 -> "각잡힌 각설탕";
		case 615 -> "빛나는 체리";
		case 701 -> "빛나는 돌맹이";
		case 702 -> "보통의 돌멩이";
		case 703 -> "철갑상어의 뼛가루";
		case 704 -> "한 줌의 천둥 구름";
		case 705 -> "널리고 널린 널빤지";
		case 706 -> "달빛 꿈의 정수";
		case 707 -> "슈뢰딩거의 동전";
		case 708 -> "말린 박쥐 날개";
		case 709 -> "고슴도치의 뾰족 가시";
		case 801 -> "나무갑옷";
		case 901 -> "나무막대기";
		default -> throw new IllegalArgumentException("Unexpected value: " + itemIndex);
		
		};
	}

	
}