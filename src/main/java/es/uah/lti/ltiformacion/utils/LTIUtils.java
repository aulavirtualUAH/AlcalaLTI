package es.uah.lti.ltiformacion.utils;

import edu.uoc.elc.spring.lti.security.User;
import org.springframework.security.core.GrantedAuthority;

import java.util.stream.Collectors;

public class LTIUtils {


    public static final String ROLE_INSTRUCTOR = "ROLE_INSTRUCTOR";


    public static boolean isInstructor(User user) {
        return user.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList())
                .contains(ROLE_INSTRUCTOR);
    }
}
