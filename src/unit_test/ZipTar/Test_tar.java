package unit_test.ZipTar;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.arpitos.annotation.TestCase;
import com.arpitos.annotation.TestPlan;
import com.arpitos.framework.infra.TestContext;
import com.arpitos.interfaces.TestExecutable;
import com.arpitos.utils.FWUtils;
import com.arpitos.utils.UtilsTar;

@TestPlan(decription = "", preparedBy = "arpit", preparationDate = "3/05/2018", reviewedBy = "", reviewDate = "")
@TestCase(skip = false, sequence = 0, label = "all")
public class Test_tar implements TestExecutable {

	public void onExecute(TestContext context) throws Exception {
		onExecute(context, Test_tar.class);
	}

	public void execute(TestContext context) throws Exception {

		context.setKnownToFail(false, "JIRA-????");
		// --------------------------------------------------------------------------------------------
		// Clean dir before start of the test
		FWUtils.cleanDir(new File("./assets/ZipTar/resulttar"), true);
		File tarFile = new File("./assets/ZipTar/Arpitos.tar");

		// Check if it is Tar
		// boolean result = UtilTar.isTarFile(zipFile);
		// Guardian.guardEquals("Tar or not Tar", true, result);
		// System.out.println("File is a Tar File :" + tarFile);

		// Untar dir
		File destDir = new File("./assets/ZipTar/resulttar/unzip");
		UtilsTar.untar(tarFile, destDir);

		// Tar single directory
		UtilsTar.tar(new File("./assets/ZipTar/resulttar/unzip"), new File("./assets/ZipTar/resulttar/testDirTar.tar"));
		UtilsTar.tarGZ(new File("./assets/ZipTar/resulttar/unzip"), new File("./assets/ZipTar/resulttar/testDirTar.tar.gz"));

		// Tar single file
		UtilsTar.tar(new File("./assets/ZipTar/resulttar/unzip/Arpitos/Test234.txt"), new File("./assets/ZipTar/resulttar/testFileTar.tar"));
		UtilsTar.tarGZ(new File("./assets/ZipTar/resulttar/unzip/Arpitos/Test234.txt"), new File("./assets/ZipTar/resulttar/testFileTar.tar.gz"));

		// Tar multiple file
		List<File> sourceFiles = new ArrayList<>();
		sourceFiles.add(new File("./assets/ZipTar/resulttar/unzip/Arpitos/Test123.json"));
		sourceFiles.add(new File("./assets/ZipTar/resulttar/unzip/Arpitos/Test234.txt"));
		UtilsTar.tar(sourceFiles, new File("./assets/ZipTar/resulttar/testFilesTar.tar"));
		UtilsTar.tarGZ(sourceFiles, new File("./assets/ZipTar/resulttar/testFilesTar.tar.gz"));

		// Tar multiple Directories
		List<File> sourceDir = new ArrayList<>();
		sourceDir.add(new File("./assets/ZipTar/resulttar/unzip/Arpitos/Test_1"));
		sourceDir.add(new File("./assets/ZipTar/resulttar/unzip/Arpitos/Test_2"));
		UtilsTar.tar(sourceDir, new File("./assets/ZipTar/resulttar/testDirsTar.tar"));
		UtilsTar.tarGZ(sourceDir, new File("./assets/ZipTar/resulttar/testDirsTar.tar.gz"));

		// Tar Files + Dirs
		List<File> sourceFilesAndDirs = new ArrayList<>();
		sourceFilesAndDirs.add(new File("./assets/ZipTar/resulttar/unzip/Arpitos/Test123.json"));
		sourceFilesAndDirs.add(new File("./assets/ZipTar/resulttar/unzip/Arpitos/Test234.txt"));
		sourceFilesAndDirs.add(new File("./assets/ZipTar/resulttar/unzip/Arpitos/Test_1"));
		sourceFilesAndDirs.add(new File("./assets/ZipTar/resulttar/unzip/Arpitos/Test_2"));
		UtilsTar.tar(sourceFilesAndDirs, new File("./assets/ZipTar/resulttar/testFilesAndDirsTar.tar"));
		UtilsTar.tarGZ(sourceFilesAndDirs, new File("./assets/ZipTar/resulttar/testFilesAndDirsTar.tar.gz"));
		// --------------------------------------------------------------------------------------------

	}
}
