import ATCMediator.ATC;
import ATCMediator.ATCMediator;
import CommandClass.Flight;
import CommandClass.Runway;
import OutsourcedTeam.OutsourcedTeam;

public class MainMediator {

        public static void main(String[] args) {
                ATCMediator atcMediator = new ATC();

                // Componente 1
                Flight f1 = new Flight(atcMediator, "LATAM", "LA4542");
                Flight f2 = new Flight(atcMediator, "GOL", "GL1273");

                // Componente 2
                Runway mainRunway = new Runway(atcMediator);

                // Componente 3
                OutsourcedTeam ost = new OutsourcedTeam(atcMediator);

                atcMediator.registerFlight(f1);
                atcMediator.registerFlight(f2);
                atcMediator.registerOST(ost);
                atcMediator.registerRunway(mainRunway);

                System.out.println(">> Contato da aeronave 1....");
                f1.getReady();
                System.out.println();

                System.out.println(">> Consultando situacao da pista....");
                mainRunway.land();
                System.out.println();

                f1.land();

                System.out.println(">> Contato da aeronave 2....");
                f2.getReady();
                System.out.println();

                System.out.println(">> Consultando situacao da pista....");
                mainRunway.land();
                System.out.println();

                System.out.println(">> Equipe de suporte entrando em ação para viabilizar novo pouso");
                atcMediator.summonSupportTeam();

                System.out.println(">> Consultando situacao da pista novamente...");
                mainRunway.land();
                System.out.println();

                f2.land();

        }

}
