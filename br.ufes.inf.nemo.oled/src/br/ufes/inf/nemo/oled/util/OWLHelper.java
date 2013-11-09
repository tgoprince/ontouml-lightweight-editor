package br.ufes.inf.nemo.oled.util;

import RefOntoUML.Model;
import br.ufes.inf.nemo.oled.ontouml2owl_swrl.OntoUML2OWL;
import br.ufes.inf.nemo.oled.util.OperationResult.ResultType;
import br.ufes.inf.nemo.ontouml2owl_swrl.util.MappingType;
import br.ufes.inf.nemo.ontouml.transformation.ontouml2owl.auxiliary.OWLStructure;
import br.ufes.inf.nemo.ontouml.transformation.ontouml2owl.tree.TreeProcessor;
import br.ufes.inf.nemo.ontouml.transformation.ontouml2owl.verbose.FileManager;
import br.ufes.inf.nemo.ontouml2simpleowl.OntoUML2SimpleOWL;

public class OWLHelper {

	public static OperationResult generateOwl(Model model, String ontologyIRI, MappingType mappingType, boolean fileOutput, String filePath)
	{
		System.out.println(ontologyIRI);
		br.ufes.inf.nemo.ontouml.transformation.ontouml2owl.auxiliary.MappingType mp = null;
		if(mappingType != null && !mappingType.equals(MappingType.RULES)){
			mp = br.ufes.inf.nemo.ontouml.transformation.ontouml2owl.auxiliary.MappingType.valueOf(mappingType.toString());
		}
    	try
    	{
    		String owlOutput;
    		
    		if(mappingType == null)
    		{
    			owlOutput = OntoUML2SimpleOWL.Transformation(model, ontologyIRI);
    		}else if(mappingType.equals(MappingType.RULES)){
    			owlOutput = OntoUML2OWL.Transformation(model, ontologyIRI);
    		}else
    		{
    			TreeProcessor tp = new TreeProcessor(model);
        		
    			// mapping the OntoUML-based structure into an OWL-based structure
    			// according to a certain mapping type
    			OWLStructure owl = new OWLStructure(mp);
    			owl.map(tp);
    			owlOutput = owl.verbose(ontologyIRI);
    		}	
			
    		if(owlOutput != null && owlOutput.length() > 0)
    		{
				if(fileOutput && filePath != null)
				{
					String owlFileName = ConfigurationHelper.canon(filePath);
				    	
					// Writing transformed model into owl file
					FileManager fileManager = new FileManager(owlFileName);
					fileManager.write(owlOutput);
					fileManager.done();
					
					return new OperationResult(ResultType.SUCESS, "OWL generated successfully", new Object[] { owlFileName });
				}
				else
				{
					return new OperationResult(ResultType.SUCESS, "OWL generated successfully", new Object[] { owlOutput });
				}
    		}
    		else
    		{
    			return new OperationResult(ResultType.ERROR, "No OWL generated", null);
    		}
    	}
    	catch (Exception ex)
    	{
    		ex.printStackTrace();
    		return new OperationResult(ResultType.ERROR, "Error while generating the OWL for the model. Details: " + ex.getMessage(), null);
    	}
	}
}