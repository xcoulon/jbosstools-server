/*
 * JBoss, Home of Professional Open Source
 * Copyright 2006, JBoss Inc., and individual contributors as indicated
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.jboss.ide.eclipse.as.ui.perspective;

import org.eclipse.debug.ui.IDebugUIConstants;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.search.ui.NewSearchUI;
import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.eclipse.ui.console.IConsoleConstants;
import org.eclipse.ui.progress.IProgressConstants;

public class ASPerspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		// TODO Auto-generated method stub
		
//		PerspectiveLayoutInheritor inheritor = new PerspectiveLayoutInheritor(layout);
//		String javaPerspectiveId = "org.eclipse.jdt.ui.JavaPerspective";
//		inheritor.inheritInitialLayout(javaPerspectiveId);
//		inheritor.inheritExtensions(javaPerspectiveId, PerspectiveLayoutInheritor.VIEWS);

		
 		String editorArea = layout.getEditorArea();
		
		IFolderLayout folder= layout.createFolder("left", IPageLayout.LEFT, (float)0.25, editorArea); //$NON-NLS-1$
		folder.addView(JavaUI.ID_PACKAGES);
		folder.addView(JavaUI.ID_TYPE_HIERARCHY);
		folder.addPlaceholder(IPageLayout.ID_RES_NAV);
		
		IFolderLayout outputfolder= layout.createFolder("bottom", IPageLayout.BOTTOM, (float)0.75, editorArea); //$NON-NLS-1$
		outputfolder.addView(IPageLayout.ID_PROBLEM_VIEW);
		outputfolder.addView(JavaUI.ID_JAVADOC_VIEW);
		outputfolder.addView(JavaUI.ID_SOURCE_VIEW);
		outputfolder.addView(IConsoleConstants.ID_CONSOLE_VIEW);
		outputfolder.addView("org.eclipse.ui.views.PropertySheet");
		outputfolder.addPlaceholder(NewSearchUI.SEARCH_VIEW_ID);
		outputfolder.addPlaceholder(IPageLayout.ID_BOOKMARKS);
		outputfolder.addPlaceholder(IProgressConstants.PROGRESS_VIEW_ID);
		
		layout.addView(IPageLayout.ID_OUTLINE, IPageLayout.RIGHT, (float)0.75, editorArea);
		
		IFolderLayout serverFolder = layout.createFolder("leftBottom", IPageLayout.BOTTOM, (float)0.60, "left"); //$NON-NLS-1$
		serverFolder.addView("org.jboss.ide.eclipse.as.ui.views.JBossServerView");
		
		
		layout.addActionSet(IDebugUIConstants.LAUNCH_ACTION_SET);
		layout.addActionSet(JavaUI.ID_ACTION_SET);
		layout.addActionSet(JavaUI.ID_ELEMENT_CREATION_ACTION_SET);
		layout.addActionSet(IPageLayout.ID_NAVIGATE_ACTION_SET);
		
		// views - java
		layout.addShowViewShortcut(JavaUI.ID_PACKAGES);
		layout.addShowViewShortcut(JavaUI.ID_TYPE_HIERARCHY);
		layout.addShowViewShortcut(JavaUI.ID_SOURCE_VIEW);
		layout.addShowViewShortcut(JavaUI.ID_JAVADOC_VIEW);

		// views - search
		layout.addShowViewShortcut(NewSearchUI.SEARCH_VIEW_ID);
		
		// views - debugging
		layout.addShowViewShortcut(IConsoleConstants.ID_CONSOLE_VIEW);

		// views - standard workbench
		layout.addShowViewShortcut(IPageLayout.ID_OUTLINE);
		layout.addShowViewShortcut(IPageLayout.ID_PROBLEM_VIEW);
		layout.addShowViewShortcut(IPageLayout.ID_RES_NAV);
		layout.addShowViewShortcut(IPageLayout.ID_TASK_LIST);
		layout.addShowViewShortcut(IProgressConstants.PROGRESS_VIEW_ID);
				
		// new actions - Java project creation wizard
		layout.addNewWizardShortcut("org.eclipse.jdt.ui.wizards.NewPackageCreationWizard"); //$NON-NLS-1$
		layout.addNewWizardShortcut("org.jboss.ide.eclipse.as.ui.MBeanComponents");
		layout.addNewWizardShortcut("org.eclipse.jdt.ui.wizards.NewClassCreationWizard"); //$NON-NLS-1$
		layout.addNewWizardShortcut("org.eclipse.jdt.ui.wizards.NewInterfaceCreationWizard"); //$NON-NLS-1$
		layout.addNewWizardShortcut("org.eclipse.jdt.ui.wizards.NewEnumCreationWizard"); //$NON-NLS-1$
		layout.addNewWizardShortcut("org.eclipse.jdt.ui.wizards.NewAnnotationCreationWizard"); //$NON-NLS-1$
		layout.addNewWizardShortcut("org.eclipse.jdt.ui.wizards.NewSourceFolderCreationWizard");	 //$NON-NLS-1$
		layout.addNewWizardShortcut("org.eclipse.jdt.ui.wizards.NewSnippetFileCreationWizard"); //$NON-NLS-1$
		layout.addNewWizardShortcut("org.eclipse.ui.wizards.new.folder");//$NON-NLS-1$
		layout.addNewWizardShortcut("org.eclipse.ui.wizards.new.file");//$NON-NLS-1$
		layout.addNewWizardShortcut("org.eclipse.ui.editors.wizards.UntitledTextFileWizard");//$NON-NLS-1$
		
		
		// perspectives
		layout.addPerspectiveShortcut("org.eclipse.debug.ui.DebugPerspective");
		layout.addPerspectiveShortcut("org.jboss.ide.eclipse.jbosscache.perspective2");
		layout.addPerspectiveShortcut("org.drools.ide.DroolsPerspective");
		layout.addPerspectiveShortcut("org.hibernate.eclipse.console.HibernateConsolePerspective");
		// Other JBoss perspectives
		
	}
}
