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
	
	public static String orVerb()
	{
		return "ou";
	}
	
	public static String subtypesVerb()
	{
		return "�";
	}
	
	public static String supertypesVerb()
	{
		return "pode ser";
	}
	
	public static String article()
	{
		return "um";
	}
	
	public static String connector()
	{
		return "que";
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
			mult += "um";
		}
		else if (prop.getLower() == 1 && prop.getUpper() == -1)
		{
			mult += "pelo menos um"; //Algum
		}
		else if (prop.getLower() == 0 && prop.getUpper() == 1)
		{
			mult += "at� um";
		}
//		else if (prop.getLower() == 0 && prop.getUpper() == -1)
//		{
//			mult += "zero ou mais";
//		}
//		else if (prop.getLower() == -1 && prop.getUpper() == -1)
//		{
//			mult += "zero ou mais";
//		}
		else
			mult += "muitos";
		
		return mult;
	}
}
