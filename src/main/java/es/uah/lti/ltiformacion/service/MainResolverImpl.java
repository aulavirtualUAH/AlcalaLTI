package es.uah.lti.ltiformacion.service;

import edu.uoc.elc.lti.platform.Member;
import edu.uoc.elc.spring.lti.security.Context;
import edu.uoc.elc.spring.lti.security.User;
import edu.uoc.elc.spring.lti.tool.ToolProvider;
import edu.uoc.lti.ags.LineItem;
import es.uah.lti.ltiformacion.beans.AgsBean;
import es.uah.lti.ltiformacion.beans.IndexBean;
import es.uah.lti.ltiformacion.beans.NamesRoleBean;
import es.uah.lti.ltiformacion.service.ags.LineItemVisitor;
import es.uah.lti.ltiformacion.service.ags.MemberVisitor;
import es.uah.lti.ltiformacion.utils.Utils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author antoni@tresipunt.com based on xaracil@uoc.edu
 */
@Service
public class MainResolverImpl implements MainResolver {
	@Override
	public IndexBean getRecap(User user, ToolProvider toolProvider) {
		final List<String> roles = user.getRoles();
		final NamesRoleBean namesRolesServiceInfo = getNamesRoleServiceRecap(toolProvider);
		final AgsBean assignmentAndGradesServiceInfo = getAssignmentGradeServiceRecap(toolProvider);
		return new IndexBean(user, user.getContext(), roles, namesRolesServiceInfo, assignmentAndGradesServiceInfo);
	}

	private NamesRoleBean getNamesRoleServiceRecap(ToolProvider toolProvider) {
		final MemberVisitor memberVisitor = new MemberVisitor(toolProvider);
		final Boolean available = memberVisitor.canGet();
		final List<Member> members = memberVisitor.getAll();
		return new NamesRoleBean(available, members);
	}

	private AgsBean getAssignmentGradeServiceRecap(ToolProvider toolProvider) {
		final LineItemVisitor lineItemVisitor = new LineItemVisitor(toolProvider);
		final Boolean available = lineItemVisitor.canGet();
		final List<LineItem> lineItems = lineItemVisitor.getAll();
		return new AgsBean(available, lineItems);
	}
}
