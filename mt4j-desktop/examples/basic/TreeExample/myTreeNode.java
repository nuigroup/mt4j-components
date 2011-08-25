package basic.TreeExample;

import org.mt4j.components.visibleComponents.shapes.MTPolygon;
import org.mt4j.components.visibleComponents.widgets.MTTextArea;
import org.mt4j.components.visibleComponents.widgets.Utils.MTree.AbstractTreeNode;
import org.mt4j.util.MTColor;
import org.mt4j.util.font.FontManager;
import org.mt4j.util.math.Vector3D;
import org.mt4j.util.math.Vertex;

import processing.core.PApplet;

public class myTreeNode extends AbstractTreeNode {

	private MTTextArea txt;

	public myTreeNode(PApplet pApplet,String text) {
		super(150, 50, pApplet);
		//unregisterAllInputProcessors();
		// TODO Auto-generated constructor stub
		MTPolygon poly = new MTPolygon(pApplet,
				new Vertex[]{
				new Vertex(50,	0), 
				new Vertex(100, 0), 
				new Vertex(150, 25), 
				new Vertex(100,	50), 
				new Vertex(50,50),
				new Vertex(0,25),
				new Vertex(50,0)
				}
		);
		addChild(poly);
		poly.setStrokeColor(new MTColor(0,0,0));

		//setStrokeColor(new MTColor(0,0,0));
		setNoFill(true);
		setNoStroke(true);
		
		txt = new MTTextArea(pApplet,FontManager.getInstance().getDefaultFont(pApplet));
		txt.setAnchor(PositionAnchor.CENTER);
		txt.setText(text);
		txt.setPositionGlobal(new Vector3D(75, 25 , 0));
		txt.setNoStroke(true);
		
		txt.setPickable(false);
		poly.addChild(txt);

	}

}
