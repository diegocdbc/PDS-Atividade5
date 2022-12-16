package io.github.diegocdbc.State;

import io.github.diegocdbc.ATC.ATCMediator;
import io.github.diegocdbc.CommandClass.Runway;

public class AvailableRunwayState implements RunwayState {
    public Runway context = null;
    public String description = "Available for landing";

    /*
     * Método resposável por settar o contexto(Runway).
     *
     * @see State.RunwayState#setContext(CommandClass.Runway)
     */
    @Override
    public void setContext(Runway context) {
        this.context = context;

    }

    /*
     * Método que será utilizado para realizar a troca de state.
     *
     * @see State.RunwayState#changeState()
     */
    @Override
    public void changeState() {
        UnavailableRunwayState unavailableRunwayState = new UnavailableRunwayState();
        unavailableRunwayState.setContext(this.context);
        this.context.changeState(unavailableRunwayState);
        System.out.println("[Runway]: State changed for '" + unavailableRunwayState.getDescription() + "'.");
    }

    /*
     * Método que retornará um booleano que representará a autorização para
     * pouso(true) ou não(false).
     *
     * @see State.RunwayState#getAuthorization()
     */
    @Override
    public boolean getAuthorization() {
        return true;

    }

    /*
     * Método que retornará um resumo descritivo do State atual da pista.
     *
     * @see State.RunwayState#getDescription()
     */
    @Override
    public String getDescription() {
        return this.description;
    }

    /*
     * Método do state, que de acordo com o comportamento do state, irá comunicar a
     * torre sobre o State permissivo ou não da pista.
     *
     * @see State.RunwayState#reportStateLanding(ATC.ATCMediator)
     */
    @Override
    public void reportStateLanding(ATCMediator atcMediator) {
        System.out.println("[Runway]: Landing permission granted.");
        atcMediator.setLandingStatus(this.getAuthorization());
    }

}