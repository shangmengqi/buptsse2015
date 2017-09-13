package graeditor.relation.graphiti;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICopyFeature;
import org.eclipse.graphiti.features.IPasteFeature;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICopyContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.IPasteContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.pattern.DefaultFeatureProviderWithPatterns;

import graeditor.relation.features.AssociateDiagramFeature;
import graeditor.relation.features.CopyFeature;
import graeditor.relation.features.CustomBackAssociateDiagramFeature;
import graeditor.relation.features.CustomChangeTextFeature;
import graeditor.relation.features.CustomDeleteFeature;
import graeditor.relation.features.DrillDownFeature;
import graeditor.relation.features.PasteFeature;
import graeditor.relation.pattern.ContentPattern;
import graeditor.relation.pattern.HorizontalLinePattern;
import graeditor.relation.pattern.TitlePattern;

public class RelationFeatureProvider extends DefaultFeatureProviderWithPatterns{

	public RelationFeatureProvider(IDiagramTypeProvider dtp) {
		super(dtp);
		addPattern(new ContentPattern());
		addPattern(new TitlePattern());
		addPattern(new HorizontalLinePattern());
	}
	
	@Override
	public IAddFeature getAddFeature(IAddContext context) {
		// 处理添加connection的情况		
		return super.getAddFeature(context);
	}
	
	@Override
	public ICustomFeature[] getCustomFeatures(ICustomContext context) {
		return new ICustomFeature[] {				
			new CustomChangeTextFeature(this),
			new CustomBackAssociateDiagramFeature(this),
			new CustomDeleteFeature(this)
			};
		
	}
	
	@Override
	public ICopyFeature getCopyFeature(ICopyContext context) {
		return new CopyFeature(this);
	}
	
	@Override
	public IPasteFeature getPasteFeature(IPasteContext context) {
		return new PasteFeature(this);
	}
}
