package es.uah.lti.ltiformacion.beans;

import edu.uoc.elc.lti.tool.deeplinking.Settings;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author antoni@tresipunt.com (based on xaracil@uoc.edu)
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeepLinkBean {
	private Settings settings;
	private List<DeepLinkForm> deepLinks;
}
