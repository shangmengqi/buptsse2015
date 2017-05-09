package graeditor.usecase.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.pattern.IPattern;

public class SolveConflictFeature extends AbstractCustomFeature{
	private static boolean canExecute = false;

	public SolveConflictFeature(IFeatureProvider fp) {
		super(fp);
	}
	
	@Override
	public String getName() {
		return "Solve Conflict";
	}
	
	@Override
    public String getDescription() {
        return "Solve Conflict";
    }
	
	@Override
	public boolean canExecute(ICustomContext context) {
		return canExecute;
	}


	@Override
	public void execute(ICustomContext context) {
		// TODO Auto-generated method stub
	}

	public static boolean isCanExecute() {
		return canExecute;
	}

	public static void setCanExecute(boolean flag) {
		canExecute = flag;
	}

}
