

## OntoUML in the Enterprise Architect ##

OLED supports OntoUML models designed with the Enterprise Architect v.10. In the following, we explain step-by-step how to install, access and use OntoUML in the Enterprise Architect and how you can export your EA model to use it in OLED.


---

**Installation**

---


Step-by-step:

  * Delete any version that you might have of the OntoUML MDG Technology and the OntoUML Template: exclude the older XML files and replace them to the new XML files in the following folders:

  * Copy the file **ontoumlMDG1.3.xml** to the folder MDGTechnologies at EA home, usually C:\Program Files\Sparx Systems\EA\MDGTechnologies .

> Newest: [ontoumlMDG1.3.xml](https://drive.google.com/file/d/0B7WqSwi56QipbkhCcHpkdnQ4MWs/edit?usp=sharing) ~3MB - Updated: Nov 7 2013

> Previous: [ontoumlMDG1.2.xml](https://drive.google.com/file/d/0B7WqSwi56QipcUVMZ2JHSUMtNUU/edit?usp=sharing) ~3MB - Updated: Aug 28 2013

> Note: The MDG 1.3 introduces 3 design patterns. Moreover, patterns with partitions do not create generalization sets anymore for this was a bug.

  * Copy the file **ontoumlTemplate.xml** to the folder modelPatterns at EA home, usually C:\Program Files\Sparx Systems\EA\modelPatterns.

> Newest: [ontoumlTemplate.xml](https://drive.google.com/file/d/0B7WqSwi56QipMXhkdHFwdlRYaUk/edit?usp=sharing) ~70KB - Updated: Aug 28 2013

  * Start the Enterprise Architect EA


---

**Access the OntoUML Language in EA**

---


Step-by-step:

  * Choose _new Project_.

  * When the Model Wizard prompts, select the option _OntoUML_ under _Technology_.

  * Check the option _OntoUML_ under _Name_.

  * If the option _OntoUML_ does not appear in the Model Wizard windows, go to: _Settings -> MDG Technologies_, locate _OntoUML_, select the checkbox, and later click _OK_.


---

**Create an OntoUML Diagram**

---


Step-by-step:

  * To create OntoUML diagrams, just click into a folder in the Project Browser and do: _Right Click on the Package/Folder -> Add -> Add Diagram… -> OntoUML_.


---

**Activate the OntoUML Toolbox**

---


Step-by-step:

  * To activate the OntoUML Toolbox, if is not already activated, go to _Diagram-> Diagram Toolbox._

![https://ontouml-lightweight-editor.googlecode.com/svn/wiki/ea-screenshot.png](https://ontouml-lightweight-editor.googlecode.com/svn/wiki/ea-screenshot.png)


---

**Export an OntoUML model as XMI**

---


Step-by-step:

  * To export the model in an EA format: _Right Click on the Package/View -> Import/Export -> Export Package to XMI file_.


---

**Import EA's XMI file into OLED**

---


Step-by-step:

  * To bring your EA model into OLED, first open the OLED application through a double click on the JAR file or through the command line "java -jar oled.jar" in a console.

  * Go to: _File -> Import from -> Enterprise Architect (EA)_.

  * When the window prompts, select the XMI file which you exported from EA in previous steps.

  * Customize your options (if you want to) before hit the "Parse File" button. OLED will parse your entered XMI file.

  * When OLED asks you to filter your model this means that if you don't want to bring your entire model to OLED you can select which diagrams or packages do you want to bring. In this case, when OLED asks you to filter the model, just click in "Yes". Otherwise, to bring your entire model from EA, just click on the button "No".

  * If you previous answer was to filter your model. Just select which packages/diagrams do you want to bring and press "Import to OLED".

![https://ontouml-lightweight-editor.googlecode.com/svn/wiki/oled-importation-ea.png](https://ontouml-lightweight-editor.googlecode.com/svn/wiki/oled-importation-ea.png)


---


**User Guide**

Here is a user guide to the OntoUML MDG technology version 1.2 for EA version 10:

[OntoUML MDG Technology Guide v1.2.docx](https://docs.google.com/file/d/0B7WqSwi56QipenA1N3lwVl9OQWM/edit)