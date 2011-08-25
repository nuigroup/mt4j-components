package org.mt4j.components.visibleComponents.widgets.buttons;

import org.mt4j.input.inputProcessors.IGestureEventListener;
import org.mt4j.input.inputProcessors.MTGestureEvent;
import org.mt4j.input.inputProcessors.componentProcessors.tapProcessor.TapEvent;
import org.mt4j.input.inputProcessors.componentProcessors.tapProcessor.TapProcessor;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * 
 * Normal MTImageButton + The scope of adding different textures for up and down events. You can
 * also remove the normal button behavious (resizing) by this code snippet
 *  for(int i = 0 ; i < this.getGestureListeners().length ; i++)
 *  	{
 *  		if(this.getGestureListeners()[i] instanceof DefaultButtonClickAction)
 *  		this.removeGestureEventListener(TapProcessor.class, this.getGestureListeners()[0]);
 *  	}
 *  
 * @author Amit Kumar Sarangi
 */


public class MTDoubleImageButton extends MTImageButton {

	PImage upTex,downTex;
	
	public MTDoubleImageButton(PApplet pApplet,PImage upButtonTexture,PImage downButtonTexture) {
		super(pApplet, upButtonTexture);
		upTex = upButtonTexture;
		downTex = downButtonTexture;
		
		this.setGestureAllowance(TapProcessor.class, true);
		this.registerInputProcessor(new TapProcessor(pApplet));
		this.addGestureListener(TapProcessor.class, new IGestureEventListener() {
			
			@Override
			public boolean processGestureEvent(MTGestureEvent ge) {
				if (ge instanceof TapEvent){
					TapEvent clickEvent = (TapEvent)ge;
						switch (clickEvent.getId()) {
						case MTGestureEvent.GESTURE_RESUMED:
						case MTGestureEvent.GESTURE_STARTED:
							if ( clickEvent.getTapID() == TapEvent.TAP_DOWN){
								setTexture(downTex);
							}
							break;
						case MTGestureEvent.GESTURE_UPDATED:
							//NOTE: usually click gesture analyzers dont send gesture update events
							if ( clickEvent.getTapID() == TapEvent.TAP_DOWN){
								setTexture(downTex);
							}
							break;
						case MTGestureEvent.GESTURE_CANCELED:
						case MTGestureEvent.GESTURE_ENDED:
							if (clickEvent.getTapID() == TapEvent.TAPPED
								|| clickEvent.getTapID() == TapEvent.TAP_UP
							){
								setTexture(upTex);
							}
							break;
						default:
							break;
						}
					}
				return false;
			}
		});

	}	
}
