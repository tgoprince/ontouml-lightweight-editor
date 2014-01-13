package br.ufes.inf.nemo.oled.antipattern.wizard;

import java.util.Collection;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.wb.swt.layout.grouplayout.GroupLayout;
import org.eclipse.wb.swt.layout.grouplayout.LayoutStyle;

/**
 * @author Tiago Sales
 * @author John Guerson
 *
 */

public class FinishingPage extends WizardPage {
	
	public List actionsList;
	public Label rulesLabel;
	
	/**
	 * Create the wizard.
	 */
	public FinishingPage() {
		super("Finishing Page");		
		setTitle("Finished.");
		setDescription("");
	}

	@SuppressWarnings("rawtypes")
	public void addActions(Collection<AntiPatternAction> actions)
	{		
		actionsList.removeAll();
		actionsList.setVisible(true);
		for(AntiPatternAction a: actions){
			String str = a.toString();			
			for(String s: str.split("\n")){
				actionsList.add(s);
			}
		}
	}
	
	@Override
	public void setVisible(boolean visible) {	
		super.setVisible(visible);
		if(visible){
			if(((AntipatternWizard)getWizard()).getActions().size()==0)
				hideActionList();
			else
				addActions(((AntipatternWizard)getWizard()).getActions());			
		}		
	}
	
	public void hideActionList()
	{
		actionsList.setVisible(false);
		rulesLabel.setText("Your model was already correct."); 
	}
	
	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);

		setControl(container);
		
		Label introLabel = new Label(container, SWT.NONE);
		introLabel.setText("Congratulations! You successfully verified the antipattern.");
		
		rulesLabel = new Label(container, SWT.NONE);
		rulesLabel.setText("The antipattern characterizes an error and the following actions will be performed to improve your model:");
		
		actionsList = new List(container, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);

		GroupLayout gl_container = new GroupLayout(container);
		gl_container.setHorizontalGroup(
			gl_container.createParallelGroup(GroupLayout.LEADING)
				.add(gl_container.createSequentialGroup()
					.add(gl_container.createParallelGroup(GroupLayout.TRAILING)
						.add(GroupLayout.LEADING, gl_container.createSequentialGroup()
							.addContainerGap()
							.add(actionsList, GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE))
						.add(GroupLayout.LEADING, gl_container.createSequentialGroup()
							.add(10)
							.add(introLabel, GroupLayout.PREFERRED_SIZE, 552, GroupLayout.PREFERRED_SIZE))
						.add(GroupLayout.LEADING, gl_container.createSequentialGroup()
							.addContainerGap()
							.add(rulesLabel)))
					.addContainerGap())
		);
		gl_container.setVerticalGroup(
			gl_container.createParallelGroup(GroupLayout.LEADING)
				.add(gl_container.createSequentialGroup()
					.add(10)
					.add(introLabel)
					.addPreferredGap(LayoutStyle.RELATED)
					.add(rulesLabel)
					.addPreferredGap(LayoutStyle.RELATED)
					.add(actionsList, GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
					.addContainerGap())
		);
		container.setLayout(gl_container);
	}
}