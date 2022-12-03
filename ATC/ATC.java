package ATC;

import java.util.ArrayList;
import java.util.List;

import CommandClass.Flight;
import CommandClass.Runway;
import OutsourcedTeam.OutsourcedTeam;

public class ATC implements ATCMediator, ATCObserver {
	private List<Flight> flightList = new ArrayList<Flight>();
	private Runway runway;
	public boolean land;
	public OutsourcedTeam ost;

	@Override
	public void registerRunway(Runway runway) {
		this.runway = runway;

	}

	@Override
	public void registerOST(OutsourcedTeam ost) {
		this.ost = ost;

	}

	@Override
	public void registerFlight(Flight flight) {
		this.flightList.add(flight);

	}

	@Override
	public void unregisterFlight(Flight flight) {
		this.flightList.remove(flight);

	}

	@Override
	public boolean isLandingOk() {
		return land;

	}

	@Override
	public void setLandingStatus(boolean status) {
		land = status;
	}

	@Override
	public void notifyFlights() {

	}

}
