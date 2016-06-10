package org.xtext.example.mydsl;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.DefaultGlobalScopeProvider;
import org.eclipse.xtext.scoping.impl.SimpleScope;
import org.eclipse.xtext.util.StringInputStream;

import com.google.common.base.Predicate;
import com.google.inject.Inject;

class MyDslGlobalScopeProvider extends DefaultGlobalScopeProvider {

	@Inject
	IResourceDescription.Manager mgr;

	@Override
	public IScope getScope(Resource resource, EReference reference, Predicate<IEObjectDescription> filter) {

		URI libaryResourceURI = URI.createURI("dummy://demo/test.mydsl");
		Resource libaryResource = resource.getResourceSet().getResource(libaryResourceURI, false);
		if (libaryResource == null) {
			System.out.println("LOOOOOOOOAAAAADDDDD");
			libaryResource = resource.getResourceSet().createResource(libaryResourceURI);
			try {
				libaryResource.load(new StringInputStream("Hello Libary1! Hello Libary2 from Libary1!"), null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		IResourceDescription resourceDescription = mgr.getResourceDescription(libaryResource);
		Iterable<IEObjectDescription> libary = resourceDescription.getExportedObjects();
		return new SimpleScope(super.getScope(resource, reference, filter), libary, false);

		
	}

}
