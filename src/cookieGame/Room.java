package cookieGame;

public class Room {
	//GameData에서 가져오기 & GameData에 보내기
	
	//Floor와 index를 받으면 룸 생성후 저장
	//생성자 <-Player에있는 enter 메서드에서 들어갈때 현재위치 정보를 받음
	Room(int floor, int roomNum) {
			
		this.numFloor = Player.getCurFloor();
		this.numRoom = Player.getCurRoom();
		this.monsterIndex1 = GameData.allFloor.get(floor).get(roomNum).get(1);
		this.monsterIndex2 = GameData.allFloor.get(floor).get(roomNum).get(2);
		this.monsterIndex3 = GameData.allFloor.get(floor).get(roomNum).get(3);

		if (GameData.allFloor.get(floor).get(roomNum).get(0) == 5) {
			this.clearOX= 0;
		} else {
			this.clearOX= 1;
		}
		
		if(floor== GameData.floorNum-1) {
			this.numFloor = Player.getCurFloor();
			this.numRoom = Player.getCurRoom();


			if (GameData.allFloor.get(floor).get(roomNum).get(0) == 5) {
				this.clearOX= 0;
			} else {
				this.clearOX= 1;
			}
				
		}
	}
	
	
	private int numFloor;
	private int numRoom;
	private int monsterIndex1;
	private int	monsterIndex2;
	private int	monsterIndex3;
	private int	bedOX;
	private int	craftBoxOX;
	private int clearOX;
	
	
	public int getClearOX() {
		return this.clearOX;
	}
	public int getFloorNum() {
		return this.numFloor;
	}
	public int getRoomNum() {
		return this.numRoom;
	}


	public void setClearOX(int i) {
		this.clearOX = 0;
		
	}
	
	
}
