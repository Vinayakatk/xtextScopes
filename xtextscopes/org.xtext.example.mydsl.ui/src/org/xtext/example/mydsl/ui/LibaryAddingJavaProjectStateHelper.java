package org.xtext.example.mydsl.ui;

import java.io.File;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.ui.containers.JavaProjectsStateHelper;
import org.eclipse.xtext.ui.containers.WorkspaceProjectsStateHelper;

import com.google.common.collect.Lists;
import com.google.inject.Singleton;

@Singleton
public class LibaryAddingJavaProjectStateHelper extends JavaProjectsStateHelper {

	@Override
	public List<String> initVisibleHandles(String handle) {
		List<String> result = Lists.newArrayList();
		List<String> parentHandles = super.initVisibleHandles(handle);
		result.addAll(parentHandles);
		result.add("LIB");
		System.err.println(result);
		return result;
	}

	@Override
	public Collection<URI> initContainedURIs(String containerHandle) {
		if ("LIB" == containerHandle) {		
			URI createURI = URI.createURI("archive:file:///C:/Users/vinio/Downloads/libx.jar!/libx/Hello.mydsl");
			
			boolean archive = createURI.isArchive();
			return Lists
					.newArrayList(URI.createURI("archive:file:///C:/Users/vinio/Downloads/libx.jar!/libx/Hello.mydsl"));
		}
		return super.initContainedURIs(containerHandle);
	}

}