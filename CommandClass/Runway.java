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

    public Runway(ATCMediator atcMediator) {
        this.atcMediator = atcMediator;
        atcMediator.setLandingStatus(true);
    }

    @Override
    public void land() {
        if (this.atcMediator.isLandingOk()) {
            System.out.println("Landing permission granted.");
        } else {
            System.out.println("Landing permission denied.");
        }
    }

}
