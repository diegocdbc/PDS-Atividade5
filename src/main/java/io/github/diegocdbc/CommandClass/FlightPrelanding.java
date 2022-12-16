package io.github.diegocdbc.CommandClass;

public interface FlightPrelanding {
    /*
     * Método que será implementado pela classe Flight para que exiba a situação de
     * pouso notificada pelo observer(Fila aérea).
     *
     * @see FlighPrelanding.FlightPrelanding#showSituation()
     */
    void showSituation(String situation);
}
