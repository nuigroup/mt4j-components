package org.mt4j.components.visibleComponents.widgets.Utils.MTTable;

import org.mt4j.AbstractMTApplication;
import org.mt4j.components.MTComponent;
import org.mt4j.components.TransformSpace;
import org.mt4j.components.visibleComponents.shapes.MTRectangle;
import org.mt4j.components.visibleComponents.shapes.MTRectangle.PositionAnchor;
import org.mt4j.components.visibleComponents.widgets.MTTextArea;
import org.mt4j.util.MTColor;
import org.mt4j.util.font.FontManager;
import org.mt4j.util.math.Vector3D;

import processing.core.PApplet;

public class MTTableViewer extends MTRectangle {
	
	int numRows,numColumns;
	String[] columnNames;
	
	float cellWidth,cellHeight;
	
	float xPad,yPad;
	
	boolean setColumnNames ;
	
	AbstractMTApplication app;
	
	public MTTableViewer(PApplet pa,int numRows, int numColumns ,float cellPaddingX,float cellPaddingY)
	{
		super(pa,1,1);
		app = (AbstractMTApplication)pa;
		this.numRows = numRows;
		this.numColumns = numColumns ;
		
		this.xPad = cellPaddingX;
		this.yPad = cellPaddingY;
		
		setColumnNames= false ;
		
	}
	
		
	public void setColumnNames(String[] names)
	{
		if(numColumns == names.length)
		{
			columnNames = names;
			
		}
		setColumnNames = true ;
	}
	
	public void setData(AbstractMTTableCell[][] data)
	{
		float xPos,yPos ,prevXPos;
		if(!setColumnNames)
		{
			 xPos = prevXPos =  xPad ;
			 yPos = yPad ;
		}
		else
		{
			xPos = prevXPos = xPad + cellWidth ;
			yPos = yPad + cellHeight ;
		}
		
		cellWidth = AbstractMTTableCell.getWidth();
		cellHeight = AbstractMTTableCell.getHeight();
		
		if(!setColumnNames)
		{
			setSizeLocal(numColumns*(xPad +cellWidth) + xPad,numRows*(yPad +cellHeight) + yPad);
		}
		else
		{
			setSizeLocal(numColumns*(xPad +cellWidth) + xPad,(numRows+1)*(yPad +cellHeight) + yPad);
		}
		setAnchor(PositionAnchor.UPPER_LEFT);
		
		if(setColumnNames)
		{
			for (int i = 0 ; i < columnNames.length ; i++)
			{
				ColumnNameCell cnc = new ColumnNameCell(app, cellWidth, cellHeight, columnNames[i]);
				cnc.setPositionGlobal(new Vector3D(xPos,yPos,0));
				addChild(cnc);
		    	xPos = xPos + cellWidth + xPad ;
			}
			xPos = prevXPos ; 
		    yPos = yPos + cellHeight + yPad ;
		}
	//	System.out.println((numColumns*(xPad +cellWidth) + xPad )+ " "+ (numRows*(yPad +cellHeight) + yPad) );
		for (int r=0; r < data.length; r++) 
		{
		    for (int c=0; c < data[r].length; c++) 
		    {
		    	data[r][c].setPositionGlobal(new Vector3D(xPos,yPos,0));
		    	addChild(data[r][c]);
		    	xPos = xPos + cellWidth + xPad ;
		    }
		    xPos = prevXPos ; 
		    yPos = yPos + cellHeight + yPad ;
		}
	}
	
	private class ColumnNameCell extends AbstractMTTableCell
	{
		private MTTextArea txt;
		
		public ColumnNameCell(PApplet pApplet, float width, float height,String text) {
			super(pApplet, width, height);
			setStrokeColor(new MTColor(0,0,0,255));
			// TODO Auto-generated constructor stub
			
			setAnchor(PositionAnchor.UPPER_LEFT);
			txt = new MTTextArea(pApplet,FontManager.getInstance().getDefaultFont(pApplet));
			txt.setAnchor(PositionAnchor.CENTER);
			txt.setText(text);
			txt.setPositionGlobal(new Vector3D(getWidth()/2, getHeight()/2 , 0));
			txt.setNoStroke(true);
			addChild(txt);

		}
		
	}
}
