package es.uah.lti.ltiformacion.beans;

import lombok.Getter;
import lombok.Setter;

public class LmsTool {

    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    private String clientId;

    @Getter
    @Setter
    private String deploymentId;

    @Getter
    @Setter
    private String loginUrl;

    @Getter
    @Setter
    private String issuer;

    @Getter
    @Setter
    private String targetLinkUri;

    @Getter
    @Setter
    private String privateKey;

    @Getter
    @Setter
    private String publicKey;

    @Getter
    @Setter
    private String awsKeyId;
}
