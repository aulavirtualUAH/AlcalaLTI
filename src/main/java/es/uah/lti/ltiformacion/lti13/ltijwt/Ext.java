package es.uah.lti.ltiformacion.lti13.ltijwt;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.annotation.Generated;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Generated("com.googlecode.jsonschema2pojo")

/*
     "https://purl.imsglobal.org/spec/lti/claim/ext": {
       "user_username": "user",
       "lms": "moodle-2"
     },
 */
public class Ext {
    @JsonProperty("user_username")
    public String user_username;
    @JsonProperty("lms")
    public String lms;
}
