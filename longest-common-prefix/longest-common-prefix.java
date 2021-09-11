class Solution {

    public String longestCommonPrefix(String[] strs) {

        Arrays.sort(strs, Comparator.comparingInt(String::length));

        List<Character> chars = new ArrayList<>();
        int lastIndexOfCommonPrefix = 0;

        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];

            if (i == 0) {
                for (int j = 0; j < str.length(); j++) {
                    chars.add(str.charAt(j));
                }
                lastIndexOfCommonPrefix = chars.size() - 1;
            } else {
                for (int j = 0; j <= lastIndexOfCommonPrefix; j++) {
                    if (str.charAt(j) != chars.get(j)) {
                        lastIndexOfCommonPrefix = j - 1;
                        break;
                    }
                }
            }
        }

        return chars.subList(0, lastIndexOfCommonPrefix + 1)
                    .stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining());
    }
}