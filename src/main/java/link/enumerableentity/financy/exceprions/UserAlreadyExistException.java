package link.enumerableentity.financy.exceprions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserAlreadyExistException extends ApplicationException{
    public UserAlreadyExistException(String message) {
        super(message);
    }

}
