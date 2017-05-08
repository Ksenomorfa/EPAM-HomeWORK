package module2.t7;

import java.lang.annotation.*;
import java.util.Date;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface AnnotatedBoat {
    String authorOfBoat();
    boolean topSecret();
    String validUntil();
}
