package advanced.ShadersTest;

import org.mt4j.AbstractMTApplication;
import org.mt4j.sceneManagement.AbstractScene;

public class ShaderTestScene extends AbstractScene{

	private AbstractMTApplication pa;

	public ShaderTestScene(AbstractMTApplication mtApplication, String name) {
		super(mtApplication, name);
		this.pa = mtApplication;
		
		shaderComponent component = new shaderComponent(pa);
		this.getCanvas().addChild(component);
		// TODO Auto-generated constructor stub
	}

}
