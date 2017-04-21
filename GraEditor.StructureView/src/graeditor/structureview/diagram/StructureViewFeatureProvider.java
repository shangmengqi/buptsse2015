package graeditor.structureview.diagram;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.pattern.DefaultFeatureProviderWithPatterns;

import graeditor.structureview.features.AddConnectionFeature;
import graeditor.structureview.features.AssociateDiagramFeature;
import graeditor.structureview.features.CreateConnectionFeature;
import graeditor.structureview.features.CustomChangeTextFeature;
import graeditor.structureview.features.CustomDeleteFeature;
import graeditor.structureview.features.DrillDownFeature;
import graeditor.structureview.pattern.FileGroupPattern;
import graeditor.structureview.pattern.FilePattern;
import graeditor.structureview.pattern.PageGroupPattern;
import graeditor.structureview.pattern.PagePattern;


public class StructureViewFeatureProvider extends DefaultFeatureProviderWithPatterns {

	public StructureViewFeatureProvider(IDiagramTypeProvider dtp) {
		super(dtp);
		// 添加pattern，对应于objects列表中的每个项
		addPattern(new PagePattern());
		addPattern(new PageGroupPattern());
		addPattern(new FilePattern());
		addPattern(new FileGroupPattern());
	}

	@Override
	public ICreateConnectionFeature[] getCreateConnectionFeatures() {
		return new ICreateConnectionFeature[] { new CreateConnectionFeature(this, "has", "Pages has everything")};
	}

	@Override
	public IAddFeature getAddFeature(IAddContext context) {
		// 处理添加connection的情况
		if (context instanceof IAddConnectionContext) {
			return new AddConnectionFeature(this);
		}
		return super.getAddFeature(context);
	}

	@Override
	public ICustomFeature[] getCustomFeatures(ICustomContext context) {
		return new ICustomFeature[] { 
				new CustomDeleteFeature(this),
				new DrillDownFeature(this), 
				new AssociateDiagramFeature(this),
				new CustomChangeTextFeature(this)};
				

	}

}
