

## OntoUML Infrastructure ##

OLED uses an infrastructure which was former developed by Roberto Carrareto, latter enhanced by Antognoni Albuquerque and now constantly improved by us. This means that you can sort of "integrate" your project with OLED using this infrastructure to create your models.

To use the infrastruture you will need of the following Eclipse (Modeling Tools) libraries in your project:

  * lpg.runtime.java
  * org.eclipse.emf.common
  * org.eclipse.emf.ecore.xmi
  * org.eclipse.emf.ecore
  * org.eclipse.ocl
  * org.eclipse.ocl.ecore
  * org.eclipse.ocl.common

We recommend using versions 4.X of Eclipse for these libraries because we actually develop OLED in these versions. Besides these Eclipse libraries, you will of course need of our OntoUML infrastructure, which can be found at: trunk/br.ufes.inf.nemo.common/lib/refontouml/

  * [br.ufes.inf.nemo.ontouml\_1.0.0.201409252327.jar](https://docs.google.com/file/d/0B7WqSwi56QipXzQ5dWo0WXRrUjA/edit) (Click here to download the library)


---


If you are not familiar with UML2 project of Eclipse, since OntoUML is an ontologically version of the Unified Modeling Language, it should be a great help to know how to create dynamically UML models via code using the Eclipse-based implementation of UML. There is a tutorial for that according to some eclipse versions. The process of creating OntoUML models is, in some extent, similar to that of UML2 project of Eclipse. Altough not necessary, you may want to take a look in these tutorials:

  * [Getting Started with UML2 (Luna 2014)](http://wiki.eclipse.org/MDT/UML2/Getting_Started_with_UML2)
  * [Getting Started with UML2 (Ganymede 2008)](http://www.eclipse.org/modeling/mdt/uml2/docs/articles/Getting_Started_with_UML2/article.html)


---

Here is a sample of the development (via code) of an ontology about traffic accidents using our OntoUML infrastructure.

---


```
//create the model
RefOntoUML.Package model = RefOntoUMLFactoryUtil.createPackage("Accident");
		
//create kinds
RefOntoUML.Kind person = RefOntoUMLFactoryUtil.createKind("Person", model);
RefOntoUML.Kind vehicle = RefOntoUMLFactoryUtil.createKind("Vehicle", model);
RefOntoUML.Kind roadway = RefOntoUMLFactoryUtil.createKind("Roadway", model);
		
//create subkinds
RefOntoUML.SubKind man = RefOntoUMLFactoryUtil.createSubKind("Man", model);
RefOntoUML.SubKind woman = RefOntoUMLFactoryUtil.createSubKind("Woman", model);
		
//create phases
RefOntoUML.Phase living = RefOntoUMLFactoryUtil.createPhase("Living", model);
RefOntoUML.Phase deceased = RefOntoUMLFactoryUtil.createPhase("Deceased", model);

//create roles
RefOntoUML.Role victim = RefOntoUMLFactoryUtil.createRole("Victim", model);
RefOntoUML.Role traveler = RefOntoUMLFactoryUtil.createRole("Traveler", model);
RefOntoUML.Role crashed = RefOntoUMLFactoryUtil.createRole("CrashedVehicle", model);
				
//create relators
RefOntoUML.Relator accident = RefOntoUMLFactoryUtil.createRelator("Traffic Accident", model);
RefOntoUML.Relator rearEndCollision = RefOntoUMLFactoryUtil.createRelator("Rear End Collision", model);
RefOntoUML.Relator travel = RefOntoUMLFactoryUtil.createRelator("Travel", model);
		
//create a partition between man and woman
List<Classifier> specifics = new ArrayList<Classifier>();
specifics.add(man);
specifics.add(woman);
RefOntoUMLFactoryUtil.createPartition("gender",specifics, person, model);
		
//create a partition between living and deceased
specifics.clear();
specifics.add(living);
specifics.add(deceased);
RefOntoUMLFactoryUtil.createPartition("life",specifics, person, model);
				
// create generalizations/specializations
RefOntoUMLFactoryUtil.createGeneralization(traveler, person);
RefOntoUMLFactoryUtil.createGeneralization(victim, traveler);		
RefOntoUMLFactoryUtil.createGeneralization(crashed, vehicle);
RefOntoUMLFactoryUtil.createGeneralization(rearEndCollision, accident);

//create primitive types and attributes
RefOntoUML.PrimitiveType intPrimitive = RefOntoUMLFactoryUtil.createPrimitiveType("int", model);		
RefOntoUMLFactoryUtil.createAttribute(accident, intPrimitive, 1, 1, "fatalvictims", true);
		
//create mediations
RefOntoUMLFactoryUtil.createMediation(accident, 1, -1, "occurs", roadway, 1, 1, model);
RefOntoUMLFactoryUtil.createMediation(accident, 1, 1, "has", victim, 1, -1, model);
RefOntoUMLFactoryUtil.createMediation(accident, 1, 1, "involves", crashed, 1, -1, model);		
RefOntoUMLFactoryUtil.createMediation(travel, 1, 1, "has", traveler, 1, -1, model);
RefOntoUMLFactoryUtil.createMediation(travel, 1, 1, "made by", vehicle, 1, 1, model);
		
//create material relationship
RefOntoUML.MaterialAssociation material = RefOntoUMLFactoryUtil.createMaterialAssociation(victim, 1, -1, "has been victim in", roadway, 1, 1, model);
		
//create the derivation
RefOntoUMLFactoryUtil.createDerivation(material, accident, model);
			
//save model into a file
File file = new File("src/br/ufes/inf/nemo/ontouml/example/accident.refontouml");
RefOntoUMLResourceUtil.saveModel(file.getAbsolutePath(), model);
```


---

**Importing a model into OLED**

---


To **import** the .refontouml file generated into OLED, just do as it follows:

  1. Go to: File -> Import -> OntoUML (Infrastructure)
  1. Choose the refontouml file and press Ok.

In other versions of OLED this menu option might be displayed with some other description, but the idea should be very similar to this one.