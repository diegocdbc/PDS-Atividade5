package ATCMediator;

import java.util.ArrayList;
import java.util.List;

import CommandClass.Flight;
import CommandClass.Runway;
import OutsourcedTeam.OutsourcedTeam;

public class ATC implements ATCMediator {
	private List<Flight> flightList = new ArrayList<Flight>();
	private Runway runway;
	private OutsourcedTeam outsourcedTeam;
	public boolean land;

	@Override
	public void registerRunway(Runway runway) {
		this.runway = runway;

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
	public void registerOST(OutsourcedTeam outsourcedTeam) {
		this.outsourcedTeam = outsourcedTeam;
	}

	@Override
	public boolean isLandingOk() {
		return land;

	}

	@Override
	public void setLandingStatus(boolean status) {
		land = status;
	}

	// Pista de pouso, podemos pousar?
	public void communicateLanding() {
		this.runway.land();
	}

	// Aeronave informa: pouso realizado com sucesso, comunique que a pista está
	// ocupada
	// Equipe de suporte informa: Pista de pouso liberada para novo pouso
	@Override
	public void changeStateRunway() {
		this.runway.getState().changeState();
	}

	@Override
	public void summonSupportTeam() {
		this.outsourcedTeam.startWork();
	}

}
