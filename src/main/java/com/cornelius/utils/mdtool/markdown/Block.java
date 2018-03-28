package com.cornelius.utils.mdtool.markdown;

import com.youbenzi.mdtool.markdown.BlockType;
import com.youbenzi.mdtool.markdown.ValuePart;

import java.util.Arrays;
import java.util.List;

public class Block {

	private String mdToken;
	private BlockType type;
	private ValuePart[] valueParts;
	private int level;
	private List<List<com.youbenzi.mdtool.markdown.Block>> tableData;
	private List<com.youbenzi.mdtool.markdown.Block> listData;
	private com.youbenzi.mdtool.markdown.Block lineData;
	
	public String getMdToken() {
		return mdToken;
	}
	public void setMdToken(String mdToken) {
		this.mdToken = mdToken;
	}
	public BlockType getType() {
		return type;
	}
	public void setType(BlockType type) {
		this.type = type;
	}
	public ValuePart[] getValueParts() {
		return valueParts;
	}
	public void setValueParts(ValuePart... valueParts) {
		this.valueParts = valueParts;
	}
	public void setValueParts(List<ValuePart> parts) {
		this.valueParts = new ValuePart[parts.size()];
		for (int i=0, l=parts.size(); i<l; i++) {
			this.valueParts[i] = parts.get(i);
		}
	}
	
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public List<List<com.youbenzi.mdtool.markdown.Block>> getTableData() {
		return tableData;
	}
	public void setTableData(List<List<com.youbenzi.mdtool.markdown.Block>> tableData) {
		this.tableData = tableData;
	}
	public List<com.youbenzi.mdtool.markdown.Block> getListData() {
		return listData;
	}
	public void setListData(List<com.youbenzi.mdtool.markdown.Block> listData) {
		this.listData = listData;
	}
	public com.youbenzi.mdtool.markdown.Block getLineData() {
		return lineData;
	}
	public void setLineData(com.youbenzi.mdtool.markdown.Block lineData) {
		this.lineData = lineData;
	}
	@Override
	public String toString() {
		return "mdToken:"+ mdToken + "blockType:"+type+"|valueParts:"+Arrays.toString(valueParts)+"|level:"+level + "|listData:" + listData;
	}
}
