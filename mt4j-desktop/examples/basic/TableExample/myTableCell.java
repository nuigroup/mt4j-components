package basic.TableExample;

import org.mt4j.components.visibleComponents.widgets.MTTextArea;
import org.mt4j.components.visibleComponents.widgets.Utils.MTTable.AbstractMTTableCell;
import org.mt4j.util.MTColor;
import org.mt4j.util.font.FontManager;
import org.mt4j.util.math.Vector3D;

import processing.core.PApplet;

public class myTableCell extends AbstractMTTableCell{

	private MTTextArea txt;
	public myTableCell(PApplet pApplet, String text) {
		super(pApplet, 100, 50);
		
		setStrokeColor(new MTColor(0,0,0));
		txt = new MTTextArea(pApplet,FontManager.getInstance().getDefaultFont(pApplet));
		txt.setAnchor(PositionAnchor.CENTER);
		txt.setText(text);
		txt.setPositionGlobal(new Vector3D(getWidth()/2, getHeight()/2 , 0));
		txt.setNoStroke(true);
		addChild(txt);
		
		// TODO Auto-generated constructor stub
	}

}
