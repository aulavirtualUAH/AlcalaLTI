package es.uah.lti.ltiformacion.lti13.ltijwt;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.annotation.Generated;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Generated("com.googlecode.jsonschema2pojo")

/*
    "https://purl.imsglobal.org/spec/lti/claim/resource_link": {
        "id": "5",
        "title": "poiuytrewq",
        "description": ""
    },
 */
public class ResourceLink {

	@JsonProperty("id")
	public String id;
	@JsonProperty("title")
	public String title;
	@JsonProperty("description")
	public String description;
}
