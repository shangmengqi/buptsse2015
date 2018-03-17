package graeditor.vocabulary.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddFeature;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;

import graeditor.vocabulary.features.CreateConnectionFeature.ConnectionType;


public class AddConnectionFeature extends AbstractAddFeature{

	public AddConnectionFeature(IFeatureProvider fp) {
		super(fp);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canAdd(IAddContext context) {
		if (context instanceof IAddConnectionContext) {
			return true;
		}
		return false;
	}

	@Override
	public PictogramElement add(IAddContext context) {
		IAddConnectionContext addConContext = (IAddConnectionContext) context;
		IPeCreateService peCreateService = Graphiti.getPeCreateService();
		
		ConnectionType type = (ConnectionType) context.getNewObject();
		
		Connection connection;
		
		if (type == ConnectionType.FREEFORM) {
			connection = peCreateService.createFreeFormConnection(getDiagram());
		}else {
			connection = peCreateService.createManhattanConnection(getDiagram());
		}
		
		connection.setStart(addConContext.getSourceAnchor());
		connection.setEnd(addConContext.getTargetAnchor());
		
		IGaService gaService = Graphiti.getGaService();
		Polyline polyline = gaService.createPolyline(connection);
		polyline.setLineWidth(1);
		polyline.setForeground(manageColor(0, 0, 0));
		ConnectionDecorator cDecorator = peCreateService.createConnectionDecorator(connection, false, 1.0, true);
		Polyline arrowLine = gaService.createPolyline(cDecorator, new int[]{-15,10,0,0,-15,-10});
		arrowLine.setForeground(manageColor(0, 0, 0));
		arrowLine.setLineWidth(1);
		return connection;
	}

}
