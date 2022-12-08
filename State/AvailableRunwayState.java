package State;

import CommandClass.Runway;

public class AvailableRunwayState implements RunwayState {
    public Runway context = null;
    public String description = "Available for landing";

    @Override
    public void setContext(Runway context) {
        this.context = context;

    }

    @Override
    public void changeState() {
        UnavailableRunwayState unavailableRunwayState = new UnavailableRunwayState();
        unavailableRunwayState.setContext(this.context);
        this.context.changeState(unavailableRunwayState);
        System.out.println("[Runway]: State changed for '" + unavailableRunwayState.getDescription() + "'.");
    }

    @Override
    public boolean getAuthorization() {
        return true;

    }

    @Override
    public String getDescription() {
        return this.description;
    }

}