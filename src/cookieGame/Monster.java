package cookieGame;

public class Monster extends Object {
	
	@Override
	public String getName() {
		return "(monster)"+Name;
	}

	Monster(int monsterIndex) {
		this.Index = GameData.MONSTERLIST[monsterIndex][0];
		this.Hp = GameData.MONSTERLIST[monsterIndex][1]*((Player.getCurFloor()*20)/25+(int)(Math.random()*6)+3);
		this.Str = GameData.MONSTERLIST[monsterIndex][2]+((Player.getCurFloor()*3)/4+(int)(Math.random()*3));
		this.Spd = GameData.MONSTERLIST[monsterIndex][3]+((Player.getCurFloor()*3)/4+(int)(Math.random()*3));
		this.Dex = GameData.MONSTERLIST[monsterIndex][4]+((Player.getCurFloor()*3)/4+(int)(Math.random()*3));
		this.Accuracy = GameData.MONSTERLIST[monsterIndex][5]+((Player.getCurFloor()*4)/10+(int)(Math.random()*3));
		this.Exp = GameData.MONSTERLIST[monsterIndex][6]+((Player.getCurFloor()*3)/4+(int)(Math.random()*3));
		this.Def = GameData.MONSTERLIST[monsterIndex][7]+((Player.getCurFloor()*3)/4+(int)(Math.random()*3));
		
		this.Name = switch(monsterIndex) {
		case 0 -> "";
		case 1 -> "닌자 케이크";
		case 2 -> "악마 케이크";
		case 3 -> "마법사 케이크";
		case 4 -> "좀비 케이크";
		case 5 -> "로봇 케이크";
		case 6 -> "미니 케이크";
		case 7 -> "초코 케이크";
		case 8 -> "아이스크림 케이크";
		case 9 -> "컵 케이크";
		case 10 -> "팬 케이크";
		case 11 -> "롤 케이크";
		case 12 -> "쉬폰 케이크";
		case 13 -> "웨딩 케이크";
		case 14 -> "떡 케이크";
		case 15 -> "당근 케이크";
		case 16 -> "생크림 케이크";
		case 17 -> "무지개 케이크";
		case 18 -> "치즈 케이크";
		case 19 -> "민트초코 케이크";
		case 20 -> "레드벨벳 케이크";
		case 21 -> "생크림 케이크(보스)";
		case 22 -> "롤 케이크(보스)";
		case 23 -> "어둠 마녀 쿠키";
		case 24 -> "보스4";
		case 25 -> "보스5";
		default -> throw new IllegalArgumentException("Unexpected value: " + monsterIndex);
		};
	}

	
}
