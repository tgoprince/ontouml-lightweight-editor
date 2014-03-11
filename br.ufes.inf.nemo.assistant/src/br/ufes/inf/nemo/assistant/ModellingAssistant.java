package br.ufes.inf.nemo.assistant;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import RefOntoUML.Classifier;
import RefOntoUML.Package;
import br.ufes.inf.nemo.assistant.graph.GraphAssistant;
import br.ufes.inf.nemo.assistant.util.StereotypeOntoUMLEnum;
import br.ufes.inf.nemo.assistant.util.UtilAssistant;
import br.ufes.inf.nemo.assistant.wizard.WizardAssitant;
import br.ufes.inf.nemo.common.ontoumlfixer.Fix;

public class ModellingAssistant {

	public static final String serializedObjectPath = "graph_assistant.ser";
	
	private HashMap<StereotypeOntoUMLEnum, GraphAssistant> hashGraph;

	/**
	 * Instantiating the class and runner the SWTAstahParser or by .jar execution
	 * or by eclipse running.
	 * */
	public ModellingAssistant(RefOntoUML.Package root) {
		readBynaryFile();
		
		Iterator<GraphAssistant> graphIterator = hashGraph.values().iterator();
		while(graphIterator.hasNext()){
			GraphAssistant graph = graphIterator.next();
			graph.getManagerPattern().setRefOntoUML(root);
		}
		
		p = root;
	}
	Package p;
	
	@SuppressWarnings("unchecked")
	private void readBynaryFile(){
		try{
			InputStream is = this.getClass().getClassLoader().getResourceAsStream(serializedObjectPath);
			
			ObjectInputStream in = null;
			
			if(is == null){
				is = this.getClass().getClassLoader().getResourceAsStream("src/"+serializedObjectPath);
				in = new ObjectInputStream(is);
			}else{
				in = new ObjectInputStream(is);
			}
			
			hashGraph = (HashMap<StereotypeOntoUMLEnum, GraphAssistant>) in.readObject();
			in.close();
			is.close();
		}catch(Exception i){
			i.printStackTrace();
			return;
		}
	}
	
	/**
	 * Run the pattern for the elem.
	 * Start and show the wizard
	 * */
	public Fix runPattern(Classifier elem){
		StereotypeOntoUMLEnum stereotype = UtilAssistant.getStereotypeFromClassifier(elem);
		try{
			if(stereotype != null){
				GraphAssistant graph = hashGraph.get(stereotype);
				graph.updateNodeList();
				graph.getManagerPattern().setClassSource(elem);

				graph.getManagerPattern().setFix(new Fix());

				Fix fix = null;

				Display display = Display.getDefault();	    	
				Shell shell = display.getActiveShell();
				WizardDialog wizardDialog = new WizardDialog(shell,new WizardAssitant(graph));

				if (wizardDialog.open() == Window.OK) {
					fix = graph.getManagerPattern().getFix();
				}
//				System.out.println("REFonto: {");
//				UtilAssistant.printRefOntoUML(p);
//				System.out.println("}");
				return fix;
			}else{
//				System.out.println("stereotype not treated yet");
			}
		}catch(Exception e){
			//e.printStackTrace();
//			System.out.println("pattern not treated yet");
		}
//		System.out.println("REFonto: {");
//		UtilAssistant.printRefOntoUML(p);
//		System.out.println("}");
		return null;
	}
}
