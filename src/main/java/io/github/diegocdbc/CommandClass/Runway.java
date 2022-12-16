package io.github.diegocdbc.CommandClass;

import io.github.diegocdbc.ATC.ATCMediator;
import io.github.diegocdbc.State.AvailableRunwayState;
import io.github.diegocdbc.State.RunwayState;

/**
 * Componente 2: Runway (representa a pista de pouso)
 *
 * @author alexs
 *
 */
public class Runway implements Command {
    private ATCMediator atcMediator = null;
    private RunwayState stateOperational;

    /**
     * Construtor da class Runway.
     *
     * @param atcMediator
     */
    public Runway(ATCMediator atcMediator) {
        this.atcMediator = atcMediator;
        this.stateOperational = new AvailableRunwayState();
        this.stateOperational.setContext(this);
        atcMediator.setLandingStatus(this.stateOperational.getAuthorization());
    }

    /**
     * Método que será utilizado pelas classes concretas de cada state para realizar
     * a troca de State.
     *
     * @param state
     */
    public void changeState(RunwayState state) {
        this.stateOperational = state;
    }

    /**
     * Método get para atributo privado referente ao State atual da pista.
     *
     * @return
     */
    public RunwayState getState() {
        return this.stateOperational;
    }

    /*
     * Método que será utilizado para se obter a informação se a pista está apta ou
     * não para realizar novos pouso. O retorno do método varia de acordo com seu
     * State.
     *
     * @see CommandClass.Command#land()
     */
    @Override
    public void land() {
        this.stateOperational.reportStateLanding(this.atcMediator);
    }

}
