package io.github.diegocdbc.OutsourcedTeam;

import io.github.diegocdbc.ATC.ATCMediator;

/**
 * Componente 3: OutsourcedTeam (representa uma equipe de solo, a equipe
 * terceirizada que apoiará no desembarque e averiguação da pista)
 *
 * @author diegocdbc
 *
 */
public class OutsourcedTeam {
    private ATCMediator atcMediator = null;

    /**
     * Contrutor da class OutsourcedTeam
     *
     * @param mediator
     */
    public OutsourcedTeam(ATCMediator mediator) {
        this.atcMediator = mediator;
    }

    /**
     * Método que será acionado pela torre para que acione a equipe de terceiros e
     * inicializar o trabalho de viabilização da pista.
     */
    public void startWork() {
        System.out.println("\n[OST]: Equipe de apoio entrando em ação");
        this.disembarkPassengers();
    }

    /**
     * Método que irá simular o ato de desembarque dos passageiros. após a
     * finalização do desembarque, a equipe terceirizada notifica a torre para
     * realizar a troca de State da pista, inicia o método de varredura da pista.
     */
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
        atcMediator.changeStateRunway();
        this.checkRunway();
    }

    /**
     * Método que irá simular a varredura da pista, após isso, chamará o método que
     * aciona a torre.
     */
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

    /**
     * Método que acionará a torre para realizar a troca de state da torre e
     * notificar a disponibilização da pista para que seja realizado um novo pouso.
     */
    public void talkTower() {
        System.out.println(">> Tudo ok para novo pouso!\n");
        atcMediator.changeStateRunway();
        this.atcMediator.setLandingStatus(true);
    }
}
