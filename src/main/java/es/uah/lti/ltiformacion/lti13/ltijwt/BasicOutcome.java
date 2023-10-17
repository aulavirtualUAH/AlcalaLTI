package es.uah.lti.ltiformacion.lti13.ltijwt;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.annotation.Generated;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Generated("com.googlecode.jsonschema2pojo")

/*
    "https://purl.imsglobal.org/spec/lti/claim/context": {
        "id": "6",
        "label": "12345",
        "title": "qwertyuio",
        "type": [
            "0987654321"
        ]
    },
 */
public class BasicOutcome {

	@JsonProperty("lis_result_sourcedid")
	public String lis_result_sourcedid;
	@JsonProperty("lis_outcome_service_url")
	public String lis_outcome_service_url;
}
