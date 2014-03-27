package br.ufes.inf.nemo.antipattern.decint;

import java.util.ArrayList;

import RefOntoUML.AntiRigidSortalClass;
import RefOntoUML.Class;
import RefOntoUML.Classifier;
import RefOntoUML.Generalization;
import RefOntoUML.GeneralizationSet;
import RefOntoUML.MixinClass;
import RefOntoUML.Mode;
import RefOntoUML.Relator;
import RefOntoUML.SortalClass;
import RefOntoUML.SubKind;
import RefOntoUML.SubstanceSortal;
import br.ufes.inf.nemo.antipattern.Antipattern;
import br.ufes.inf.nemo.antipattern.AntipatternInfo;
import br.ufes.inf.nemo.common.ontoumlparser.OntoUMLParser;

public class DecIntAntipattern extends Antipattern<DecIntOccurrence> {

	public DecIntAntipattern(OntoUMLParser parser) throws NullPointerException {
		super(parser);
	}
	
	private static final String oclQuery = 
			"Class.allInstances()" +
			"->select( x | " +
			"	x.oclAsType(Classifier).parents()" +
			"	->select( parent : Classifier | " +
			"		parent.oclIsKindOf(SortalClass)" +
			"	)->size()>1" +
			")";

	private static final AntipatternInfo info = new AntipatternInfo("Deceiving Intersection", 
			"DecInt", 
			"This anti-pattern identifies...",
			oclQuery); 
		
	public static AntipatternInfo getAntipatternInfo(){
		return info;
	}
	
	
	@Override
	public ArrayList<DecIntOccurrence> identify(){
		
		for (Class c : parser.getAllInstances(Class.class)) {
		
			if(c instanceof SubstanceSortal || c instanceof MixinClass)
				continue;
			
			if(c.parents().size()<2)
				continue;
			
			ArrayList<Classifier> relevantParents = new ArrayList<Classifier>(c.parents());
			
			//remove abstract parents and Mixin parents
			for (Classifier parent : c.parents()) {
				if(parent.isIsAbstract() || parent instanceof MixinClass)
					relevantParents.remove(parent);
			}


			//remove "complete" parents
			for (Generalization g : c.getGeneralization()) {
				if(relevantParents.contains(g.getGeneral())){
					for (GeneralizationSet gs : g.getGeneralizationSet()) {
						if(gs.isIsCovering()){
							relevantParents.remove(g.getGeneral());
							break;
						}
					}
				}
			}
			
			if(!compatibleStereotypes(c,relevantParents))
				continue;
			
			if(relevantParents.size()<2)
				continue;
			
			try {
				DecIntOccurrence decInt = new DecIntOccurrence(c, relevantParents, this);
				occurrence.add(decInt);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		return this.getOccurrences();
	}
	
	private boolean compatibleStereotypes(Classifier c, ArrayList<Classifier> parents){
		
		if(c instanceof Relator){
			for (Classifier parent : parents) {
				if(!(parent instanceof Relator))
					return false;
			}
			return true;
		}
		
		if(c instanceof Mode){
			for (Classifier parent : parents) {
				if(!(parent instanceof Mode))
					return false;
			}
			return true;
		}
		
		if(c instanceof SubKind){
			for (Classifier parent : parents) {
				if(!(parent instanceof SubKind) && !(parent instanceof SubstanceSortal))
					return false;
			}
			return true;
		}
		
		if(c instanceof AntiRigidSortalClass){
			for (Classifier parent : parents) {
				if(!(parent instanceof SortalClass))
					return false;
			}
			return true;
		}
		
		return false;
	}
}
