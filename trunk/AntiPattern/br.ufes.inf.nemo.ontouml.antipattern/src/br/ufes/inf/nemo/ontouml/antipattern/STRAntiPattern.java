package br.ufes.inf.nemo.ontouml.antipattern;

import br.ufes.inf.nemo.ontouml.antipattern.mapper.NamesMapper;
import br.ufes.inf.nemo.ontouml.antipattern.util.AlloyConstructor;

import RefOntoUML.Association;
import RefOntoUML.Classifier;

/*Self-Type Relationship AntiPattern*/
public class STRAntiPattern {
	private Association association;
	private Classifier type;
	
	
	public STRAntiPattern (Association association) throws Exception{
		this.setAssociation(association);
	}
	
	/*This method returns an Alloy predicate which only generates model instances in which the association that characterizes the antipattern is REFLEXIVE*/
	public String generateReflexivePredicate (int cardinality, NamesMapper mapper) {
		String predicate, rules, name;
		
		String associationName, typeName;
		associationName = mapper.elementsMap.get(this.association);
		typeName = mapper.elementsMap.get(this.type);
		
		name = "reflexive_"+associationName;
		rules = "#" + associationName + ">" + cardinality;
		rules += "\n\tall w:World | reflexive[w."+ associationName +", w."+typeName+"]";
		
		predicate = AlloyConstructor.AlloyParagraph(name, rules, AlloyConstructor.PRED);
		predicate += AlloyConstructor.RunCheckCommand(name, "10", "1", AlloyConstructor.PRED)+"\n";
		
		return predicate;
	}
	
	/*This method returns an Alloy predicate which only generates model instances in which the association that characterizes the antipattern is IRREFLEXIVE*/
	public String generateIrreflexivePredicate (int cardinality, NamesMapper mapper){
		String predicate, rules, name;
		
		String associationName;
		associationName = mapper.elementsMap.get(this.association);
		
		name = "irreflexive_"+associationName;
		
		rules = "#" + associationName + ">" + cardinality; 
		rules += "\n\tall w:World | irreflexive[w."+ associationName +"]";
				
		predicate = AlloyConstructor.AlloyParagraph(name, rules, AlloyConstructor.PRED);
		predicate += AlloyConstructor.RunCheckCommand(name, "10", "1", AlloyConstructor.PRED)+"\n"; 
    	
    	return predicate;
	}
	
	/*This method returns an Alloy predicate which only generates model instances in which the association that characterizes the antipattern is Transitive*/
	public String generateTransitivePredicate (int cardinality, NamesMapper mapper){
		String predicate, rules, name;
		
		String associationName;
		associationName = mapper.elementsMap.get(this.association);
		name = "transitive_"+associationName;
		
		rules = "#" + associationName + ">" + cardinality; 
		rules += "\n\tall w:World | transitive[w."+ associationName +"]";
				
		predicate = AlloyConstructor.AlloyParagraph(name, rules, AlloyConstructor.PRED);
		predicate += AlloyConstructor.RunCheckCommand(name, "10", "1", AlloyConstructor.PRED)+"\n"; 
    	
    	return predicate;
	}
	
	/*This method returns an Alloy predicate which only generates model instances in which the association that characterizes the antipattern is INTRANSITIVE*/
	public String generateIntransitivePredicate (int cardinality, NamesMapper mapper){
		String predicate, rules, name;
		
		String associationName, typeName;
		associationName = mapper.elementsMap.get(this.association);
		typeName = mapper.elementsMap.get(this.type);
		
		name = "instransitive_"+associationName;
		rules = "#" + associationName + ">" + cardinality; 
		rules += "\n\tall w:World | all disj x,y,z: w."+ typeName +" | (y in x.(w."+ associationName +") and z in y.(w."+ associationName +") ) implies z not in x.(w."+ associationName +")";
		
		predicate = AlloyConstructor.AlloyParagraph(name, rules, AlloyConstructor.PRED);
		predicate += AlloyConstructor.RunCheckCommand(name, "10", "1", AlloyConstructor.PRED)+"\n"; 
		
		return predicate;
	}
	
	/*This method returns an Alloy predicate which only generates model instances in which the association that characterizes the antipattern is SYMMETRIC*/
	public String generateSymmetricPredicate (int cardinality, NamesMapper mapper){
		String predicate, rules, name;
		
		String associationName;
		associationName = mapper.elementsMap.get(this.association);
		name = "symmetric_"+associationName;
		
		rules = "#" + associationName + ">" + cardinality; 
		rules += "\n\tall w:World | symmetric[w."+ associationName +"]";
				
		predicate = AlloyConstructor.AlloyParagraph(name, rules, AlloyConstructor.PRED);
		predicate += AlloyConstructor.RunCheckCommand(name, "10", "1", AlloyConstructor.PRED)+"\n"; 
    	
    	return predicate;
	}
	
	/*This method returns an Alloy predicate which only generates model instances in which the association that characterizes the antipattern is ANTISYMMETRIC*/
	public String generateAntisymmetricPredicate (int cardinality, NamesMapper mapper){
		String predicate, rules, name;
		
		String associationName;
		associationName = mapper.elementsMap.get(this.association);
		name = "antisymmetric_"+associationName;
		rules = "#" + associationName + ">" + cardinality;
		rules += "\n\tall w:World | antisymmetric[w."+ associationName +"]";
		
		predicate = AlloyConstructor.AlloyParagraph(name, rules, AlloyConstructor.PRED);
		predicate += AlloyConstructor.RunCheckCommand(name, "10", "1", AlloyConstructor.PRED)+"\n";
			
		return predicate;
	}
	
	public Association getAssociation() {
		return association;
	}

	public void setAssociation(Association association) throws Exception {
		
		
		if (association == null)
			throw new NullPointerException();
		/*Check if the provided association indeed characterizes a SelfType Relationship AntiPattern*/
		else if (!association.getMemberEnd().get(0).getType().equals(association.getMemberEnd().get(1).getType()))
			throw new Exception("Input association does not characterize a Self-Type Relationship AntiPattern");
		
		this.association = association;
		this.type = (Classifier) association.getMemberEnd().get(0).getType();
	}

	public Classifier getType() {
		return type;
	}
	
	@Override
	public String toString() {
		return type.getName()+" - "+association.getName();
	}

}
