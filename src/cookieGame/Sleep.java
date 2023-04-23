package cookieGame;

import java.util.Scanner;

public class Sleep {
	public static void sleep() {
		if(Player.getStamina()<10) {
			Interface.message("스테미나가 10이하는 사용 할 수 없습니다");
			//아무키나눌러 나가기
		} else if(Player.getHp()==Player.getFullHp()) {
			Interface.message("이미 최대 체력 입니다");
			//아무키나 눌러 나가기
		} else {
			int ranSta = ((int)((Math.random())*3)+2);
			int PlayerStamina = Player.getStamina()-ranSta;
			int ranHp =(int)((Math.random())*10);
			if (Player.getHp()+ranHp>Player.getFullHp()) {
				ranHp = Player.getFullHp()-Player.getHp();
			}
			int plusHp = Player.getHp()+ranHp;

			Player.setStamina(PlayerStamina);
			Player.setHp(plusHp);
			
			Interface.message("<<스테미나 "+ranSta+"를 소모 / 현재 스테미나 : "+PlayerStamina+">>");
			Interface.message3("<<체력 "+ranHp+" 을 회복 / 현재 체력 : "+Player.getHp()+">>");
			//아무키나 눌러 나가기
		}
		Scanner in = new Scanner(System.in);
		
		while (true) {
			
			Interface.message("어떤 행동을 선택할 것입니까?");
			Interface.message2("> 1. 더 휴식하기.");
			Interface.message3("> 2. 나가기.");
			Combine com = new Combine();
			int a = in.nextInt();
			if (a == 1 || a == 2 ) {
				switch(a) {
					case 1 -> sleep();
					case 2 -> {
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
}
