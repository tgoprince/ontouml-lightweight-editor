package br.ufes.inf.nemo.ontouml2z3py;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;

import RefOntoUML.Classifier;
import RefOntoUML.Generalization;
import RefOntoUML.GeneralizationSet;
import RefOntoUML.Kind;
import RefOntoUML.ObjectClass;
import RefOntoUML.Phase;
import RefOntoUML.Role;
import RefOntoUML.SubKind;
import br.ufes.inf.nemo.common.ontoumlparser.OntoUMLParser;
import br.ufes.inf.nemo.common.resource.ResourceUtil;
import br.ufes.inf.nemo.z3py.BooleanFunctionDefinition;
import br.ufes.inf.nemo.z3py.Conjunction;
import br.ufes.inf.nemo.z3py.Equality;
import br.ufes.inf.nemo.z3py.Expression;
import br.ufes.inf.nemo.z3py.FunctionCall;
import br.ufes.inf.nemo.z3py.IntConstant;
import br.ufes.inf.nemo.z3py.LogicalBinaryExpression;
import br.ufes.inf.nemo.z3py.LogicalNegation;
import br.ufes.inf.nemo.z3py.OntoUMLZ3System;
import br.ufes.inf.nemo.z3py.Quantification;
import br.ufes.inf.nemo.z3py.impl.Z3pyFactoryImpl;
import br.ufes.inf.nemo.z3py.impl.Z3pyFactoryImpl.LogicalBinaryExpressionTypes;
public class Transformer {
	
	private OntoUMLParser ontoparser;
	private String sourceModelPath;
	private Z3pyFactoryImpl factory = new Z3pyFactoryImpl();
	private OntoUMLZ3System generatedModel;
	List<RefOntoUML.Class> identityProviderTypes = new ArrayList<RefOntoUML.Class>();
	
	public Transformer(){
		
	}
	
	public Transformer(String sourceModelPath){
		this.sourceModelPath= sourceModelPath;
		
	}
	public OntoUMLZ3System run(){
		
		generatedModel = factory.createOntoUMLZ3System();
		//Gero toda a axiomatização referente a estrutura de mundos
		populateWithBranchInTimeWorldStructure();
		//Adiciono a estrutura que utilizarei para verificar se um dado elemento existe em um dado mundo
		populateWithExistenceAxioms();		
		Resource resource;
		try {
			resource = ResourceUtil.loadReferenceOntoUML(sourceModelPath);
			RefOntoUML.Package root  = (RefOntoUML.Package)resource.getContents().get(0);
			ontoparser = new OntoUMLParser(root);	
			populateWithObjectClasses();
			populatesWithGeneralizations();
			
			//Crio fórmula que garante que todo elemento de mundo é instância de um tipo que provê identidade
			addIdentityFormula(identityProviderTypes);	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return generatedModel;	
	}
	
	private void populatesWithGeneralizations()
	{
		FunctionCall general,specific;
		Expression e;
		for(Generalization g: ontoparser.getAllInstances(Generalization.class))
		{
			general = factory.createFunctionCall(getFunction(g.getGeneral().getName()), getConstants(new int[]{1, 2}));
			specific = factory.createFunctionCall(getFunction(g.getSpecific().getName()), getConstants(new int[]{1, 2})); 
			e = factory.createBinaryExpression(specific, general, LogicalBinaryExpressionTypes.IMPLICATION);
			addFormula(true, e, specific.getCalledFunction().getName() + " is subtypes of " + general.getCalledFunction().getName());
		}
	}
	
	private void populatesWithGeneralizationSets()
	{
		FunctionCall general,specific;
		Expression e;
		Generalization g;
		boolean isCovering, isDisjoint;
		for(GeneralizationSet gs: ontoparser.getAllInstances(GeneralizationSet.class))
		{	
			isCovering = gs.isIsCovering();
			isDisjoint = gs.isIsDisjoint();
			List<Generalization> generalizations = gs.getGeneralization();
			if(generalizations.size() ==1 && isCovering){
				g = generalizations.get(0);
				general = factory.createFunctionCall(getFunction(g.getGeneral().getName()), getConstants(new int[]{1, 2}));
				specific = factory.createFunctionCall(getFunction(g.getSpecific().getName()), getConstants(new int[]{1, 2})); 
				e = factory.createBinaryExpression(general, specific, LogicalBinaryExpressionTypes.IMPLICATION);
				addFormula(true, e, "The generalization set is complete. Thus, every "+ general.getCalledFunction().getName() + " is also a " + specific.getCalledFunction().getName());
			}else if(generalizations.size() >2){
				if (isCovering){
					for(Generalization g1: generalizations){
						//Fazer or entre todos os specifics
						
						
					}	
					//Fazer implies do general para o or entre todos os specifics
				}
				if (isDisjoint){
					for(Generalization g1: generalizations){
						//quero garantir qualquer que seja o elemento ele não satisfaz mais de um dos subtipos
						//Então, quero negar a disjuncão entre as conunções de dois subtipos quaisquer
						//Por exemplo, se pessoa pode ser homem ou mulher, vou dizer que para todo x em todo mundo w, not(homem(w,x) e mulher(w,x)
						//Se pensarmos em nulher (M), Homem(H) ou bicha (B), teria que fazer que para todo x,w tenho:
						//not ((H(w,x) and M(w,x)) or (H(w,x) and B(w,x)) or (B(w,x) and M(w,x)))
					}	
				}
			}	
		}
	}
	private void populateWithExistenceAxioms() {
		addFunction("exists", 2);
		//Pensar se precisa de uma formula que faça a tipagem dos argumentos de exists
		
	}

	private void populateWithObjectClasses(){
		
		for(RefOntoUML.Class p: ontoparser.getAllInstances(ObjectClass.class)){
			//Crio a função que representa o fato de um dado individuo ser daquele tipo em um dado mundo
			addFunction(p.getName(),2);

			//Tipagem dos argumentos da função: crio fórmula afirmando que se a função criada retorna true, então o primeiro argumento é world e o segundo existe nesse world. 
			FunctionCall fc1 = factory.createFunctionCall(getFunction(p.getName()), getConstants(new int[]{1, 2}));
			FunctionCall fc2 = factory.createFunctionCall(getFunction("World"), getConstants(new int[]{1}));
			FunctionCall fc3 = factory.createFunctionCall(getFunction("exists"), getConstants(new int[]{1,2}));
			LogicalBinaryExpression lbe1 = factory.createBinaryExpression(fc2, fc3, LogicalBinaryExpressionTypes.CONJUNCTION);
			LogicalBinaryExpression lbe2 = factory.createBinaryExpression(fc1, lbe1, LogicalBinaryExpressionTypes.IMPLICATION);
			addFormula(true, lbe2, "Typing the arguments: If "+ p.getName() + "(x,y) holds then x is a world and y exists in x as a " + p.getName());

			//Crio fórumla para evitar trivialização, ou seja, evitar que gere um modelo no qual nao existam elementos daquele tipo
			addFormula(false, fc1, "Formula to avoid Trivialization: Exists at least one "+ p.getName() + " in one world");
			
			if (p instanceof Kind){
				//Como Kind provê identidade, adiciono o tipo ao conjunto de tipos provedores de identidade para no final criar a fórmula que garante que todo mundo tem identidade
				identityProviderTypes.add(p);
				//Crio formula que garante que o tipo é rígido
				addRigidityFormula(p);						
			}
			else if (p instanceof SubKind){
				addRigidityFormula(p);
			}
			else if (p instanceof Phase){
				addAntiRigidityFormulaConsideringBranchInTime(p);
			}
			else if (p instanceof Role){
				addAntiRigidityFormulaConsideringBranchInTime(p);
			}
		}
			
		
	}
	
	
	private void populateWithBranchInTimeWorldStructure(){
		
		//Crio as funções que utilizarei		
		addFunction("World",1);
		addFunction("CurrentWorld",1);
		addFunction("PastWorld",1);
		addFunction("CounterfactualWorld", 1);
		addFunction("FutureWorld", 1);
		addFunction("next", 2);
		addFunction("recursiveNext", 2);


		//Crio as fórmulas
		//1.	1.	∀x,y (next(x,y) → World(x) ∧ World(y))		
		FunctionCall fc1 = factory.createFunctionCall(getFunction("next"), getConstants(new int[]{1, 2}));
		FunctionCall fc2 = factory.createFunctionCall(getFunction("World"), getConstants(new int[]{1}));
		FunctionCall fc3 = factory.createFunctionCall(getFunction("World"), getConstants(new int[]{2}));
		LogicalBinaryExpression lbe1 = factory.createBinaryExpression(fc2, fc3, LogicalBinaryExpressionTypes.CONJUNCTION);
		LogicalBinaryExpression lbe2 = factory.createBinaryExpression(fc1, lbe1, LogicalBinaryExpressionTypes.IMPLICATION);
		addFormula(true, lbe2, "The two arguments fo the function next are worlds");
		
		//2.	∀x,y,z (next(x,y) ∧ next(z,y)) →x=z
		fc1 = factory.createFunctionCall(getFunction("next"), getConstants(new int[]{1, 2}));
		fc2 = factory.createFunctionCall(getFunction("next"), getConstants(new int[]{3, 2}));
		lbe1 = factory.createBinaryExpression(fc1, fc2, LogicalBinaryExpressionTypes.CONJUNCTION);
		Equality e1 = factory.createEquality(getConstants(new int[]{1, 3}));
		lbe2 = factory.createBinaryExpression(lbe1, e1 , LogicalBinaryExpressionTypes.IMPLICATION);
		addFormula(true, lbe2, "Every world is the next of, at most, one world");
		
		//3.	∀x (¬next(x,x))
		fc1 = factory.createFunctionCall(getFunction("next"), getConstants(new int[]{1, 1}));
		LogicalNegation ln = factory.createLogicalNegation(fc1);
		addFormula(true, ln, "The function next is irreflexive");
		
		//4.	∀x,y (recursiveNext(x,y) ↔ next(x,y) ∨ ∃z (next(z,y) ∧ recursiveNext(x,z)))
		fc1= factory.createFunctionCall(getFunction("recursiveNext"), getConstants(new int[]{1, 2}));//1-x, 2-z, 3-y
		fc2= factory.createFunctionCall(getFunction("next"), getConstants(new int[]{2, 3}));
		lbe1 = factory.createBinaryExpression(fc1, fc2, LogicalBinaryExpressionTypes.CONJUNCTION);
		Quantification qt = factory.createQuantification(false, lbe1, new HashSet<IntConstant>(getConstants(new int[]{2})), "");
		fc1= factory.createFunctionCall(getFunction("next"), getConstants(new int[]{1, 3}));//1-x, 2-z, 3-y
		lbe1 = factory.createBinaryExpression(fc1, qt, LogicalBinaryExpressionTypes.DISJUNCTION);
		fc1= factory.createFunctionCall(getFunction("recursiveNext"), getConstants(new int[]{1, 3}));//1-x, 2-z, 3-y
		lbe2 = factory.createBinaryExpression(fc1, lbe1, LogicalBinaryExpressionTypes.BIIMPLICATION);
		addFormula(true,lbe2,"Here we defined the recursiveNext function as a helper to express the transitive closure of the function next");
				
		//5.	∀x,y (recursiveNext(x,y) →¬ recursiveNext(y,x))
		fc1= factory.createFunctionCall(getFunction("recursiveNext"), getConstants(new int[]{1, 2}));//1-x, 2-y		
		fc2= factory.createFunctionCall(getFunction("recursiveNext"), getConstants(new int[]{2, 1}));//1-x, 2-y
		ln = factory.createLogicalNegation(fc2);
		lbe1 = factory.createBinaryExpression(fc1, ln, LogicalBinaryExpressionTypes.IMPLICATION);
		addFormula(true,lbe1,"The next function is assimetric when considering its transitive closure");
		
		//World tem especialização disjunta e completa com CurrentWorld, PastWorld, FutureWorld e CounterfactualWorld
		fc1= factory.createFunctionCall(getFunction("World"), getConstants(new int[]{1}));
		List<FunctionCall> subClasses = new ArrayList<FunctionCall>();
		subClasses.add(factory.createFunctionCall(getFunction("CounterfactualWorld"), getConstants(new int[]{1})));
		subClasses.add(factory.createFunctionCall(getFunction("FutureWorld"), getConstants(new int[]{1})));
		subClasses.add(factory.createFunctionCall(getFunction("PastWorld"), getConstants(new int[]{1})));
		subClasses.add(factory.createFunctionCall(getFunction("CurrentWorld"), getConstants(new int[]{1})));
		
		addSpecializationFormulas(fc1,subClasses, true, true);		
		
		//8.	∃x (CurrentWorld(x))
		fc1= factory.createFunctionCall(getFunction("CurrentWorld"), getConstants(new int[]{1}));
		addFormula(false, fc1, "There is at least one current world");
		
		//9.	∀x,y (CurrentWorld(x) ∧ CurrentWorld(y) → x=y)
		fc1= factory.createFunctionCall(getFunction("CurrentWorld"), getConstants(new int[]{1}));
		fc2= factory.createFunctionCall(getFunction("CurrentWorld"), getConstants(new int[]{2}));
		lbe1 = factory.createBinaryExpression(fc1, fc2, LogicalBinaryExpressionTypes.CONJUNCTION);
		e1 = factory.createEquality(getConstants(new int[]{1, 2}));
		lbe2 = factory.createBinaryExpression(lbe1, e1, LogicalBinaryExpressionTypes.IMPLICATION);
		addFormula(true, lbe2, "There is at most one Current World");
		
		//10.	∀x,y (CurrentWorld(x) ∧ next(x,y) → FutureWorld(y))
		fc1= factory.createFunctionCall(getFunction("CurrentWorld"), getConstants(new int[]{1}));
		fc2= factory.createFunctionCall(getFunction("FutureWorld"), getConstants(new int[]{2}));
		fc3= factory.createFunctionCall(getFunction("next"), getConstants(new int[]{1,2}));
		lbe1 = factory.createBinaryExpression(fc1, fc3, LogicalBinaryExpressionTypes.CONJUNCTION);
		lbe2 = factory.createBinaryExpression(lbe1, fc2, LogicalBinaryExpressionTypes.IMPLICATION);
		addFormula(true, lbe2, "The next world of a current world is a future world");
		
		//11.	∀x,y (FutureWorld(x) ∧ next(x,y) → FutureWorld(y))
		fc1= factory.createFunctionCall(getFunction("FutureWorld"), getConstants(new int[]{1}));
		fc2= factory.createFunctionCall(getFunction("FutureWorld"), getConstants(new int[]{2}));
		fc3= factory.createFunctionCall(getFunction("next"), getConstants(new int[]{1,2}));
		lbe1 = factory.createBinaryExpression(fc1, fc3, LogicalBinaryExpressionTypes.CONJUNCTION);
		lbe2 = factory.createBinaryExpression(lbe1, fc2, LogicalBinaryExpressionTypes.IMPLICATION);
		addFormula(true, lbe2, "The next world of a future world is a future world");
		
		//12.	∀y (FutureWorld(y) → ∃x (CurrentWorld(x) ∧ recursiveNext(x,y)))
		fc1= factory.createFunctionCall(getFunction("CurrentWorld"), getConstants(new int[]{1}));
		fc2= factory.createFunctionCall(getFunction("FutureWorld"), getConstants(new int[]{2}));
		fc3= factory.createFunctionCall(getFunction("recursiveNext"), getConstants(new int[]{1,2}));
		lbe1 = factory.createBinaryExpression(fc1, fc3, LogicalBinaryExpressionTypes.CONJUNCTION);
		qt = factory.createQuantification(false, lbe1, new HashSet<IntConstant>(getConstants(new int[]{1})), "");
		lbe1 = factory.createBinaryExpression(fc2, qt, LogicalBinaryExpressionTypes.IMPLICATION);
		addFormula(true, lbe1, "Every future world is acessible from the current world by the recursiveNext transitive closure");
		
		//13.	∀x,y (PastWorld(x) ∧ next(x,y) → (CurrentWorld(y) ∨ PastWorld(y) ∨ CounterFactualWorld(y)))
		fc1= factory.createFunctionCall(getFunction("PastWorld"), getConstants(new int[]{1}));
		fc2= factory.createFunctionCall(getFunction("CurrentWorld"), getConstants(new int[]{2}));
		fc3= factory.createFunctionCall(getFunction("CounterfactualWorld"), getConstants(new int[]{2}));
		FunctionCall fc4= factory.createFunctionCall(getFunction("PastWorld"), getConstants(new int[]{2}));
		lbe1 = factory.createBinaryExpression(fc3, fc4, LogicalBinaryExpressionTypes.DISJUNCTION);
		lbe1 = factory.createBinaryExpression(fc2, lbe1, LogicalBinaryExpressionTypes.DISJUNCTION);
		fc2= factory.createFunctionCall(getFunction("next"), getConstants(new int[]{1,2}));
		lbe2 = factory.createBinaryExpression(fc1, fc2, LogicalBinaryExpressionTypes.CONJUNCTION);
		lbe2 = factory.createBinaryExpression(lbe2, lbe1, LogicalBinaryExpressionTypes.IMPLICATION);
		addFormula(true, lbe2, "The next world of a past world may be a cuurent world, a counterfactual world or another past world");
		
		//14.	∀x (PastWorld(x) → ∃y (CurrentWorld(y) ∧ recursiveNext(x,y)))
		fc1= factory.createFunctionCall(getFunction("PastWorld"), getConstants(new int[]{1}));
		fc2= factory.createFunctionCall(getFunction("CurrentWorld"), getConstants(new int[]{2}));
		fc3= factory.createFunctionCall(getFunction("recursiveNext"), getConstants(new int[]{1,2}));
		lbe1 = factory.createBinaryExpression(fc2, fc3, LogicalBinaryExpressionTypes.CONJUNCTION);
		qt = factory.createQuantification(false, lbe1, new HashSet<IntConstant>(getConstants(new int[]{2})), "");
		lbe1 = factory.createBinaryExpression(fc1, qt, LogicalBinaryExpressionTypes.IMPLICATION);
		addFormula(true, lbe1, "The current world is acessible from all past worlds by the recursiveNext transitive closure");
		
		//15.	∀x,y (CounterFactualWorld (x) ∧ next(x,y) → CounterFactualWorld (y))
		fc1= factory.createFunctionCall(getFunction("CounterfactualWorld"), getConstants(new int[]{1}));
		fc2= factory.createFunctionCall(getFunction("CounterfactualWorld"), getConstants(new int[]{2}));
		fc3= factory.createFunctionCall(getFunction("next"), getConstants(new int[]{1,2}));
		lbe1 = factory.createBinaryExpression(fc1, fc3, LogicalBinaryExpressionTypes.CONJUNCTION);
		lbe2 = factory.createBinaryExpression(lbe1, fc2, LogicalBinaryExpressionTypes.IMPLICATION);
		addFormula(true, lbe2, "The next world of a contrafactual world is another contrafactual world");
		
		//16.	∀x,y (PastWorld(x) ∧ CounterFactualWorld (y) →  recursiveNext(x,y))
		fc1= factory.createFunctionCall(getFunction("PastWorld"), getConstants(new int[]{1}));
		fc2= factory.createFunctionCall(getFunction("CounterfactualWorld"), getConstants(new int[]{2}));
		fc3= factory.createFunctionCall(getFunction("recursiveNext"), getConstants(new int[]{1,2}));
		lbe1 = factory.createBinaryExpression(fc1, fc2, LogicalBinaryExpressionTypes.CONJUNCTION);
		lbe2 = factory.createBinaryExpression(lbe1, fc3, LogicalBinaryExpressionTypes.IMPLICATION);
		addFormula(true, lbe2, "A contrafactual world is acessible from all past worlds by the recursiveNext transitive closure");
	}
	
	
	//To do: vou ter de alterar form de tratar generalizations. Ver métodos populatesWithGeneralizations e populatesWithGeneralizationSets do transformer de Alloy
	//A ideia é criar a primeira formula no populatewithgeneralization e as formulas de completeness e disjointness no segundo.
	//Detalhe: Ele usa métodos do parser para obter generalization e generalizationSets

	private void addSpecializationFormulas (FunctionCall superClass, List<FunctionCall> subClasses, boolean isComplete, boolean isDisjoint){
		if (subClasses.size()>0){
			Expression subDisjunction = subClasses.get(0);
			FunctionCall f1,f2;
			int i, subClassesNumber = subClasses.size();
			//Adiciono a formula que garante que a especilização existe 			
			String subClassesNames = ((FunctionCall)subDisjunction).getCalledFunction().getName();
			for(i = 1; i<subClassesNumber;i++){
				f1 = subClasses.get(i);
				subDisjunction = factory.createBinaryExpression(f1, subDisjunction, LogicalBinaryExpressionTypes.DISJUNCTION);
				subClassesNames = subClassesNames.concat(", " + f1.getCalledFunction().getName());
			}
			Expression e = factory.createBinaryExpression(subDisjunction, superClass, LogicalBinaryExpressionTypes.IMPLICATION);
			addFormula(true, e, subClassesNames + " are subtypes of " + superClass.getCalledFunction().getName());
			
			//Se for complete, adiciono a formula que garante completude
			if(isComplete){
				e = factory.createBinaryExpression(superClass, subDisjunction, LogicalBinaryExpressionTypes.IMPLICATION);
				addFormula(true, e, "The Specializazion from " + superClass.getCalledFunction().getName() + " in " + subClassesNames + " is complete");
			}
			
			//Se for disjoint adiciono formula que garante disjointness
			if(isDisjoint && subClassesNumber>1){
				//quero garantir qualquer que seja o elemento ele não satisfaz mais de um dos subtipos
				//Então, quero negar a disjuncão entre as conunções de dois subtipos quaisquer
				//Por exemplo, se pessoa pode ser homem ou mulher, vou dizer que para todo x em todo mundo w, not(homem(w,x) e mulher(w,x)
				//Se pensarmos em nulher (M), Homem(H) ou bicha (B), teria que fazer que para todo x,w tenho:
				//not ((H(w,x) and M(w,x)) or (H(w,x) and B(w,x)) or (B(w,x) and M(w,x)))
				Conjunction conj;
				Expression disjointness=null;
				for (i=0;i<subClassesNumber-1; i++){
					f1 = subClasses.get(i);
					for (int j = i+1; j<subClassesNumber; j++){
						f2 = subClasses.get(j);
						conj = (Conjunction) factory.createBinaryExpression(f1, f2, LogicalBinaryExpressionTypes.CONJUNCTION);
						if (disjointness==null)
							disjointness = conj;
						else
							disjointness = factory.createBinaryExpression(disjointness, conj, LogicalBinaryExpressionTypes.DISJUNCTION);
					}
				}
				disjointness = factory.createLogicalNegation(disjointness);
				addFormula(true,disjointness,"The Specializazion from " + superClass.getCalledFunction().getName() + " in " + subClassesNames + " is disjoint");
				
			}			
		}
	}
	
	
	private BooleanFunctionDefinition addFunction(String name, int numberOfArguments){
		BooleanFunctionDefinition newFunction = factory.createFunction(name, numberOfArguments);
		generatedModel.getFunctions().add(newFunction);
		return newFunction;
	}

	private Quantification addFormula(boolean isUniversal, Expression exp, String comments){
		Quantification newFormula = factory.createFormula(isUniversal, exp, comments);
		generatedModel.getFormulas().add(newFormula);
		return newFormula;
	}
	
	private void addIdentityFormula(List<RefOntoUML.Class> identityProviderTypes){
		if (identityProviderTypes.size()>0){
			FunctionCall fc1;
			Expression e1 = factory.createFunctionCall(getFunction(identityProviderTypes.get(0).getName()), getConstants(new int[]{1, 2}));		 
			for(int i = 1; i<identityProviderTypes.size();i++){
				fc1 = factory.createFunctionCall(getFunction(identityProviderTypes.get(i).getName()), getConstants(new int[]{1, 2}));
				e1 = factory.createBinaryExpression(fc1, e1, LogicalBinaryExpressionTypes.DISJUNCTION);
			}
			fc1 = factory.createFunctionCall(getFunction("World"), getConstants(new int[]{1}));
			e1 = factory.createBinaryExpression(fc1, e1, LogicalBinaryExpressionTypes.CONJUNCTION);
			fc1 = factory.createFunctionCall(getFunction("exists"), getConstants(new int[]{1,2}));
			e1 = factory.createBinaryExpression(fc1, e1, LogicalBinaryExpressionTypes.IMPLICATION);
			addFormula(true, e1, "Everything that exists in a world must be of a type that provides an identity principle");
		}
	}
	
	
	private void addRigidityFormula(RefOntoUML.Class type){
		//Ex.:ForAll([w1,w2,x], Implies(And(Pessoa(w1,x), existe(w2,x)),Pessoa(w2,x)))
		FunctionCall fc1 = factory.createFunctionCall(getFunction(type.getName()), getConstants(new int[]{1, 2}));
		FunctionCall fc2 = factory.createFunctionCall(getFunction("exists"), getConstants(new int[]{3,2}));
		FunctionCall fc3 = factory.createFunctionCall(getFunction(type.getName()), getConstants(new int[]{3,2}));
		LogicalBinaryExpression lbe1 = factory.createBinaryExpression(fc1, fc2, LogicalBinaryExpressionTypes.CONJUNCTION);
		LogicalBinaryExpression lbe2 = factory.createBinaryExpression(lbe1, fc3, LogicalBinaryExpressionTypes.IMPLICATION);
		addFormula(true, lbe2, type.getName() + " is a rigid type");	
	}

	private void addAntiRigidityFormulaConsideringBranchInTime(RefOntoUML.Class type){
		//Ex.: ForAll([w1,x], Implies(Aluno(w1,x),Exists(w2,And(existe(w2,x),Not(Aluno(w2,x))))))
		FunctionCall fc1 = factory.createFunctionCall(getFunction(type.getName()), getConstants(new int[]{2, 3}));
		FunctionCall fc2 = factory.createFunctionCall(getFunction("exists"), getConstants(new int[]{2 ,3}));
		LogicalNegation ln = factory.createLogicalNegation(fc1);		
		LogicalBinaryExpression lbe1 = factory.createBinaryExpression(fc2, ln, LogicalBinaryExpressionTypes.CONJUNCTION);
		Quantification qt = factory.createQuantification(false, lbe1, new HashSet<IntConstant>(getConstants(new int[]{2})), "");
		fc1 = factory.createFunctionCall(getFunction(type.getName()), getConstants(new int[]{1, 3}));
		lbe1 = factory.createBinaryExpression(fc1, qt, LogicalBinaryExpressionTypes.IMPLICATION);
		addFormula(true, lbe1, type.getName() + " is a anti-rigid type (this formula considers a branch-in-time structure and so, that counterfactual worlds exist");	
	}

	
	
	private BooleanFunctionDefinition getFunction (String name){
		for (BooleanFunctionDefinition i:generatedModel.getFunctions()){
			if (i.getName().equals(name)) return i;
		}
		return null;
	}
	
	//Cria as constantes sob demanda e retorna uma lista contendo as constantes solicitadas
	private List<IntConstant> getConstants(int[] constIds){
		List <IntConstant> consts, r; 
		r = new ArrayList <IntConstant>();
		consts = generatedModel.getConstants();
		for (int i : constIds){
			//Se aquele indice de variavel nÃ£o existe crio variÃ¡veis atÃ© chegar em tal Ã­ndice
			if (i> consts.size())
				for(int j = consts.size(); j<i;j++)
					addConstant();
			r.add(consts.get(i-1));							
		}
		return r;
	}

	private IntConstant addConstant(){
		IntConstant newConst = factory.createConstant();
		generatedModel.getConstants().add(newConst);
		return newConst;		
	}
	
	public Hashtable<Classifier, Classifier> getGeneralizationSets (){
		Hashtable<Classifier, Classifier> sets = new Hashtable<Classifier, Classifier>();
		for(Generalization p: ontoparser.getAllInstances(Generalization.class)){
			System.out.println("Generalization: "+ p.getGeneral() +" / " +p.getSpecific());
			sets.put(p.getGeneral(), p.getSpecific());
		}
		return sets;		
	}

}