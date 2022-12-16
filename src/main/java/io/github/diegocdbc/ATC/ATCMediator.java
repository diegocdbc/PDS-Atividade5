package io.github.diegocdbc.ATC;

import io.github.diegocdbc.CommandClass.Flight;
import io.github.diegocdbc.CommandClass.Runway;
import io.github.diegocdbc.LandingQueueObserver.QueueLandingController;
import io.github.diegocdbc.OutsourcedTeam.OutsourcedTeam;

public interface ATCMediator {

    // Registrars
    public void registerRunway(Runway runway);

    public void registerOST(OutsourcedTeam ost);

    public void registerAirQueue(QueueLandingController airQueue);

    // Methods ATC - Flight
    public void reportLanding(Flight flight);

    public Boolean checkEligibility(Flight flight);

    public void informCondition(Flight flight, String newCondition);

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
