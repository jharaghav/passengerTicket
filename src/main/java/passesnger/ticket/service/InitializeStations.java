package passesnger.ticket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import passesnger.ticket.model.Station;
import passesnger.ticket.model.Ticket;
import passesnger.ticket.utilities.StationConstants;

import java.util.ArrayList;
import java.util.List;

@Service
public class InitializeStations {


    @Autowired
    private Ticket ticket;

    public Ticket populateStations() {
        List<Station> stations = new ArrayList<>();
        String stationId = "ST_";
        int stationNumber = 1;
        for (StationConstants s : StationConstants.values()) {
            Station station = Station.builder()
                    .id(stationId + stationNumber)
                    .stataionNumber(stationNumber)
                    .stationName(s.stationName)
                    .distanceFromOrigin(0)
                    .build();
            stationNumber++;
            stations.add(station);
        }
        ticket.setStations(stations);
        return ticket;
    }
}
