package org.xtext.example.mydsl.ui;
import org.eclipse.xtext.ui.containers.JavaProjectsStateHelper;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Scopes;

@SuppressWarnings("restriction")
public class CustomSharedContributionWithJDTModule implements Module {

	@Override
	public void configure(Binder binder) {
		binder.install(new Module() {

			@Override
			public void configure(Binder binder) {
				binder.bind(JavaProjectsStateHelper.class).to(LibaryAddingJavaProjectStateHelper.class).in(Scopes.SINGLETON);
				
			}
			
		});
		
	}

}
