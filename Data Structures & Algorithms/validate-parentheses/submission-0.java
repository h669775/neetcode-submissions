class Solution {
    public boolean isValid(String s) {
        Stack<Character> brackets = new Stack<>();

        Map<Character, Character> closeToOpen = new HashMap<>();
        closeToOpen.put(')', '(');
        closeToOpen.put('}', '{');
        closeToOpen.put(']', '[');

        for (char c : s.toCharArray()) {
            if (closeToOpen.containsKey(c)) {

                if (!brackets.isEmpty() && brackets.peek() == closeToOpen.get(c)) {
                    brackets.pop();
                } else {
                    return false;
                }
            } else {
                brackets.push(c);
            }
        }

        return brackets.isEmpty();

    }
}
