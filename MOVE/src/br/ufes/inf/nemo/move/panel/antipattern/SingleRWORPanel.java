package br.ufes.inf.nemo.move.panel.antipattern;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import RefOntoUML.Classifier;
import br.ufes.inf.nemo.move.ui.TheFrame;
import br.ufes.inf.nemo.ontouml.antipattern.RWORAntiPattern;

/**
 * @author John Guerson
 */

public class SingleRWORPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTextField textRelator;
	private JPanel tablePane;
	private JScrollPane scrollPane;
	private RoleJTable table;		
	private JButton btnGenerateAlloy;
	private JButton btnGenerateOclSolution;	
	private JCheckBox cbxExclusive;
	private JCheckBox cbxOverlapping;
	private JCheckBox cbxCustomizedExclusive;	
	private RWORAntiPattern rwor;	
	private TheFrame frame;
			
	/**
	 * Create a Single RWOR AntiPattern Panel.
	 * 
	 * @param rbos
	 */
	public SingleRWORPanel(RWORAntiPattern rwor, TheFrame frame)
	{
		this();
		
		this.rwor = rwor;
		this.frame= frame;
		
		textRelator.setText(rwor.getRelator().getName());		
		
		Collection<Classifier> roles = rwor.getMediations().values();		
		
		table.setRolesTableModel(roles);
		table.setPreferredSize(new Dimension(table.getRowCount()*20,table.getColumnCount()*50));						
	}	

	/**
	 * Set the title of the Line Border.
	 * 
	 * @param title
	 */
	public void setTitleBorder (String title)
	{
		((TitledBorder)getBorder()).setTitle(title);	
	}	
	
	/**
	 * Create the panel.
	 */
	public SingleRWORPanel() 
	{
		setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 128), 1, true), "RWOR #1", TitledBorder.LEFT, TitledBorder.BELOW_TOP, null, Color.RED));
		
		JLabel lblRelator = new JLabel("Relator:");		
		JLabel lblDisjointsRoles = new JLabel("Disjoints Roles:");
		
		textRelator = new JTextField();
		textRelator.setBackground(Color.WHITE);
		textRelator.setEditable(false);
		textRelator.setColumns(10);
		
		JPanel checkPane = new JPanel();		
		JPanel btnPane = new JPanel();
		
		btnGenerateAlloy = new JButton("Generate Alloy");
		btnGenerateAlloy.addActionListener(new ActionListener() 
		{
       		public void actionPerformed(ActionEvent event) 
       		{
       			GenerateAlloyActionPerformed(event);
       		}
       	});		
		btnPane.add(btnGenerateAlloy);
		
		btnGenerateOclSolution = new JButton("Generate OCL Solution");
		btnGenerateOclSolution.addActionListener(new ActionListener() 
		{
       		public void actionPerformed(ActionEvent event) 
       		{
       			GenerateOCLSolutionActionPerformed(event);
       		}
       	});	
		btnPane.add(btnGenerateOclSolution);
		
		cbxExclusive = new JCheckBox("Exclusive");
		checkPane.add(cbxExclusive);
		
		cbxOverlapping = new JCheckBox("Overlapping");
		checkPane.add(cbxOverlapping);
		
		cbxCustomizedExclusive = new JCheckBox("Customized Exclusive");
		checkPane.add(cbxCustomizedExclusive);
		
		tablePane = new JPanel();
		tablePane.setBackground(Color.WHITE);
		tablePane.setLayout(new BorderLayout(0, 0));
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(tablePane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
						.addComponent(lblDisjointsRoles, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
						.addComponent(btnPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
						.addComponent(checkPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(lblRelator)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textRelator, GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)))
					.addGap(21))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRelator)
						.addComponent(textRelator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(15)
					.addComponent(lblDisjointsRoles)
					.addGap(18)
					.addComponent(tablePane, GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(checkPane, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(44))
		);
		
		scrollPane = new JScrollPane();
		tablePane.add(scrollPane, BorderLayout.CENTER);

		table = new RoleJTable();		
		scrollPane.setViewportView(table);	

		setLayout(groupLayout);			
	}
	
	/**
	 * Generate Alloy.
	 * 
	 * @param event
	 */
	public void GenerateAlloyActionPerformed(ActionEvent event)
	{
		/*
		Boolean exclusive = cbxExclusive.isSelected();
		Boolean overlapping = cbxOverlapping.isSelected();
		Boolean custom = cbxCustomizedExclusive.isSelected();
				
		String exclusivePred = new String();
		String overlappingPred = new String();
		String customPred = new String();
		*/			
	}
	
	/**
	 * Generate OCL Solution.
	 * 
	 * @param event
	 */
	public void GenerateOCLSolutionActionPerformed(ActionEvent event)
	{
		/*
		Boolean exclusive = cbxExclusive.isSelected();
		Boolean overlapping = cbxOverlapping.isSelected();
		Boolean custom = cbxCustomizedExclusive.isSelected();
				
		String exclusiveConstraint = new String();
		String overlappingConstraint = new String();
		String customConstraint = new String();	
		*/				
	}
}
