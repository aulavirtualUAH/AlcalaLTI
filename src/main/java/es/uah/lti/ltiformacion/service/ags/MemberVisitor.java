package es.uah.lti.ltiformacion.service.ags;

import edu.uoc.elc.lti.platform.Member;
import edu.uoc.elc.spring.lti.tool.NamesRoleServiceProvider;
import edu.uoc.elc.spring.lti.tool.ToolProvider;
import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.List;

/**
 * @author antoni@tresipunt.com based on xaracil@uoc.edu
 */
@RequiredArgsConstructor
public class MemberVisitor {
	private final ToolProvider toolProvider;

	public List<Member> getAll() {
		final NamesRoleServiceProvider namesRoleServiceProvider = toolProvider.getNamesRoleServiceProvider();
		return getFromNameServiceProvider(namesRoleServiceProvider);
	}

	public List<Member> getAllLearners() {
		final NamesRoleServiceProvider namesRoleServiceProvider = toolProvider.getNamesRoleServiceProvider();
		return getLearnersFromNameServiceProvider(namesRoleServiceProvider);
	}

	public boolean canGet() {
		final NamesRoleServiceProvider namesRoleServiceProvider = toolProvider.getNamesRoleServiceProvider();
		return namesRoleServiceProvider.hasNameRoleService();
	}

	private List<Member> getFromNameServiceProvider(NamesRoleServiceProvider namesRoleServiceProvider) {
		try {
			return namesRoleServiceProvider.getMembers(false);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return Collections.EMPTY_LIST;
	}
	private List<Member> getLearnersFromNameServiceProvider(NamesRoleServiceProvider namesRoleServiceProvider) {
		try {
			return namesRoleServiceProvider.getLearners(false);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return Collections.EMPTY_LIST;
	}
}
