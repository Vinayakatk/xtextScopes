package org.xtext.example.mydsl.ui;
import org.eclipse.xtext.ui.shared.internal.SharedContributionWithJDT;
import org.eclipse.xtext.ui.shared.internal.SharedStateContributionRegistryImpl;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.util.Modules;

@SuppressWarnings("restriction")
public class MyDslSharedStateContributionRegistryImpl extends SharedStateContributionRegistryImpl {

	@Inject
	public MyDslSharedStateContributionRegistryImpl(Injector injector) {
		super(injector);
	}

	@Override
	protected Module getWrappedModule(Module childModule) {
		if (childModule instanceof SharedContributionWithJDT) {
			return super.getWrappedModule(
					Modules.override(childModule).with(new CustomSharedContributionWithJDTModule()));
		}
		return super.getWrappedModule(childModule);
	}

}