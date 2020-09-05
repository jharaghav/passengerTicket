package passesnger.ticket.service;

import org.springframework.stereotype.Service;
import passesnger.ticket.model.Passenger;
import passesnger.ticket.utilities.StationConstants;

import java.util.Scanner;

@Service
public class UserInputsProcessing {

    public Passenger geneatePassengerFromInputs() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter Name:");
        // String input
        String name = sc.nextLine();
        int age;
        do {
            System.out.println("Please enter Age:");
            while (!sc.hasNextInt()) {
                System.out.println("That's not a valid Age");
                sc.next();
            }
            age = sc.nextInt();
        } while (age <= 0);
        System.out.println("Please enter From Station :");
        sc.nextLine();
        String fromStation = sc.nextLine();
        while (!isValidStationName(fromStation)) {
            System.out.println("Please enter Valid From Station!");
            fromStation = sc.nextLine();
        }
        System.out.println("Please enter To Station :");
        String toStation = sc.nextLine();
        while (!isValidStationName(toStation)) {
            System.out.println("Please enter Valid To Station!");
            toStation = sc.nextLine();
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
