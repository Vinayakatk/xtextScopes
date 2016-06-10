package org.xtext.example.mydsl.ui;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.builder.impl.IToBeBuiltComputerContribution;
import org.eclipse.xtext.builder.impl.ToBeBuilt;

public class LibaryAddingToBeBuiltComputerContribution implements IToBeBuiltComputerContribution {

	@Override
	public void removeProject(ToBeBuilt toBeBuilt, IProject project, IProgressMonitor monitor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateProject(ToBeBuilt toBeBuilt, IProject project, IProgressMonitor monitor) throws CoreException {

		toBeBuilt.getToBeUpdated()
				.add(URI.createURI("archive:file:///C:/Users/vinio/Downloads/libx.jar!/libx/Hello.mydsl"));

	}

	@Override
	public boolean removeStorage(ToBeBuilt toBeBuilt, IStorage storage, IProgressMonitor monitor) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateStorage(ToBeBuilt toBeBuilt, IStorage storage, IProgressMonitor monitor) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isPossiblyHandled(IStorage storage) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isRejected(IFolder folder) {
		// TODO Auto-generated method stub
		return false;
	}

}