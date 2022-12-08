package State;

import CommandClass.Runway;

public class UnavailableRunwayState implements RunwayState {
    public Runway context = null;
    public String description = "Unavailable for landing";

    @Override
    public void setContext(Runway context) {
        this.context = context;

    }

    @Override
    public void changeState() {
        InsecureRunwayState insecureRunwayState = new InsecureRunwayState();
        insecureRunwayState.setContext(context);
        this.context.changeState(insecureRunwayState);
        System.out.println("[Runway]: State changed for '" + insecureRunwayState.getDescription() + "'.");
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