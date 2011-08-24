package org.mt4j.components.visibleComponents.widgets.Utils.MTree;

import java.util.Vector;

import org.mt4j.components.TransformSpace;
import org.mt4j.components.visibleComponents.shapes.MTRectangle;
import org.mt4j.util.math.Vector3D;

import processing.core.PApplet;

public class AbstractTreeNode extends MTRectangle{
	
	private Vector<AbstractTreeNode> children;
	private AbstractTreeNode parent;

	public AbstractTreeNode(float width, float height, PApplet pApplet) {
		super(pApplet,width, height);
		// TODO Auto-generated constructor stub
		
		children = new Vector<AbstractTreeNode>();
		parent = null;
		setAnchor(PositionAnchor.UPPER_LEFT);
	}
	
	public float getHeight()
	{
		float height = this.getHeightXY(TransformSpace.GLOBAL);	

		for(int i = 0 ; i < children.size() ; i++ )
		{
			height = height + children.get(i).getHeight();
		}

		return height;
	}
	
	public void addChildNode(AbstractTreeNode node)
	{
		children.add(node);
		node.setParent(this);
		redraw();
	}
	
	public void removeChildNode(AbstractTreeNode node)
	{
		children.remove(node);
		redraw();
	}
	
	public AbstractTreeNode getChildNode(int index)
	{
		return children.get(index);
	}
	
	public void redraw()
	{
		float xPos,yPos;
		if(parent != null)
		{
			 xPos = this.getPosition(TransformSpace.GLOBAL).x + MTTreeViewer.getXOffset();
			 yPos = this.getPosition(TransformSpace.GLOBAL).y + this.getHeightXY(TransformSpace.GLOBAL);
		}
		else
		{
			 xPos =  MTTreeViewer.getXOffset();
			 yPos = this.getHeightXY(TransformSpace.GLOBAL) ;

		}
		
		for(int i = 0 ; i < children.size() ; i++)
		{
			Vector3D vec = new Vector3D();
			vec.x = xPos;
			vec.y = yPos;
			children.get(i).setPositionGlobal(vec);
			addChild(children.get(i));
			children.get(i).redraw();
			yPos = vec.y + children.get(i).getHeight()+MTTreeViewer.getYOffset();
		}
	}
	
	public void setParent(AbstractTreeNode parent)
	{
		this.parent = parent;
	}
}
