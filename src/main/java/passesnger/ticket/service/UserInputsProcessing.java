package passesnger.ticket.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import passesnger.ticket.model.Passenger;
import passesnger.ticket.utilities.StationConstants;

import java.util.Scanner;

@Service
@Slf4j
public class UserInputsProcessing {

    public Passenger geneatePassengerFromInputs() {
        Scanner sc = new Scanner(System.in);
        log.info("Please enter Name:");
        // String input
        String name = sc.nextLine();
        int age;
        do {
            log.info("Please enter Age:");
            while (!sc.hasNextInt()) {
                log.info("That's not a valid Age");
                sc.next();
            }
            age = sc.nextInt();
        } while (age <= 0);
        log.info("Please enter From Station :");
        sc.nextLine();
        String fromStation = sc.nextLine();
        while (!isValidStationName(fromStation)) {
            log.info("Please enter Valid From Station!");
            fromStation = sc.nextLine();
        }
        log.info("Please enter To Station :");
        String toStation = sc.nextLine();
        while (!isValidStationName(toStation)) {
            log.info("Please enter Valid To Station!");
            toStation = sc.nextLine();
        }

        log.info("Please enter 'YES/NO' for return ticket needed or not ?:");
        String returnTicketNeeded = sc.nextLine();
        while (!(returnTicketNeeded.equalsIgnoreCase("YES") ||returnTicketNeeded.equalsIgnoreCase("NO"))) {
            log.info("Please enter Valid 'YES/NO'for return ticket needed or not ?");
            returnTicketNeeded = sc.nextLine();
        }

        return Passenger.builder().age(age).fromStation(fromStation).toStation(toStation).name(name).build();
    }

    private static boolean isValidStationName(String stationName) {
        for (StationConstants s : StationConstants.values()) {
            if (s.stationName.equalsIgnoreCase(stationName)) {
                return true;
            }
        }
        return false;
    }
}
