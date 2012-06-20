package br.ufes.inf.nemo.ontouml.xmi2refontouml.transformation;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import br.ufes.inf.nemo.ontouml.xmi2refontouml.util.RefOntoUMLResourceFactory;


import RefOntoUML.*;
import RefOntoUML.impl.*;

public class RefOntoCreator {
	
	public static String save_file_address;
	public Resource resource;
	public RefOntoUMLFactory factory = RefOntoUMLFactory.eINSTANCE;
	
	public void intialize(String saveAddress) {

		//Criar um ResourceSet para "gerenciar" o resource do modelo
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new RefOntoUMLResourceFactory());
		resourceSet.getPackageRegistry().put(RefOntoUML.RefOntoUMLPackage.eNS_URI,RefOntoUML.RefOntoUMLPackage.eINSTANCE);
		RefOntoUMLPackageImpl.init();
		
		//Cria um novo modelo (Resource) na URL especificada
		resource = resourceSet.createResource(URI.createURI(saveAddress));
		save_file_address = saveAddress;

	}
	
	public void saveXMI() throws IOException {
		// Saves XMI into file
	
		//resource.setURI(URI.createURI("file://"+save_file_address));
		try {
			resource.save(Collections.EMPTY_MAP);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	/*
	 * CREATOR METHODS
	 */
	
	public RefOntoUML.Model createModel() {
		Model model = factory.createModel();
		resource.getContents().add(model);
		return model;
	}
	
	public RefOntoUML.Package createPackage() {
		return factory.createPackage();
	}
	
	public RefOntoUML.Class createClass(String stereotype) {
		
		RefOntoUML.Class newclass = null;
		
		// Criar elementos do tipo Class
		if (stereotype.equalsIgnoreCase("kind")) {
    		newclass = factory.createKind();
    	} 
		else if (stereotype.equalsIgnoreCase("subkind")) {
    		newclass = factory.createSubKind();
    	} 
    	else if (stereotype.equalsIgnoreCase("role")) {
    		newclass = factory.createRole();
    	} 
    	else if (stereotype.equalsIgnoreCase("phase")) {
    		newclass = factory.createPhase();
    	}
    	else if (stereotype.equalsIgnoreCase("category")) {
    		newclass = factory.createCategory();
    	}
    	else if (stereotype.equalsIgnoreCase("collective")) {
    		newclass = factory.createCollective();
    	}
    	else if (stereotype.equalsIgnoreCase("mixin")) {
    		newclass = factory.createMixin();
    	}
    	else if (stereotype.equalsIgnoreCase("mode")) {
    		newclass = factory.createMode();
    	}
    	else if (stereotype.equalsIgnoreCase("quantity")) {
    		newclass = factory.createQuantity();
    	}
    	else if (stereotype.equalsIgnoreCase("relator")) {
    		newclass = factory.createRelator();
    	}
    	else if (stereotype.equalsIgnoreCase("rolemixin")) {
    		newclass = factory.createRoleMixin();
    	}
    	else {
    		System.out.println("Error: Stereotype '" + stereotype + "' not supported.");
    	}
		
		return newclass;
	}
	
	public RefOntoUML.DataType createDataType(String stereotype) {
		
		DataType newdatatype = null;
		
		//Cria elementos do tipo DataType
    	if (stereotype.equalsIgnoreCase("datatype")) {
    		newdatatype = factory.createDataType();
    	}
    	else if (stereotype.equalsIgnoreCase("primitivetype")) {
    		newdatatype = factory.createPrimitiveType();
    	}
    	else if (stereotype.equalsIgnoreCase("enumeration") || stereotype.equalsIgnoreCase("enum")) {
    		newdatatype = factory.createEnumeration();
    	}
    	else {
    		System.out.println("Error: Stereotype '" + stereotype + "' not supported.");
    	}
    	
    	return newdatatype;
	}
	
	public RefOntoUML.Association createAssociation(String stereotype) {
		
		Association newassoc = null;
		
		if (stereotype.equalsIgnoreCase("characterization")) {
			newassoc = factory.createCharacterization();
    	}
		else if (stereotype.equalsIgnoreCase("componentof")) {
    		newassoc = factory.createcomponentOf();
    	}
		else if (stereotype.equalsIgnoreCase("formal")) {
    		newassoc = factory.createFormalAssociation();
    	}
		else if (stereotype.equalsIgnoreCase("derivation")) {
    		newassoc = factory.createDerivation();
    	}
		else if (stereotype.equalsIgnoreCase("material")) {
    		newassoc = factory.createMaterialAssociation();
    	}
		else if (stereotype.equalsIgnoreCase("mediation")) {
    		newassoc = factory.createMediation();
    	}
		else if (stereotype.equalsIgnoreCase("memberof")) {
    		newassoc = factory.creatememberOf();
    	}
		else if (stereotype.equalsIgnoreCase("subcollectionof")) {
    		newassoc = factory.createsubCollectionOf();
    	}
		else if (stereotype.equalsIgnoreCase("subquantityof")) {
    		newassoc = factory.createsubQuantityOf();
    	}
		else {
			System.out.println("Error: Stereotype '" + stereotype + "' not supported.");
		}
		
		return newassoc;
	}
	
	public RefOntoUML.Property createProperty() {
		return factory.createProperty();
	}
	
	public RefOntoUML.Generalization createGeneralization() {
		return factory.createGeneralization();
	}
	
	public RefOntoUML.GeneralizationSet createGeneralizationSet() {
		return factory.createGeneralizationSet();
	}
	
	public RefOntoUML.Dependency createDependency() {
		return factory.createDependency();
	}
	
	public RefOntoUML.Comment createComment() {
		return factory.createComment();
	}
	
	/* 
	 * DEALER METHODS 
	 */
	
	public void dealModel(RefOntoUML.Model model, Map<String, Object> hashProp) {
		model.setViewpoint((String)hashProp.get("viewpoint"));
		dealPackage(model, hashProp);
	}
	
	public void dealPackage(RefOntoUML.Package pack, Map<String, Object> hashProp) {
		dealPackageableElement(pack, hashProp);
		dealNamespace(pack, hashProp);
	}
	
	public void dealClass(RefOntoUML.Class cl, Map<String, Object> hashProp) {
		try {
			// Specific property of Collective
    		((Collective)cl).setIsExtensional(Boolean.parseBoolean((String)hashProp.get("isextensional")));
    	} catch (ClassCastException e) {
    		// DO NOTHING
    	}
    	cl.setIsActive(Boolean.parseBoolean((String)hashProp.get("isactive")));
    	dealClassifier(cl, hashProp);
	}
	
	public void dealDataType(RefOntoUML.DataType dt, Map<String, Object> hashProp) {
		dealClassifier(dt, hashProp);
	}
	
	public void dealAssociation(RefOntoUML.Association assoc1, Map<String, Object> hashProp) {
		try {
			// Specific properties of Meronymic associations.
    		((Meronymic)assoc1).setIsEssential(Boolean.parseBoolean((String)hashProp.get("isessential")));
    		((Meronymic)assoc1).setIsImmutablePart(Boolean.parseBoolean((String)hashProp.get("isimmutablepart")));
    		((Meronymic)assoc1).setIsImmutableWhole(Boolean.parseBoolean((String)hashProp.get("isimmutablewhole")));
    		((Meronymic)assoc1).setIsInseparable(Boolean.parseBoolean((String)hashProp.get("isinseparable")));
    		((Meronymic)assoc1).setIsShareable(Boolean.parseBoolean((String)hashProp.get("isshareable")));
    	} catch (ClassCastException e) {
    		// DO NOTHING
    	}
		assoc1.setIsDerived(Boolean.parseBoolean((String)hashProp.get("isderived")));
		dealClassifier(assoc1, hashProp);
		dealRelashionship(assoc1, hashProp);
	}
	
	public void dealClassifier (Classifier c1, Map<String, Object> hashProp) {
		c1.setIsAbstract(Boolean.parseBoolean((String)hashProp.get("isabstract")));
		dealNamespace(c1, hashProp);
		dealRedefElement(c1, hashProp);
		dealType(c1, hashProp);
	}
	
	public void dealGeneralization (Generalization gen1, Map<String, Object> hashProp) {
		gen1.setIsSubstitutable(Boolean.parseBoolean((String)hashProp.get("issubstitutable")));
		// General and Specific are EOposites.
		// Given that, it`s only necessary to define one of those properties.
		gen1.setGeneral((Classifier)hashProp.get("general"));
		gen1.setSpecific((Classifier)hashProp.get("specific"));
		dealDirectedRelashionship(gen1, hashProp);
	}
	
	public void dealGeneralizationSet (GeneralizationSet genset1, Map<String, Object> hashProp) {
		genset1.setIsCovering(Boolean.parseBoolean((String)hashProp.get("iscovering")));
		genset1.setIsDisjoint(Boolean.parseBoolean((String)hashProp.get("isdisjoint")));

		for (Object gen : (List<?>)hashProp.get("generalization")) {
			// Only one of those properties must be set, since they are EOposite.
			genset1.getGeneralization().add((Generalization)gen);
			((Generalization)gen).getGeneralizationSet().add(genset1);
		}
		
		dealPackageableElement(genset1, hashProp);
	}
	
	public void dealDependency (Dependency dep1, Map<String, Object> hashProp) {
		for (Object client : (List<?>)hashProp.get("client")) {
			dep1.getClient().add((NamedElement)client);
		}
		for (Object supplier : (List<?>)hashProp.get("supplier")) {
			dep1.getSupplier().add((NamedElement)supplier);
		}
		
		dealPackageableElement(dep1, hashProp);
		dealDirectedRelashionship(dep1, hashProp);
	}
	
	public void dealDirectedRelashionship (DirectedRelationship drel, Map<String, Object> hashProp) {
		dealRelashionship(drel, hashProp);
	}
	
	public void dealRelashionship (Relationship rel1, Map<String, Object> hashProp) {
		dealElement(rel1, hashProp);
	}
	
	public void dealProperty(RefOntoUML.Property prop1, Map<String, Object> hashProp) {
		prop1.setIsDerived(Boolean.parseBoolean((String)hashProp.get("isderived")));
		//property.setIsDerivedUnion(Boolean.parseBoolean(hashProp.get("isderivedunion")));
		//property.setDefault(value);
		//property.setIsComposite(Boolean.parseBoolean(hashProp.get("iscomposite")));
		prop1.setAggregation(AggregationKind.get((String)hashProp.get("aggregation")));
		dealStructFeature(prop1, hashProp);
	}
	
	public void dealStructFeature (StructuralFeature stf, Map<String, Object> hashProp) {
		stf.setIsReadOnly(Boolean.parseBoolean((String)hashProp.get("isreadonly")));
		dealFeature(stf, hashProp);
		dealTypedElement(stf, hashProp);
		dealMultiplicityElement(stf, hashProp);
	}
	
	public void dealFeature (StructuralFeature feat, Map<String, Object> hashProp) {
		feat.setIsReadOnly(Boolean.parseBoolean((String)hashProp.get("isstatic")));
		dealRedefElement(feat, hashProp);
	}
	
	public void dealType (RefOntoUML.Type typ, Map<String, Object> hashProp) {
		dealPackageableElement(typ, hashProp);
	}
	
	public void dealTypedElement (RefOntoUML.TypedElement tel, Map<String, Object> hashProp) {
		tel.setType((Type)hashProp.get("type"));
		dealNamedElement(tel, hashProp);
	}
	
	// M�todo criado puramente no intuito de tornar a representa��o ideal do metamodelo
	public void dealPackageableElement (RefOntoUML.PackageableElement pack, Map<String, Object> hashProp) {
		dealNamedElement(pack, hashProp);
	}
	
	// M�todo criado puramente no intuito de tornar a representa��o ideal do metamodelo
	public void dealNamespace (RefOntoUML.Namespace namesp, Map<String, Object> hashProp) {
		dealNamedElement(namesp, hashProp);
	}
	
	public void dealRedefElement(RefOntoUML.RedefinableElement rel, Map<String, Object> hashProp) {
		rel.setIsLeaf(Boolean.parseBoolean((String)hashProp.get("isleaf")));
		dealNamedElement(rel, hashProp);
	}
	
	public void dealMultiplicityElement (RefOntoUML.MultiplicityElement mel, Map<String, Object> hashProp) {
		RefOntoUML.LiteralInteger lowerValue = factory.createLiteralInteger();
		RefOntoUML.LiteralUnlimitedNatural upperValue = factory.createLiteralUnlimitedNatural();
		
		if (hashProp.get("lower") != null && hashProp.get("upper") != null) {
			lowerValue.setValue(Integer.parseInt((String)hashProp.get("lower")));
			upperValue.setValue(Integer.parseInt((String)hashProp.get("upper")));
			mel.setLowerValue(lowerValue);
			mel.setUpperValue(upperValue);
		} else {
			System.out.println("Warning: Property '"+hashProp.get("name")+"' multiplicity undefined.");
		}
		
		dealElement(mel, hashProp);
	}
	
	public void dealNamedElement (RefOntoUML.NamedElement nel, Map<String, Object> hashProp) {
		nel.setName((String)hashProp.get("name"));
		nel.setVisibility(VisibilityKind.get((String)hashProp.get("visibility")));
		dealElement(nel, hashProp);
	}
	
	public void dealComment (RefOntoUML.Comment com, Map<String, Object> hashProp) {
		com.setBody((String)hashProp.get("body"));
		
		for (Object annotatedElement : (List<?>)hashProp.get("annotatedelement")) {
			com.getAnnotatedElement().add((Element)annotatedElement);
		}
		
		dealElement(com, hashProp);
	}
	
	public void dealElement (RefOntoUML.Element ele, Map<String, Object> hashProp) {
		//ele.getOwnedComment().add();
	}
	
	/*
	 * ADD METHODS
	 */
	
	public void addPackagedElement(RefOntoUML.Package pack, RefOntoUML.PackageableElement pel) {
		pack.getPackagedElement().add(pel);
	}
	
	public void addProperty(RefOntoUML.Classifier classf, RefOntoUML.Property prop) {
		if (classf instanceof RefOntoUML.Class) {
        	((RefOntoUML.Class)classf).getOwnedAttribute().add(prop);
        }
		else if (classf instanceof RefOntoUML.DataType) {
        	((RefOntoUML.DataType)classf).getOwnedAttribute().add(prop);
		}
		else if (classf instanceof RefOntoUML.Association) {
			((RefOntoUML.Association)classf).getOwnedEnd().add(prop);
			((RefOntoUML.Association)classf).getMemberEnd().add(prop);
			prop.setAssociation(((RefOntoUML.Association)classf));
		}
	}
	
	public void addGeneralization(RefOntoUML.Classifier classf, RefOntoUML.Generalization gen) {
		classf.getGeneralization().add(gen);
	}
	
	public void addComment(RefOntoUML.Element elem, RefOntoUML.Comment comment) {
		elem.getOwnedComment().add(comment);
	}

}
