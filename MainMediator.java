import ATC.ATC;
import ATC.ATCMediator;
import CommandClass.Flight;
import CommandClass.Runway;
import LandingQueueObserver.QueueLandingController;
import OutsourcedTeam.OutsourcedTeam;

public class MainMediator {

        public static void main(String[] args) {
                ATCMediator atcMediator = new ATC();

                // Componente 1 (Flight)
                Flight f1 = new Flight(atcMediator, "LATAM", "LA4542");
                Flight f2 = new Flight(atcMediator, "GOL", "CB4329");
                Flight f3 = new Flight(atcMediator, "QATAR AIWAYS", "QA1329");
                Flight f4 = new Flight(atcMediator, "AZUL", "RJ1227");

                // Componente 2 (Runway)
                Runway mainRunway = new Runway(atcMediator);

                // Component 3 (OutsourcedTeam)
                OutsourcedTeam ost = new OutsourcedTeam(atcMediator);

                // Component 4 (QueueLandingController)
                QueueLandingController airQueue = new QueueLandingController(atcMediator);

                // Mediator registration
                atcMediator.registerRunway(mainRunway);
                atcMediator.registerOST(ost);
                atcMediator.registerAirQueue(airQueue);

                // Execution
                System.out.println("\n[MAIN]: Contato da aeronave 1....");
                f1.contactTower();
                System.out.println();

                System.out.println("\n[MAIN]: Contato da aeronave 2....");
                f2.contactTower();
                System.out.println();

                System.out.println("\n[MAIN]: Contato da aeronave 3....");
                f3.contactTower();
                System.out.println();

                System.out.println("\n[MAIN]: Contato da aeronave 4....");
                f4.contactTower();
                System.out.println();

                System.out.println("\n[MAIN]: Consultando situacao da pista...");
                atcMediator.checkTrackStatus();
                System.out.println();

                System.out.println("\n[MAIN]: Aeronave " + f1 + " indica a torre que irá pousar");
                f1.land();

                System.out.println("\n[MAIN]: Consultando situacao da pista para novo pouso...");
                atcMediator.checkTrackStatus();
                System.out.println();

                System.out.println("\n[MAIN]: Aeronave " + f2 + " indica a torre que irá pousar");
                f2.land();

                System.out.println(
                                "\n[MAIN]: Chamando a torre para solicitar apoio da equipe de solo para viabilizar a pista");
                atcMediator.summonSupportTeam();

                System.out.println("\n[MAIN]: Consultando situacao da pista para novo pouso...");
                atcMediator.checkTrackStatus();
                System.out.println();

                System.out.println("\n[MAIN]: Aeronave " + f2 + " indica a torre que irá pousar");
                f2.land();

                atcMediator.summonSupportTeam();

                System.out.println("\n[MAIN]: Consultando situacao da pista para novo pouso...");
                atcMediator.checkTrackStatus();
                System.out.println();

                System.out.println("\n[MAIN]: Aeronave " + f4 + " tenta pousar sem ser elegível");
                f4.land();

                System.out.println("\n[MAIN]: Aeronave " + f3 + " indica a torre que irá pousar");
                f3.land();

                atcMediator.summonSupportTeam();

                System.out.println("\n[MAIN]: Consultando situacao da pista para novo pouso...");
                atcMediator.checkTrackStatus();
                System.out.println();

                System.out.println("\n[MAIN]: Aeronave " + f4 + " indica a torre que irá pousar");
                f4.land();

                atcMediator.summonSupportTeam();

                System.out.println("\n[MAIN]: Aplicação finalizada com sucesso.\n");
        }

}
