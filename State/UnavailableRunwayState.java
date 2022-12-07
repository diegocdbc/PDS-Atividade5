package State;

import CommandClass.Runway;

public class UnavailableRunwayState implements RunwayState {
    public Runway context = null;

    @Override
    public void setContext(Runway context) {
        this.context = context;

    }

    @Override
    public void changeState() {
        AvailableRunwayState availableRunwayState = new AvailableRunwayState();
        availableRunwayState.setContext(context);
        this.context.changeState(availableRunwayState);
    }

    @Override
    public boolean getAuthorization() {
        return false;

    }

}
