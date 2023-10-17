package es.uah.lti.ltiformacion.components.jwtkeystore;

import edu.uoc.elc.lti.tool.Registration;
import es.uah.lti.ltiformacion.beans.LmsTool;
import es.uah.lti.ltiformacion.components.toolmanager.ToolManager;
import es.uah.lti.ltiformacion.lti13.LTI13KeySetUtil;
import es.uah.lti.ltiformacion.lti13.LTI13Util;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;

@Component("keySetManager")
@Slf4j
public class KeySetManager {

    final private ToolManager toolManager;

    KeySetManager(ToolManager toolManager) {
        this.toolManager = toolManager;
    }


    /**
     * Get the keyset for a specific tool
     * @param toolId The tool Id
     * @return The generated keyset
     */
    public JSONObject getKeySet(String toolId) {
        return getKeySet(toolManager.getToolById(toolId));
    }

    /**
     * Get the keyset for a specific tool
     * @param tool The tool to query for keyset
     * @return The generated keyset
     */
    public JSONObject getKeySet(LmsTool tool) {
        String siteId = null;  // Full bypass mode
//        String toolPublicKey = this.managerAWSKMS.getToolPublicKey(tool);
        String publicSerialized = tool.getPublicKey();
//        String publicSerialized = toolPublicKey;
//        if (publicSerialized == null) {
//            response.setHeader(ERROR_DETAIL, "Client has no public key");
//            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//            log.error("Client_id={} has no public key", tool_id);
//            return;
//        }
        Key publicKey = LTI13Util.string2PublicKey(publicSerialized);
//        if (publicKey == null) {
//            response.setHeader(ERROR_DETAIL, "Client public key deserialization error");
//            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//            log.error("Client_id={} deserialization error", tool_id);
//            return;
//        }
        RSAPublicKey rsaPublic = (RSAPublicKey) publicKey;
        JSONObject keySetJSON = null;
        try {
            keySetJSON = LTI13KeySetUtil.getKeySetJSON(rsaPublic);
        } catch (NoSuchAlgorithmException ex) {
//            response.setHeader(ERROR_DETAIL, "NoSuchAlgorithmException");
//            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            log.error("Client_id={} NoSuchAlgorithmException", tool.getId());
            return null;
        }
        return keySetJSON;
    }
    /**
     * Get the keyset for a specific tool
     * @param tool The tool to query for keyset
     * @return The generated keyset
     */
    public JSONObject getKeySet(Registration tool) {
        String publicSerialized = tool.getKeySet().getKeys().get(0).getPublicKey();
        String kid = tool.getKeySet().getKeys().get(0).getId();
        Key publicKey = LTI13Util.string2PublicKey(publicSerialized);
        RSAPublicKey rsaPublic = (RSAPublicKey) publicKey;
        JSONObject keySetJSON = null;
        try {
            keySetJSON = LTI13KeySetUtil.getKeySetJSON(kid, rsaPublic);
        } catch (NoSuchAlgorithmException ex) {
            log.error("Client_id={} NoSuchAlgorithmException", tool.getId());
            return null;
        }
        return keySetJSON;
    }
}