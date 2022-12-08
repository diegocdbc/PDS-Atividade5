package CommandClass;

import ATC.ATCMediator;
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
        if (this.stateOperational.getDescription().equals("Available for landing")) {
            System.out.println("[Runway]: Landing permission granted.");
            atcMediator.setLandingStatus(this.stateOperational.getAuthorization());
        } else if (this.stateOperational.getDescription().equals("Unavailable for landing")) {
            System.out.println("[Runway]: Landing permission denied.");
            atcMediator.setLandingStatus(this.stateOperational.getAuthorization());
        } else if (this.stateOperational.getDescription().equals("Insecure for landing")) {
            System.out.println("[Runway]: Landing permission denied. The track is currently in a state of insecurity");
            atcMediator.setLandingStatus(this.stateOperational.getAuthorization());
        }
    }

}
