import ATC.ATC;
import ATC.ATCMediator;
import CommandClass.Flight;
import CommandClass.Runway;
import OutsourcedTeam.OutsourcedTeam;

public class MainMediator {

        public static void main(String[] args) {
                ATCMediator atcMediator = new ATC();

                // Componente 1
                Flight f1 = new Flight(atcMediator, "LATAM", "LA4542");
                Flight f2 = new Flight(atcMediator, "GOL", "CB4329");
                Flight f3 = new Flight(atcMediator, "QATAR AIWAYS", "QA1329");
                // Componente 2
                Runway mainRunway = new Runway(atcMediator);

                // Component 3
                OutsourcedTeam ost = new OutsourcedTeam(atcMediator);

                atcMediator.registerRunway(mainRunway);
                atcMediator.registerOST(ost);

                System.out.println("[MAIN]: Contato da aeronave 1....");
                f1.getReady();
                System.out.println();
                System.out.println("[MAIN]: Contato da aeronave 2....");
                f2.getReady();
                System.out.println();
                // System.out.println(atcMediator);

                System.out.println("[MAIN]: Consultando situacao da pista...");
                mainRunway.land();
                System.out.println();

                // Para realizar um novo pouso será necessário acionar a equipe para desembarque
                // a veriguação da pista.
                // ost.startWork();
        }

}
