package br.ufes.inf.nemo.ocl2owl_swrl.factory.ocl.uml.impl;

import org.eclipse.uml2.uml.internal.impl.NamedElementImpl;

/**
 * @author Freddy Brasileiro Silva {freddybrasileiro@gmail.com}
 */
public class LoopExpImplFactory extends CallExpImplFactory {
	public OCLExpressionImplFactory bodyFactory;
	
	public LoopExpImplFactory(NamedElementImpl m_NamedElementImpl){
		super(m_NamedElementImpl);
	}
}