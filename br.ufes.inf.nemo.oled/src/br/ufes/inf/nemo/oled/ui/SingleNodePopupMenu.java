package br.ufes.inf.nemo.oled.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.KeyStroke;

import br.ufes.inf.nemo.oled.util.AppCommandListener;
import br.ufes.inf.nemo.oled.util.ApplicationResources;
import br.ufes.inf.nemo.oled.util.IconLoader;

public class SingleNodePopupMenu extends JPopupMenu implements ActionListener {

	private static final long serialVersionUID = 1L;
	private Set<AppCommandListener> commandListeners = new HashSet<AppCommandListener>();
	
	public SingleNodePopupMenu()
	{
		JMenuItem propertyItem = createMenuItem(this, "editproperties");
		propertyItem.setAccelerator(KeyStroke.getKeyStroke("F9"));		
		
		JMenu drawOrderMenu = new JMenu(ApplicationResources.getInstance().getString("submenu.draworder.name"));
		add(drawOrderMenu);
		
		createMenuItem(drawOrderMenu, "draworder.tofront");
		createMenuItem(drawOrderMenu, "draworder.toback");
		
		addSeparator();
		
		createMenuItem(this, "delete");		
	}
	
	/**
	 * Adds the specified AppCommandListener.
	 * 
	 * @param l
	 *            the AppCommandListener to add
	 */
	public void addAppCommandListener(AppCommandListener l) {
		commandListeners.add(l);
	}
	
	/**
	 * Generic helper method to construct a menu according to the resource
	 * strings.
	 * 
	 * @param menu
	 *            the menu to create the item in
	 * @param name
	 *            the menu item name
	 * @return the JMenuItem
	 */
	public JMenuItem createMenuItem(JComponent menu, String name) {
		String prefix = "menuitem." + name;
		JMenuItem menuitem = new JMenuItem(getResourceString(prefix + ".name"));

		// Command
		String actionCommand = getResourceString(prefix + ".command");
		menuitem.setActionCommand(actionCommand);
		menuitem.addActionListener(this);

		// icon
		String iconType = getResourceString(prefix + ".icon");
		if (iconType != null) {
			menuitem.setIcon(IconLoader.getInstance().getIcon(iconType));
		}
		menu.add(menuitem);
		return menuitem;
	}
	
	/**
	 * Returns the specified resource as a String object.
	 * 
	 * @param property
	 *            the property name
	 * @return the property value or null if not found
	 */
	private String getResourceString(String property) {
		return ApplicationResources.getInstance().getString(property);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void actionPerformed(ActionEvent e) {
		for (AppCommandListener l : commandListeners) {
			l.handleCommand(e.getActionCommand());
		}
	}

	/**
	 * Helper method to construct a check box menu item according to resource
	 * strings.
	 * 
	 * @param menu
	 *            the parent menu
	 * @param name
	 *            the menuitem name
	 * @return the menu item
	 */
	@SuppressWarnings("unused")
	private JCheckBoxMenuItem createCheckBoxMenuItem(JComponent menu,
			String name) {
		String prefix = "menuitem." + name;
		JCheckBoxMenuItem menuitem = new JCheckBoxMenuItem(
				getResourceString(prefix + ".name"));

		// Command
		String actionCommand = getResourceString(prefix + ".command");
		menuitem.setActionCommand(actionCommand);
		menuitem.addActionListener(this);
		menu.add(menuitem);
		return menuitem;
	}
}
