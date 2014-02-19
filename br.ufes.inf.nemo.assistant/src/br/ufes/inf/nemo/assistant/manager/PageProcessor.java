package br.ufes.inf.nemo.assistant.manager;

import java.util.ArrayList;

import RefOntoUML.Classifier;
import RefOntoUML.Generalization;
import RefOntoUML.GeneralizationSet;
import RefOntoUML.Package;
import br.ufes.inf.nemo.assistant.util.StereotypeOntoUMLEnum;
import br.ufes.inf.nemo.assistant.util.UtilAssistant;
import br.ufes.inf.nemo.assistant.wizard.pageassistant.NewClass;
import br.ufes.inf.nemo.assistant.wizard.pageassistant.NewGeneralizationSet;
import br.ufes.inf.nemo.assistant.wizard.pageassistant.NewGenericRelation;
import br.ufes.inf.nemo.assistant.wizard.pageassistant.NewPhase;
import br.ufes.inf.nemo.assistant.wizard.pageassistant.NewRelator;
import br.ufes.inf.nemo.common.ontoumlfixer.Fix;
import br.ufes.inf.nemo.common.ontoumlfixer.OutcomeFixer;
import br.ufes.inf.nemo.common.ontoumlfixer.OutcomeFixer.ClassStereotype;
import br.ufes.inf.nemo.common.ontoumlfixer.OutcomeFixer.RelationStereotype;

public class PageProcessor{
	private OutcomeFixer outcomeFixer;

	private Fix fix = new Fix();
	public Fix getFix(){
		return fix;
	}

	private Classifier source;
	public void setSourceClass(Classifier source) {
		this.source = source; 
	}

	private PatternOperator patternOperator;
	public PageProcessor(PatternOperator operator) {
		patternOperator = operator;
	}

	public void setRootPackage(Package root) {
		if(outcomeFixer == null){
			outcomeFixer = new OutcomeFixer(root);
		}
	}


	/* Process */
	public void process(NewGenericRelation page) {
		System.out.println(page.toString());
	}

	public void process(NewPhase page) {
		/*
			factory.createComment()
			criar comentario para as rules ou ocls?
		 */ 
		//for each page.getPhases()
		ArrayList<String[]> phasesString = page.getPhases();
		for (String[] phaseString : phasesString) {
			//phase = new Phase
			Classifier phase = (Classifier)outcomeFixer.createClass(ClassStereotype.PHASE);
			phase.setName(phaseString[0]);

			//phase.container = source.container
			outcomeFixer.copyContainer(source, phase);

			//add(phase)
			fix.includeAdded(phase);
		}
	}

	public void process(NewClass page) {
		//Set the new name
		source.setName(page.getClassName());
		if(UtilAssistant.getStereotypeFromClassifier(source) != StereotypeOntoUMLEnum.valueOf(page.getStereotype().toUpperCase())){
			//source.stereotype != page.stereotype
			//change the source stereotype
			Fix f = outcomeFixer.changeClassStereotypeTo(source, ClassStereotype.valueOf(page.getStereotype().toUpperCase()));
			fix.addAll(f);
		}
		//include all modifications
		fix.includeModified(source);
	}

	public void process(NewRelator page){
		System.out.println(page.toString());
	}

	public void process(NewGeneralizationSet page) {
		if(page.isListSpecifics()){
			//if page.isListSpecific
			ArrayList<Classifier> specificList = new ArrayList<>();

			//general = page.getGeneral()
			Classifier general = patternOperator.getClassifierForStringRepresentationClass(page.getGeneral());
			
			//for each specific in page.getListSpecifics()
			ArrayList<String[]> specificsStringList = page.getListSpecifics();
			for (String[] specificString : specificsStringList) {
				//classifier = page.getSpecific(x)
				RefOntoUML.Classifier specific = patternOperator.getClassifierForStringRepresentationClass(specificString[0]);
				//source.container = general.container
				outcomeFixer.copyContainer(general, specific);
				fix.includeModified(specific);	
				specificList.add(specific);
			}

			//delete(source)
			Fix f = outcomeFixer.deleteElement(source);
			fix.addAll(f);

			ArrayList<Generalization> genList = new ArrayList<>();

			//for each specific
			for (Classifier specific : specificList) {
				//gen.general  = general
				//gen.specific = source
				Generalization gen = (Generalization) outcomeFixer.createRelationship(RelationStereotype.GENERALIZATION);
				gen.setGeneral(general);
				gen.setSpecific(specific);
				fix.includeAdded(gen);
				genList.add(gen);
			}

			//genSet = page.getGeneralizationSet()
			GeneralizationSet genSet = patternOperator.getGeneralizationSetByName(page.getGeneralizationSet());

			if(genSet == null){
				//a new genSet
				Fix f2 = outcomeFixer.createGeneralizationSet(genList, page.getIsDisjoint(), page.getIsComplete(), page.getGeneralizationSet());
				genSet = (GeneralizationSet)f.getAdded().get(0);
				fix.addAll(f2);
			}else{
				//other genSet selected
				//update metaproperties
				genSet.setIsDisjoint(page.getIsDisjoint());
				genSet.setIsCovering(page.getIsComplete());

				//genSet.addAll(gens)
				genSet.getGeneralization().addAll(genList);
			}
			fix.includeModified(genSet);
		}else{
			//if page.isGeneral
			//source.container = general.container
			RefOntoUML.Classifier general = patternOperator.getClassifierForStringRepresentationClass(page.getGeneral()); 
			outcomeFixer.copyContainer(general, source);
			fix.includeModified(source);

			//gen.general  = general
			//gen.specific = source
			Generalization gen = (Generalization) outcomeFixer.createRelationship(RelationStereotype.GENERALIZATION);
			gen.setGeneral(general);
			gen.setSpecific(source);
			fix.includeAdded(gen);

			//genSet.add(gen)
			GeneralizationSet genSet = patternOperator.getGeneralizationSetByName(page.getGeneralizationSet());
			if(genSet == null){
				//a new genSet
				ArrayList<Generalization> gens = new ArrayList<>();
				gens.add(gen);
				Fix f = outcomeFixer.createGeneralizationSet(gens, page.getIsDisjoint(), page.getIsComplete(), page.getGeneralizationSet());
				genSet = (GeneralizationSet)f.getAdded().get(0);
				fix.addAll(f);
			}else{
				//modifications in meta properties
				genSet.setIsDisjoint(page.getIsDisjoint());
				genSet.setIsCovering(page.getIsComplete());
			}
			genSet.getGeneralization().add(gen);
			fix.includeModified(genSet);
		}
	}
}