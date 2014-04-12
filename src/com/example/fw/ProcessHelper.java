package com.example.fw;

import java.io.IOException;

public class ProcessHelper extends HelperBase{

	private Process process;

	public ProcessHelper(ApplicationManager manager) {
		super(manager);
	}

	public void startAppUndertest () throws IOException {
		//String command = "";
		String command = manager.getProperty("app.path");
		process = Runtime.getRuntime().exec(command);
	}
	
	public void stopAppUndertest () {
		process.destroy();
	}
	
}
