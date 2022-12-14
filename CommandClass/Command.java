package CommandClass;

/**
 * Interface que define os métodos que cada avião deverá implementar.
 * Os métodos dizem respeito às ações de pouso de cada avião (vôo)
 * 
 * @author alex
 *
 */
public interface Command {
    /*
     * Método que será implementado pelas classes Flight e Runway relativas ao
     * pouso.
     * 
     * @see CommandClass.Command#land()
     */
    void land();
}
