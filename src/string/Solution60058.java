package string;

class Solution60058 {
    public String solution(String p) {
        String answer = "";
        answer = solve(p);

        return answer;
    }

    public String solve(String str) {
        if(isCorrect(str)||str.isEmpty())
            return str;
        StringBuilder sb = new StringBuilder();
        String[] uv = getUV(str);
        if (isCorrect(uv[0])) {
            sb.append(uv[0]);
            sb.append(solve(uv[1]));
        } else {
            sb.append('(');
            sb.append(solve(uv[1]));
            sb.append(')');
            char[] cs = uv[0].substring(1, uv[0].length() - 1).toCharArray();
            for (char c : cs) {
                if(c==')') sb.append('(');
                else sb.append(')');
            }
        }

        return sb.toString();
    }

    public String[] getUV(String str) {
        String[] result = new String[2];
        char[] arr = str.toCharArray();
        int len = str.length();

        for (int j = 1; j <= len; j++) {
            String s1 = str.substring(0, j);
            if(!isBalanced(s1)) continue;
            result[0] = s1;
            result[1] = "";
            if(j<len) result[1] = str.substring(j);
            break;
        }

        System.out.println("str = " + str);
        System.out.printf("%s - %s\n", result[0], result[1]);
        return result;
    }

    public boolean isBalanced(String str) {
        int r1 = 0, r2 = 0;
        int len = str.length();
        char[] arr = str.toCharArray();

        for (int i = 0; i < len; i++) {
            if(arr[i]=='(') r1++;
            else r2++;
        }

        return r1 == r2;
    }

    public boolean isCorrect(String str) {
        int count = 0;
        int len = str.length();
        char[] arr = str.toCharArray();

        for (int i = 0; i < len; i++) {
            if(arr[i]=='(') count++;
            else if(count>0) count--;
            else return false;
        }

        return count == 0;
    }
}