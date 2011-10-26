package de.chandelier.vocatra;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ExpandBar;
import org.eclipse.swt.widgets.ExpandItem;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

public class View extends ViewPart {
	public static final String ID = "de.chandelier.vocatra.view";

	private TableViewer viewer;

		/**
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 */
	public void createPartControl(Composite parent) {
		ExpandBar expandBar = new ExpandBar(parent, SWT.None);
		ExpandItem vocabularyItem = new ExpandItem(expandBar, SWT.NONE);
		vocabularyItem.setText("Vocabulary");
		Composite composite = new Composite(expandBar, SWT.BORDER);
		composite.setLayout(new FillLayout());
		viewer = new TableViewer(composite);
		viewer.setContentProvider(new ArrayContentProvider());
		viewer.setLabelProvider(new LabelProvider());
		viewer.setInput(new String[]{"Vokabeln Lektion 1","Vokabeln Lektion 2","Vokabeln Lektion 3"});
		vocabularyItem.setHeight(composite.computeSize(SWT.DEFAULT, SWT.DEFAULT).y);
		vocabularyItem.setControl(composite);
		
		Composite grammarComposite = new Composite(expandBar, SWT.BORDER);
		grammarComposite.setLayout(new FillLayout());
		TableViewer gramarViewer = new TableViewer(grammarComposite);
		gramarViewer.setContentProvider(new ArrayContentProvider());
		gramarViewer.setLabelProvider(new LabelProvider());
		gramarViewer.setInput(new String[]{"Grammatik Lektion 1","Grammatik Lektion 2","Grammatik Lektion 3"});
		ExpandItem grammarItem = new ExpandItem(expandBar, SWT.NONE);
		grammarItem.setText("Grammar");
		grammarItem.setHeight(grammarComposite.computeSize(SWT.DEFAULT, SWT.DEFAULT).y);
		grammarItem.setControl(grammarComposite);
		
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
//		viewer.getControl().setFocus();
	}
}