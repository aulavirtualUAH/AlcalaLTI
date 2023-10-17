package es.uah.lti.ltiformacion.beans;

import edu.uoc.elc.lti.platform.Member;
import edu.uoc.lti.ags.LineItem;
import edu.uoc.lti.ags.Result;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * @author antoni@tresipunt.com based on xaracil@uoc.edu
 */
@RequiredArgsConstructor
@Getter
public class LineItemBean {
	private final LineItem lineItem;
	private final List<Member> members;
	private final List<Result> results;
}
