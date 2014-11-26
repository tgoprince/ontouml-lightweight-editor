package br.ufes.inf.nemo.ontouml2alloy.scenarios;

public abstract class Scenario {
	
	enum ParagraphType {PRED, ASSERT, FACT}
	private ParagraphType paragraphType;
	
	public abstract String getString();
	public abstract String getAlloy();
	public abstract String getScenarioName();
	
	public ParagraphType getParagraphType(){
		return paragraphType;
	}
	
	public boolean isPredicate(){
		return paragraphType == ParagraphType.PRED;
	}
	
	public boolean isFact(){
		return paragraphType == ParagraphType.FACT;
	}
	
	public boolean isAssertion(){
		return paragraphType == ParagraphType.ASSERT;
	}
	
	public void setAsPredicate(){
		this.paragraphType = ParagraphType.PRED;
	}
	
	public void setAsFact(){
		this.paragraphType = ParagraphType.FACT;
	}
	
	public void setAsAssertion(){
		this.paragraphType = ParagraphType.ASSERT;
	}
	
	public String getParagraphString(){
		
		if (paragraphType==ParagraphType.PRED)
			return "Is want to see";
		if (paragraphType==ParagraphType.ASSERT)
			return "The model only allows";
		if (paragraphType==ParagraphType.FACT)
			return "I want to enforce";
		
		return "";
	}
	
	private String getParagraphKeyword() {
		
		if (paragraphType==ParagraphType.PRED)
			return "pred";
		if (paragraphType==ParagraphType.ASSERT)
			return "assert";
		if (paragraphType==ParagraphType.FACT)
			return "fact";
		
		return "";
	}
	
	public String getNaturalLanguageTranslation(){
		return getParagraphString()+" "+getString()+".";
	}
		
	public String getParagraph(){
		return 	getParagraphKeyword()+" "+getScenarioName()+" {"+
				"\n\t"+getAlloy()+
				"\n}";
	}
		
}