package io.github.diegocdbc.CommandClass;

import io.github.diegocdbc.ATC.ATCMediator;

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
    private String landingCondition = "";

    /**
     * Construtor da classe Flight.
     *
     * @param atcMediator
     * @param airline
     * @param flight
     */
    public Flight(ATCMediator atcMediator, String airline, String flight) {
        this.atcMediator = atcMediator;
        this.flightNumber = flight;
        this.airline = airline;
    }

    /*
     * Método utilizado para que a aeronave tente pousar. Para que seu pouso seja
     * possível, a torre(ATCmediator) tem que informar que a pista está disponível
     * para pousar e o observador(Fila aérea) informar que a aeronave é elegivel
     * para realizar o pouso.
     *
     * @see CommandClass.Command#land()
     */
    @Override
    public void land() {
        if (atcMediator.isLandingOk() && atcMediator.checkEligibility(this)) {
            System.out.println("[" + this.flightNumber + "]: Successfully Landed.");
            atcMediator.reportLanding(this);
        } else if ((atcMediator.isLandingOk()) && !(atcMediator.checkEligibility(this))) {
            System.out.println("[" + this.flightNumber + "]: Not eligible to land.");
        } else
            System.out.println("[" + this.flightNumber + "]: Waiting for landing.");

    }

    /**
     * Método utilizado para contactar a torre e solicitar autorização para pousar.
     */
    public void contactTower() {
        System.out
                .println("[" + this.flightNumber + "]:  solicitando autorização para pouso...");
        this.atcMediator.requestAddition(this);

    }

    /**
     * Método utilizado para settar a condição de pouso da aeronave.
     *
     * @param newCondition
     */
    public void setLandingCondition(String newCondition) {
        this.landingCondition = newCondition;
        this.showSituation(newCondition);
    }

    /*
     * Método utilizado para exibir no terminal a situação da aeronave referente ao
     * seu pouso solicitado.
     *
     * @see CommandClass.FlightPrelanding#showSituation(java.lang.String)
     */
    @Override
    public void showSituation(String situation) {
        System.out.println("[AIR QUEUE]: Flight " + this + " " + situation);

    }

    @Override
    public String toString() {
        return this.flightNumber + " da " + this.airline;
    }
}
