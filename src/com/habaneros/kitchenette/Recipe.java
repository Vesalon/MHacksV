package com.habaneros.kitchenette;
import com.microsoft.windowsazure.mobileservices.*;

import java.io.Serializable;
import java.util.ArrayList;
public class Recipe implements Serializable {

	private ArrayList<Step> steps;
	private int numOfSteps;
	private String name;
	private String author;
	private int rating;
	private int totalTime;
	

	public Recipe(String user, String recipeName) {
		 steps = new ArrayList<Step>();
		 name = recipeName;
		 author = user;
		 numOfSteps = 0;
		 
	}

	public Recipe(ArrayList<Step> firstSteps) {
		for (int i = 0; i < firstSteps.size(); i++) {
			steps.add(firstSteps.get(i));
			numOfSteps++;
		}
	}

	public Step getStep(int index) {
		return steps.get(index);
	}

	public Step getFirstStep() {
		return getStep(0);
	}

	public Step removeStep(int index) {
		numOfSteps--;
		return steps.remove(index);
	}

	public Step removeFrontStep() {
		numOfSteps--;
		return steps.remove(0);
	}

	public void addStep(String step) {
		Step s = new Step(step);
		steps.add(s);
		numOfSteps++;
	}

	public void addTimedStep(String step) {
		Step s = new Step(step);
		s.timed();
		numOfSteps++;
		steps.add(s);
	}
	
	public int size() {
		return steps.size();
	}
	
	public ArrayList<Step> getSteps() {
		return steps;
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
	public int getNumOfSteps() {
		return numOfSteps;
	}
	
	public void setNumOfSteps(int num) {
		numOfSteps = num;
	}
	public void setSteps(ArrayList<Step> steps) {
		this.steps = steps;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAuthor(String auth) {
		this.author = auth;
	}
	public void setRating(int rate) {
		this.rating = rate;
	}
	public void setTotalTime(int time) {
		this.totalTime = time;
	}
	
	public String toString() {
		return name + " by " + author + " for " + totalTime + " with a rating of " + rating; 
	}
}
