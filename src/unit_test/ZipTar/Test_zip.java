package unit_test.ZipTar;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.arpitos.infra.TestContext;
import com.arpitos.infra.annotation.Testcase;
import com.arpitos.interfaces.TestExecutable;
import com.arpitos.utils.Guardian;
import com.arpitos.utils.Utils;
import com.arpitos.utils.UtilsZip;

// @formatter:off
@Testcase(skip=false, scenario = "Test_zip",
decription = "\nGIVEN : "
           + "\nAND   : "
           + "\nWHEN  : "
           + "\nAND   : "
           + "\nTHEN  : "
, preparedBy = "arpit", preparationDate = "28/04/2018", reviewedBy = "", reviewDate = "")
// @formatter:on
public class Test_zip implements TestExecutable {

	public void onExecute(TestContext context) throws Exception {
		onExecute(context, Test_zip.class);
	}

	public void execute(TestContext context) throws Exception {

		context.setKnownToFail(false, "");
		// --------------------------------------------------------------------------------------------
		// Clean dir before start of the test
		Utils.cleanDir(new File("./assets/ZipTar/resultzip"), true);
		File zipFile = new File("./assets/ZipTar/Arpitos.zip");

		// Check if it is Zip
		boolean result = UtilsZip.isZipFile(zipFile);
		Guardian.guardEquals("Zip or not Zip", true, result);
		System.out.println("File is a Zip File :" + zipFile);

		// Unzip dir
		File destDir = new File("./assets/ZipTar/resultzip/unzip");
		UtilsZip.unzip(zipFile, destDir);

		// Zip single directory
		UtilsZip.zip(new File("./assets/ZipTar/resultzip/unzip"), new File("./assets/ZipTar/resultzip/testDirZip.zip"));

		// Zip single file
		UtilsZip.zip(new File("./assets/ZipTar/resultzip/unzip/Arpitos/Test234.txt"), new File("./assets/ZipTar/resultzip/testFileZip.zip"));

		// Zip multiple file
		List<File> sourceFiles = new ArrayList<>();
		sourceFiles.add(new File("./assets/ZipTar/resultzip/unzip/Arpitos/Test123.json"));
		sourceFiles.add(new File("./assets/ZipTar/resultzip/unzip/Arpitos/Test234.txt"));
		UtilsZip.zip(sourceFiles, new File("./assets/ZipTar/resultzip/testFilesZip.zip"));

		// Zip multiple Directories
		List<File> sourceDir = new ArrayList<>();
		sourceDir.add(new File("./assets/ZipTar/resultzip/unzip/Arpitos/Test_1"));
		sourceDir.add(new File("./assets/ZipTar/resultzip/unzip/Arpitos/Test_2"));
		UtilsZip.zip(sourceDir, new File("./assets/ZipTar/resultzip/testDirsZip.zip"));

		// Zip Files + Dirs
		List<File> sourceFilesAndDirs = new ArrayList<>();
		sourceFilesAndDirs.add(new File("./assets/ZipTar/resultzip/unzip/Arpitos/Test123.json"));
		sourceFilesAndDirs.add(new File("./assets/ZipTar/resultzip/unzip/Arpitos/Test234.txt"));
		sourceFilesAndDirs.add(new File("./assets/ZipTar/resultzip/unzip/Arpitos/Test_1"));
		sourceFilesAndDirs.add(new File("./assets/ZipTar/resultzip/unzip/Arpitos/Test_2"));
		UtilsZip.zip(sourceFilesAndDirs, new File("./assets/ZipTar/resultzip/testFilesAndDirsZip.zip"));
		// --------------------------------------------------------------------------------------------

	}
}