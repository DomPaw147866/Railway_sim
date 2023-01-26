package pl.poznan.put;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		Station poznanStation = new Station("Poznan station", 323223L, StationType.BIG);
		Station gnieznoStation = new Station("Gniezno station", 323223L, StationType.SMALL);
		Station torunStation = new Station("Torun station", 323223L, StationType.MEDIUM);
		Station gdanskStation = new Station("Gdansk station", 231232L, StationType.BIG);
		Station gdyniaStation = new Station("Gdynia cargo station", 231232L, StationType.CARGO);
		List<Station> stations = new ArrayList<>();
		stations.add(poznanStation);
		stations.add(gnieznoStation);
		stations.add(torunStation);
		stations.add(gdanskStation);
		List<Station> cargoStations = new ArrayList<>(stations);
		cargoStations.add(gdyniaStation);

		Train standardTrain = new Train("Mieszko", 323L,TrainType.PASSENGER);
		Train cargoTrain = new Train("TrasporterTrain", 323L,TrainType.CARGO);
		Train expressTrain = new Train("Pendolino", 323L,TrainType.EXPRESS);
		Track track = new Track("Poznan-Gdansk", stations);
		Track cargoTrack = new Track("Poznan-Gdynia", stations);

		try {
			System.out.println("Standard Train");
			standardTrain.run(track);
			standardTrain.run(cargoTrack);
			System.out.println("Express Train");
			expressTrain.run(track);
			expressTrain.run(cargoTrack);
			System.out.println("Cargo Train");
			cargoTrain = cargoTrain.run(track);
			cargoTrain = cargoTrain.run(cargoTrack);
		} catch (Exception e) {
			System.out.println(e.getMessage()); 
		}

	}
}
