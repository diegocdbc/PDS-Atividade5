package State;

import ATC.ATCMediator;
import CommandClass.Runway;

public interface RunwayState {
    public void setContext(Runway context);

    public void changeState();

    public boolean getAuthorization();

    public String getDescription();

    public void reportStateLanding(ATCMediator atcMediator);
}