package com.artos.tests;

import com.artos.framework.infra.Runner;

public class ArtosMain {

	public static void main(String[] args) throws Exception {
		Runner runner = new Runner(ArtosMain.class);
		runner.run(args);
	}

}
