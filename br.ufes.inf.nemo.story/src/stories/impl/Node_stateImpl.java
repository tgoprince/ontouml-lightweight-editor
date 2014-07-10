/**
 */
package stories.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import stories.Node;
import stories.Node_state;
import stories.StoriesPackage;
import stories.World;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node state</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link stories.impl.Node_stateImpl#getClassified_in <em>Classified in</em>}</li>
 *   <li>{@link stories.impl.Node_stateImpl#getNot_classified_in <em>Not classified in</em>}</li>
 *   <li>{@link stories.impl.Node_stateImpl#getAntiRigidClasses <em>Anti Rigid Classes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Node_stateImpl extends Story_elementImpl implements Node_state {
	/**
	 * The cached value of the '{@link #getClassified_in() <em>Classified in</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassified_in()
	 * @generated
	 * @ordered
	 */
	protected EList<World> classified_in;

	/**
	 * The cached value of the '{@link #getNot_classified_in() <em>Not classified in</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNot_classified_in()
	 * @generated
	 * @ordered
	 */
	protected EList<World> not_classified_in;

	/**
	 * The cached value of the '{@link #getAntiRigidClasses() <em>Anti Rigid Classes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAntiRigidClasses()
	 * @generated
	 * @ordered
	 */
	protected EList<RefOntoUML.Class> antiRigidClasses;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Node_stateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StoriesPackage.Literals.NODE_STATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<World> getClassified_in() {
		if (classified_in == null) {
			classified_in = new EObjectResolvingEList<World>(World.class, this, StoriesPackage.NODE_STATE__CLASSIFIED_IN);
		}
		return classified_in;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<World> getNot_classified_in() {
		if (not_classified_in == null) {
			not_classified_in = new EObjectResolvingEList<World>(World.class, this, StoriesPackage.NODE_STATE__NOT_CLASSIFIED_IN);
		}
		return not_classified_in;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RefOntoUML.Class> getAntiRigidClasses() {
		if (antiRigidClasses == null) {
			antiRigidClasses = new EObjectResolvingEList<RefOntoUML.Class>(RefOntoUML.Class.class, this, StoriesPackage.NODE_STATE__ANTI_RIGID_CLASSES);
		}
		return antiRigidClasses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StoriesPackage.NODE_STATE__CLASSIFIED_IN:
				return getClassified_in();
			case StoriesPackage.NODE_STATE__NOT_CLASSIFIED_IN:
				return getNot_classified_in();
			case StoriesPackage.NODE_STATE__ANTI_RIGID_CLASSES:
				return getAntiRigidClasses();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case StoriesPackage.NODE_STATE__CLASSIFIED_IN:
				getClassified_in().clear();
				getClassified_in().addAll((Collection<? extends World>)newValue);
				return;
			case StoriesPackage.NODE_STATE__NOT_CLASSIFIED_IN:
				getNot_classified_in().clear();
				getNot_classified_in().addAll((Collection<? extends World>)newValue);
				return;
			case StoriesPackage.NODE_STATE__ANTI_RIGID_CLASSES:
				getAntiRigidClasses().clear();
				getAntiRigidClasses().addAll((Collection<? extends RefOntoUML.Class>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case StoriesPackage.NODE_STATE__CLASSIFIED_IN:
				getClassified_in().clear();
				return;
			case StoriesPackage.NODE_STATE__NOT_CLASSIFIED_IN:
				getNot_classified_in().clear();
				return;
			case StoriesPackage.NODE_STATE__ANTI_RIGID_CLASSES:
				getAntiRigidClasses().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case StoriesPackage.NODE_STATE__CLASSIFIED_IN:
				return classified_in != null && !classified_in.isEmpty();
			case StoriesPackage.NODE_STATE__NOT_CLASSIFIED_IN:
				return not_classified_in != null && !not_classified_in.isEmpty();
			case StoriesPackage.NODE_STATE__ANTI_RIGID_CLASSES:
				return antiRigidClasses != null && !antiRigidClasses.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	private String isClassifiedIn(Node n, RefOntoUML.Class c, World w){
		return '\t'+ n.getLabel()+" in "+w.getLabel()+"."+c.getName()+'\n';
	}
	@Override
	public String existance(Node target) {
		String existance = "";
		for( World w: this.getClassified_in()){
			for(RefOntoUML.Class c : this.getAntiRigidClasses()){
				existance = existance+ this.isClassifiedIn(target,c,w);
			}
		}
		for( World w: this.getNot_classified_in()){
			for(RefOntoUML.Class c : this.getAntiRigidClasses()){
				existance = existance+ "not "+this.isClassifiedIn(target,c,w);
			}
		}
		return existance;
	}

} //Node_stateImpl
