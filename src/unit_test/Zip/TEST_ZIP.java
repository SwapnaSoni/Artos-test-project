package unit_test.Zip;

import java.io.File;

import javax.swing.JFileChooser;

import com.arpit.framework.Test;
import com.arpit.infra.TestContext;
import com.arpit.interfaces.TestExecutor;
import com.arpit.utils.Zip;

/***
 * 
 * <PRE>
 * START_OF_TEST_HEADER
 * TEST_TARGET			= 	TEST_ZIP
 * TEST_STEPS			=	???
 * EXPECTED_RESULTS		=	???
 * DEPENDENCY			=	None
 * NOTES				=	None
 * PREPARED_BY			=	arpit
 * REVIEWED_BY			=	
 * REVIEW_DATE			=	dd/mm/yyyy
 * END_OF_TEST_HEADER
 * </PRE>
 */
public class TEST_ZIP extends Test implements TestExecutor {

	public void onExecute(TestContext context) throws Exception {
		onExecute(context, TEST_ZIP.class, "arpit", "31/10/2017", "");
	}

	protected void execute(TestContext context) throws Exception {

		context.setKnownToFail(false, "");
		// --------------------------------------------------------------------------------------------
		File SourceDir = dirChooser("Please select Source Dir");
		File DestDir = dirChooser("Please select Destination Dir");
		Zip appZip = new Zip(SourceDir, DestDir, "test123.zip");
		// --------------------------------------------------------------------------------------------

	}

	public File dirChooser(String strDialogTitle) {
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("."));
		chooser.setDialogTitle(strDialogTitle);
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

		//
		// disable the "All files" option.
		//
		chooser.setAcceptAllFileFilterUsed(false);

		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			return chooser.getSelectedFile();
		} else {
			return null;
		}
	}
}