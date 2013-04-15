package br.ufes.inf.nemo.ontouml2text.core;

import RefOntoUML.Association;
import RefOntoUML.Characterization;
import RefOntoUML.Derivation;
import RefOntoUML.Mediation;
import RefOntoUML.Property;
import RefOntoUML.componentOf;
import RefOntoUML.memberOf;
import RefOntoUML.subCollectionOf;
import RefOntoUML.subQuantityOf;

public class Phrases {
	
	public static String ownsVerb()
	{
		return "possui";
	}
	
	public static String andVerb()
	{
		return "e";
	}
	
	public static String subtypesVerb()
	{
		return "� um tipo de";
	}
	
	public static String supertypesVerb()
	{
		return "pode ser";
	}

	public static String processVerb(Association assoc)
	{
		if (assoc instanceof Mediation)
		{
			return "media";
		}
		else if (assoc instanceof Characterization)
		{
			return "caracteriza";
		}
		else if (assoc instanceof Derivation)
		{
			return "deriva";
		}
		else if (assoc instanceof componentOf)
		{
			return "� composto de";
		}
		else if (assoc instanceof memberOf)
		{
			return "� membro de";
		}
		else if (assoc instanceof subQuantityOf)
		{
			return "� sub-quantity de";
		}
		else if (assoc instanceof subCollectionOf)
		{
			return "� sub-collection de";
		}
		else 
			return "tem";
	}
	
	public static String processMultiplicity (Property prop)
	{
		String mult = new String();
		if (prop.getLower() == 1 && prop.getUpper() == 1)
		{
			mult += "um(a)";
		}
		else if (prop.getLower() == 1 && prop.getUpper() == -1)
		{
			mult += "no m�nimo um(a)";
		}
		else if (prop.getLower() == 0 && prop.getUpper() == 1)
		{
			mult += "no m�ximo um(a)";
		}
		else if (prop.getLower() == 0 && prop.getUpper() == -1)
		{
			mult += "zero ou mais";
		}
		else if (prop.getLower() == -1 && prop.getUpper() == -1)
		{
			mult += "zero ou mais";
		}
		else
			mult += "muitos(as)";
		
		return mult;
	}
}
