package CommandClass;

import ATC.ATCMediator;

/**
 * Componente 2: Runway (representa a pista de pouso)
 * 
 * @author alexs
 *
 */
public class Runway implements Command {
    private ATCMediator atcMediator = null;
    private String status = "UNAVAILABLE";

    public Runway(ATCMediator atcMediator) {
        this.atcMediator = atcMediator;
    }

    @Override
    public void land() {
        if (this.status.equals("UNAVAILABLE")) {
            System.out.println("[RUNWAY]: Providing runway to start landings\n");
            this.status = "AVAILABLE";
            atcMediator.setLandingStatus(true);
        }
        if (this.atcMediator.isLandingOk() && this.status.equals("AVAILABLE")) {
            System.out.println("[RUNWAY]: Landing permission granted.\n");
            atcMediator.setLandingStatus(true);
        } else {
            System.out.println("[RUNWAY]: Landing permission denied.\n");
        }
    }

}
