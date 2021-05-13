package api.inbound;

import java.util.Map;

public interface EmailReceiver {
    void processEmail(String idEmail, Map<String, String> details);
}
