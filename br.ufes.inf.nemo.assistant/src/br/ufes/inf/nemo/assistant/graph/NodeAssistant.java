package br.ufes.inf.nemo.assistant.graph;

import br.ufes.inf.nemo.assistant.wizard.pageassistant.WizardPageAssistant;

public class NodeAssistant {
	protected GraphAssistant graph;

	private NodeAssistant nextNode = null;
	private NodeAssistant backNode = null;
	private NodeAssistant trueNode = null;
	private NodeAssistant falseNode = null;

	private WizardPageAssistant page = null;

	private boolean isEndNode = false;

	public boolean isEndNode(){
		return isEndNode;
	}

	public void isEndNode(boolean b){
		isEndNode = b;
		if(page != null)
			page.setEndPage(b);
	}

	public NodeAssistant(GraphAssistant graph){
		this.graph = graph;
	}

	public NodeAssistant(GraphAssistant graph, WizardPageAssistant page){
		this.graph = graph;
		this.page = page;
	}

	public void setPage(WizardPageAssistant page){
		this.page = page;
	}
	
	public WizardPageAssistant getPage(){
		return page;
	}

	public NodeAssistant getNextNode() {
		graph.setCurrentNode(nextNode);
		if(nextNode != null){
			nextNode.setBackNode(this);
		}
		return nextNode;
	}

	public void setNextNode(NodeAssistant nextNode) {
		this.nextNode = nextNode;
		if(nextNode == null)
			isEndNode(true);
	}

	public NodeAssistant getBackNode() {
		graph.setCurrentNode(backNode);
		return backNode;
	}

	public void setBackNode(NodeAssistant backNode) {
		this.backNode = backNode;
	}

	public NodeAssistant getTrueNode() {
		graph.setCurrentNode(trueNode);
		if(trueNode != null){
			trueNode.setBackNode(this);
		}
		return trueNode;
	}

	public void setTrueNode(NodeAssistant trueNode) {
		this.trueNode = trueNode;
		if(trueNode == null)
			isEndNode(true);
	}

	public NodeAssistant getFalseNode() {
		graph.setCurrentNode(falseNode);
		if(falseNode != null){
			falseNode.setBackNode(this);
		}
		return falseNode;
	}

	public void setFalseNode(NodeAssistant falseNode) {
		this.falseNode = falseNode;
		if(falseNode == null)
			isEndNode(true);
	}

	public GraphAssistant getGraph() {
		return graph;
	}

	public void setGraph(GraphAssistant graph) {
		this.graph = graph;
	}

	public boolean canGoFalse(){
		return falseNode != null;
	}
	
	public boolean canGoTrue(){
		return trueNode != null;
	}
	
	
	protected boolean isAction = false;
	public boolean isAction(){
		return isAction;
	}
}