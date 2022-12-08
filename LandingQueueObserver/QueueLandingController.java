package LandingQueueObserver;

import java.util.ArrayList;
import java.util.List;

import ATC.ATCMediator;
import CommandClass.Flight;

public class QueueLandingController {
    private List<Flight> flightList = new ArrayList<Flight>();
    private ATCMediator atcMediator = null;

    public QueueLandingController(ATCMediator atcMediator) {
        this.atcMediator = atcMediator;
    }

    public void registerFlight(Flight flight) {
        this.flightList.add(flight);
    }

    public void unregisterFlight(Flight flight) {
        this.flightList.remove(flight);
    }

    public void notifyFlights() {
        for (int i = 0; i < this.flightList.size(); i++) {
            if (i == 0) {
                this.flightList.get(i)
                        .getSituation("[AIR QUEUE]: Flight " + this.flightList.get(0) + " Cleared to land.");
            } else if (i == 1) {
                this.flightList.get(i)
                        .getSituation("[AIR QUEUE]: Flight " + this.flightList.get(1) + " Wait for land, you is next.");
            } else {
                this.flightList.get(i)
                        .getSituation("[AIR QUEUE]: Wait, soon it will be released to land");
            }
        }
    }

    public Boolean verifyPermission(Flight flight) {
        if (this.flightList.indexOf(flight) == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        String aux = "[ ";
        if (this.flightList.size() > 0) {
            for (int i = 0; i < this.flightList.size(); i++) {
                if (i != this.flightList.size() - 1) {
                    aux += this.flightList.get(i) + ", ";
                } else {
                    aux += this.flightList.get(i);
                }

            }
        }
        return aux + " ]";
    }
}
