package com.habaneros.kitchenette;
import com.microsoft.windowsazure.mobileservices.*;

public class Step {

	boolean timed;
	String action;
	Duration time;

	public Step(String action) {
		timed = false;
		this.action = action;
	}

	public void timed() {
		timed = true;
	}
	
	public Boolean isTimed() {
		return timed;
	}
	
	public void timer(int hour, int min, int sec) {
		time = new Duration(hour, min, sec);
	}
	
	public int getDuration() {
		return time.getLength();
	}
	
	public String getAction() {
		return action;
	}
	
	public String toString() {
		String timer = isTimed() ? " for " + time.toString() : "";
		return action + timer;
	}
	
	private class Duration {
		int hour;
		int min;
		int sec;
		
		public Duration(int hour, int min, int sec) {
			this.hour = hour;
			this.min = min;
			this.sec = sec;
		}
		
		public int getLength() {
			return hour * 3600 + min * 60 + sec;
		}
		
		public String toString() {
			String ret = "";
			int count = 0;
			if (sec != 0) {
				ret = sec + " seconds";
				count++;
			}
			if (min != 0 && count == 0) {
				ret = min + "minutes";
			} else if (min != 0) {
				ret = min + " minutes and " + ret;
				count++;
			}
			if (hour != 0 && count == 0) {
				ret = hour + " hours";
			} else if (hour != 0 && count == 1) {
				ret = hour + " hours and " + ret;
			} else if (hour != 0 && count == 2) {
				ret = hour + " hours " + ret;
			}
			return ret;
		}
	}
	
}
