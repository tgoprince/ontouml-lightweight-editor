/**
 * Copyright 2011 NEMO (http://nemo.inf.ufes.br/en)
 *
 * This file is part of OLED (OntoUML Lightweight BaseEditor).
 * OLED is based on TinyUML and so is distributed under the same
 * licence terms.
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

package br.ufes.inf.nemo.oled.ui.diagram;

import java.awt.geom.Point2D;

import RefOntoUML.Classifier;
import br.ufes.inf.nemo.oled.draw.DiagramElement;
import br.ufes.inf.nemo.oled.draw.DrawingContext;
import br.ufes.inf.nemo.oled.draw.LineConnectMethod;
import br.ufes.inf.nemo.oled.draw.NullElement;
import br.ufes.inf.nemo.oled.model.RelationType;
import br.ufes.inf.nemo.oled.ui.diagram.commands.AddConnectionCommand;
import br.ufes.inf.nemo.oled.umldraw.shared.UmlConnection;
import br.ufes.inf.nemo.oled.umldraw.shared.UmlNode;
import br.ufes.inf.nemo.oled.umldraw.structure.AssociationElement;

/**
 * This class is a handler for line shaped allElements.
 *
 * @author Wei-ju Wu, Antognoni Albuquerque
 * @version 1.1
 */
public class LineHandler implements EditorMode {

  private DiagramEditor editor;
  private Point2D anchor = new Point2D.Double();
  private Point2D tmpPos = new Point2D.Double();
  private DiagramElement source;
  private boolean isDragging;
  private RelationType relationType;
  private LineConnectMethod connectMethod;

  /**
   * Constructor.
   * @param anEditor a DiagramEditor
   */
  public LineHandler(DiagramEditor anEditor) {
    editor = anEditor;
  }

  /**
   * Sets the association type.
   * @param anAssociationType the association type
   * @param aConnectMethod the connect method
   */
  public void setRelationType(RelationType anAssociationType,
    LineConnectMethod aConnectMethod) {
    connectMethod = aConnectMethod;
    relationType = anAssociationType;
  }

  /**
   * Returns the isDragging property for testing.
   * @return the status for the isDragging property
   */
  public boolean isDragging() { return isDragging; }

  /**
   * {@inheritDoc}
   */
  public void stateChanged() { }

  /**
   * {@inheritDoc}
   */
  public void cancel() { isDragging = false; }

  /**
   * Determines whether the specified element is a valid s ource for the
   * connection.
   * @param elem the target element
   * @return true if valid source, false otherwise
   */
//  private boolean isValidSource(DiagramElement elem) {
//	//FIXME Change this to allow self-relationships
////    return elem instanceof UmlNode &&
////        ((UmlNode) elem).acceptsConnection(relationType,
////           RelationEndType.SOURCE, null);
//  }

  /**
   * Determines whether the specified element is a valid target for the
   * connection.
   * @param elem the target element
   * @return true if valid, false otherwise
   */
//  private boolean isValidTarget(DiagramElement elem) {
//    //FIXME Change this to allow self-relationships
//	  return elem instanceof UmlNode && elem != source &&
//      ((UmlNode) elem).acceptsConnection(relationType, RelationEndType.TARGET, (UmlNodesource);
//  }

  /**
   * {@inheritDoc}
   */
  public void mousePressed(EditorMouseEvent event) {
    double mx = event.getX(), my = event.getY();
    DiagramElement elem = editor.getDiagram().getChildAt(mx, my);
    if (elem!=null && ! (elem instanceof NullElement)) {
      anchor.setLocation(mx, my); //TODO Change the anchor to the edge of the Diagram Element
      tmpPos.setLocation(mx, my);
      isDragging = true;
      if (elem instanceof UmlNode)
    	  source = (UmlNode) elem;
      else
    	  source = (UmlConnection) elem;
    }
  }

  /**
   * {@inheritDoc}
   * FIXME Allow Self-Relationships !
   *
   */
  public void mouseReleased(EditorMouseEvent event) {
    double mx = event.getX(), my = event.getY();
    DiagramElement target = editor.getDiagram().getChildAt(mx, my);    
    tmpPos.setLocation(mx, my);
   
    // UmlNode ->(connectedTo) -> UmlNode
    if (source != null && source instanceof UmlNode && target instanceof UmlNode && target != source) {
      UmlConnection conn = editor.getDiagram().getElementFactory().createConnection(relationType, (UmlNode) source, (UmlNode) target);
      connectMethod.generateAndSetPointsToConnection(conn, (UmlNode)source, (UmlNode) target, anchor, tmpPos);      
      AddConnectionCommand command = new AddConnectionCommand(editor, editor.getDiagram(), conn, (Classifier) ((UmlNode)source).getClassifier(), (Classifier) ((UmlNode)target).getClassifier(), editor.getDiagram().getProject());
      editor.execute(command);
    }
        
    // UmlNode ->(connectedTo) -> UmlConnection
    if(source != null && source instanceof UmlNode && target instanceof UmlConnection && target != source){    	 
    	 //invert sides if derivation is pushed from the umlnode relator
         if (relationType == RelationType.DERIVATION) { 
    	     UmlConnection conn = editor.getDiagram().getElementFactory().createConnection(relationType, (UmlConnection) target, (UmlNode) source);    	 
             connectMethod.generateAndSetPointsToConnection(conn, (UmlConnection) target, (UmlNode)source, anchor, tmpPos);         
	         AddConnectionCommand command = new AddConnectionCommand(editor, editor.getDiagram(), conn, (Classifier) ((AssociationElement)target).getRelationship(), (Classifier) ((UmlNode)source).getClassifier(), editor.getDiagram().getProject());
	         editor.execute(command);
         }
    }
    //UmlConnection ->(connectedTo) -> UmlNode
    if(target!=null && target instanceof UmlNode && source instanceof UmlConnection && target != source){
    	 UmlConnection conn = editor.getDiagram().getElementFactory().createConnection(relationType, (UmlConnection) source, (UmlNode) target);
         connectMethod.generateAndSetPointsToConnection(conn, (UmlConnection)source,  (UmlNode)target, anchor, tmpPos);         
         AddConnectionCommand command = new AddConnectionCommand(editor, editor.getDiagram(), conn, (Classifier) ((AssociationElement)source).getRelationship(), (Classifier) ((UmlNode)target).getClassifier(), editor.getDiagram().getProject());
         editor.execute(command);
    }
    
    isDragging = false;
    editor.redraw();
  }

  /**
   * {@inheritDoc}
   */
  public void mouseClicked(EditorMouseEvent event) { }


  /**
   * {@inheritDoc}
   */
  public void mouseDragged(EditorMouseEvent event) {
    double mx = event.getX(), my = event.getY();
    tmpPos.setLocation(mx, my);
    editor.redraw();
  }

  /**
   * {@inheritDoc}
   */
  public void mouseMoved(EditorMouseEvent event) { }

  /**
   * {@inheritDoc}
   */
  public void draw(DrawingContext drawingContext) {
    if (isDragging) {
      connectMethod.drawLineSegments(drawingContext, anchor, tmpPos);
    }
  }
}
