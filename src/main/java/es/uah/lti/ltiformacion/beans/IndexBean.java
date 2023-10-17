package es.uah.lti.ltiformacion.beans;

import edu.uoc.elc.spring.lti.security.Context;
import edu.uoc.elc.spring.lti.security.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * @author antoni@tresipunt.com based on xaracil@uoc.edu
 */
@Getter
@RequiredArgsConstructor
public class IndexBean {
	private final User user;
	private final Context context;
	private final List<String> roles;
	private final NamesRoleBean namesRoleService;
	private final AgsBean agsService;
}
