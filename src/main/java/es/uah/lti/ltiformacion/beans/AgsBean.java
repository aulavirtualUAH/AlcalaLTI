package es.uah.lti.ltiformacion.beans;

import edu.uoc.lti.ags.LineItem;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * @author antoni@tresipunt.com based on xaracil@uoc.edu
 */
@RequiredArgsConstructor
@Getter
public class AgsBean {
	private final Boolean available;
	private final List<LineItem> lineItems;
}
