package CommandClass;

import ATC.ATCMediator;

/**
 * Componente 1: Flight (representa um vôo de uma empresa aérea)
 * 
 * @author alexs
 *
 */
public class Flight implements Command, FlightPrelanding {
    private ATCMediator atcMediator = null;
    private String flightNumber = null;
    private String airline = null;

    public Flight(ATCMediator atcMediator, String airline, String flight) {
        this.atcMediator = atcMediator;
        this.flightNumber = flight;
        this.airline = airline;
    }

    @Override
    public void land() {
        if (atcMediator.isLandingOk() && atcMediator.checkEligibility(this)) {
            System.out.println("[" + this.flightNumber + "]: Successfully Landed.");
            atcMediator.reportLanding(this);
        } else
            System.out.println("[" + this.flightNumber + "]: Waiting for landing.");

    }

    public void contactTower() {
        System.out
                .println("[" + this.flightNumber + "]:  solicitando autorização para pouso...");
        this.atcMediator.requestAddition(this);

    }

    @Override
    public String toString() {
        return this.flightNumber + " da " + this.airline;
    }

    @Override
    public void getSituation(String situation) {
        System.out.println(situation);

    }

}
