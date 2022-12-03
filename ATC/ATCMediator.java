package ATC;

import CommandClass.Flight;
import CommandClass.Runway;
import OutsourcedTeam.OutsourcedTeam;

public interface ATCMediator {
    public void registerRunway(Runway runway);

    public void registerFlight(Flight flight);

    public void registerOST(OutsourcedTeam ost);

    public void unregisterFlight(Flight flight);

    public boolean isLandingOk();

    public void setLandingStatus(boolean status);

}
