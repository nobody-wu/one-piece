package com.cornelius.utils.mdtool.export;

import com.youbenzi.mdtool.markdown.Block;

import java.util.List;

public interface Decorator {
	
	public void beginWork(String outputFilePath);
	
	public void decorate(List<Block> list);
	
	public void afterWork(String outputFilePath);
	
}
