package org.fujitsu.training.codes;

import java.io.File;

public class TestFileTransfer {

	public static void main(String[] args) {
		FileTransfer ft = new FileTransfer();
		ft.createBin();
		ft.createBin2();
		ft.transfer();

	}

}
