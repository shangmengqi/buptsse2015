package graeditor.relation.graphiti;

import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;

public class RelationDiagramTypeProvider extends AbstractDiagramTypeProvider{

	public RelationDiagramTypeProvider() {
		super();
		setFeatureProvider(new RelationFeatureProvider(this));
	}
}
