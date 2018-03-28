package com.cornelius.utils.mdtool.markdown.builder;

import com.youbenzi.mdtool.markdown.Block;
import com.youbenzi.mdtool.markdown.BlockType;
import com.youbenzi.mdtool.markdown.ValuePart;
import com.youbenzi.mdtool.markdown.builder.BlockBuilder;

public class CodeBuilder implements BlockBuilder {

	private String content;
	public CodeBuilder(String content){
		this.content = content;
	}
	
	public Block bulid() {
		Block block = new Block();
		block.setType(BlockType.CODE);
		block.setValueParts(new ValuePart(content));
		return block;
	}

	public boolean isRightType() {
		return false;
	}

}
