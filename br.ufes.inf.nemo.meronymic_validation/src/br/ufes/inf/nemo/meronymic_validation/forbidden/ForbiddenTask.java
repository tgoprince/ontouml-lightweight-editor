package br.ufes.inf.nemo.meronymic_validation.forbidden;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.SwingWorker;

import RefOntoUML.Classifier;
import RefOntoUML.Meronymic;
import br.ufes.inf.nemo.common.ontoumlparser.OntoUMLParser;
import br.ufes.inf.nemo.meronymic_validation.graph.DirectedEdge;
import br.ufes.inf.nemo.meronymic_validation.graph.EdgePath;
import br.ufes.inf.nemo.meronymic_validation.graph.Graph;
import br.ufes.inf.nemo.meronymic_validation.graph.Node;
import br.ufes.inf.nemo.meronymic_validation.userinterface.ForbiddenTableModel;

public abstract class ForbiddenTask <T extends Meronymic> extends SwingWorker<Boolean, ForbiddenMeronymic<T>>{

	protected OntoUMLParser parser;
	protected Set<T> existing;
	protected ArrayList<EdgePath> paths;
	protected ArrayList<ForbiddenMeronymic<T>> forbidden;
	private boolean arePathsSet;
	ForbiddenTableModel tableModel;
	
	public ForbiddenTask(OntoUMLParser parser, ForbiddenTableModel tableModel) {
		this.parser = parser;
		this.tableModel = tableModel;
		
		existing = new HashSet<T>();
		paths = new ArrayList<EdgePath>();
		forbidden = new ArrayList<ForbiddenMeronymic<T>>();
		arePathsSet = false;
	}
	
	public OntoUMLParser getParser() {
		return parser;
	}

	public Set<T> getExisting() {
		return existing;
	}

	public ArrayList<EdgePath> getPaths() {
		return paths;
	}

	public ForbiddenTableModel getTable() {
		return tableModel;
	}

	public ArrayList<ForbiddenMeronymic<T>> getForbidden() {
		return forbidden;
	}
	
	
	public boolean arePathsSet() {
		return arePathsSet;
	}

	public void setPaths(boolean addPartChildren, boolean addPartParents){
		
		paths.clear();
		
		Graph genGraph = new Graph(parser);
		//creates directed graph with classes and meronymics
		genGraph.createMeronymicGraph(existing, addPartParents, addPartChildren);
		System.out.println(genGraph.getAllNodes());
		
		for (Node node : genGraph.getAllNodes()) {
			for (DirectedEdge egde : node.getEdges()) {
				System.out.println("(Edge) "+egde.getSource().toString()+" -> "+egde.getTarget().toString());
			}
		}
		//get all paths in the graph
		paths = genGraph.getAllEdgePathsFromAllNodes();
		
		arePathsSet = true;
	}
	
	protected <M extends Meronymic> Set<M> getDirect(Classifier whole, Classifier part, Class<M> stereotype){
		
		Set<M> result = new HashSet<M>();
		
		for (Meronymic meronymic : existing){
			if(stereotype.isInstance(meronymic) && OntoUMLParser.getWholeEnd(meronymic).getType().equals(whole) && OntoUMLParser.getPartEnd(meronymic).getType().equals(part))
				result.add(stereotype.cast(meronymic));
		}
						
		return result;
	}

	@Override
	protected void process(final List<ForbiddenMeronymic<T>> result) {
		System.out.println("PROCESSING!!!");
		for (ForbiddenMeronymic<T> forbiddenMeronymic : result) {
			tableModel.addRow(forbiddenMeronymic);
		}
	}
	
	@Override
	protected void done() {
		System.out.println("DONE!!!");
	}
}
