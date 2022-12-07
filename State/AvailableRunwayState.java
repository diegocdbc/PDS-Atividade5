package State;

import CommandClass.Runway;

public class AvailableRunwayState implements RunwayState {
    public Runway context = null;

    @Override
    public void setContext(Runway context) {
        this.context = context;

    }

    @Override
    public void changeState() {
        UnavailableRunwayState unavailableRunwayState = new UnavailableRunwayState();
        unavailableRunwayState.setContext(this.context);
        this.context.changeState(unavailableRunwayState);
    }

    @Override
    public boolean getAuthorization() {
        return true;

    }

}
