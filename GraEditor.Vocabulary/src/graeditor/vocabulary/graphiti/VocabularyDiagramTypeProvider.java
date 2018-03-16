package graeditor.vocabulary.graphiti;

import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;


public class VocabularyDiagramTypeProvider extends AbstractDiagramTypeProvider{
	
	public VocabularyDiagramTypeProvider() {
		super();
		setFeatureProvider(new VocabularyFeatureProvider(this));	}

}
