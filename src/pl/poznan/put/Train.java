package pl.poznan.put;

import java.util.stream.Collectors;

public class Train implements Run {

	private String name;

	private Long ID;

	private Station location;

	private TrainType type;

	public Train(String name, Long iD, TrainType type) {
		super();
		this.name = name;
		ID = iD;
		this.type = type;
	}

	public Train(String name, Long iD, Station location, TrainType type) {
		super();
		this.name = name;
		ID = iD;
		this.location = location;
		this.type = type;
	}

	@Override
	public Train run(Track track) throws Exception {

		if (location != null && !track.firstStation().equals(location)) {
			throw new Exception("Start train location is diffent from first station");
		}
		if (track.allStations().stream().map(Station::typeOfStation).collect(Collectors.toList())
				.contains(StationType.CARGO) && !type.equals(TrainType.CARGO)) {
			throw new Exception("Wrong track, only Cargo train can pass cargo station");
		}
		if (track.allStations().stream().map(Station::typeOfStation).collect(Collectors.toList())
				.contains(StationType.SMALL) && type.equals(TrainType.EXPRESS)) {
			throw new Exception("Wrong track, Express train cannot get to small station");
		}

		else {
			System.out.println(String.format("Train %s run from %s to %s ", trainFullName(),track.firstStation(),
					track.lastStation().stationName()));

			for (Station currentStation : track.allStations()) {
				if (!currentStation.equals(track.firstStation())) {
					System.out.println(
							String.format("Train %s get to %s", trainFullName(), currentStation.stationName()));
				}
			}
			System.out.println(String.format("Train %s end track %s", trainFullName(), track.trackName()));
			return changeLocation(track.lastStation());
		}

	}

	public String trainFullName() {
		return String.format("%s(%d)", name, ID);

	}

	private Train changeLocation(Station newLocation) {

		return new Train(name, ID, newLocation, type);
	}

	public String trainLocation() {
		return String.format("current train Location: %s",
				(location == null) ? "nie ma lokalizacji" : location.stationName());
	}

}
