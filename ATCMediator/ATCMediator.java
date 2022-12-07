package ATCMediator;

import CommandClass.Flight;
import CommandClass.Runway;
import OutsourcedTeam.OutsourcedTeam;

public interface ATCMediator {
    public void registerRunway(Runway runway);

    public void registerFlight(Flight flight);

    public void unregisterFlight(Flight flight);

    public void registerOST(OutsourcedTeam outsourcedTeam);

    public boolean isLandingOk();

    public void setLandingStatus(boolean status);

    public void changeStateRunway();

    public void summonSupportTeam();

}
