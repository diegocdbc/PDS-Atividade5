package CommandClass;

import ATCMediator.ATCMediator;

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
            System.out.println("Flight " + flightNumber + " Successfully Landed.");
            atcMediator.unregisterFlight(this);
            atcMediator.changeStateRunway();
        } else
            System.out.println("Waiting for landing.");

    }

    public void getReady() {
        System.out
                .println("Voo " + this.flightNumber + " da " + this.airline + " solicitando autorizacao para pouso...");

    }

    public String getFlight() {
        return this.flightNumber;
    }

}
