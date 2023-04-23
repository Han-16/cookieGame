package cookieGame;

import java.util.Scanner;

public class PlayerMaker {
	
	public static void SetPlayer() {
		Player.setName(Ablility.Name);
		Player.setFullHp(Ablility.FullHp);
		Player.setHp(Ablility.Hp);
		Player.setFullStamina(Ablility.FullStamina);
		Player.setStamina(Ablility.Stamina);
		Player.setFullExp(Ablility.FullExp);
		Player.setExp(Ablility.Exp);
		Player.setStr(Ablility.Str);
		Player.setSpd(Ablility.Spd);
		Player.setDex(Ablility.Dex);
		Player.setAccuracy(Ablility.Accuracy);
		
	}
	public static void playerMaker() {
		Scanner in = new Scanner(System.in);
		
		while (true) {
			System.out.println("\n어떤 쿠키를 선택할 것입니까?");
			System.out.println("> 1. 용감한 쿠키.");
			System.out.println("> 2. 명량한 쿠키.");
			System.out.println("> 3. 버블껌 쿠키.");
			System.out.println("> 4. 슈크림 쿠키.");
			int a = in.nextInt();
			if (a == 1 || a == 2 || a == 3 || a == 4) {
				switch(a) {
				case 1 -> Ablility.Cookie1();
				case 2 -> Ablility.Cookie2();
				case 3 -> Ablility.Cookie3();
				case 4 -> Ablility.Cookie4();
				}
				PlayerMaker.SetPlayer();
				break;
			} else {
				System.out.println("1 ~ 4 번 쿠키를 선택하세요.");
				continue;
			}
		}
		
	}

	
}
