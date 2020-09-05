package passesnger.ticket.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class Ticket {

    private List<Station> stations;

}
