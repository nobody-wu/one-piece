package com.cornelius.utils.mdtool.markdown.builder;

import com.youbenzi.mdtool.markdown.Analyzer;
import com.youbenzi.mdtool.markdown.Block;
import com.youbenzi.mdtool.markdown.BlockType;
import com.youbenzi.mdtool.markdown.ValuePart;
import com.youbenzi.mdtool.markdown.builder.BlockBuilder;
import com.youbenzi.mdtool.tool.Tools;

import java.util.ArrayList;
import java.util.List;

public class CommonTextBuilder implements BlockBuilder {

	private String content;
	public CommonTextBuilder(String content){
		this.content = content;
	}
	
	public Block bulid() {
		Block block = new Block();
		
		block.setType(BlockType.NONE);
		List<String> lines = Tools.read2List(content);
		List<ValuePart> valueParts = new ArrayList<>();
		for (String line : lines) {
			valueParts.addAll(Analyzer.analyzeLineText(line));
		}
		block.setValueParts(valueParts);
		
		return block;
	}

	public boolean isRightType() {
		return true;
	}

}
