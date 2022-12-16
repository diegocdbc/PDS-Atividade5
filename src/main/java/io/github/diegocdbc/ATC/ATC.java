package io.github.diegocdbc.ATC;

import io.github.diegocdbc.CommandClass.Flight;
import io.github.diegocdbc.CommandClass.Runway;
import io.github.diegocdbc.LandingQueueObserver.QueueLandingController;
import io.github.diegocdbc.OutsourcedTeam.OutsourcedTeam;

public class ATC implements ATCMediator {
    private Runway runway;
    private QueueLandingController airQueue;
    public boolean land;
    public OutsourcedTeam ost;

    // Methods registration

    /*
     * Método para registrar a pista(Runway)
     *
     * @see ATC.ATCMediator#registerRunway(CommandClass.Runway)
     */
    @Override
    public void registerRunway(Runway runway) {
        this.runway = runway;

    }

    /*
     * Método para registrar a equipe terceirizada(OutsourcedTeam)
     *
     * @see ATC.ATCMediator#registerOST(OutsourcedTeam.OutsourcedTeam)
     */
    @Override
    public void registerOST(OutsourcedTeam ost) {
        this.ost = ost;

    }

    /*
     * Método para registrar a fila aérea(QueueLandingController)
     *
     * @see
     * ATC.ATCMediator#registerAirQueue(LandingQueueObserver.QueueLandingController)
     */
    @Override
    public void registerAirQueue(QueueLandingController airQueue) {
        this.airQueue = airQueue;

    }

    // Methods ATC - Runway

    /*
     * Método que será utilizado para consultar se a pista está disponível ou não
     * para pouso.
     *
     * @see ATC.ATCMediator#isLandingOk()
     */
    @Override
    public boolean isLandingOk() {
        return land;

    }

    /*
     * Método que será utilizado para settar a informação da torre a respeito da
     * disponibilização ou não da pista.
     *
     * @see ATC.ATCMediator#setLandingStatus(boolean)
     */
    @Override
    public void setLandingStatus(boolean status) {
        land = status;
    }

    /*
     * Método que será utilizado para a torre consultar a pista o seu state atual.
     *
     * @see ATC.ATCMediator#checkTrackStatus()
     */
    @Override
    public void checkTrackStatus() {
        this.runway.land();

    }

    /*
     * Método que será utilizado pela equipe terceirizada para intermediar a
     * comunicação com a pista. o Método irá solicitar a pista que ela realize a
     * troca de State, caso State se torne "Available", a torre acionará o Observer
     * para que ele aplique sua lógica de notificação das aeronaves que estão no
     * aguardo para pousar.
     *
     * @see ATC.ATCMediator#changeStateRunway()
     */
    @Override
    public void changeStateRunway() {
        this.runway.getState().changeState();
        if (this.runway.getState().getAuthorization()) {
            this.airQueue.notifyFlights();
        }
    }

    // Methods ATC - Flight

    /*
     * Método que será utilizado para que a torre contacte a fila aérea informando o
     * pouso e solicitando a remoção da aeronave da fila aérea. Após a remoção,
     * serão exibidas as aeronaves que ainda aguardam permissão para pouso.
     *
     * @see ATC.ATCMediator#reportLanding(CommandClass.Flight)
     */
    @Override
    public void reportLanding(Flight flight) {
        this.requestRemoval(flight);
        System.out.println("[TORRE]: Flights waiting for landing: " + this.airQueue);
        this.setLandingStatus(false);
        this.changeStateRunway();
    }

    /*
     * Método que será utilizado para que a torre copnsulte a fila aérea e retorne a
     * elegibilidade ou não de uma aeronave para pouso.
     *
     * @see ATC.ATCMediator#checkEligibility(CommandClass.Flight)
     */
    @Override
    public Boolean checkEligibility(Flight flight) {
        return airQueue.verifyPermission(flight);
    }

    /*
     * Método que será utilizado pela fila aerea para que ela contacte a aeronave
     * notifique sua condição atual de pouso.
     *
     * @see ATC.ATCMediator#informCondition(CommandClass.Flight, java.lang.String)
     */
    @Override
    public void informCondition(Flight flight, String newCondition) {
        flight.setLandingCondition(newCondition);
    }

    // Methods ATC - AirQueue

    /*
     * Método que será utilizado pela aeronave, quando ela declarar intensão de
     * pouso, a torre intermediará a comunicação com a fila aérea. A fila aérea
     * registrará essa aeronave.
     *
     * @see ATC.ATCMediator#requestAddition(CommandClass.Flight)
     */
    @Override
    public void requestAddition(Flight flight) {
        this.airQueue.registerFlight(flight);
    }

    /*
     * Método que será acionado quando a aeronave notificar o pouso a torre, a mesma
     * por sua vez, irá acionara fila aérea para retirar o registro da aeronave da
     * fila.
     *
     * @see ATC.ATCMediator#requestRemoval(CommandClass.Flight)
     */
    @Override
    public void requestRemoval(Flight flight) {
        this.airQueue.unregisterFlight(flight);
    }

    // Methods ATC - OST

    /*
     * Método que será utilizado para acionar a equipe de solo para realizar o
     * desembarque e viabilização da pista para um novo pouso.
     *
     * @see ATC.ATCMediator#summonSupportTeam()
     */
    @Override
    public void summonSupportTeam() {
        this.ost.startWork();
    }
}
