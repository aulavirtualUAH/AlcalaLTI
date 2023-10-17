package es.uah.lti.ltiformacion.beans;

import edu.uoc.elc.lti.platform.Member;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * @author antoni@tresipunt.com based on xaracil@uoc.edu
 */
@RequiredArgsConstructor
@Getter
public class NamesRoleBean {
	private final Boolean available;
	private final List<Member> members;
}
