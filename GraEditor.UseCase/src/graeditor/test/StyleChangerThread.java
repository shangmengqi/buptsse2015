package graeditor.test;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;


public class StyleChangerThread extends AbstractCustomFeature  implements Runnable{
	private ICustomContext context;
	
	public StyleChangerThread(IFeatureProvider fp) {
		super(fp);
	}

	private Diagram mDiagram;
	

	@Override
	public void run() {
		
	}

	@Override
	public void execute(ICustomContext context) {
		this.context = context;
		
	}
}
