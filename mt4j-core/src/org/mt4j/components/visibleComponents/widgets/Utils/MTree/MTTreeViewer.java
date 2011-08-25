package org.mt4j.components.visibleComponents.widgets.Utils.MTree;

import java.util.Vector;

import org.mt4j.components.visibleComponents.shapes.MTRectangle;
import org.mt4j.util.MTColor;
import org.mt4j.util.math.Vector3D;

import processing.core.PApplet;

public class MTTreeViewer extends MTRectangle {

	private Vector<AbstractTreeNode> children;
	private static float xPad,yPad;
	
	public MTTreeViewer(PApplet pApplet) {
		super(pApplet,50,50);
		setNoStroke(true);
		setFillColor(new MTColor(0,0,0,0));
		setAnchor(PositionAnchor.UPPER_LEFT);
		children = new Vector<AbstractTreeNode>();
		xPad = yPad = 0 ;
		// TODO Auto-generated constructor stub
	}
	
	public void addNode(AbstractTreeNode node)
	{
		children.add(node);	
		redraw();
	}
	
	public void removeNode(AbstractTreeNode node)
	{
		children.remove(node);
		redraw();
	}
	
	public void redraw()
	{
		float xPos = 0 ;
		float yPos = 0 ;
		
		for(int i = 0 ; i < children.size() ; i++)
		{
			Vector3D vec = new Vector3D();
			vec.x = xPos;
			vec.y = yPos;
			children.get(i).setPositionGlobal(vec);
			addChild(children.get(i));
			children.get(i).redraw();
			yPos = vec.y + children.get(i).getHeight();
		}
		setParentHeightWidth();
	}
	
	public void setOffset(float xOffset, float yOffset)
	{
		xPad = xOffset;
		yPad = yOffset;
	}
	
	public static float getXOffset()
	{
		return xPad;
	}
	
	public static float getYOffset()
	{
		return yPad;
	}
	
	private void setParentHeightWidth()
	{
		float height = 0 ;
		for (int i = 0 ; i < children.size() ; i ++)
		{
			height = height + children.get(i).getHeight();
		}
		System.out.println(height);
		this.setSizeLocal(500f, height);
	}
}
