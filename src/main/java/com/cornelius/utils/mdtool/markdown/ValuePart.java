package com.cornelius.utils.mdtool.markdown;

import com.youbenzi.mdtool.markdown.BlockType;
import com.youbenzi.mdtool.markdown.MDToken;

import java.util.Arrays;
import java.util.Map.Entry;

public class ValuePart{
	private String value;
	private BlockType[] types;
	private int level;
	private String url;
	private String title;

	public ValuePart(){
		super();
	}

	public ValuePart(String value){
		this.value = revertValue(value);
	}

	public ValuePart(String value, BlockType... types){
		this.value = revertValue(value);
		this.types = types;
	}

	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = revertValue(value);
	}
	public BlockType[] getTypes() {
		return types;
	}
	public void setTypes(BlockType... types) {
		this.types = types;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public void addType(BlockType type){
		if(types!=null){
			types = Arrays.copyOf(types, types.length+1);
		}else{
			types = new BlockType[1];
		}

		types[types.length-1] = type;
	}

	/**
	 * 还原value中的特殊符号占位符
	 * @param value 操作对象
	 * @return 还原结果
	 */
	public static String revertValue(String value) {

		for (Entry<String, String> entry : MDToken.PLACEHOLDER_MAP.entrySet()) {
			String tmpValue = entry.getKey().substring(1);	//需要去除第一个反斜杠
			value = value.replace(entry.getValue(), tmpValue);
		}
		return value;
	}

	/**
	 * 把需要显示的特殊符号转换为占位符
	 * @param value 操作对象
	 * @return 转换结果
	 */
	public static String convertValue(String value) {
		for (Entry<String, String> entry : MDToken.PLACEHOLDER_MAP.entrySet()) {
			value = value.replace(entry.getKey(), entry.getValue());
		}
		return value;
	}

	@Override
	public String toString() {
		return "value:"+value+"|types:"+Arrays.toString(types);
	}

	public static void main(String[] args) {
		com.youbenzi.mdtool.markdown.ValuePart part = new com.youbenzi.mdtool.markdown.ValuePart();
		part.setTypes(BlockType.BOLD_WORD, BlockType.CODE);
		System.out.println(Arrays.toString(part.getTypes()));
		part.addType(BlockType.HEADLINE);
		System.out.println(Arrays.toString(part.getTypes()));
	}
}