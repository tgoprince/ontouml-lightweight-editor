package br.ufes.inf.nemo.ocl2swrl.factory.uml2.uml.internal.impl;

import org.eclipse.uml2.uml.internal.impl.NamedElementImpl;

import br.ufes.inf.nemo.ocl2swrl.factory.Factory;



/**
 * @author fredd_000
 * @version 1.0
 * @created 24-set-2013 09:16:13
 */
public class NamedElementImplFactory extends Factory {

	public NamedElementImpl m_NamedElementImpl;
	
	public NamedElementImplFactory(NamedElementImpl m_NamedElementImpl){
		this.m_NamedElementImpl = m_NamedElementImpl;
	}

	public void finalize() throws Throwable {

	}

	
}