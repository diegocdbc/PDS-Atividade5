package State;

import ATC.ATCMediator;
import CommandClass.Runway;

public class InsecureRunwayState implements RunwayState {
    public Runway context = null;
    public String description = "Insecure for landing";

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
        AvailableRunwayState availableRunwayState = new AvailableRunwayState();
        availableRunwayState.setContext(context);
        this.context.changeState(availableRunwayState);
        System.out.println("[Runway]: State changed for '" + availableRunwayState.getDescription() + "'.");
    }

    /*
     * Método que retornará um booleano que representará a autorização para
     * pouso(true) ou não(false).
     * 
     * @see State.RunwayState#getAuthorization()
     */
    @Override
    public boolean getAuthorization() {
        return false;

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
        System.out.println("[Runway]: Landing permission denied. The track is currently in a state of insecurity");
        atcMediator.setLandingStatus(this.getAuthorization());
    }

}
