package LandingQueueObserver;

import java.util.ArrayList;
import java.util.List;

import ATC.ATCMediator;
import CommandClass.Flight;

/**
 * Componente 4: QueueLandingController (representa a fila aérea)
 * 
 * @author diegocdbc
 *
 */
public class QueueLandingController {
    private List<Flight> flightList = new ArrayList<Flight>();
    private ATCMediator atcMediator = null;

    /**
     * Construtor da classe QueueLandingController
     * 
     * @param atcMediator
     */
    public QueueLandingController(ATCMediator atcMediator) {
        this.atcMediator = atcMediator;
    }

    /**
     * Método que será utilizado para registra uma aeronave interessada em ser
     * notificada pelo observador(Fila aérea)
     * 
     * @param flight
     */
    public void registerFlight(Flight flight) {
        this.flightList.add(flight);
    }

    /**
     * Método que será utilizado para retirar uma aeronave que não está mais
     * interessada em ser notificada pelo observador(Fila aérea)
     * 
     * @param flight
     */
    public void unregisterFlight(Flight flight) {
        this.flightList.remove(flight);
    }

    /**
     * Método que será utilizado para notificar as aeronaves interessadas em ser
     * notificada pelo observador. A primeira aeronave da fila será notificadao que
     * é a sua vez de pousar, a segunda é avisada que será a próxima, dessa forma
     * estará pronta para quando for a sua vez, as demais, serão notificadas que
     * deverão aguardar.
     * 
     */
    public void notifyFlights() {
        for (int i = 0; i < this.flightList.size(); i++) {
            if (i == 0) {
                this.atcMediator.informCondition(this.flightList.get(i), "Cleared to land.");
            } else if (i == 1) {
                this.atcMediator.informCondition(this.flightList.get(i), "Wait for land, you is next.");
            } else {
                this.atcMediator.informCondition(this.flightList.get(i), "Wait, soon it will be released to land");
            }
        }
    }

    /**
     * Método que irá analisar se a aeronave que foi passada como parâmetro é
     * elegível ou não ao pouso.
     * 
     * @param flight
     * @return
     */
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
