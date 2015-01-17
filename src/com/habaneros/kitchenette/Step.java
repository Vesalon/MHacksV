package com.habaneros.kitchenette;

public class Step {

	boolean timed;
	String step;

	public Step(String add) {
		timed = false;
		step = add;
	}

	public void makeTimed() {
		timed = true;
	}
}
