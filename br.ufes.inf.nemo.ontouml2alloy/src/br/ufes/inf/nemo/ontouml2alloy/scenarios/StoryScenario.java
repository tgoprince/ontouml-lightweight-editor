package br.ufes.inf.nemo.ontouml2alloy.scenarios;



public class StoryScenario extends Scenario{
	
	private StoryType storyType;
	
	private BinaryOperator op;
	private int numberOfWorlds;
	
	
	public enum Limit {
		UPPER {
			@Override 
			public String toString() { 
				return "At Most";
			}
		}, 
		LOWER{
			@Override 
			public String toString() { 
				return "At Least";
			}
		},  
	};
	private Limit limit;
	private int depth;
	private CustomQuantification quant;
	
	
	public StoryScenario (){
		quant = CustomQuantification.createWorldQuantification(1);
		setNumberOfWorlds(BinaryOperator.EQUAL, 2);
	}

	public void setType(StoryType type) {
		this.storyType = type;
	}
	
	public void setNumberOfWorlds(BinaryOperator op, int numberOfWorlds) {
		this.op = op;
		this.numberOfWorlds = checkNumberOfWorlds(numberOfWorlds);
	}
	
	public void setDepth(Limit limit, int storyDepth) {
		this.limit=limit;
		this.depth = checkStoryDepth(storyDepth);
		
		if(limit==Limit.UPPER)
			quant.setAsNo();
		else if(limit==Limit.LOWER)
			quant.setAsSome();
	}

	public StoryType getStoryType(){
		return storyType;
	}
	
	public int getNumberOfWorlds() {
		return numberOfWorlds;
	}
	
	public BinaryOperator getOperator() {
		return op;
	}
	
	public int getDepth() {
		return depth;
	}
	
	public boolean isDepthSet() {
		return depth>=0 && limit!=null;
	}
	
	public void removeDepth(){
		depth=-1;
		limit = null;
	}
	
	public Limit getLimit() {
		return limit;
	}
	
	public int getAdjustedDepth(){
		if(limit==Limit.UPPER)
			return depth+1;
		return depth;
	}

	
	public int checkNumberOfWorlds(int value){
		return value;
//		switch (type) {
//		case COUNTER:
//			
//			if (comparator.op==Operator.EQUAL || comparator.op==Operator.GREATER_EQ){
//				if(value<4)
//					return 4;
//				return value;
//			}
//			
//			if (comparator.op==Operator.GREATER){
//				if(value<3)
//					return value;
//				return 4;
//			}
//			
//			if (comparator.op==Operator.L || comparator.op==Operator.GREATER_EQ){
//				if(value>4)
//					return value;
//				return 4;
//			}
//			
//		case FUTURES:
//			if (value>3)
//				return value;
//			return 3;
//		case LINEAR:
//		case UNDEF:
//		default:
//			if (value>1)
//				return value;
//			return 1;
//		}
				
	}
	
	//TODO: fix according to operator
	public int checkStoryDepth(int value) {
		return value;
//		switch (type) {
//		case COUNTER:
//			if (value>2)
//				return value;
//			return 2;
//		case FUTURES:
//			return 1;
//		case LINEAR:
//		case UNDEF:
//		default:
//			if (value>1)
//				return value;
//			return 1;
//		}
	}

	@Override
	public String getString() {
		switch (storyType) {
			case COUNTER:
				return "things may have taken a different outcome in the past";
			case FUTURES:
				return "different outcomes for a given situation";
			case LINEAR:
				return "linear story";
			default:
				break;
		}
		
		return "";
	}

	@Override
	public String getAlloy() {
		String alloy = "";
		
		if(storyType==StoryType.COUNTER || storyType==StoryType.FUTURES || storyType==StoryType.LINEAR)
			alloy+=getStructureExpression()+"\n\t";
		
		alloy+=getSizeExpression();
		
		if(isDepthSet())
			alloy+="\n\t"+getDepthExpression();
		
		return alloy;
	}
	
	private String getDepthExpression() {
		return quant.addQuantification(getRestriction());
	}
	
	private String getRestriction() {
		String expr="";
				
		for (int i = 1; i < getAdjustedDepth(); i++) {
			String var1 = quant.getVariable(0,i);
			String var2 = quant.getVariable(0,i+1);
			
			expr += var2+" in "+var1+".next";
			
			if(i<getAdjustedDepth()-1)
				expr+=" and ";
		}
		
		return expr;
	}
	
	
	private String getSizeExpression() {
		return op.getExpression("#World", Integer.toString(numberOfWorlds));
	}

	private String getStructureExpression() {
		switch (storyType) {
		case COUNTER:
			return "some w1,w2:World | w1!=w2 && next.w1=next.w2 && (some w1.next or some w2.next)";
		case FUTURES:
			return "one w:World | no next.w && all w2:World | w!=w2 implies w2 in w.next";
		case LINEAR:
			return "one w1,w2:World | no w1.next and no next.w2";
		case UNDEF:
		default:
			return "";
		}
	}

	@Override
	public String getScenarioName() {
		return "Story";
	}

	

	
}
