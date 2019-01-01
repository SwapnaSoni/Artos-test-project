package com.artos.tests.utils_ziptar;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;
import com.artos.utils.UtilsFile;
import com.artos.utils.UtilsTar;

@TestPlan(description = "", preparedBy = "arpit", preparationDate = "3/05/2018", reviewedBy = "", reviewDate = "")
@TestCase(skip = false, sequence = 0)
public class Test_tar implements TestExecutable {

	@Override public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		// Clean dir before start of the test
		UtilsFile.cleanDir(new File("./assets/ZipTar/resulttar"), true);
		File tarFile = new File("./assets/ZipTar/Arpitos.tar");

		// Check if it is Tar
		// boolean result = UtilTar.isTarFile(zipFile);
		// Guard.guardEquals(context, "Tar or not Tar", true, result);
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
