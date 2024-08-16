class Solution {
    public String addBinary(String a, String b) {
        StringBuilder str = new StringBuilder();

        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0;

        while(i >= 0 || j >= 0 || carry == 1){
            if(i >= 0){
                carry += a.charAt(i--) - '0';
            }
            if(j >= 0){
                carry += b.charAt(j--) - '0';
            }

            str.append(carry % 2);
            carry = carry/2;
        }

        return str.reverse().toString();
    }
}