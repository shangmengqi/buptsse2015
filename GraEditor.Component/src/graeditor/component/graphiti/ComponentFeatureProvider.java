package graeditor.component.graphiti;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.pattern.DefaultFeatureProviderWithPatterns;

import graeditor.component.pattern.DatabasePattern;
import graeditor.component.pattern.LittleComponentPattern;
import graeditor.component.pattern.LittleFramworkPattern;
import graeditor.component.pattern.LittleInterfacePattern;

public class ComponentFeatureProvider extends DefaultFeatureProviderWithPatterns{

	public ComponentFeatureProvider(IDiagramTypeProvider dtp) {
		super(dtp);
		addPattern(new DatabasePattern());
		addPattern(new LittleComponentPattern());
		addPattern(new LittleInterfacePattern());
		addPattern(new LittleFramworkPattern());
	}
	
	
	@Override
	public IAddFeature getAddFeature(IAddContext context) {
		return super.getAddFeature(context);
	}

}
