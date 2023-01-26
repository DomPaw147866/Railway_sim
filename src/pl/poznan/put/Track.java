package pl.poznan.put;

import java.util.List;

public class Track {
	
	private String name;
	private List<Station> stations;
	
	
	public Track(String name, List<Station> stations) {
		super();
		this.name = name;
		this.stations = stations;
	}
	
	public String trackName() {
		return name;
		
	}
	
	public Station lastStation() {
		
		return stations.get(stations.size()-1);
	}
	
	public Station firstStation() {
		
		return stations.get(0);
	}
	
	public List<Station> allStations(){
		
		return stations;
	}
}
