/**
 * Copyright(C) 2011-2014 by John Guerson, Tiago Prince, Antognoni Albuquerque
 *
 * This file is part of OLED (OntoUML Lightweight BaseEditor).
 * OLED is based on TinyUML and so is distributed under the same
 * license terms.
 *
 * OLED is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * OLED is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with OLED; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package br.ufes.inf.nemo.oled.dialog.properties;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Normalizer;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.eclipse.emf.ecore.EObject;

import RefOntoUML.GeneralizationSet;
import br.ufes.inf.nemo.oled.DiagramManager;

/**
 * @author John Guerson
 */
public class GeneralizationSetDialog extends JDialog{

	private static final long serialVersionUID = 1L;
		
	private GeneralizationSet genSet;
	private DiagramManager diagramManager;
	private JFrame parent;		
	private GeneralizationSetEditionPanel genSetEdition;
	private JButton btnOk; 
	private JButton btnCancel;
	
	public GeneralizationSetDialog(final JFrame parent, final DiagramManager diagramManager, final GeneralizationSet genSet, boolean modal) 
	{
		super(parent, modal);
		
		initData(parent,diagramManager,genSet);
		initGUI();
	}
	
	public void initData(final JFrame parent, final DiagramManager diagramManager, final GeneralizationSet genSet)
	{
		this.diagramManager = diagramManager;
		this.genSet=genSet;
		this.parent = parent;
	}
	
	public void  initGUI() 
	{	
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);		
		setTitle(""+""+getStereotype(genSet)+" "+ ((GeneralizationSet)genSet).getName());
				
		setIconImage(Toolkit.getDefaultToolkit().getImage(ClassDialog.class.getResource("/resources/icons/x16/cog.png")));
		
		if (parent instanceof JFrame)
			genSetEdition = new GeneralizationSetEditionPanel((JFrame)parent, diagramManager, genSet);
				
		getContentPane().add(genSetEdition, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(100,50));
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				genSetEdition.transferGenSetData();				
				dispose();
			}
		});
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(165)
					.addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCancel)
					.addGap(156))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancel)
						.addComponent(btnOk))
					.addContainerGap(16, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		setSize(new Dimension(470, 370));
	}
	
	public static String getStereotype(EObject element)
	{
		String type = element.getClass().toString().replaceAll("class RefOntoUML.impl.","");
	    type = type.replaceAll("Impl","");
	    type = Normalizer.normalize(type, Normalizer.Form.NFD);
	    if (!type.equalsIgnoreCase("association")) type = type.replace("Association","");
	    return type;
	}
}
