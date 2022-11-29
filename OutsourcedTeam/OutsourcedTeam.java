package OutsourcedTeam;

public class OutsourcedTeam {

    public void disembarkPassengers() {
        for (int i = 7; i > 0; i--) {
            try {
                // 1000 milisegundos equivale a 1 segundo
                Thread.sleep(1000);
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
