package passesnger.ticket.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Station {

    private String id;

    private String stationName;

    private int stataionNumber;

    private int distanceFromOrigin;
}
