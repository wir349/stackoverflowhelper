package org.cs259.stackoverflowhelper;

import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.ITypeRoot;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.*;
import org.eclipse.jdt.core.dom.NodeFinder;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.texteditor.*;
import org.eclipse.jface.text.ITextSelection;


public class ASTArticleHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
	    //this object is needed to render wizards, messages and so on 
	    Shell activeShell = HandlerUtil.getActiveShell(event);
	    //get selected items or text 
	    ISelection currentSelection = HandlerUtil.getCurrentSelection(event);
	    //identify active GUI part
	    String activePartId = HandlerUtil.getActivePartId(event);
	    //java editor must be handled differently than view selection 
//	    if (EclipseConstants.JAVA_EDITOR_ID.equals(activePartId)) {
		      //get edited file
		IEditorInput input = HandlerUtil.getActiveEditorInput(event);
		System.out.println(input);
		      //currentSelection now contains text selection inside input file
		      //... locate class selected in that file ...
//	    } else {
//	      //currentSelection now contains all classes inside 
//	      //... collect all selected classes ...
//	    }
	    
		ITextEditor editor = (ITextEditor) HandlerUtil.getActiveEditor(event);
		ITextSelection sel  = (ITextSelection) editor.getEditorSite().getSelectionProvider().getSelection();
        ITypeRoot typeRoot = JavaUI.getEditorInputTypeRoot(editor.getEditorInput());
        ICompilationUnit icu = (ICompilationUnit) typeRoot.getAdapter(ICompilationUnit.class);
        CompilationUnit cu = parse(icu);
        NodeFinder finder = new NodeFinder(cu, sel.getOffset(), sel.getLength());
        ASTNode node = finder.getCoveringNode();
        switch(node.getParent().getNodeType()) {
        case ASTNode.METHOD_INVOCATION:
        	MethodInvocation method = (MethodInvocation) node.getParent();
        	SimpleName methodName = method.getName();
        	String str = method.getExpression().toString();
        	Helper.sendToPythonScript(str, methodName.getIdentifier());
//        	ASTNode parent = node.getParent();
//        	ASTNode grandparent = node.getParent().getParent();
//        	ASTNode greatgrandparent = node.getParent().getParent().getParent();
//        	ASTNode root = node.getRoot();
//        	System.out.println(parent.toString() + grandparent.toString());
        	
        default:
//        	parent = node.getParent();
//        	grandparent = node.getParent().getParent();
//        	System.out.println(parent.toString() + grandparent.toString());
        }
		System.out.println(node.toString());

	    System.out.println("CheckNonNullParameterHandler");
	    return null;
	}
	
	private AbstractASTArticle createActionExecutable(String id) {
		if ("net.sourceforge.earticleast.app.astArticleAction1".equals(id)) {
			return new ASTArticleMoveVariableDeclaration();
		} else {
			throw new IllegalArgumentException(id);
		}
	}

	/**
	 * Parses source code.
	 *
	 * @param lwUnit
	 *            the Java Model handle for the compilation unit
	 * @return the root AST node of the parsed source
	 */
	protected CompilationUnit parse(ICompilationUnit lwUnit) {
		ASTParser parser = ASTParser.newParser(AST.JLS3);
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		parser.setSource(lwUnit); // set source
		parser.setResolveBindings(true); // we need bindings later on
		return (CompilationUnit) parser.createAST(null /* IProgressMonitor */); // parse
	}

}
