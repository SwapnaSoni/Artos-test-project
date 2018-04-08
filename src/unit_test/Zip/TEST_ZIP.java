package unit_test.Zip;

import java.io.File;

import javax.swing.JFileChooser;

import com.arpitos.infra.TestContext;
import com.arpitos.infra.annotation.Testcase;
import com.arpitos.interfaces.TestExecutable;
import com.arpitos.utils.Zip;

//@formatter:off
@Testcase(skip = false, scenario = "TEST_BYTES_TO_ASCII",
decription = "\nGIVEN : "
           + "\nAND   : "
           + "\nWHEN  : "
           + "\nTHEN  : "
, preparedBy = "arpit", preparationDate = "8/04/2018", reviewedBy = "", reviewDate = "")
//@formatter:on
public class TEST_ZIP implements TestExecutable {

	public void onExecute(TestContext context) throws Exception {
		onExecute(context, TEST_ZIP.class);
	}

	public void execute(TestContext context) throws Exception {

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