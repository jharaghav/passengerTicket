package passesnger.ticket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import passesnger.ticket.model.Passenger;
import passesnger.ticket.model.Station;
import passesnger.ticket.model.Ticket;
import passesnger.ticket.service.InitializeStations;
import passesnger.ticket.service.TicketOuputProcessing;
import passesnger.ticket.service.UserInputsProcessing;

import java.time.Instant;
import java.util.List;

@SpringBootApplication
@Slf4j
public class TicketApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(TicketApplication.class, args);
        InitializeStations initializeStations = applicationContext.getBean(InitializeStations.class);
        Ticket ticket = initializeStations.populateStations();
        List<Station> stationList = ticket.getStations();
        UserInputsProcessing userInputsProcessing = applicationContext.getBean(UserInputsProcessing.class);
        Passenger passenger = userInputsProcessing.geneatePassengerFromInputs();
        TicketOuputProcessing ticketOuputProcessing = applicationContext.getBean(TicketOuputProcessing.class);
        int price = ticketOuputProcessing.getTotalPrice(passenger, stationList);
        int numberOfstops = ticketOuputProcessing.getTotalStops();
        displayOutput(passenger.getFromStation(), passenger.getToStation(), numberOfstops, price);
    }

    public static void displayOutput(String fromStation, String toStation, int numberOfstops, int price) {
        log.info("Purchase Date & Time : {} ", Instant.now());
        log.info("From Station : {}", fromStation);
        log.info("To Station : {}", toStation);
        log.info("Number Of Stops : {} Stops", numberOfstops);
        log.info("Price : Rs{}", price);
    }
}
