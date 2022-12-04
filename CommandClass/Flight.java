package CommandClass;

import ATC.ATCMediator;

/**
 * Componente 1: Flight (representa um vôo de uma empresa aérea)
 * 
 * @author alexs
 *
 */
public class Flight implements Command {
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
        if (atcMediator.isLandingOk()) {
            System.out.println("[" + this.flightNumber + "]: Successfully Landed.");
            atcMediator.reportLanding(this);
        } else
            System.out.println("[" + this.flightNumber + "]: Waiting for landing.");

    }

    public void getReady() {
        System.out
                .println("[" + this.flightNumber + "]:  solicitando autorização para pouso...");
        this.atcMediator.registerFlight(this);

    }

    @Override
    public String toString() {
        return this.flightNumber + " da " + this.airline;
    }

}
