package ATCMediator;

import CommandClass.Flight;
import CommandClass.Runway;

public interface ATCMediator {
    public void registerRunway(Runway runway);

    public void registerFlight(Flight flight);

    // public void unregisterFlight(Flight flight);

    public boolean isLandingOk();

    public void setLandingStatus(boolean status);

}
