/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 吉彬
 */
import java.util.Stack;

public class Solution {
    private int min_num;//记录压栈时最小值
    private Stack<Integer> data_stack = new Stack<Integer>();//数据栈
    private Stack<Integer> aux_stack = new Stack<Integer>();//辅助栈
    public static void main(String[] args){
        
    }
    /*
    问题：
    定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
    */
    
    /*
    解决思路：
    定义两个栈，一个数据栈，一个辅助栈。
    数据栈为空时向数据栈压栈，那么当前要压入的元素就可认为是最小值，
    用变量min_num记住，并把它压入辅助栈，无论出栈还是入栈都要保持min_num与最小值关联；
    在以后入栈操作时，小于等于min_num的元素入数据栈时也要入辅助栈，大于min_num的元素只入数据栈即可。
    出栈时先判断数据栈栈顶元素是否与辅助栈栈顶元素相同，若相同则数据栈与辅助栈都要进行出栈操作；若不相同则仅数据栈出栈即可。获取最小值从辅助栈中即可获取到。
    */
    public void push(int node) {
        if(data_stack.empty()){
            min_num = node;
            data_stack.push(min_num);
            aux_stack.push(min_num);
        }
        else{
            if(min_num>=node){
                min_num = node;
                data_stack.push(min_num);
                aux_stack.push(min_num);
            }
            else
                data_stack.push(node);
        }
    }
    
    public void pop() {
        if(data_stack.empty())
            throw new RuntimeException("栈为空！");
        if(data_stack.pop()==aux_stack.peek())
            aux_stack.pop();
        if(!aux_stack.empty())//始终让min_num与最小值关联
            min_num = aux_stack.peek();
    }
    
    public int top() {
        if(data_stack.empty())
            throw new RuntimeException("栈为空！");
        return data_stack.peek();
    }
    
    public int min() {
        if(data_stack.empty())
            throw new RuntimeException("栈为空！");
        return aux_stack.peek();
    }
}
