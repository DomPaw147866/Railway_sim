package pl.poznan.put;

public class Station {
	
	private String name;
	
	private Long ID;
	
	private StationType type;
	

	public Station(String name, Long iD, StationType type) {
		super();
		this.name = name;
		ID = iD;
		this.type = type;
	}
	
	public String stationName() {
		
		return String.format("%s(%d)", name,ID);
	}
	
	public StationType typeOfStation() {
		return type;
	}
	
	
	
}
