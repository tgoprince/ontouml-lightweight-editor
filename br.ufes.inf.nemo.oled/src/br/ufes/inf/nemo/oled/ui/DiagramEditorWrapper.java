package br.ufes.inf.nemo.oled.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.UIManager;

import br.ufes.inf.nemo.oled.draw.Diagram;
import br.ufes.inf.nemo.oled.model.UmlProject;
import br.ufes.inf.nemo.oled.move.ErrorTablePanel;
import br.ufes.inf.nemo.oled.move.PropertyTablePanel;
import br.ufes.inf.nemo.oled.move.WarningTablePanel;
import br.ufes.inf.nemo.oled.ui.diagram.DiagramEditor;
import br.ufes.inf.nemo.oled.util.ApplicationResources;
import br.ufes.inf.nemo.oled.util.IconLoader;

/** 
 * Wrapper class for {@link DiagramEditor} responsible for providing toolbar and handling the model file.  
 */
public class DiagramEditorWrapper extends JPanel implements Editor{

	private static final long serialVersionUID = -1962960747434759099L;
	private DiagramEditor editor;	
	private JSplitPane editorArea  = new JSplitPane();
	
	public static JTabbedPane infoTabbedPane;
	public static PropertyTablePanel properties;
	public static ErrorTablePanel errors;
	public static WarningTablePanel warnings;
	public static OutputPane outputPane;
	
	//TODO Remove me
	private File projectFile;
	
	public DiagramEditorWrapper(DiagramEditor editor, DiagramEditorCommandDispatcher editorDispatcher)
	{
		super(new BorderLayout());
		this.editor = editor;		
		
		DiagramEditorToolbar editorToolbar = new DiagramEditorToolbar();
		JToolBar toolbar = editorToolbar.getToolbar();
		editorToolbar.addCommandListener(editorDispatcher);
		this.add(toolbar, BorderLayout.NORTH);
		
		editorArea.setContinuousLayout(true);
		editorArea.setOneTouchExpandable(true);
		editorArea.setDividerSize(7);
		editorArea.setOrientation(JSplitPane.VERTICAL_SPLIT);
		editorArea.setResizeWeight(1) ;
		editorArea.setDividerLocation(1.0);
		
		this.add(editorArea, BorderLayout.CENTER);

		JScrollPane scrollpane = new JScrollPane(editor);
		scrollpane.getVerticalScrollBar().setUnitIncrement(10);
		scrollpane.getHorizontalScrollBar().setUnitIncrement(10);
		
		properties = new PropertyTablePanel(editor.getProject());		
		errors = new ErrorTablePanel(editor.getProject());
		warnings = new WarningTablePanel(editor.getProject());
		outputPane = new OutputPane();
		
		infoTabbedPane = new JTabbedPane();
		infoTabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 11));
		infoTabbedPane.setBorder(null);
		infoTabbedPane.setPreferredSize(new Dimension(400,600));
		infoTabbedPane.setBackground(UIManager.getColor("Panel.background"));
					
		infoTabbedPane.add(properties);	
		infoTabbedPane.setTitleAt(0," Properties ");
		infoTabbedPane.setIconAt(0,new ImageIcon(DiagramEditorWrapper.class.getResource("/resources/br/ufes/inf/nemo/oled/move/table-16x16.png")));
		
		infoTabbedPane.add(warnings);	
		infoTabbedPane.setTitleAt(1," Warnings ");
		infoTabbedPane.setIconAt(1,new ImageIcon(DiagramEditorWrapper.class.getResource("/resources/br/ufes/inf/nemo/oled/move/warning-16x16.png")));
		
		infoTabbedPane.add(errors);	
		infoTabbedPane.setTitleAt(2," Errors ");
		infoTabbedPane.setIconAt(2,new ImageIcon(DiagramEditorWrapper.class.getResource("/resources/br/ufes/inf/nemo/oled/move/error-16x16.png")));
		
		infoTabbedPane.add(outputPane);	
		infoTabbedPane.setTitleAt(3," Output ");
		infoTabbedPane.setSelectedIndex(3);
		infoTabbedPane.setIconAt(3,IconLoader.getInstance().getIcon(getResourceString("editortoolbar.showoutput.icon")));
		
		editorArea.add(scrollpane, JSplitPane.TOP);
		editorArea.add(infoTabbedPane, JSplitPane.BOTTOM);
		
	}	
	
	public static PropertyTablePanel getProperties(){
		return properties;
	}

	public static OutputPane getOutput(){
		return outputPane;
	}
	
	public static WarningTablePanel getWarnings(){
		return warnings;
	}
	
	public static void setTitleWarning(String text)
	{
		infoTabbedPane.setTitleAt(1,text);
	}
	
	public static void setTitleErrors(String text)
	{
		infoTabbedPane.setTitleAt(2,text);
	}
	
	public static ErrorTablePanel getErrors(){
		return errors;
	}
	
	private String getResourceString(String property) {
	    return ApplicationResources.getInstance().getString(property);
	}
	
	public static void focusOnProperties()
	{
		infoTabbedPane.setSelectedIndex(0);
	}
	
	public static void focusOnErrors()
	{
		infoTabbedPane.setSelectedIndex(2);
	}
	
	public static void focusOnWarnings()
	{
		infoTabbedPane.setSelectedIndex(1);
	}
	
	public static void focusOnOutput()
	{
		infoTabbedPane.setSelectedIndex(3);
	}
	
	public void setDiagramEditor(DiagramEditor editor) {
		this.editor = editor;
	}

	public DiagramEditor getDiagramEditor() {
		return editor;
	}
	
	public void showOutputText(String text, boolean clear, boolean showOutput)
	{		
		if(clear)
		{
			outputPane.write(text);
		}
		else
		{
			outputPane.apped(text);
		}
		
		if(showOutput)
		{
			outputPane.setVisible(true);
			showOutput();
		}
	}
	
	public void setModelFile(File modelFile) {
		this.projectFile = modelFile;
	}

	public File getModelFile() {
		return projectFile;
	}

	class OutputPane extends JPanel
	{
		private static final long serialVersionUID = -7066838889714939605L;
		JTextPane output = new JTextPane();
		
		public OutputPane()
		{
			super();
			
			output.setEditable(false);
			output.setBackground(new Color(0xF2FCAC));
			output.setMinimumSize(new Dimension(0, 0));
			
			BorderLayout layout = new BorderLayout();
			this.setLayout(layout);
			
			JScrollPane scrollpane = new JScrollPane(output);
			scrollpane.getVerticalScrollBar().setUnitIncrement(10);
			scrollpane.getHorizontalScrollBar().setUnitIncrement(10);
			
			this.add(scrollpane, BorderLayout.CENTER);
			this.setMinimumSize(new Dimension(0, 0));
		}
		
		public void apped(String text)
		{
			output.setText(output.getText() + text);
		}
		
		public void write(String text)
		{
			output.setText(text);
		}
	}
	
	class ProgressPane extends JPanel
	{
		private static final long serialVersionUID = -2139086725410223732L;
		JLabel output = new JLabel();
		JProgressBar progressBar = new JProgressBar();
		
		public ProgressPane()
		{
			super();
			
			BoxLayout layout = new BoxLayout(this, javax.swing.BoxLayout.X_AXIS);
			this.setLayout(layout);
			progressBar.setMaximumSize(new java.awt.Dimension(100, 14));
			progressBar.setLayout(null);
			
			this.add(output);
			this.add(Box.createHorizontalGlue());
			this.add(progressBar);
		}
		
		/*
		 * Display short status messages, with no scrolling
		 */
		public void write(String text)
		{
			output.setText(text);
		}
	}

	private void showOutput()
	{
		int location = editorArea.getDividerLocation();
		int maxLocation = editorArea.getMaximumDividerLocation();
		if(location >= maxLocation - 1) //1px bug
        {
        	editorArea.setDividerLocation(0.83);
        }
	}
	
	public void showOrHideOutput() {
		
		int location = editorArea.getDividerLocation();
		int maxLocation = editorArea.getMaximumDividerLocation();
		if(location < maxLocation)
        {
        	editorArea.setDividerLocation(1.0);	
        }
        else
        {
        	editorArea.setDividerLocation(0.83);
        }
	}

	@Override
	public UmlProject getProject() {
		return editor.getDiagram().getProject();
	}
	
	@Override
	public boolean isSaveNeeded() {
		return editor.isSaveNeeded();
	}

	@Override
	public EditorNature getEditorNature() {
		return editor.getEditorNature();
	}

	@Override
	public Diagram getDiagram() {
		return editor.getDiagram();
	}

	@Override
	public void dispose() {
		
	}
}
