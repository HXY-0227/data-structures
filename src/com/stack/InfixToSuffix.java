package com.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InfixToSuffix {

    private static final Map<Character,Integer> basis = new HashMap<>();
    
    static{
        basis.put('-', 1);
        basis.put('+', 1);
        basis.put('*', 2);
        basis.put('/', 2);
        basis.put('(', 0);
    }

    /**
     * 中缀表达式转换成后缀表达式
     * @param infix
     * @return
     */
    public String toSuffix(String infix){
        
        //存储数字以及最后的后缀表达式
        List<String> queue = new ArrayList<>();
        //存储运算符，最后stack会被弹空
        List<Character> stack = new ArrayList<>();
        
        //字符数组  用于拆分数字或符号
        char[] charArr = infix.trim().toCharArray();
        String standard = "*/+-()";
        char ch = '$';
        
        //用于记录字符长度  例如100*2,则记录的len为3 到时候截取字符串的前三位就是数字
        int len = 0;
        
        for(int i = 0; i < charArr.length; i++){
            ch = charArr[i];
            
            //数字
            if (Character.isDigit(ch)) {
                len++;
            }else if (ch == '.') {
                len++;
                
            //若为空格 代表 一段结束
            }else if (Character.isSpace(ch)) {
                if (len > 0) {
                    //往队列存入截取的 字符串
                    queue.add(String.valueOf(Arrays.copyOfRange(charArr, i-len, i)));
                    //长度置空
                    len = 0;
                }
                continue;
            //"*/+-()"中的一个
            }else if (standard.indexOf(ch) != -1) {
                //符号之前的可以截取下来做数字
                if (len > 0) {
                    queue.add(String.valueOf(Arrays.copyOfRange(charArr, i-len, i)));
                    len = 0;
                }
                //将左括号 放入栈中
                if (ch == '(') {
                    stack.add(ch);
                    continue;
                }
                if (!stack.isEmpty()) {
                    int size = stack.size() - 1;
                    boolean flag = false;
                    
                    //若当前ch为右括号，则栈里元素从栈顶一直弹出，直到弹出到左括号
                    while(size >= 0 && ch == ')' && stack.get(size) != '('){
                        queue.add(String.valueOf(stack.remove(size)));
                        size--;
                        flag = true;
                    }
                    
                    //若取得不是（）内的元素，并且当前栈顶元素的优先级>=对比元素 那就出栈插入队列
                    while(size >= 0 && !flag && basis.get(stack.get(size)) >= basis.get(ch)){
                        queue.add(String.valueOf(stack.remove(size)));
                        size--;
                    }
                }
                
                if (ch != ')') {
                    stack.add(ch);
                }else {
                    stack.remove(stack.size() - 1);
                }
            } 
            //如果已经走到了中缀表达式的最后一位
            if (i == charArr.length - 1) {
                if (len > 0) {
                    queue.add(String.valueOf(Arrays.copyOfRange(charArr, i - len + 1, i + 1)));
                }
                
                int size = stack.size() - 1;
                //一直将栈内 符号全部出栈并且加入队列中
                while(size >= 0) {
                    queue.add(String.valueOf(stack.remove(size)));
                    size--;
                }
            }
        }
        return queue.toString().substring(1, queue.toString().length()-1);
    }

    /**
     * 将后缀表达式进行运算计算出结果
     * @param equation
     * @return
     */
    public String dealEquation(String equation){
        final String ADD = "*";
        String [] arr = equation.split(",");
        List<String> list = new ArrayList<String>(); 
        
        for (int i = 0; i < arr.length; i++) {
            int size = list.size();
            switch (arr[i].trim()) {
            case "+": 
                double a = Double.parseDouble(list.remove(size-2))+ Double.parseDouble(list.remove(size-2)); list.add(String.valueOf(a));
                break;
            case "-": 
                double b = Double.parseDouble(list.remove(size-2))- Double.parseDouble(list.remove(size-2)); list.add(String.valueOf(b));
                break;
            case "*": 
                double c = Double.parseDouble(list.remove(size-2))* Double.parseDouble(list.remove(size-2)); list.add(String.valueOf(c));
                break;
            case "/": 
                double d = Double.parseDouble(list.remove(size-2))/ Double.parseDouble(list.remove(size-2)); list.add(String.valueOf(d));
                break;
            default: list.add(arr[i].trim());     
                break;
            }
        }
        
        return list.size() == 1 ? list.get(0) : "运算失败" ;
    }
    
    public static void main(String[] args) {
        InfixToSuffix test = new InfixToSuffix();
        String str = test.toSuffix("20+4*8+(5+3*8)-7");
        System.out.println(str);
        String result = test.dealEquation(str);
        System.out.println(result);
    }
}
