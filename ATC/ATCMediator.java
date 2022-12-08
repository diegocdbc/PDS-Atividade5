package ATC;

import CommandClass.Flight;
import CommandClass.Runway;
import LandingQueueObserver.QueueLandingController;
import OutsourcedTeam.OutsourcedTeam;

public interface ATCMediator {

    // Registrars
    public void registerRunway(Runway runway);

    public void registerOST(OutsourcedTeam ost);

    public void registerAirQueue(QueueLandingController airQueue);

    // Methods ATC - Flight
    public void reportLanding(Flight flight);

    public Boolean checkEligibility(Flight flight);

    // Methods ATC - Runway
    public boolean isLandingOk();

    public void setLandingStatus(boolean status);

    public void checkTrackStatus();

    public void changeStateRunway();

    // Methods ATC - OST
    public void summonSupportTeam();

    // Methods ATC - Air Quue
    public void requestAddition(Flight flight);

    public void requestRemoval(Flight flight);

}
