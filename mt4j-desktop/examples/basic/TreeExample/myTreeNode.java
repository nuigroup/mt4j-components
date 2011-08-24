package basic.TreeExample;

import org.mt4j.components.visibleComponents.widgets.MTTextArea;
import org.mt4j.components.visibleComponents.widgets.Utils.MTree.AbstractTreeNode;
import org.mt4j.util.MTColor;
import org.mt4j.util.font.FontManager;
import org.mt4j.util.math.Vector3D;

import processing.core.PApplet;

public class myTreeNode extends AbstractTreeNode {

	private MTTextArea txt;

	public myTreeNode(PApplet pApplet,String text) {
		super(150, 50, pApplet);
		//unregisterAllInputProcessors();
		// TODO Auto-generated constructor stub
		
		setStrokeColor(new MTColor(0,0,0));
		txt = new MTTextArea(pApplet,FontManager.getInstance().getDefaultFont(pApplet));
		txt.setAnchor(PositionAnchor.CENTER);
		txt.setText(text);
		txt.setPositionGlobal(new Vector3D(75, 25 , 0));
		txt.setNoStroke(true);
		
		txt.setPickable(false);
		addChild(txt);

	}

}
