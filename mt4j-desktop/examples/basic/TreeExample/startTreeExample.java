package basic.TreeExample;

import org.mt4j.MTApplication;

public class startTreeExample extends MTApplication{

	private static final long serialVersionUID = 1L;

	public static void main(String args[]){
		initialize();
	}
	
	@Override
	public void startUp() {
		// TODO Auto-generated method stub
		this.addScene(new TreeExampleScene(this, "Tree scene"));
		
	}

}
