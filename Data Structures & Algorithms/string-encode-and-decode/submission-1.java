class Solution {
    public String encode(List<String> strs) {
        StringBuilder result = new StringBuilder();
        for(String str: strs) {
            result.append(str.length());
            result.append("#");
            result.append(str);
        }
        return result.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while(i < str.length()) {
            int j = i;
            while(str.charAt(j) != '#') j++;
            int size = Integer.parseInt(str.substring(i, j));
            result.add(str.substring(j+1, j+1+size));
            i = j + 1 + size;
        }
        return result;
    }
}
