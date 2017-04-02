package util;

public class StringUtils {
	/*
	 * 判断字符串为否为空
	 * @param str
	 * @return true/false
	 */
	public static boolean isEmpty(String str) {
        return null == str  || str.equals("")
                || str.matches("\\s*");
    }

    public static String defaultValue(String content,String defaultValue){
        if(isEmpty(content)){
            return defaultValue;
        }
        return content;
    }
    
    /*
     * 将数据库字段名修改为驼峰命名
     * @param column
     * @return
     */
    
    public static String columnToProperty(String column){
    	//字段为空返回空字符串
    	if(isEmpty(column)) return "";
    	//获取字段长度
    	Byte length = (byte) column.length();
    	
    	StringBuilder sb = new StringBuilder(length);
    	
    	for(int i = 0; i < length ; i++){
    		if(column.charAt(i) == '_'){
    			while(column.charAt(i+1) == '_'){
    				i =+ 1;
    			}
    			sb.append((""+column.charAt(++i)).toUpperCase());
    		}else{
    			sb.append(column.charAt(i));
    		}
    	}
    	return sb.toString();
    }
    
    /*
     * 将字符串的首字母改为大写
     * @param str
     * @return
     */
    
    public static String upperCaseFirstCharacter(String str){
    	StringBuilder sb = new StringBuilder();
    	char[] arr = str.toCharArray();
    	for(int i = 0 ; i < arr.length ; i++){
    		if(i == 0) sb.append((arr[i]+"").toUpperCase());
    		else sb.append((arr[i]+""));
    	}
    	return sb.toString();
    }
    

}
