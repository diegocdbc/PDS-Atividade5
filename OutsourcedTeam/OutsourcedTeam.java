package OutsourcedTeam;

import ATCMediator.ATCMediator;

public class OutsourcedTeam {
    private ATCMediator atcMediator = null;

    public OutsourcedTeam(ATCMediator mediator) {
        this.atcMediator = mediator;
    }

    public void startWork() {
        System.out.println("\n[OST]: Equipe de apoio entrando em ação");
        this.disembarkPassengers();
    }

    public void disembarkPassengers() {
        System.out.println(">> Desembarcando passageiros");
        for (int i = 5; i > 0; i--) {
            try {
                // 1000 milisegundos equivale a 1 segundo
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(">> Desembarque finalizado com sucesso!");
        this.checkRunway();
    }

    public void checkRunway() {
        System.out.println(">> Iniciando averiguação da pista para novo pouso, por favor aguarde.");
        for (int i = 2; i > 0; i--) {
            try {
                // 1000 milisegundos equivale a 1 segundo
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(">> Pista averiguada.");
        this.talkTower();
    }

    public void talkTower() {
        System.out.println(">> Tudo ok para novo pouso!\n");
        this.atcMediator.changeStateRunway();
    }
}