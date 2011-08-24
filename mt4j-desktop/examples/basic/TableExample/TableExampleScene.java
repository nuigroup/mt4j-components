package basic.TableExample;

import org.mt4j.AbstractMTApplication;
import org.mt4j.components.visibleComponents.widgets.Utils.MTTable.MTTableViewer;
import org.mt4j.sceneManagement.AbstractScene;
import org.mt4j.util.MTColor;

public class TableExampleScene extends AbstractScene{

	public TableExampleScene(AbstractMTApplication mtApplication, String name) {
		super(mtApplication, name);
		// TODO Auto-generated constructor stub
	
		MTTableViewer table = new MTTableViewer(mtApplication, 2, 2, 0, 0);
		myTableCell[][] cells = {{new myTableCell(mtApplication, "1"),new myTableCell(mtApplication,"2")},{new myTableCell(mtApplication, "3"),new myTableCell(mtApplication, "4")}};
		String[] cn = {"First","Second"};
		table.setColumnNames(cn);
		table.setData(cells);
		table.setComposite(true);
		getCanvas().addChild(table);
		
		setClearColor(new MTColor(255,0,0,255));
		//myTableCell cell = new myTableCell(mtApplication, "text");
		//getCanvas().addChild(cell);
	
	//	System.out.println(table.getWidthXY(TransformSpace.GLOBAL));
	}

}
