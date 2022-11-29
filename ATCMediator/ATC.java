package ATCMediator;

//import java.util.ArrayList;
//import java.util.List;

import CommandClass.Flight;
import CommandClass.Runway;

public class ATC implements ATCMediator {
	// private List<Flight> flightList=new ArrayList<Flight>();
	private Flight flight;
	private Runway runway;
	public boolean land;

	@Override
	public void registerRunway(Runway runway) {
		this.runway = runway;

	}

	// vai começar a lidar com uma lista
	@Override
	public void registerFlight(Flight flight) {
		this.flight = flight;

	}

	// @Override
	// public void registerFlight(Flight flight) {
	// this.flightList.add(flight);
	//
	// }

	// @Override
	// public void unregisterFlight(Flight flight) {
	// this.flightList.remove(flight);
	//
	// }

	@Override
	public boolean isLandingOk() {
		return land;

	}

	@Override
	public void setLandingStatus(boolean status) {
		land = status;
	}

}
