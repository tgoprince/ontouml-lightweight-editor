package br.ufes.inf.nemo.antipattern.wholeover;

import java.util.HashSet;

import RefOntoUML.Classifier;
import RefOntoUML.Meronymic;
import RefOntoUML.Property;
import br.ufes.inf.nemo.antipattern.overlapping.OverlappingOccurrence;
import br.ufes.inf.nemo.antipattern.overlapping.OverlappingGroup;

public class WholeOverOccurrence extends OverlappingOccurrence {

	public WholeOverOccurrence(Classifier whole, HashSet<Property> partEnds, WholeOverAntipattern ap) throws Exception {
		super(ap, whole, partEnds);
		
		for (Property p : getAllPartEnds()) {
			if(!(p.getAssociation() instanceof Meronymic))
				throw new Exception(WholeOverAntipattern.getAntipatternInfo().getAcronym()+": All provided properties must belong to a meronymc.");
		}
		
		if(!verifyMinimumUpperCardinalitySum(3))
			throw new Exception(WholeOverAntipattern.getAntipatternInfo().getAcronym()+": The sum of the upper cardinality is lower than 3.");
		
	}
	
	public Classifier getWhole() {
		return getMainType();
	}

	public HashSet<Property> getAllPartEnds() {
		return getAllProperties();
	}
	
	@Override
	public String toString() {
		String result;
		
		result = "Whole: "+getParser().getStringRepresentation(getWhole())+"\n"+
				"All Parts: ";
				
		for (Property p : getAllPartEnds())
			result+="\n\t"+getParser().getStringRepresentation(p);
				
		for (OverlappingGroup variation : getVariations()) {
			result+="\n\n"+variation.toString();
		}
		return result;
	}

	@Override
	public String getShortName() {
		return "Whole: "+ parser.getStringRepresentation(getWhole());
	}

	@Override
	public String getPropertyTypeString() {
		return "part types of";
	}

	@Override
	public String getExclusiveExample() {
		return 	"A scientific event organization committee (the whole base) is composed by people with different assignments and responsibilities. " +
				"There’s the Event Chairman, the Local Organization Chairs, the Technical Program Chairs, amongst others (which define the association set to the part types). "+
				"\r\n\r\n"+
				"If it is possible for the same person to perform all roles in the same conference, the memberships from the whole committee to the different " +
				"members  are non-exclusive. If a person can only have at most one position in a given committee, the relations set is said to exclusive.";
		 
	}

	@Override
	public String getBaseClassType() {
		return "Whole";
	}	
}
