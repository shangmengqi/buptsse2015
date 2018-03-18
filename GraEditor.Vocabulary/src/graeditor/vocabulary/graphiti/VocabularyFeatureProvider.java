package graeditor.vocabulary.graphiti;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.pattern.DefaultFeatureProviderWithPatterns;


import graeditor.vocabulary.features.AddConnectionFeature;
import graeditor.vocabulary.features.AssociateDiagramFeature;
import graeditor.vocabulary.features.CreateConnectionFeature;
import graeditor.vocabulary.features.CreateConnectionFeature.ConnectionType;
import graeditor.vocabulary.features.CreateNewActionDiagramFeature;
import graeditor.vocabulary.features.VocabularyDrillDownFeature;
import graeditor.vocabulary.pattern.AreaPattern;
import graeditor.vocabulary.pattern.ClusterPattern;
import graeditor.vocabulary.pattern.ConcurrentSetPattern;
import graeditor.vocabulary.pattern.CondBranchPattern;
import graeditor.vocabulary.pattern.ContHorzPattern;
import graeditor.vocabulary.pattern.ContVertPattern;
import graeditor.vocabulary.pattern.DecPointPattern;
import graeditor.vocabulary.pattern.FilePattern;
import graeditor.vocabulary.pattern.FileStackPattern;
import graeditor.vocabulary.pattern.PagePattern;
import graeditor.vocabulary.pattern.PageStackPattern;

public class VocabularyFeatureProvider extends DefaultFeatureProviderWithPatterns{

	public VocabularyFeatureProvider(IDiagramTypeProvider dtp) {
		super(dtp);
		addPattern(new AreaPattern());
		addPattern(new FilePattern());
		addPattern(new FileStackPattern());
		addPattern(new PagePattern());
		addPattern(new PageStackPattern());
		addPattern(new DecPointPattern());
		addPattern(new ConcurrentSetPattern());
		addPattern(new CondBranchPattern());
		addPattern(new ClusterPattern());
		addPattern(new ContVertPattern());
		addPattern(new ContHorzPattern());
	}
	
	@Override
	public IAddFeature getAddFeature(IAddContext context) {
		// �������connection�����
		if (context instanceof IAddConnectionContext) {
			return new AddConnectionFeature(this);
		}
		return super.getAddFeature(context);
	}
	
	@Override
	public ICreateConnectionFeature[] getCreateConnectionFeatures() {
		return new ICreateConnectionFeature[]{
				new CreateConnectionFeature(this, ConnectionType.FREEFORM),
				new CreateConnectionFeature(this, ConnectionType.MANHATTAN)
		};
	}
	
	@Override
	public ICustomFeature[] getCustomFeatures(ICustomContext context) {
		return new ICustomFeature[] {				
			new VocabularyDrillDownFeature(this),
			new AssociateDiagramFeature(this),
			new CreateNewActionDiagramFeature(this),
			};
	}

}
