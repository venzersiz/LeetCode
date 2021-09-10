class Solution {

    public String longestCommonPrefix(String[] strs) {

        Arrays.sort(strs, Comparator.comparingInt(String::length));

        List<Character> chars = new ArrayList<>();
        int commonPrefixIndex = 0;

        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];

            if (i == 0) {
                for (int j = 0; j < str.length(); j++) {
                    chars.add(str.charAt(j));
                }
                commonPrefixIndex = chars.size() - 1;
            } else {
                for (int j = 0; j <= commonPrefixIndex; j++) {
                    if (str.charAt(j) != chars.get(j)) {
                        commonPrefixIndex = j - 1;
                        break;
                    }
                }

            }
        }

        List<Character> output = chars.subList(0, commonPrefixIndex + 1);

        return output.stream().map(String::valueOf).collect(Collectors.joining());
    }
}