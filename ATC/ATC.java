package ATC;

import CommandClass.Flight;
import CommandClass.Runway;
import LandingQueueObserver.QueueLandingController;
import OutsourcedTeam.OutsourcedTeam;

public class ATC implements ATCMediator {
	private Runway runway;
	private QueueLandingController airQueue;
	public boolean land;
	public OutsourcedTeam ost;

	// Methods registration
	@Override
	public void registerRunway(Runway runway) {
		this.runway = runway;

	}

	@Override
	public void registerOST(OutsourcedTeam ost) {
		this.ost = ost;

	}

	@Override
	public void registerAirQueue(QueueLandingController airQueue) {
		this.airQueue = airQueue;

	}

	// Methods ATC - Runway
	@Override
	public boolean isLandingOk() {
		return land;

	}

	@Override
	public void setLandingStatus(boolean status) {
		land = status;
	}

	@Override
	public void checkTrackStatus() {
		this.runway.land();

	}

	@Override
	public void changeStateRunway() {
		this.runway.getState().changeState();
		if (this.runway.getState().getAuthorization()) {
			this.airQueue.notifyFlights();
		}
	}

	// Methods ATC - Flight
	@Override
	public void reportLanding(Flight flight) {
		this.requestRemoval(flight);
		System.out.println("[TORRE]: Flights waiting for landing: " + this.airQueue);
		this.setLandingStatus(false);
		this.changeStateRunway();
	}

	@Override
	public Boolean checkEligibility(Flight flight) {
		return airQueue.verifyPermission(flight);
	}

	@Override
	public void informCondition(Flight flight, String newCondition) {
		flight.setLandingCondition(newCondition);
	}

	// Methods ATC - AirQueue
	@Override
	public void requestAddition(Flight flight) {
		this.airQueue.registerFlight(flight);
	}

	@Override
	public void requestRemoval(Flight flight) {
		this.airQueue.unregisterFlight(flight);
	}

	// Methods ATC - OST
	@Override
	public void summonSupportTeam() {
		this.ost.startWork();
	}
}
