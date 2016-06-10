package org.xtext.example.mydsl.ui;

import org.eclipse.xtext.builder.impl.IToBeBuiltComputerContribution;
import org.eclipse.xtext.ui.containers.WorkspaceProjectsStateHelper;
import org.eclipse.xtext.ui.shared.contribution.ISharedStateContributionRegistry;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Scopes;

public class ContributingModule implements Module {

	@Override
	public void configure(Binder binder) {

		binder.bind(IToBeBuiltComputerContribution.class).to(LibaryAddingToBeBuiltComputerContribution.class);
		
	}

}
