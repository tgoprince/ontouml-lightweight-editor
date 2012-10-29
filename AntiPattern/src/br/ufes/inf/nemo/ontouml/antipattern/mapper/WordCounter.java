package br.ufes.inf.nemo.ontouml.antipattern.mapper;

public class WordCounter {
	
	private String word;
	private int counter;
	
	public String getWord() 
	{
		return word;
	}
	
	public void setWord(String word) 
	{
		this.word = word;
	}
	
	public int getCounter() 
	{
		return counter;
	}
	
	public void setCounter(int counter) 
	{
		this.counter = counter;
	}
	
	public WordCounter(String word, int counter) 
	{
		super();
		this.word = word;
		this.counter = counter;
	}
	
}
