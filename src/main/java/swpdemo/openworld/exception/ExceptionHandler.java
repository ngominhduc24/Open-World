package swpdemo.openworld.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

public class ExceptionHandler {
    /**
     * Handle UnsupportedOperationException
     */
    @org.springframework.web.bind.annotation.ExceptionHandler(UnsupportedOperationException.class)
    @ResponseStatus(value = HttpStatus.HTTP_VERSION_NOT_SUPPORTED)
    public Map<String, Object> UnsupportedOperationException(Exception ex, WebRequest request) {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("locale", request.getLocale().toString());

        return resultMap;
    }
}
