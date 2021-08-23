package org.ssglobal.training.codes;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Divide {
	private static Logger logger = Logger.getLogger(Divide.class.getName());
	
	public Divide() {
		logger.setLevel(Level.INFO);
	}
	
	public int div(int x, int y) throws ArithmeticException, Exception{
		logger.info("execute div x="+ x + " and y=" + y);
		
		logger.info("validation: denomenator u not be 0");
		if(y == 0) {
			logger.severe("Error: division by zero not allowed");
			throw new ArithmeticException("division by zero not allowed");
		}else {
			logger.info("exit without errors div");
			return x/y;
		}
		
	}

}
