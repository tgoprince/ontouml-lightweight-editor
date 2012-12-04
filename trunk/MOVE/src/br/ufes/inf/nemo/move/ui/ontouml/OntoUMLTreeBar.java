package br.ufes.inf.nemo.move.ui.ontouml;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 * @author John Guerson
 */

public class OntoUMLTreeBar extends JPanel {
	
	private static final long serialVersionUID = -115797584019893402L;
	
	public JTextField textPath;	
	public JButton btnOpen;
	public JButton btnVerify;
	public JButton btnShowUnique;
	
	public JButton btnCompleteSelect;
	public JPopupMenu popupCompleteSelect;	
	
	public JMenuItem menuItemDefaultAncestors;
	public JMenuItem menuItemAllAncestors;
	public JMenuItem menuItemSortalAncestor;
	
	public void showPopupCompleteSelect()
	{
		popupCompleteSelect.show(btnCompleteSelect, 10, 10);
   	    btnCompleteSelect.repaint();
   	    btnCompleteSelect.validate();
	}
		
	public OntoUMLTreeBar() 
	{		
		textPath = new JTextField();
		textPath.setBackground(Color.WHITE);
		textPath.setEditable(false);
		textPath.setColumns(10);
		
		setPreferredSize(new Dimension(441, 92));
		
		btnOpen = new JButton("");
		btnOpen.setToolTipText("Open OntoUML Model");
		btnOpen.setIcon(new ImageIcon(OntoUMLTreeBar.class.getResource("/resources/br/ufes/inf/nemo/move/open-16x16.png")));
		
		btnVerify = new JButton("");
		btnVerify.setToolTipText("Verify Model Sintactically");
		btnVerify.setIcon(new ImageIcon(OntoUMLTreeBar.class.getResource("/resources/br/ufes/inf/nemo/move/check-16x16.png")));
		
		btnShowUnique = new JButton("");
		btnShowUnique.setToolTipText("Show Aliases");
		btnShowUnique.setIcon(new ImageIcon(OntoUMLTreeBar.class.getResource("/resources/br/ufes/inf/nemo/move/visible-16x16.png")));
		
		btnCompleteSelect = new JButton("");
		btnCompleteSelect.setIcon(new ImageIcon(OntoUMLTreeBar.class.getResource("/resources/br/ufes/inf/nemo/move/selection-16x16.png")));
		btnCompleteSelect.setToolTipText("Complete Selections");
						
		popupCompleteSelect = new JPopupMenu();
		menuItemDefaultAncestors = new JMenuItem("Default");
		menuItemAllAncestors = new JMenuItem("All Ancestors");
		menuItemSortalAncestor = new JMenuItem("Ancestors until SubstanceSortal");
		popupCompleteSelect.add(menuItemDefaultAncestors);
		popupCompleteSelect.add(menuItemAllAncestors);
		popupCompleteSelect.add(menuItemSortalAncestor);
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(textPath, GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnOpen, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnShowUnique, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnVerify, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCompleteSelect, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(textPath, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCompleteSelect, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
						.addComponent(btnShowUnique, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
						.addComponent(btnVerify, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
						.addComponent(btnOpen, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
					.addContainerGap())
		);
		setLayout(groupLayout);
							
	}	
}
