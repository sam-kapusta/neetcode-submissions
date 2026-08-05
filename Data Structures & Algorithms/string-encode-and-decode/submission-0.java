class Solution {
    public String encode(List<String> strs) {
        StringBuilder result = new StringBuilder();
        for(String str: strs) {
            result.append(str);
            result.append("€");
        }
        return result.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder(str);
        int index = sb.indexOf("€");
        while(index != -1) {
            result.add(sb.substring(0, index));
            sb.delete(0, index+1);
            index = sb.indexOf("€");
        }
        return result;
    }
}
