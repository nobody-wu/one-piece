package com.cornelius.utils.mdtool.markdown;

import com.youbenzi.mdtool.markdown.Block;
import com.youbenzi.mdtool.markdown.BlockType;
import com.youbenzi.mdtool.markdown.MDToken;
import com.youbenzi.mdtool.markdown.TextLinePiece;
import com.youbenzi.mdtool.markdown.TextLinePiece.PieceType;
import com.youbenzi.mdtool.markdown.ValuePart;
import com.youbenzi.mdtool.markdown.filter.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Analyzer {

	private static List<String> mdTokenInLine = Arrays.asList(MDToken.BOLD_WORD1, MDToken.BOLD_WORD2, MDToken.ITALIC_WORD,
			MDToken.ITALIC_WORD_2, MDToken.STRIKE_WORD, MDToken.CODE_WORD, MDToken.IMG, MDToken.LINK);

	/**
	 * 灏嗘枃鏈В鏋愪负璇硶鍧�
	 *
	 * @param content
	 *            琚В鏋愮殑鏂囨湰
	 * @return 璇硶鍧楀垪琛�
	 */
	public static List<Block> analyze(String content) {
		content = formatText(content);
		SyntaxFilter filter = new CodePartFilter(
				new TablePartFilter(
					new HeaderOneLineFilter(
						new ListFilter(
							new HeaderNextLineFilter(null)))));

		List<Block> blocks = filter.call(content);
		return blocks;
	}

	/**
	 * 瀵逛竴琛屾枃鏈繘琛岃娉曞垎鏋愶紝涓昏閽堝鍔犵矖锛屾枩浣撶瓑鑳藉湪鍙ヤ腑浣跨敤鐨勬牸寮�
	 *
	 * @param text
	 *            涓�琛屾枃鏈�
	 * @return 鍒嗘瀽缁撴灉
	 */
	public static List<ValuePart> analyzeLineText(String text) {

		List<ValuePart> result = text2ValuePart(text.trim(), new ArrayList<String>(), new ArrayList<String>());

		if(text.endsWith(MDToken.ROW)) {
			result.add(createValuePart("", Arrays.asList(MDToken.ROW)));
		}
		return result;
	}

	/**
	 * 灏員ext 杞负 valuePart
	 * @param text 鏂囨湰鍐呭
	 * @param notCheckMDTokens 涓嶉渶瑕佹鏌ョ殑md token
	 * @param currentTypes 褰撳墠鏂囨湰宸茬粡鍖呭惈鐨刴d token绫诲瀷
	 * @return valuePart 鍒楄〃
	 */
	private static List<ValuePart> text2ValuePart(String text, List<String> notCheckMDTokens,
                                                  List<String> currentTypes) {
		List<ValuePart> result = new ArrayList<ValuePart>();
		text = ValuePart.convertValue(text);
		int textLength = text.length();
		//1. 妫�绱㈠埌绗竴涓殑md token銆傝緭鍑猴細浣嶇疆i锛岃娉曪細token
		int i = textLength;
		String mdToken = null;
		for (String tmp : mdTokenInLine) { // 妫�鏌ユ槸鍚︽湁鎸囧畾鐨刴d璇硶
			if (notCheckMDTokens.contains(tmp)) {
				continue;
			}
			int j = text.indexOf(tmp);
			if (j > -1 && i > j) { // 鎵惧埌绗竴涓鍚堣姹傜殑md璇硶
				i = j;
				mdToken = tmp;
			}
		}
		//2. 鏍规嵁杩欎釜token妫�娴嬭娉曟槸鍚﹀畬鏁�
		TextLinePiece piece = checkIfCorrectSyntax(i, mdToken, text);
		//3. 瀵规枃鏈垎涓轰笁鍧�
		int firstPartEndIndex = textLength;
		int secondPartEndIndex = 0;
		int thirdPartEndIndex = 0;
		if(piece != null) {
			firstPartEndIndex = piece.getBeginIndex();
			secondPartEndIndex = piece.getEndIndex();
			if(secondPartEndIndex < (textLength - 1)) {
				thirdPartEndIndex = textLength;
			}
		}
		//4. 瀵硅繖涓猼oken鍧椾箣鍓嶇殑鍐呭褰掓。
		if(firstPartEndIndex > 0) {
			ValuePart valuePart = createValuePart(text.substring(0, firstPartEndIndex), currentTypes);
			result.add(valuePart);
		}
		//5. 瀵硅繖涓猼oken鍧楃殑鍐呭杩涜閫掑綊鍒嗘瀽
		if(secondPartEndIndex > 0) {
			List<String> currentTypesClone = cloneList(currentTypes);
			List<String> notCheckMDTokensClone = cloneList(notCheckMDTokens);
			notCheckMDTokensClone.add(mdToken);
			currentTypesClone.add(mdToken);
			ValuePart valuePart = null;

			switch (piece.getPieceType()) {
			case LINK:
				valuePart = analyzeTextInLink(piece.getTitle(), notCheckMDTokensClone, currentTypesClone);
				String tmpValue = valuePart.getTitle() + "(" + piece.getUrl() + ")";
				valuePart.setValue(tmpValue);
				valuePart.setUrl(piece.getUrl());
				result.add(valuePart);
				break;
			case IMAGE:
				valuePart = createValuePart(piece.getUrl(), currentTypesClone);
				valuePart.setTitle(piece.getTitle());
				valuePart.setUrl(piece.getUrl());
				result.add(valuePart);
				break;
			case COMMON:
			default:
				String sencondPart = text.substring(piece.getBeginIndex() + mdToken.length(), secondPartEndIndex);
				List<ValuePart> tmpList2 = text2ValuePart(sencondPart, notCheckMDTokensClone, currentTypesClone);
				for (ValuePart tmp : tmpList2) {
					result.add(tmp);
				}
				break;
			}
		}
		//6. 瀵硅繖涓猼oken鍧椾箣鍚庡鍐呭杩涜閫掑綊鍒嗘瀽
		if(thirdPartEndIndex > 0) {

			String thirdPart = "";
			if (piece.getPieceType() == PieceType.IMAGE) { // image鐨勫紑濮嬬鏄袱涓瓧绗︼紝缁撴潫绗︽槸涓�涓瓧绗︼紝鎵�浠ヨ鐗规畩澶勭悊
				thirdPart = text.substring(piece.getEndIndex() + 1);
			} else { // 鍏跺畠鏍囩鐨勫紑濮嬬璺熺粨鏉熺闀垮害涓�鑷�
				thirdPart = text.substring(piece.getEndIndex() + mdToken.length());
			}

			List<ValuePart> tmpList1 = text2ValuePart(thirdPart, notCheckMDTokens, currentTypes);
			for (ValuePart valuePart : tmpList1) {
				result.add(valuePart);
			}
		}

		return result;
	}

	private static List<String> cloneList(List<String> target) {
		List<String> result = new ArrayList<>();
		for (String tmp : target) {
			result.add(tmp);
		}
		return result;
	}

	/**
	 * 妫�鏌dtoken 瀵瑰簲鐨勮娉曟槸鍚﹀畬鏁�
	 * @param i 寮�濮嬫煡鎵剧殑浣嶇疆
	 * @param mdToken 鏌ユ壘鐨刴d token
	 * @param text 琚煡鎵剧殑鏂囨湰
	 * @return mdtoken瀵瑰簲鐨勮娉曞潡锛屽鏋滄壘涓嶅埌锛屽垯杩斿洖null
	 */
	private static TextLinePiece checkIfCorrectSyntax(int i, String mdToken, String text) {
		if(mdToken == null) {
			return null;
		}
		TextLinePiece textLinePiece = null;
		if (mdToken.equals(MDToken.LINK) || mdToken.equals(MDToken.IMG)) {
			textLinePiece = hasLinkOrImage(text, mdToken.equals(MDToken.LINK));
		} else {
			int j = text.indexOf(mdToken, i + mdToken.length());
			if(j > -1) {
				textLinePiece = new TextLinePiece(i, j, PieceType.COMMON);
			}
		}
		return textLinePiece;
	}

	private static ValuePart createValuePart(String value, List<String> mdTokens) {
		ValuePart valuePart = new ValuePart();
		valuePart.setValue(value);
		if (mdTokens.size() > 0) {
			BlockType[] types = new BlockType[mdTokens.size()];
			int i = 0;
			for (int k = (mdTokens.size() - 1); k >= 0; k--) {
				types[i] = MDToken.convert(mdTokens.get(k)); // 杩欓噷寮曞叆i锛屾槸涓轰簡鏁扮粍鍙嶅簭
				i++;
			}
			valuePart.setTypes(types);
		}

		return valuePart;
	}

	private static TextLinePiece hasLinkOrImage(String str, boolean isLink) {
		TextLinePiece linkOrImageBean = new TextLinePiece();
		linkOrImageBean.setPieceType(isLink? PieceType.LINK: PieceType.IMAGE);
		String token = null;
		if (isLink) {
			token = MDToken.LINK;
		} else {
			token = MDToken.IMG;
		}
		int i = str.indexOf(token);
		int j = str.indexOf("]", i);
		if (j > 0) {
			int k = str.indexOf("(", j);
			if (k > 0 && k == (j + 1)) {
				int l = str.indexOf(")", k);
				if (l > 0) {
					String strHasUrl = str.substring(k + 1, l).trim();
					int m = strHasUrl.indexOf(" ");
					String url = "";
					if (m > -1) {
						url = strHasUrl.substring(0, m);
					} else {
						url = strHasUrl;
					}
					String title = str.substring(i + token.length(), j);
					linkOrImageBean.setBeginIndex(i);
					linkOrImageBean.setEndIndex(l);
					linkOrImageBean.setTitle(title);
					linkOrImageBean.setUrl(url);
					return linkOrImageBean;
				}
			}
		}
		return null;
	}

	private static ValuePart analyzeTextInLink(String str, List<String> notCheckMDTokens, List<String> currentTypes) {
		String mdToken = null;
		for (String tmp : mdTokenInLine) { // 妫�鏌ユ槸鍚︽湁鎸囧畾鐨刴d璇硶
			if (notCheckMDTokens.contains(tmp)) {
				continue;
			}
			if (str.startsWith(tmp)) {
				int end = str.indexOf(tmp, tmp.length());
				if (end > 0) {
					mdToken = tmp;
					break;
				}
			}
		}
		if (mdToken != null) {
			notCheckMDTokens.add(mdToken);
			currentTypes.add(mdToken);
			str = str.substring(mdToken.length(), str.length() - mdToken.length());
			return analyzeTextInLink(str, notCheckMDTokens, currentTypes);
		} else {
			ValuePart valuePart = createValuePart("", currentTypes);
			valuePart.setTitle(str);
			return valuePart;
		}
	}
	
	/**
	 * 鍐呭鏍煎紡鍖�
	 * @param text 闇�瑕佹牸寮忓寲鐨勫唴瀹�
	 * @return 缁撴灉
	 */
	private static String formatText(String text) {
		text = text.replaceAll("\t", "    ");
		return text;
	}
}
