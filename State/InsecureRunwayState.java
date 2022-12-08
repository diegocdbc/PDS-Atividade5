package State;

import CommandClass.Runway;

public class InsecureRunwayState implements RunwayState {
    public Runway context = null;
    public String description = "Insecure for landing";

    @Override
    public void setContext(Runway context) {
        this.context = context;

    }

    @Override
    public void changeState() {
        AvailableRunwayState availableRunwayState = new AvailableRunwayState();
        availableRunwayState.setContext(context);
        this.context.changeState(availableRunwayState);
        System.out.println("[Runway]: State changed for '" + availableRunwayState.getDescription() + "'.");
    }

    @Override
    public boolean getAuthorization() {
        return false;

    }

    @Override
    public String getDescription() {
        return this.description;
    }

}
