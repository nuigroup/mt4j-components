package org.mt4j.util.logging;


/**
 * A logger which doesent to anything. Use this logger if you dont want anything to be logged
 * and for better runtime performance of an application.
 */
public class AndroidDummyLogger implements ILogger {
		private String name;
		
		public AndroidDummyLogger(){	}
		
		private AndroidDummyLogger(String name){
			this.name = name;
		}
		
		public void setLevel(int level) {
		}

		public void info(Object message) {
		}

		public void debug(Object message) {
		}

		public void warn(Object message) {
		}

		public void error(Object message) {
		}

		public ILogger createNew(String name) {
			return new AndroidDummyLogger(name);
		}

		public int getLevel() {
			return -1;
		}

	}
