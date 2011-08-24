package org.mt4j.android.scenes;

import org.mt4j.AbstractMTApplication;
import org.mt4j.components.visibleComponents.widgets.MTTextArea;
import org.mt4j.input.gestureAction.DefaultLassoAction;
import org.mt4j.input.gestureAction.DefaultPanAction;
import org.mt4j.input.gestureAction.DefaultZoomAction;
import org.mt4j.input.inputProcessors.componentProcessors.lassoProcessor.LassoProcessor;
import org.mt4j.input.inputProcessors.componentProcessors.panProcessor.PanProcessorTwoFingers;
import org.mt4j.input.inputProcessors.componentProcessors.zoomProcessor.ZoomProcessor;
import org.mt4j.input.inputProcessors.globalProcessors.CursorTracer;
import org.mt4j.sceneManagement.AbstractScene;
import org.mt4j.util.MT4jSettings;
import org.mt4j.util.MTColor;
import org.mt4j.util.font.FontManager;
import org.mt4j.util.font.IFont;

public class MT4jAndroidTestScene extends AbstractScene {

	public MT4jAndroidTestScene(AbstractMTApplication mtApplication, String name) {
		super(mtApplication, name);
		
		this.setClearColor(new MTColor(146, 150, 188, 255));
		//Show touches
		this.registerGlobalInputProcessor(new CursorTracer(mtApplication, this));
		
		LassoProcessor lp = new LassoProcessor(mtApplication, getCanvas(), getSceneCam());
		getCanvas().registerInputProcessor(lp);
		getCanvas().addGestureListener(LassoProcessor.class, new DefaultLassoAction(mtApplication, getCanvas().getClusterManager(), getCanvas()));
		
		ZoomProcessor zp = new ZoomProcessor(mtApplication, 800);
		getCanvas().registerInputProcessor(zp);
		getCanvas().addGestureListener(ZoomProcessor.class, new DefaultZoomAction());
		
		PanProcessorTwoFingers pp = new PanProcessorTwoFingers(mtApplication, 800);
		getCanvas().registerInputProcessor(pp);
		getCanvas().addGestureListener(PanProcessorTwoFingers.class, new DefaultPanAction());
		
		IFont fontArial = FontManager.getInstance().createFont(mtApplication, "arial20.fnt", 20, MTColor.WHITE, true);
		//Create a textfield
		MTTextArea textField = new MTTextArea(mtApplication, fontArial); 
		textField.setNoStroke(true);
		textField.setNoFill(true);
		textField.setText("Hello Android World!");
		//Center the textfield on the screen
		textField.setPositionGlobal(MT4jSettings.getInstance().getWindowCenter());
		//Add the textfield to our canvas
		this.getCanvas().addChild(textField);
		
		/*
		float cellWidth = 155;
		float cellHeight = 40;
		
		MTList list = new MTList(mtApplication,0, 0, 157, 1* cellHeight + 7*3);
		list.unregisterAllInputProcessors();
		list.setAnchor(PositionAnchor.CENTER);
		getCanvas().addChild(list);

		final MTListCell cell = new MTListCell(mtApplication, cellWidth, cellHeight);
		cell.setChildClip(null); //FIXME TEST, no clipping for performance!
		cell.setFillColor(MTColor.YELLOW);
		list.addListElement(cell);
		
		final MTListCell cell2 = new MTListCell(mtApplication, cellWidth, cellHeight);
		cell2.setChildClip(null); //FIXME TEST, no clipping for performance!
		cell2.setFillColor(MTColor.BLUE);
		list.addListElement(cell2);
		
		//cell.destroy();
		*/
	}

}
