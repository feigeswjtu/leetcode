package code71;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 简化路径
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    private char SLASH = '/';
    private char POINT = '.';

    private String CURRENT_POINT = ".";
    private String LAST_POINT = "..";

    public String simplifyPath(String path) {
        StringBuilder stringBuilder = new StringBuilder();
        Deque<String> deque = buildDeque(path);

        if (deque.isEmpty()) {
            return "/";
        }

        while (!deque.isEmpty()) {
            String s = deque.pollLast();
            stringBuilder.append(s);
        }

        return stringBuilder.toString();
    }

    private Deque<String> buildDeque(String path) {
        Deque<String> deque = new ArrayDeque<>();
        StringBuilder stringBuilder = new StringBuilder();
        char currentChar = path.charAt(0);
        stringBuilder.append(currentChar);

        for (int i = 1; i < path.length(); i++) {
            char c = path.charAt(i);
            if (currentChar == SLASH) {
                if (c == currentChar) {
                    continue;
                } else {
                    pushDeque(deque, stringBuilder.toString());
                    stringBuilder = new StringBuilder();
                    currentChar = c;
                    stringBuilder.append(currentChar);

                }

            } else if (currentChar == POINT) {
                if (c == SLASH) {
                    pushDeque(deque, stringBuilder.toString());
                    stringBuilder = new StringBuilder();
                    currentChar = c;
                    stringBuilder.append(currentChar);

                } else {
                    stringBuilder.append(c);

                }

            } else {
                if (c == SLASH) {
                    pushDeque(deque, stringBuilder.toString());
                    stringBuilder = new StringBuilder();
                    currentChar = c;
                    stringBuilder.append(currentChar);
                } else {
                    stringBuilder.append(c);
                }
            }

        }

        if (stringBuilder.length() > 0) {
            pushDeque(deque, stringBuilder.toString());
        }

        if (deque.peek().equals("/")) {
            deque.pop();
        }

        return deque;
    }

    private void pushDeque(Deque<String> deque, String currentPath) {
        if (currentPath.charAt(0) == SLASH) {
            String peek = deque.peek();
            if (peek == null || peek.charAt(0) != SLASH) {
                deque.push(currentPath);
            }
        } else if (currentPath.equals(CURRENT_POINT)) {

        } else if (currentPath.equals(LAST_POINT)) {
            if (!deque.isEmpty()) {
                deque.pop();
            }
            if (!deque.isEmpty()) {
                deque.pop();
            }
            if (deque.isEmpty()) {
                deque.push("/");
            }
        } else {
            deque.push(currentPath);
        }

    }
}
