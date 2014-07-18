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
package br.ufes.inf.nemo.oled.popupmenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import RefOntoUML.Category;
import RefOntoUML.Collective;
import RefOntoUML.DataType;
import RefOntoUML.Kind;
import RefOntoUML.Mixin;
import RefOntoUML.Mode;
import RefOntoUML.Phase;
import RefOntoUML.Quantity;
import RefOntoUML.Relator;
import RefOntoUML.Role;
import RefOntoUML.RoleMixin;
import RefOntoUML.SubKind;
import br.ufes.inf.nemo.oled.DiagramManager;

/**
 * @author John Guerson
 */
public class ClassStereotypeChangeMenu extends JMenu{

	private static final long serialVersionUID = 1L;
	
	public DiagramManager diagramManager;
	public RefOntoUML.Element type;
	
	public void setElement(RefOntoUML.Element element)
	{
		this.type = element;
	}
	
	public void setDiagramManager(DiagramManager diagramManager)
	{
		this.diagramManager=diagramManager;
	}
	
	public ClassStereotypeChangeMenu(final DiagramManager diagramManager)
	{		
		this();
		this.diagramManager=diagramManager;
	}
	
	public ClassStereotypeChangeMenu()
	{
		super("Change to");
		
		JMenuItem kindItem = new JMenuItem("Kind");
		JMenuItem collectiveItem  = new JMenuItem("Collective");
		JMenuItem quantityItem = new JMenuItem("Quantity");
		JMenuItem subkindItem = new JMenuItem("SubKind");
		JMenuItem phaseItem = new JMenuItem("Phase");
		JMenuItem roleItem = new JMenuItem("Role");
		JMenuItem categoryItem = new JMenuItem("Category");
		JMenuItem rolemixinItem = new JMenuItem("Role Mixin");
		JMenuItem mixinItem = new JMenuItem("Mixin");	
		JMenuItem relatorItem = new JMenuItem("Relator");
		JMenuItem modeItem = new JMenuItem("Mode");	
		JMenuItem datatypeItem = new JMenuItem("Data Type");
		JMenuItem perceivableItem = new JMenuItem("Perceivable Quality");    			
		JMenuItem nonperceivableItem = new JMenuItem("NonPerceivable Quality");
		JMenuItem nominalItem = new JMenuItem("Nominal Quality");
		add(kindItem);
		kindItem.addActionListener(new ActionListener() {				
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		if (!(type instanceof Kind)) diagramManager.changeClassStereotype((RefOntoUML.Type)type,"Kind");
        	}
        });
		add(collectiveItem);
		collectiveItem.addActionListener(new ActionListener() {				
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		if (!(type instanceof Collective))diagramManager.changeClassStereotype((RefOntoUML.Type)type,"Collective");
        	}
        });
		add(quantityItem);
		quantityItem.addActionListener(new ActionListener() {				
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		if (!(type instanceof Quantity)) diagramManager.changeClassStereotype((RefOntoUML.Type)type,"Quantity");
        	}
        });
		add(subkindItem);
		subkindItem.addActionListener(new ActionListener() {				
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		if (!(type instanceof SubKind)) diagramManager.changeClassStereotype((RefOntoUML.Type)type,"SubKind");
        	}
        });
		add(phaseItem);
		phaseItem.addActionListener(new ActionListener() {				
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		if (!(type instanceof Phase)) diagramManager.changeClassStereotype((RefOntoUML.Type)type,"Phase");
        	}
        });
        add(roleItem);
        roleItem.addActionListener(new ActionListener() {				
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		if (!(type instanceof Role))diagramManager.changeClassStereotype((RefOntoUML.Type)type,"Role");
        	}
        });
        add(categoryItem);
        categoryItem.addActionListener(new ActionListener() {				
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		if (!(type instanceof Category))diagramManager.changeClassStereotype((RefOntoUML.Type)type,"Category");
        	}
        });
        add(rolemixinItem);
        rolemixinItem.addActionListener(new ActionListener() {				
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		if (!(type instanceof RoleMixin)) diagramManager.changeClassStereotype((RefOntoUML.Type)type,"RoleMixin");
        	}
        });
        add(mixinItem);
        mixinItem.addActionListener(new ActionListener() {				
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		if (!(type instanceof Mixin))diagramManager.changeClassStereotype((RefOntoUML.Type)type,"Mixin");
        	}
        });
        add(relatorItem);
        relatorItem.addActionListener(new ActionListener() {				
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		if (!(type instanceof Relator))diagramManager.changeClassStereotype((RefOntoUML.Type)type,"Relator");
        	}
        });
        add(modeItem);
        modeItem.addActionListener(new ActionListener() {				
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		if (!(type instanceof Mode))diagramManager.changeClassStereotype((RefOntoUML.Type)type,"Mode");
        	}
        });
        add(datatypeItem);
        datatypeItem.addActionListener(new ActionListener() {				
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		if (!(type instanceof DataType))diagramManager.changeClassStereotype((RefOntoUML.Type)type,"DataType");
        	}
        }); 
        add(perceivableItem);
        perceivableItem.addActionListener(new ActionListener() {				
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		if (!(type instanceof DataType))diagramManager.changeClassStereotype((RefOntoUML.Type)type,"PerceivableQuality");
        	}
        }); 
        add(nonperceivableItem);
        nonperceivableItem.addActionListener(new ActionListener() {				
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		if (!(type instanceof DataType))diagramManager.changeClassStereotype((RefOntoUML.Type)type,"NonPerceivableQuality");
        	}
        }); 
        add(nominalItem);
        nominalItem.addActionListener(new ActionListener() {				
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		if (!(type instanceof DataType))diagramManager.changeClassStereotype((RefOntoUML.Type)type,"NominalQuality");
        	}
        }); 
   	    kindItem.setIcon(new ImageIcon(ClassStereotypeChangeMenu.class.getResource("/resources/icons/x16/tree/kind.png")));
        quantityItem.setIcon(new ImageIcon(ClassStereotypeChangeMenu.class.getResource("/resources/icons/x16/tree/quantity.png")));
        collectiveItem.setIcon(new ImageIcon(ClassStereotypeChangeMenu.class.getResource("/resources/icons/x16/tree/collective.png")));
        subkindItem.setIcon(new ImageIcon(ClassStereotypeChangeMenu.class.getResource("/resources/icons/x16/tree/subkind.png")));
        phaseItem.setIcon(new ImageIcon(ClassStereotypeChangeMenu.class.getResource("/resources/icons/x16/tree/phase.png")));
        roleItem.setIcon(new ImageIcon(ClassStereotypeChangeMenu.class.getResource("/resources/icons/x16/tree/role.png")));
        categoryItem.setIcon(new ImageIcon(ClassStereotypeChangeMenu.class.getResource("/resources/icons/x16/tree/category.png")));
        rolemixinItem.setIcon(new ImageIcon(ClassStereotypeChangeMenu.class.getResource("/resources/icons/x16/tree/rolemixin.png")));
        mixinItem.setIcon(new ImageIcon(ClassStereotypeChangeMenu.class.getResource("/resources/icons/x16/tree/mixin.png")));
        modeItem.setIcon(new ImageIcon(ClassStereotypeChangeMenu.class.getResource("/resources/icons/x16/tree/mode.png")));
        relatorItem.setIcon(new ImageIcon(ClassStereotypeChangeMenu.class.getResource("/resources/icons/x16/tree/relator.png")));
        datatypeItem.setIcon(new ImageIcon(ClassStereotypeChangeMenu.class.getResource("/resources/icons/x16/tree/datatype.png")));
        perceivableItem.setIcon(new ImageIcon(ClassStereotypeChangeMenu.class.getResource("/resources/icons/x16/tree/datatype.png")));
        nonperceivableItem.setIcon(new ImageIcon(ClassStereotypeChangeMenu.class.getResource("/resources/icons/x16/tree/datatype.png")));
        nominalItem.setIcon(new ImageIcon(ClassStereotypeChangeMenu.class.getResource("/resources/icons/x16/tree/datatype.png")));
	}
}
