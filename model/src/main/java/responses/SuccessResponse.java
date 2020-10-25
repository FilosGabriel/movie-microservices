package responses;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class SuccessResponse<T> extends ResponseEntity<T> {
    public SuccessResponse() {
        super(HttpStatus.OK);
    }
}

