package graeditor.usecase.provider;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.IDeleteFeature;
import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.pattern.DefaultFeatureProviderWithPatterns;
import org.eclipse.graphiti.ui.features.DefaultFeatureProvider;

import graeditor.usecase.features.AddConnectionFeature;
import graeditor.usecase.features.AssociateDiagramFeature;
import graeditor.usecase.features.CreateConnectionFeature;
import graeditor.usecase.features.CustomChangeTextFeature;
import graeditor.usecase.features.CustomDeleteFeature;
import graeditor.usecase.features.DeleteFeatureNotify;
import graeditor.usecase.features.DrillDownFeature;
import graeditor.usecase.features.SolveConflictFeature;
import graeditor.usecase.pattern.UseCasePattern;
import graeditor.usecase.pattern.UserPattern;

public class UseCaseDiagramFeatureProvider extends DefaultFeatureProviderWithPatterns{

	public UseCaseDiagramFeatureProvider(IDiagramTypeProvider dtp) {
		super(dtp);
		// 添加pattern，对应于objects列表中的每个项
		addPattern(new UserPattern());
		addPattern(new UseCasePattern());
	}
	
	/* 
	 * 添加“连接”选项进入右侧的Palette中
	 */
	@Override
	public ICreateConnectionFeature[] getCreateConnectionFeatures() {
		return new ICreateConnectionFeature[] { new CreateConnectionFeature(this, "has", "User has Usecase")};
	}

	@Override
	public IAddFeature getAddFeature(IAddContext context) {
		// 处理添加connection的情况
		if (context instanceof IAddConnectionContext) {
			return new AddConnectionFeature(this);
		}
		return super.getAddFeature(context);
	}
	
	public IDeleteFeature getDeleteFeature(IDeleteContext context){
		return new DeleteFeatureNotify(this);
	}

	@Override
	public ICustomFeature[] getCustomFeatures(ICustomContext context) {
		return new ICustomFeature[] { 
//				new SolveConflictFeature(this),
				new DrillDownFeature(this),
				new AssociateDiagramFeature(this),
				new CustomChangeTextFeature(this),
				new CustomDeleteFeature(this)};
	}
}
