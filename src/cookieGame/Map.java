package cookieGame;

public class Map {
	public static void map() {
		
		StringBuilder sb = new StringBuilder();
		
		//0 없는방 4 들어갔던방 5 clear한 방
//		for(int i = 0; i<=9;i++) {
		
		sb.append("\n");
		sb.append("     +++++++++++++++++++++++++< M A P >+++++++++++++++++++++++++");
		sb.append("\n");
		sb.append("     +                                                         +");
		sb.append("\n");
		for(int i = Player.getHightFloor(); i>=0 ;i--) {
			//역순임
			sb.append("     +");
			for(int j=1; j<4; j++) {
				//clear표시
				sb.append("||");
				switch(GameData.allFloor.get(i).get(j).get(0)) {
				case 5->sb.append("     clear     ");
				case 1,2,3->sb.append("       ?       ");
				case 0->sb.append("|||||||||||||||");
				default->{
					if(GameData.allFloor.get(i).get(j).get(1)==0 && GameData.allFloor.get(i).get(j).get(2)== 0 && GameData.allFloor.get(i).get(j).get(3)==0) {
						sb.append("     search    ");
					} else {
						sb.append("       mon     ");
					}
				}
				}				

				
//				sb.append("\n");

				sb.append("||");	
				
			}
			sb.append("+");
			
			sb.append("\n");
			sb.append("     +");
			for(int j=1; j<4; j++) {
				//clear표시
				sb.append("||");
				switch(GameData.allFloor.get(i).get(j).get(0)) {
				case 5->sb.append("       O       ");
				case 1,2,3->sb.append("               ");
				case 0->sb.append("|||||||||||||||");
				default->{
					if(GameData.allFloor.get(i).get(j).get(1)==0 && GameData.allFloor.get(i).get(j).get(2)== 0 && GameData.allFloor.get(i).get(j).get(3)==0) {
						sb.append("        X      ");
					} else {
						int monC = 0;
						for(int c=1; c<=3; c++) {
							if(GameData.allFloor.get(i).get(j).get(c) != 0) {
								monC += 1;
							}
						}
						sb.append("       "+monC+"       ");
					}
				}
				}		
//				sb.append("\n");

				sb.append("||");
				
				
			}
			sb.append("+");
			sb.append("\n");
			if(GameData.teleportPosition.get(i)==1) {
				sb.append("     +"+i+"===텔레포트================================================+");
			} else if(GameData.teleportPosition.get(i)==2) {
				sb.append("     +"+i+"===침대&조합대==============================================+");
			} else {
				sb.append("     +"+i+"========================================================+");
			}
			sb.append("\n");
			
		}
		sb.append("     +                                                         +");
		sb.append("\n");
		sb.append("     +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		sb.append("\n");
		
		sb.append("\n");
		System.out.println(sb.toString());
	}
	
	public static void curFloorMap() {

		StringBuilder sb = new StringBuilder();
		if(Player.getCurFloor()>9) {
			sb.append("||||||||||||||||||||||||||||||<  F-"+Player.getCurFloor()+"  >|||||||||||||||||||||||||||||");
		} else {
			sb.append("||||||||||||||||||||||||||||||<  F-"+Player.getCurFloor()+"  >||||||||||||||||||||||||||||||");
		}
		sb.append("\n");
		sb.append("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		sb.append("\n");
		for(int j=1; j<4; j++) {
			//clear표시
			sb.append("||||");
			switch(GameData.allFloor.get(Player.getCurFloor()).get(j).get(0)) {
			case 5->{
				sb.append("     clear     ");
				

			}
			case 1,2,3->{
				sb.append("       ?       ");
				

			}
			case 0->{
				sb.append("|||||||||||||||");
				

			}
			default->{
				if(GameData.allFloor.get(Player.getCurFloor()).get(j).get(1)==0 && GameData.allFloor.get(Player.getCurFloor()).get(j).get(2)== 0 && GameData.allFloor.get(Player.getCurFloor()).get(j).get(3)==0) {
					sb.append("     search    ");
				} else {
					sb.append("       mon     ");
				}
			}
		}
			sb.append("||||");
	}
		sb.append("\n");
		for(int j=1; j<4; j++) {
			//clear표시
			sb.append("||||");
			switch(GameData.allFloor.get(Player.getCurFloor()).get(j).get(0)) {
			case 5->sb.append("       O       ");
			case 1,2,3->sb.append("               ");
			case 0->sb.append("|||||||||||||||");
			default->{
				if(GameData.allFloor.get(Player.getCurFloor()).get(j).get(1)==0 && GameData.allFloor.get(Player.getCurFloor()).get(j).get(2)== 0 && GameData.allFloor.get(Player.getCurFloor()).get(j).get(3)==0) {
					sb.append("        X      ");
				} else {
					int monC = 0;
					for(int c=1; c<=3; c++) {
						if(GameData.allFloor.get(Player.getCurFloor()).get(j).get(c) != 0) {
							monC += 1;
						}
					}
					sb.append("       "+monC+"       ");
				}
			}
			}
			sb.append("||||");
		}
		sb.append("\n");

		sb.append("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");	
		if(GameData.teleportPosition.get(Player.getCurFloor())==1) {
			sb.append("\n");
			sb.append("||||    FloorInfo    -    텔레포트 사용가능                           ||||\n");
			sb.append("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");	
		} else if(GameData.teleportPosition.get(Player.getCurFloor())==2) {
			sb.append("\n");
			sb.append("||||    FloorInfo    -    침대&조합대 사용가능                         ||||\n");
			sb.append("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		}

		System.out.println(sb.toString());

	}
}
