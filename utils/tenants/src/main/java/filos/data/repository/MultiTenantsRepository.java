package filos.data.repository;

import org.apache.logging.log4j.util.PerformanceSensitive;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.springframework.stereotype.Component;

@Component
public class MultiTenantsRepository {

    @Around("")
    public Object wrapDataAccess(ProceedingJoinPoint point) {
        return null;
    }
}
