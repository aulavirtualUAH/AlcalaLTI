package es.uah.lti.ltiformacion.beans;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.net.URL;

/**
 * @author antoni@tresipunt.com (based on xaracil@uoc.edu)
 */
@RequiredArgsConstructor
@Getter
public class DeepLinkCreationResponseBean {
	private final String JWT;
	private final URL url;
}
