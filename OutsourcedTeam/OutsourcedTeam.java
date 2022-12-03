package OutsourcedTeam;

import ATC.ATCMediator;

public class OutsourcedTeam {
    private ATCMediator atcMediator = null;

    public OutsourcedTeam(ATCMediator mediator) {
        this.atcMediator = mediator;
    }

    public void disembarkPassengers() {
        for (int i = 7; i > 0; i--) {
            try {
                // 1000 milisegundos equivale a 1 segundo
                Thread.sleep(1000);
                this.checkRunway();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void checkRunway() {
        for (int i = 5; i > 0; i--) {
            try {
                // 1000 milisegundos equivale a 1 segundo
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
