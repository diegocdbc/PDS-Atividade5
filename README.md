# PDS-Atividade5

## Observer

### Objetos:

Flight: Aeronave
Runway: Pista.
ATCMediator: Torre.
OutsourcedTeam: Equipe de apoio.

### Como foi aplicado o padrão:

1- Flight(subscriber) notifica(se inscreve no Publisher) intenção de pouso.
	- Através do método .contactTower()
2- ATC/Torre(Publisher) obtem armazena o registro(flightList) de todos os interessados(subscriber: Flights) no evento.
	- O Evento é o fato de disponibilização da pista.
	- Equipe de de apoio(OST) e a pista que disponibilizam a pista para pouso.
    - Toda vez que a pista estiver disponível, a próxima aeronava a pousar é notificada e quem vai pousar depois dela é alertada.
