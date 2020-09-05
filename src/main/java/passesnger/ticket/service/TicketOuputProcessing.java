package passesnger.ticket.service;

import org.springframework.stereotype.Service;
import passesnger.ticket.model.Passenger;
import passesnger.ticket.model.Station;
import passesnger.ticket.utilities.PriceConstants;
import passesnger.ticket.utilities.StationRuleConstants;

import java.util.List;

@Service
public class TicketOuputProcessing {

    private int numberOfStops = 0;

    public int getTotalPrice(Passenger passenger, List<Station> stationList) {
        int fromStationNumber = 0;
        int toStationNumber = 0;
        int totalPrice = 0;
        boolean isCompleteJourney;
        for (Station station : stationList) {
            if (passenger.getFromStation().equalsIgnoreCase(station.getStationName())) {
                fromStationNumber = station.getStataionNumber();
            }
            if (passenger.getToStation().equalsIgnoreCase(station.getStationName())) {
                toStationNumber = station.getStataionNumber();
            }
        }
        isCompleteJourney = isCompleteJourney(fromStationNumber, toStationNumber, stationList);
        if (isCompleteJourney) {
            return PriceConstants.TOTAL_PRICE_FOR_END_TO_END;
        } else {
            totalPrice = getPrice(fromStationNumber, toStationNumber);
        }
        numberOfStops = Math.abs(fromStationNumber - toStationNumber);
        return totalPrice;
    }

    private boolean isCompleteJourney(int fromStationNumber, int toStationNumber, List<Station> stationList) {
        if (Math.abs(fromStationNumber - toStationNumber) == stationList.size()) {
            return true;
        }
        return false;
    }

    private int getPrice(int fromStationNumber, int toStationNumber) {
        int totalPrice = 0;
        int stationNumberDifference = Math.abs(fromStationNumber - toStationNumber);
        if (stationNumberDifference <= StationRuleConstants.NUMBER_OF_STATIONS_FOR_FIXED_BASE_PRICE) {
            totalPrice = PriceConstants.BASE_PRICE;
        } else {
            int variedPriceStationNumber = stationNumberDifference - StationRuleConstants.NUMBER_OF_STATIONS_FOR_FIXED_BASE_PRICE;
            int mod = variedPriceStationNumber % StationRuleConstants.NUMBER_OF_STATIONS_FOR_VARY_PRICE;
            if (mod == 0) {
                totalPrice = PriceConstants.BASE_PRICE + (variedPriceStationNumber / StationRuleConstants.NUMBER_OF_STATIONS_FOR_VARY_PRICE * PriceConstants.EXTRA_PRICE_FOR_EVERY_FIVE_STATIONS);
            } else if (variedPriceStationNumber >= StationRuleConstants.NUMBER_OF_STATIONS_FOR_VARY_PRICE) {
                totalPrice = PriceConstants.BASE_PRICE + (variedPriceStationNumber / StationRuleConstants.NUMBER_OF_STATIONS_FOR_VARY_PRICE * PriceConstants.EXTRA_PRICE_FOR_EVERY_FIVE_STATIONS) + PriceConstants.EXTRA_PRICE_FOR_EVERY_FIVE_STATIONS;
            } else {
                totalPrice = PriceConstants.BASE_PRICE + PriceConstants.EXTRA_PRICE_FOR_EVERY_FIVE_STATIONS + PriceConstants.EXTRA_PRICE_FOR_EVERY_FIVE_STATIONS;
            }
        }
        return totalPrice;
    }


    public int getTotalStops() {
        return numberOfStops;
    }
}
