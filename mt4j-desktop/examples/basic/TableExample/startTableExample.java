package basic.TableExample;

import org.mt4j.MTApplication;

import basic.svgExample.SVGScene;

public class startTableExample extends MTApplication{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String args[]){
		initialize();
	}
	
	@Override
	public void startUp() {
		// TODO Auto-generated method stub
		this.addScene(new TableExampleScene(this, "Table scene"));
		
	}

}
