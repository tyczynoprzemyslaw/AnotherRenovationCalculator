package logic;

public class Room {	
		
	public Room(String name, double wallA, double wallB, double high) {
		super();
		
		this.name= name;
		this.wallA = wallA;
		this.wallB = wallB;
		this.high = high;
	}
	
	
	public Room() {
		// TODO Auto-generated constructor stub
	}


	private String name;
	private double wallA;
	private double wallB;
	private double high;

	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getWallA() {
		return wallA;
	}
	
	public void setWallA(double wallA) {
		this.wallA = wallA;
	}
	
	public double getWallB() {
		return wallB;
	}
	
	public void setWallB(double wallB) {
		this.wallB = wallB;
	}
	
	public double getHigh() {
		return high;
	}
	
	public void setHigh(double high) {
		this.high = high;
	}
	
	
	public double areaWalls() {				
		return 2*wallA*high+2*wallB*high;
	}
	
	public double areaCeiling() {
		return wallA*wallB;
	}
	
	public double totalArea() {			
		return 2* wallA*high + 2*wallB*high + wallA*wallB;
	}

	public double circumferenceOfRoom() {		
		return 2*wallA+2*wallB;
	}

}
