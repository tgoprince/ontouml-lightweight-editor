package br.ufes.inf.nemo.ontouml2text.ontoUmlGlossary.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import br.ufes.inf.nemo.common.ontoumlparser.OntoUMLParser;
import br.ufes.inf.nemo.ontouml2text.ontoUmlGlossary.OntoUmlGlossary;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.ImageIcon;

public class GlossaryGeneratorUI extends JFrame {
	
	private OntoUmlGlossary ontoUmlGlossary;
	private OntoUMLParser parser;
	private JPanel contentPane;
	private JComboBox<String> cmbLanguage;
	private JTextField edtOutputFileName;
	private JTextField edtOutputDirectory;
	private JCheckBox chkAnalyseDescriptiveConsistency;
	private JButton btnSelectOutputDirectory;
	private JButton btnGenerateGlossary;
	private static final long serialVersionUID = 1L;
	
	private boolean doGlossaryGeneration;
	private JButton btnCancel;
	private JTextField edtSubtitle;
	private JTextField edtTitle;
	private JLabel lblTitle;
	private JCheckBox chkInheritMediations;
	private JLabel lblNewLabel_1;

	public GlossaryGeneratorUI(OntoUMLParser parser){
		this();		
		this.parser = parser;
	}
	
	/**
	 * Create the frame.
	 */
	public GlossaryGeneratorUI() {
		
		setResizable(false);
		setType(Type.UTILITY);
		setTitle("OntoUML Glossary Generator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 388, 395);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Output File Name");
		
		edtOutputFileName = new JTextField();
		edtOutputFileName.setText("Glossary Output");
		edtOutputFileName.setColumns(10);
		
		JLabel lblOutputDirectory = new JLabel("Output Directory");
		
		edtOutputDirectory = new JTextField();
		edtOutputDirectory.setColumns(10);
		
		btnSelectOutputDirectory = new JButton("...");
		
		chkAnalyseDescriptiveConsistency = new JCheckBox("Analyse Descriptive Consistency");
		chkAnalyseDescriptiveConsistency.setToolTipText("Check if exists any inconsistency that can be affect the generation of glossary");
		
		cmbLanguage = new JComboBox<String>();
		cmbLanguage.addItem("Portugu�s - BR");
		cmbLanguage.setSelectedIndex(0);
		
		JLabel lblLanguage = new JLabel("Target Language");
		
		edtSubtitle = new JTextField();
		edtSubtitle.setText("Detailed Description of Concepts");
		edtSubtitle.setColumns(10);
		
		JLabel lblSubtitle = new JLabel("Subtitle");
		
		edtTitle = new JTextField();
		edtTitle.setText("Glossary");
		edtTitle.setColumns(10);
		
		lblTitle = new JLabel("Title");
		
		JPanel panel = new JPanel();
		
		chkInheritMediations = new JCheckBox("Inherit Mediations of Parent Relators ");
		chkInheritMediations.setSelected(true);
		chkInheritMediations.setToolTipText("Check if exists any inconsistency that can be affect the generation of glossary");
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setToolTipText("Adds the mediation's description of a parent relator");
		lblNewLabel_1.setIcon(new ImageIcon(GlossaryGeneratorUI.class.getResource("/resources/icon/1392770960_information.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
						.addComponent(lblLanguage)
						.addComponent(cmbLanguage, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
						.addComponent(chkAnalyseDescriptiveConsistency)
						.addComponent(lblOutputDirectory)
						.addComponent(lblNewLabel)
						.addComponent(lblSubtitle)
						.addComponent(lblTitle)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(edtSubtitle, Alignment.LEADING)
								.addComponent(edtTitle, Alignment.LEADING)
								.addComponent(edtOutputDirectory, Alignment.LEADING)
								.addComponent(edtOutputFileName, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnSelectOutputDirectory, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(chkInheritMediations, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_1)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblLanguage)
					.addGap(9)
					.addComponent(cmbLanguage, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblTitle)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(edtTitle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(lblSubtitle)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(edtSubtitle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(edtOutputFileName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblOutputDirectory)
					.addGap(1)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(edtOutputDirectory, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSelectOutputDirectory))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(chkAnalyseDescriptiveConsistency)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(chkInheritMediations)
						.addComponent(lblNewLabel_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		btnGenerateGlossary = new JButton("Generate Glossary");
		btnGenerateGlossary.setIcon(new ImageIcon(GlossaryGeneratorUI.class.getResource("/resources/icon/1392761208_rich_text_align_left.png")));
		btnGenerateGlossary.setActionCommand("generateGlossary");
		
		btnCancel = new JButton("Cancel");
		btnCancel.setIcon(new ImageIcon(GlossaryGeneratorUI.class.getResource("/resources/icon/cancel.png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(63)
					.addComponent(btnGenerateGlossary)
					.addGap(5)
					.addComponent(btnCancel)
					.addGap(63))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCancel, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
						.addComponent(btnGenerateGlossary, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)))
		);
		panel.setLayout(gl_panel);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		btnGenerateGlossary.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {

				if(edtOutputFileName.getText().equals("") || edtOutputDirectory.getText().equals(""))
					this.showErrorMessage(this,"There is no output file name or output directory. Please, complete the fields.","Output Name Error",JOptionPane.ERROR_MESSAGE,null);	
				
				else{			
					if(cmbLanguage.getSelectedIndex() == 0){ // Brazilian Portuguese
						ontoUmlGlossary = new OntoUmlGlossary(OntoUmlGlossary.PT_BR, parser, edtOutputFileName.getText(), 
								edtOutputDirectory.getText(), edtTitle.getText(), edtSubtitle.getText(), chkInheritMediations.isSelected()); 
					}
					
					if(chkAnalyseDescriptiveConsistency.isSelected()){
						SwingUtilities.invokeLater(new Runnable() {			
							public void run() {
								List<String> missingUserDescriptions = ontoUmlGlossary.verifiyMissingUserDescriptions();
								List<String> isolatedDescriptions = ontoUmlGlossary.verfifyIsolatedDescriptions();
								List<String> nonDeterminedRelationships = ontoUmlGlossary.verfifyNonDeterminedRelationships();
								
								if(missingUserDescriptions.size() + isolatedDescriptions.size() + nonDeterminedRelationships.size() > 0) {
									GlossaryGeneratorAnalisysUI analisys = new GlossaryGeneratorAnalisysUI(ontoUmlGlossary, 
											missingUserDescriptions,
											isolatedDescriptions,
											nonDeterminedRelationships);
									analisys.setVisible(true);	
								}else{
									ontoUmlGlossary.modelToText();
									JOptionPane.showMessageDialog(null, "Glossary generated successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
									dispose();
								}
							}
						});		
					}else{
						Component root = SwingUtilities.getRoot((JButton) e.getSource());
						
						try{				
			                root.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
							
							ontoUmlGlossary.modelToText();
							JOptionPane.showMessageDialog(null, "Glossary generated successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
							dispose();
						}finally{
							root.setCursor(Cursor.getDefaultCursor());
						}
					}
				}
			}

			private void showErrorMessage(ActionListener actionListener,
					String message, String title, int errorMessage,
					Object object) {
				JOptionPane.showMessageDialog(contentPane, message, title, 0);
				
			}
			
		});
		contentPane.setLayout(gl_contentPane);
		
		setLocationRelativeTo(null);
		
		btnSelectOutputDirectory.setActionCommand("outputSelection");
		
		btnSelectOutputDirectory.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				  JFileChooser chooser = new JFileChooser();
			      chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	
			      try {
			            int code = chooser.showOpenDialog(contentPane);
			            if (code == JFileChooser.APPROVE_OPTION) {
			               File selectedFile = chooser.getSelectedFile();
			               edtOutputDirectory.setText(selectedFile.getAbsolutePath());
			            }
			      } catch (Exception f) {
			         f.printStackTrace();
			      }	
			}
			
		});
		
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
	
	public String getOutputDirectory(){
		return edtOutputDirectory.getText();
	}
	
	public boolean doDescriptiveConsistency(){
		return chkAnalyseDescriptiveConsistency.isSelected();
	}
	
	public boolean doGlossaryGeneration(){
		return doGlossaryGeneration;
	}
}
