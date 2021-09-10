class Solution {

    private final Map<Character, Integer> map = new HashMap<>();

    {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public int romanToInt(String input) {

        int output = 0;

        char beforeRoman = ' ';

        for (int i = 0; i < input.length(); i++) {
            char roman = input.charAt(i);
            output += map.get(roman);

            if ( ((roman == 'V' || roman == 'X') && beforeRoman == 'I')
              || ((roman == 'L' || roman == 'C') && beforeRoman == 'X')
              || ((roman == 'D' || roman == 'M') && beforeRoman == 'C') ) {
                output -= map.get(beforeRoman) * 2;
            }

            beforeRoman = roman;
        }

        return output;
    }
}