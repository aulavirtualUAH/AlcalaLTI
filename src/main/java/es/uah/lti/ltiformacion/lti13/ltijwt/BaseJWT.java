package es.uah.lti.ltiformacion.lti13.ltijwt;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseJWT {
    @JsonProperty("iss")
    public String issuer;  // The url of the LMS or product
    @JsonProperty("aud")
    public String audience;  // The Client ID
    @JsonProperty("sub")
    public String subject;   // The user_id
    @JsonProperty("nonce")
    public String nonce;
    @JsonProperty("iat")
    public Long issued;
    @JsonProperty("exp")
    public Long expires;
}
