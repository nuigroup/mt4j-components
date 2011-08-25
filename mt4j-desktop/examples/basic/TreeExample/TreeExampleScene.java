package basic.TreeExample;

import org.mt4j.AbstractMTApplication;
import org.mt4j.components.visibleComponents.widgets.Utils.MTree.MTTreeViewer;
import org.mt4j.sceneManagement.AbstractScene;
import org.mt4j.util.MTColor;

public class TreeExampleScene extends AbstractScene{

	public TreeExampleScene(AbstractMTApplication mtApplication, String name) {
		super(mtApplication, name);
		
		setClearColor(new MTColor(0,255,0,255));
		
		MTTreeViewer tree = new MTTreeViewer(mtApplication);
		tree.setOffset(30, 0);
		tree.setFillColor(new MTColor(255,0,0,255));
		//tree.setComposite(true);
		
		myTreeNode node = new myTreeNode(mtApplication, " 0 0");
		node.addChildNode(new myTreeNode(mtApplication, " 1 1"));
		node.addChildNode(new myTreeNode(mtApplication, " 1 2"));
		node.getChildNode(1).addChildNode(new myTreeNode(mtApplication, " 2 1"));
		node.addChildNode(new myTreeNode(mtApplication, " 1 1"));
		node.addChildNode(new myTreeNode(mtApplication, " 1 2"));
		tree.addNode(node);
		tree.addNode(new myTreeNode(mtApplication, " 2 2"));
		tree.addNode(new myTreeNode(mtApplication, " 2 2"));
		tree.addNode(new myTreeNode(mtApplication, " 2 2"));
		tree.addNode(new myTreeNode(mtApplication, " 2 2"));
		
		getCanvas().addChild(tree);
	}

}
