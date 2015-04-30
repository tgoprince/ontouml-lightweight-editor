

## Running OLED via Source Code ##

First, you'll have to download all of our Java code to your computer through some Subversion client application such as TortoiseSVN ([download it here](http://tortoisesvn.net/)). If you are not sure how to do this, for now, you can search it on google. We will have a tutorial for that in the future. Eclipse also has support for subversion clients, so you can use it to download the source code.

Once you have checked out the source code in your machine and installed the Eclipse Modeling Tools (Juno or superior) in it ([download it here](https://eclipse.org/downloads/)). All you have to do to run OLED in a Java-based Eclipse is in the following:

Requirements:

  * Java 7 or superior installed in your machine
  * Eclipse Modeling Tools (Juno or superior)
  * SVN client application (TortoiseSVN or other)

### Step 1: Importing the Source Code into Eclipse ###

1. Open the Eclipse Modeling Tools application and choose the appropriate workspace, that is, the root folder where you downloaded the source code of our tool.

2. Go to File -> Import-> General ->Existing Project into Workspace

3. Choose the root directory clicking in the Browse button. This directory is the same of your workspace where you can find all the source code.

4. Once all the projects are loaded in the dialog area, check them all and click in Finish.

### Step 2: Configuring the SWT to your System ###

Before running it, **you need to change the SWT JAR library attached to some of our projects**. By default, all of our projects point to the Winx64 SWT library. We use SWT in some of our projects and this is the best we could do at the moment to attach the correct library in development time.

If you use a Win-x64 system, you can skip this step and go to the next step (How to Run the Application). If not, do as it follows:

Right click on the project you want to configure and go to _Build Path -> Configure Build Path_. In the Libraries tab, search for the _swt.jar_ file. Notice that it is a win x64 library attached. Remove this entry clicking on _Remove_ and click on _Add Jars_. All the SWT libraries are at _br.ufes.inf.nemo.common/lib/_ folder. Choose your appropriate entry according to your OS (linux, windows or macosx). This process must be repeated to each of the following projects:

  * br.ufes.inf.nemo.antipattern
  * br.ufes.inf.nemo.assistant
  * br.ufes.inf.nemo.assistant.parser
  * br.ufes.inf.nemo..pattern
  * br.ufes.inf.nemo.oled

We will try to find a better solution for this but for now, you will need to change the SWT libraries for development, according to your OS by hand.

### Step 3: Running the Application ###

Now that you already configured the SWT libraries according to your OS. Just one more detail:

**Mac Users: If you do not do this in Eclipse/MacOS, the application won't start, in fact, nothing is going to happen**.

Go to _br.ufes.inf.nemo.oled/Main.java_ file, _Right click -> Run As -> Run Configurations -> Arguments Tab_, and **DISABLE** the checkbox to not use the XstartOnFirstThread argument.

To run the Application. Go to: _Main.java -> Right Click -> Run As -> Java Application_