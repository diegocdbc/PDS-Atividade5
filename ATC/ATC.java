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
		if (status == true && this.land == false) {
			this.land = status;
			System.out.println("[TORRE]: Consulting flights available");
			this.notifyFlights();
		} else if (status == false && this.land == true) {
			this.ost.startWork();
			this.land = status;
		} else {
			System.out.println("[TORRE]: Consulting flights available");
			this.land = status;
			this.notifyFlights();
		}
	}

	@Override
	public void notifyFlights() {
		if (this.flightList.size() > 0) {
			System.out.println("[TORRE]: Flight " + this.flightList.get(0) + " Cleared to land.");
			if (this.flightList.size() > 1) {
				System.out.println("[TORRE]: Flight " + this.flightList.get(1) + " Wait for land, you is next.");
			}
			// System.out.println("**** " + this.flightList.get(0) + " ****");
			this.flightList.get(0).land();
		} else {
			System.out.println("[TORRE]: There are no aircraft waiting to land");
		}
	}

	@Override
	public void reportLanding(Flight flight) {
		this.unregisterFlight(flight);
		System.out.println("[TORRE]: Flights waiting for landing: " + this);
		this.setLandingStatus(false);
	}

	@Override
	public String toString() {
		String aux = "[ ";
		if (this.flightList.size() > 0) {
			for (int i = 0; i < this.flightList.size(); i++) {
				if (i != this.flightList.size() - 1) {
					aux += this.flightList.get(i) + ", ";
				} else {
					aux += this.flightList.get(i);
				}

			}
		}
		return aux + " ]";
	}

}
