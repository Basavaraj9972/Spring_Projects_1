 class ReversewithoutConsiderSpecioalChar {

    public static void main(String[] args) {

        String input  = "asd#dfg%$";
        int i = 0, j = input.length() - 1;
        char[] ch = input.toCharArray();
        
        while (i < j) {
            if (Character.isLetterOrDigit(ch[i]) && Character.isLetterOrDigit(ch[j])) {
                // Swap the characters
                char temp = ch[i];
                ch[i] = ch[j];
                ch[j] = temp;
                i++;
                j--;
            } else if (!Character.isLetterOrDigit(ch[i]) && Character.isLetterOrDigit(ch[j])) {
                // Move forward if the start character is a special character
                i++;
            } else if (Character.isLetterOrDigit(ch[i]) && !Character.isLetterOrDigit(ch[j])) {
                // Move backward if the end character is a special character
                j--;
            }
            else {
            	i++;
            	j--;
            }
        }
        
        // Convert character array back to string
        String output = new String(ch);
        System.out.println(output);
    }
}
