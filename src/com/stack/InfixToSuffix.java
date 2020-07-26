package com.stack;

import java.util.*;
import java.util.Stack;

public class InfixToSuffix {

    private static final Map<Character,Integer> PRIORITY_MAP = new HashMap<>();
    private static final String OPERATOR = "*/+-()";
    
    static{
        PRIORITY_MAP.put('-', 1);
        PRIORITY_MAP.put('+', 1);
        PRIORITY_MAP.put('*', 2);
        PRIORITY_MAP.put('/', 2);
        PRIORITY_MAP.put('(', 0);
    }

    // 中缀表达式转换成后缀表达式
    private String toSuffix(String infix){
        List<String> suffix = new LinkedList<>();
        Stack<Character> stack = new Stack<>();
        
        // 用于记录字符长度  例如100*2,则记录的len为3 到时候截取字符串的前三位就是数字
        int len = 0;
        for(int i = 0; i < infix.length(); i++){
            char ch = infix.charAt(i);
            
            // 数字
            if (Character.isDigit(ch) || ch == '.') {
                len++;
            } else if (OPERATOR.indexOf(ch) != -1) {
                // 符号之前的可以截取下来做数字
                if (len > 0) {
                    suffix.add(infix.substring(i-len, i));
                    len = 0;
                }
                // 将左括号放入栈中
                if (ch == '(') {
                    stack.push(ch);
                    continue;
                }
                if (!stack.isEmpty()) {
                    int size = stack.size() - 1;
                    boolean flag = false;
                    
                    // 若当前ch为右括号，则栈里元素从栈顶一直弹出，直到弹出到左括号
                    while(size >= 0 && ch == ')' && stack.peek() != '('){
                        suffix.add(String.valueOf(stack.pop()));
                        size--;
                        flag = true;
                    }
                    
                    // 若取得不是（）内的元素，并且当前栈顶元素的优先级>=对比元素 那就出栈插入队列
                    while(size >= 0 && !flag && PRIORITY_MAP.get(stack.peek()) >= PRIORITY_MAP.get(ch)){
                        suffix.add(String.valueOf(stack.pop()));
                        size--;
                    }
                }
                
                if (ch != ')') {
                    stack.push(ch);
                }else {
                    stack.pop();
                }
            } 
            // 如果已经走到了中缀表达式的最后一位
            if (i == infix.length() - 1) {
                if (len > 0) {
                    suffix.add(infix.substring(i - len + 1, i + 1));
                }
                
                int size = stack.size() - 1;
                // 一直将栈内 符号全部出栈并且加入队列中
                while(size >= 0) {
                    suffix.add(String.valueOf(stack.pop()));
                    size--;
                }
            }
        }
        return suffix.toString().substring(1, suffix.toString().length()-1);
    }

    // 根据后缀表达式计算结果
    private String calculate(String suffix){
        String [] arr = suffix.split(",");
        Stack<String> stack = new Stack<>();
        
        for (int i = 0; i < arr.length; i++) {
            switch (arr[i].trim()) {
            case "+": 
                double a = Double.parseDouble(stack.pop()) + Double.parseDouble(stack.pop());
                stack.push(String.valueOf(a));
                break;
            case "-": 
                double b = Double.parseDouble(stack.pop()) - Double.parseDouble(stack.pop());
                stack.push(String.valueOf(-b));
                break;
            case "*": 
                double c = Double.parseDouble(stack.pop()) * Double.parseDouble(stack.pop());
                stack.push(String.valueOf(c));
                break;
            case "/": 
                double d = Double.parseDouble(stack.pop()) / Double.parseDouble(stack.pop());
                stack.push(String.valueOf(d));
                break;
            default:
                stack.push(arr[i].trim());
                break;
            }
        }
        
        return stack.size() == 1 ? stack.pop() : "运算失败";
    }

    /**
     * 程序入口
     *
     * @param infix 中缀表达式
     * @return 计算结果
     */
    public String run(String infix) {
        String suffix = toSuffix(infix);
        return calculate(suffix);
    }

    public static void main(String[] args) {
        InfixToSuffix test = new InfixToSuffix();
        String result = test.run("20+5*(3-1)+9");
        System.out.println(result);
    }
}
