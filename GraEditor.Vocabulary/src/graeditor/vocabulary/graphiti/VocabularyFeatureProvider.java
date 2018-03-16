package graeditor.vocabulary.graphiti;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.pattern.DefaultFeatureProviderWithPatterns;

import graeditor.vocabulary.pattern.AreaPattern;
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
	}
	
	@Override
	public IAddFeature getAddFeature(IAddContext context) {
		// �������connection�����
		if (context instanceof IAddConnectionContext) {
//			return new AddConnectionFeature(this);
		}
		return super.getAddFeature(context);
	}

}
