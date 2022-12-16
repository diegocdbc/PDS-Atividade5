package io.github.diegocdbc.State;

import io.github.diegocdbc.ATC.ATCMediator;
import io.github.diegocdbc.CommandClass.Runway;

public interface RunwayState {
    public void setContext(Runway context);

    public void changeState();

    public boolean getAuthorization();

    public String getDescription();

    public void reportStateLanding(ATCMediator atcMediator);
}