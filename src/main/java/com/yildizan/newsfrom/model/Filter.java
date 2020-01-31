package com.yildizan.newsfrom.model;

public class Filter {
	
	private int[] categories;
	private int[] languages;
	private int[] publishers;
	
	public Filter() {}

	public int[] getCategories() {
		return categories;
	}

	public void setCategories(int[] categories) {
		this.categories = categories;
	}

	public int[] getLanguages() {
		return languages;
	}

	public void setLanguages(int[] languages) {
		this.languages = languages;
	}

	public int[] getPublishers() {
		return publishers;
	}

	public void setPublishers(int[] publishers) {
		this.publishers = publishers;
	}
	
}
