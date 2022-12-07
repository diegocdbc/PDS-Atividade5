package State;

import CommandClass.Runway;

public interface RunwayState {
    public void setContext(Runway context);

    public void changeState();

    public boolean getAuthorization();
}
