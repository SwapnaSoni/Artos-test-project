package com.tests;

import com.artos.framework.infra.Runner;
import com.artos.interfaces.PrePostRunnable;

public class ArtosMain implements PrePostRunnable {

	public static void main(String[] args) throws Exception {
		Runner runner = new Runner(ArtosMain.class);
		runner.run(args, null, 1);
	}

}
