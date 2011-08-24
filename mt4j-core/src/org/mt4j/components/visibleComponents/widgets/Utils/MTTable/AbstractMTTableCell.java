package org.mt4j.components.visibleComponents.widgets.Utils.MTTable;

import org.mt4j.components.visibleComponents.shapes.MTRectangle;

import processing.core.PApplet;

public class AbstractMTTableCell extends MTRectangle {
	
	static float w;
	static float h;
		
	public AbstractMTTableCell(PApplet pApplet, float width, float height) {
		super(pApplet, width, height);
		setAnchor(PositionAnchor.UPPER_LEFT);
		
		w = width;
		h = height;
		
		unregisterAllInputProcessors();
	}

	public static float getWidth()
	{
		return w;
	}
	
	public static float getHeight()
	{
		return h;
	}

}
