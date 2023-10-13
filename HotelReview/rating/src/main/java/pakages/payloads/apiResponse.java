package pakages.payloads;

import lombok.*;
import org.springframework.http.HttpStatus;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder//this class automatically creates relevant constrs
public class apiResponse {

    private String message;
    private boolean success;
    private HttpStatus status;


}
