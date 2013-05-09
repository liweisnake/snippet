package org.levi.reusable.algo;

/**
 * 在一个大串中查找和另外一个字符串是anagram的子串。比如，GetAnagram("abcdbcsdaqdbahs'', "scdcb'') ==> "cdbcs''。
 * 
 * @author Administrator
 *
 */
public class GetAnagram {

	private static String getAnagram(String orginal, String sub){
		int count = 0;
		for(int i = 0; i < orginal.length(); i++){
			if(sub.contains(orginal.charAt(i) + "")){
				count++;
				if(count == sub.length()){
					return orginal.substring(i - count + 1, i + 1);
				}
			}else{
				count = 0;
			}
		}
		return "";
	}
	
	private static String getAnagram2(String orginal, String sub){
		for(int i = 0; i < orginal.length(); i++){
			int index = 0;
			StringBuffer sb = new StringBuffer(sub);
			for(int j = 0; j < sub.length(); j++){//advance
				if((index = sb.indexOf(orginal.charAt(i + j) + "")) != -1){
					sb = sb.deleteCharAt(index);
					if(sb.length() == 0)
						return orginal.substring(i, i + sub.length());
				}else{
					sb = new StringBuffer(sub);
				}
			}
		}
		return "";
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(getAnagram2("abcdbcsdaqdbahs", "scdcb"));
	}

}
