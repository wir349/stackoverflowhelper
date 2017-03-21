package org.cs259.stackoverflowhelper;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.Statement;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.debug.core.*;

/**
 * Utitility class.
 * <p>
 * Project page: <a target="_blank"
 * href="http://sourceforge.net/projects/earticleast">http://sourceforge.net/projects/earticleast</a>
 * </p>
 *
 * @author Thomas Kuhn
 *
 */
public class Helper {
	/**
	 * Hidden. Call the static methods.
	 */
	private Helper() {
	}

	/**
	 * Finds the parent {@link Block} of a {@link Statement}.
	 *
	 * @param s
	 *            the {@link Statement} to find the its parent {@link Block} for
	 * @return the parent block of {@code s}
	 */
	public static Block getParentBlock(Statement s) {
		ASTNode node = s;
		while (!(node instanceof Block)) {
			node = node.getParent();
		}
		return (Block) node;
	}
	
	public static void sendToPythonScript(String className, String functionName) {
		try {
			ILaunchManager manager = DebugPlugin.getDefault().getLaunchManager();
			//to be able to listen the end
			ILaunchConfigurationType type = manager
			  .getLaunchConfigurationType("org.eclipse.ui.externaltools.ProgramLaunchConfigurationType");
			ILaunchConfiguration[] configurations;
				configurations = manager
						  .getLaunchConfigurations(type);
				for (int i = 0; i < configurations.length; i++) {
				 ILaunchConfiguration configuration = configurations[i];
				 if (configuration.getName().equals("PythonScript")) {
				  configuration.delete();
				  break;
				 }
				}
				ILaunchConfigurationWorkingCopy workingCopy = type.newInstance(
						  null, "PythonScript");
				workingCopy.setAttribute(
				  "org.eclipse.ui.externaltools.ATTR_LOCATION",
				  "/System/Library/Frameworks/Python.framework/Versions/2.7/bin/python2.7");
				workingCopy.setAttribute(
				  "org.eclipse.ui.externaltools.ATTR_TOOL_ARGUMENTS",
				  "/Users/waleed/PycharmProjects/stackoverflowhelper/main.py java stackoverflow " + className + " " + functionName + " doesn't work");
				ILaunch launch = workingCopy.launch(ILaunchManager.RUN_MODE,
				  new NullProgressMonitor());
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
