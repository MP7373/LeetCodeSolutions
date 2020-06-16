import java.util.regex.*;

class Solution {
    private static final Pattern ip4Pattern = Pattern.compile("^" +
            "([0-9]|([1-9][0-9])|(1[0-9][0-9])|(2[0-4][0-9])|(25[0-5]))" + "\\." +
            "([0-9]|([1-9][0-9])|(1[0-9][0-9])|(2[0-4][0-9])|(25[0-5]))" + "\\." +
            "([0-9]|([1-9][0-9])|(1[0-9][0-9])|(2[0-4][0-9])|(25[0-5]))" + "\\." +
            "([0-9]|([1-9][0-9])|(1[0-9][0-9])|(2[0-4][0-9])|(25[0-5]))" + "$");
    private static final Pattern ip6Pattern = Pattern.compile("^" +
            "(([0-9a-fA-F]|([0-9a-fA-F][0-9a-fA-F])|([0-9a-fA-F][0-9a-fA-F][0-9a-fA-F])|([0-9a-fA-F][0-9a-fA-F][0-9a-fA-F][0-9a-fA-F]))\\:){7}" +
            "([0-9a-fA-F]|([0-9a-fA-F][0-9a-fA-F])|([0-9a-fA-F][0-9a-fA-F][0-9a-fA-F])|([0-9a-fA-F][0-9a-fA-F][0-9a-fA-F][0-9a-fA-F]))" + "$");

    public String validIPAddress(String IP) {
        return isValidIPv4Address(IP) ?
            "IPv4" :
            isValidIPv6Address(IP) ?
                "IPv6" :
                "Neither";
            
    }
    
    private boolean isValidIPv4Address(String ip) {
        return ip4Pattern.matcher(ip).matches();
    }
    
    private boolean isValidIPv6Address(String ip) {
        return ip6Pattern.matcher(ip).matches();
    }
}
