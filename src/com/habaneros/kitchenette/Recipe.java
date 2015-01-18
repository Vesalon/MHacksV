package com.habaneros.kitchenette;

import java.util.ArrayList;
public class Recipe {

	private ArrayList<Step> steps;
	private String name;
	private String author;
	private int rating;
	

	public Recipe(String user, String recipeName) {
		 steps = new ArrayList<Step>();
		 name = recipeName;
		 author = user;
		 
	}

	public Recipe(ArrayList<Step> firstSteps) {
		for (int i = 0; i < firstSteps.size(); i++) {
			steps.add(firstSteps.get(i));
		}
	}

	public Step getStep(int index) {
		return steps.get(index);
	}

	public Step getFirstStep() {
		return getStep(0);
	}

	public Step removeStep(int index) {
		return steps.remove(index);
	}

	public Step removeFrontStep() {
		return steps.remove(0);
	}

	public void addStep(String step) {
		Step s = new Step(step);
		steps.add(s);
	}

	public void addTimedStep(String step) {
		Step s = new Step(step);
		s.timed();
		steps.add(s);
	}
	
	public int size() {
		return steps.size();
	}
	
	public String getName() {
		return name;
	}
	public String getAuthor() {
		return author;
	}
	public int getRating() {
		return rating;
	}
}
