package uk.ac.bham.sitra.tracing;

import java.util.ArrayList;
import java.util.List;

import uk.ac.bham.sitra.Rule;

/**
 * <p>An implementation of the {@link ITrace} interface. </p>
 * <p>Holds a collection of {@link TraceInstanceImpl}s that represent the mapping between particular
 * source and target objects.</p> 
 * 
 * @author Kyriakos Anastasakis
 * @since 0.2
 * 
 * @see TraceInstanceImpl
 *
 */
public class TraceImpl implements ITrace{
	
	private static String NEW_LINE = System.getProperty("line.separator");
	
	/**
	 * A List of {@link TraceInstanceImpl}s that hold the mapping between source and target element instances. 
	 */
	protected List<TraceInstance> tis = new ArrayList<TraceInstance>();
	
	/**
	 * Whether the Tracing is enabled.
	 */
	protected boolean _isEnabled = true;
	
	/**
	 * <p>Creates a {@link TraceInstance} that represents that trace between the <i>source</i>
	 * 	the <i>target</i> mapped by the {@link Rule} <i>r</i>. </p>
	 * 
	 * <p>Please note it only records the mapping if {@link TraceImpl#_isEnabled} is <i>true</i></p>
	 * 
	 * @param source The object of the source metamodel that we are tracing.
	 * @param target The object of the target metamodel that we are tracing.
	 * @param r The {@link Rule} instance which carried out the mapping between <i>source</i> 
	 * and <i>target</i>.
	 * @return The {@link TraceInstance} generated by the <i>source</i>, <i>target</i>
	 * and <i>rule</i>.
	 * <
	 */
	@SuppressWarnings("unchecked")
	public <S,T> TraceInstance<S, T> recordMapping(S source, T target, Rule<S, T> r){		
		TraceInstance<S,T> ti = new TraceInstanceImpl<S,T>(source,target,r);	
		recordMapping(ti);
		return ti;
	}
	
	/**
	 * <p>Adds the {@link TraceInstanceImpl} passed as a parameter to the collection of 
	 * {@link TraceInstanceImpl}s this TraceImpl is holding.</p>
	 * 
	 * 	<p>Please note it only records the mapping if {@link TraceImpl#_isEnabled} is <i>true</i></p>
	 * 
	 * @param ti The {@link TraceInstanceImpl} to add to the List of {@link TraceInstanceImpl}s 
	 * of this implementation. 
	 */
	public <S,T> void recordMapping(TraceInstance<S,T> ti){
		if (getIsEnabled())
			tis.add(ti);
		else // TODO Maybe throw an exception if tracing is disabled 
			System.err.println("Tracing is disabled. Will not record mapping between: " + ti.getSource().toString() + " and " + ti.getTarget().toString());		
	}	
	
	/**
	 * Returns all the {@link TraceInstanceImpl}s registered so far.
	 * @return A List of the {@link TraceInstanceImpl}s registered so far
	 */
	@SuppressWarnings("unchecked")
	public List<TraceInstance> getTraceInstances() {
		return tis;
	}
	
	/**
	 * Whether tracing is enabled
	 * @return <i>true</i> if enabled. <br/> <i>false</i> otherwise 
	 */
	public boolean getIsEnabled(){
		return _isEnabled;
	}
	
	/**
	 * Sets whether tracing is enabled.
	 * @param enabled <i>true</i> to enable tracing. <br/> <i>false</i> to disable.
	 */
	public void setIsEnabled(boolean enabled){
		_isEnabled = enabled;
	}
	
	
	// ** METHODS PROPOSED BY THE QVT TO QUERY THE TRACE MAPPINGS STORED **/
	

	/**
	 * <p>Goes through the {@link TraceInstanceImpl} collection and if the source object equals to the 
	 * parameter, this method returns the <b>first</b> target object that was generated by the source object. </p>  
	 * 
	 * @param src The source object on which the resolveone method is applied
	 * @return The <b>first</b> target object that was mapped from the source object. <br />
	 * <i>null</i> if the source object has not generated any target object. 
	 */
	public <S,T> T resolveone(S src){
		return this.<S,T>resolveone(src, null);  
//		this.resolveone(src,null);		
	}
		
	/**
	 * <p>Goes through the {@link TraceInstanceImpl} collection and if the source object equals to the 
	 * parameter, and the type of the target object is the same as the second param, 
	 * this method returns the <b>first</b> target object that was generated by the source object.</p>  
	 * 
	 * @param src The source object on which the resolveone method is applied
	 * @param targetType The type of the target object
	 * @return The <b>first</b> target object that was mapped from the source object.<br />
	 * <i>null</i> if the source object has not generated any target object. 
	 */
	public <S,T> T resolveone(S src, Class<T> targetType){
		List<S> srclist = new ArrayList<S>();
		srclist.add(src);
		return this.<S,T>resolveone(srclist, targetType);
	}
	
	
	/**
	 * <p>Iterates through the list of the source objects passed
	 * as a parameter and goes through the {@link TraceInstanceImpl} collection. If the source object of 
	 * the {@link TraceInstanceImpl} equals to the 
	 * object of the iteration 
	 * this method returns the <b>first</b> target object that was generated by the source object.</p>  
	 * 
	 * @param srclst The collection of the source objects on which the resolveone method is applied
	 * @return The <b>first</b> target object that was mapped from the source object.<br />
	 * <i>null</i> if the source object has not generated any target object.   
	 */
	public <S,T> T resolveone(List<S> srclst){
		return this.<S,T>resolveone (srclst,null);
	}
	
	
	/**
	 * <p>Iterates through the list of the source objects passed
	 * as a parameter and goes through the {@link TraceInstanceImpl} collection. If the source object of 
	 * the {@link TraceInstanceImpl} equals to the 
	 * object of the iteration, and the type of the target object is the same as the second param,   
	 * this method returns the <b>first</b> target object that was generated by the source object.</p>  
	 * 
	 * @param srclst The collection of the source objects on which the resolveone method is applied
	 * @param targetType The type of the target object
	 * @return The <b>first</b> target object that was mapped from the source object.<br />
	 * <i>null</i> if the source object has not been generated any target object.    
	 */
	public <S,T> T resolveone(List<S> srclst, Class targetType){	
			
		for (S source : srclst){
			for (TraceInstance<S, T> ti : getTraceInstances()){
				if (ti.getSource().equals(source))
					if (targetType == null)
						return ti.getTarget();
					else
						if (ti.getTarget().getClass().equals(targetType)) return ti.getTarget();
			}
		}
			// If it reaches here it is null
			return null;
	}
	
	
	
	
	public List<Object> resolve(Object src){		
		return resolve(src,null);
	}
	
	public List<Object> resolve(List<Object> srclist){
		return resolve(srclist,null);
	}
	
	
	@SuppressWarnings("unchecked")
	public <S,T> List<T> resolve(S src, Class targetType){
		ArrayList<S> srclist = new ArrayList<S>();
		srclist.add(src);
		return resolve(srclist,targetType);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public <S,T> List<T> resolve (List<S> srclist, Class targetType){
		List<T> l = new ArrayList<T>();
		
		for (S src: srclist){
			for (TraceInstance<S, T> ti: getTraceInstances()){
				if ((ti.getSource().equals(src)))
					if (targetType==null) 
						l.add(ti.getTarget());
					else 
						if (ti.getTarget().getClass().equals(targetType)) l.add(ti.getTarget());
			}
		}				
		
		return l;
	}	
	
	
	// TODO Implement inverse resolve methods!
	// TODO Implement resolveIn methods!
	
	
	@SuppressWarnings("unchecked")
	public String toString(){
		StringBuffer sb = new StringBuffer();
		
		for (TraceInstance ti : getTraceInstances()){
			
			sb.append("SOURCE: ").append(
					ti.getSource()).append("  ").append(" =====> ")
				.append(ti.getTarget()).append("  RULE: ").append(ti.getRule())
			.append(NEW_LINE);
		}
		
		
		
		return sb.toString();
	}

	
	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> resolve(Class<? extends T> targetType) {
		List<T> arrList = new ArrayList<T>(); 
		
		for (TraceInstance ti : getTraceInstances()){
			if (ti.getTarget().getClass().equals(targetType)){				
				arrList.add((T) ti.getTarget());
			}
		}
		
		return arrList;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public <S,T> List<S> resolvein (List<T> targetList, Class sourceType){
		List<S> l = new ArrayList<S>();
		
		for (T tar: targetList){
			for (TraceInstance<S, T> ti: getTraceInstances()){
				if ((ti.getTarget().equals(tar)))
					if (sourceType==null) 
						l.add(ti.getSource());
					else 
						if (ti.getTarget().getClass().equals(sourceType)) l.add(ti.getSource());
			}
		}				
		
		return l;
	}
	
	/** END OF METHODS PROPOSED BY THE QVT TO QUERY THE TRACE MAPPINGS STORED **/
}
