package es.uah.lti.ltiformacion.beans;

import lombok.Data;

/**
 * @author antoni@tresipunt.com (based on xaracil@uoc.edu)
 */
@Data
public class DeepLinkForm {
	private String title;
	private String text;
	private String url;
	private String documentTarget;
	private String type;
	private String mediaType;
}
