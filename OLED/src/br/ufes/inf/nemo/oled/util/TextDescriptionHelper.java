package br.ufes.inf.nemo.oled.util;


import ontouml2text.core.Writer;

import RefOntoUML.Model;
import br.ufes.inf.nemo.oled.util.OperationResult.ResultType;

public class TextDescriptionHelper {
	
   public static OperationResult generateText(final Model refmodel, String tempDir) {
	   
//	   String modelFileName = ConfigurationHelper.getCanonPath(tempDir, OLEDSettings.MODEL_DEFAULT_FILE.getValue());
//	   File modelFile = new File(modelFileName);  	
//	   modelFile.deleteOnExit();
//   	
//	   try {
//			
//			FileOutputStream out = new FileOutputStream(modelFile);
//			refmodel.eResource().save(out, Collections.EMPTY_MAP);
//			
//			Writer.Write(modelFileName);
//			
//			String docPage = modelFile.getPath().replace(".refontouml", ".txt");
//			
//			return new OperationResult(ResultType.SUCESS, "Model description generated successfully", new Object[] { docPage });
//			
//		} catch (Exception ex) {
//			return new OperationResult(ResultType.ERROR, "Error while generating the model description. Details: " + ex.getMessage(), null);
//		}
	   try {
		   
	   		String textOutput;
	   		
	   		textOutput = Writer.Write(refmodel);
				
	   		if(textOutput != null && textOutput.length() > 0)
	   		{
//					if(fileOutput && filePath != null)
//					{
//						String owlFileName = ConfigurationHelper.canon(filePath);
//					    	
//						// Writing transformed model into owl file
//						FileManager fileManager = new FileManager(owlFileName);
//						fileManager.write(owlOutput);
//						fileManager.done();
//						
//						return new OperationResult(ResultType.SUCESS, "OWL generated successfully", new Object[] { owlFileName });
//					}
//					else
//					{
						return new OperationResult(ResultType.SUCESS, "Model description generated successfully.", new Object[] { textOutput });
//					}
	   		}
	   		else
	   		{
	   			return new OperationResult(ResultType.ERROR, "No model description generated.", null);
	   		}
	   	}
	   	catch (Exception ex)
	   	{
	   		ex.printStackTrace();
	   		return new OperationResult(ResultType.ERROR, "Error while generating the model description. Details: " + ex.getMessage(), null);
	   	}
	}
	
}
