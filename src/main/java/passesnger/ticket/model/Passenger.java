package passesnger.ticket.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Passenger {

    private String name;

    private int age;

    private String fromStation;

    private String toStation;
}
