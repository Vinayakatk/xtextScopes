package org.xtext.example.mydsl.ui;

import org.eclipse.xtext.ui.containers.WorkspaceProjectsStateHelper;
import org.eclipse.xtext.ui.shared.contribution.ISharedStateContributionRegistry;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Scopes;

public class MyDslOverridingGuiceModule implements Module {

	@Override
	public void configure(Binder binder) {

		binder.bind(WorkspaceProjectsStateHelper.class).to(LibaryAddingProjectStateHelper.class);
		binder.bind(ISharedStateContributionRegistry.class).to(MyDslSharedStateContributionRegistryImpl.class)
				.in(Scopes.SINGLETON);

	}

}