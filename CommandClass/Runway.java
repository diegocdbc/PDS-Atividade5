package CommandClass;

import ATCMediator.ATCMediator;
import State.AvailableRunwayState;
import State.RunwayState;

/**
 * Componente 2: Runway (representa a pista de pouso)
 * 
 * @author alexs
 *
 */
public class Runway implements Command {
    private ATCMediator atcMediator = null;
    private RunwayState stateOperational;

    public Runway(ATCMediator atcMediator) {
        this.atcMediator = atcMediator;
        this.stateOperational = new AvailableRunwayState();
        this.stateOperational.setContext(this);
        atcMediator.setLandingStatus(this.stateOperational.getAuthorization());
    }

    public void changeState(RunwayState state) {
        this.stateOperational = state;
    }

    public RunwayState getState() {
        return this.stateOperational;
    }

    @Override
    public void land() {
        if (this.stateOperational.getAuthorization()) {
            System.out.println("Landing permission granted.");
            atcMediator.setLandingStatus(this.stateOperational.getAuthorization());
        } else {
            System.out.println("Landing permission denied.");
            atcMediator.setLandingStatus(this.stateOperational.getAuthorization());
        }
    }

}
