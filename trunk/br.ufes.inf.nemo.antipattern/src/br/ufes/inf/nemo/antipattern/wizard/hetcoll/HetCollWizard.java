package br.ufes.inf.nemo.antipattern.wizard.hetcoll;

import br.ufes.inf.nemo.antipattern.hetcoll.HetCollAntipattern;
import br.ufes.inf.nemo.antipattern.hetcoll.HetCollOccurrence;
import br.ufes.inf.nemo.antipattern.wizard.AntiPatternAction;
import br.ufes.inf.nemo.antipattern.wizard.AntipatternWizard;
import br.ufes.inf.nemo.antipattern.wizard.FinishingPage;
import br.ufes.inf.nemo.antipattern.wizard.PresentationPage;

public class HetCollWizard extends AntipatternWizard {

	public HetCollFirstPage firstPage;
	public HetCollSecondPage secondPage;
		
	public HetCollWizard(HetCollOccurrence ap) {
		super(ap,HetCollAntipattern.getAntipatternInfo().name);		
	}

	@Override
	public void addPages() 
	{
		firstPage = new HetCollFirstPage((HetCollOccurrence)ap);
		secondPage = new HetCollSecondPage((HetCollOccurrence)ap);
			
		finishing = new FinishingPage();
		options = new HetCollRefactoringPage(getAp());
		
		presentation = new PresentationPage(
				HetCollAntipattern.getAntipatternInfo().name,
				HetCollAntipattern.getAntipatternInfo().acronym,
			ap.toString(),
			firstPage,
			options
		);
			
		addPage(presentation);	
		addPage(firstPage);	
		addPage(secondPage);
		addPage(options);
		addPage(finishing);
	}
	
	public HetCollOccurrence getAp() {
		return (HetCollOccurrence)ap;
	}
	
	public HetCollFirstPage getFirstPage()
	{
		return firstPage;
	}
	
	public HetCollSecondPage getSecondPage()
	{
		return secondPage;
	}
	
	@Override
	public boolean performFinish() {
		for(AntiPatternAction<?> action: super.getAllActions())
			action.run();
		
		return true;
	}
}