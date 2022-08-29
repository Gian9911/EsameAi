package com.company;

public class SudokuNode extends Node{

    //private final int x;
    //private final int y;

    SudokuNode(Object data, int x, int y) {
        super(data);
        //this.x=x;
        //this.y=y;
        for (int i = 1; i < 10; i++){
            String t = String.valueOf(i);
            this.getValues().add(t);
        }
    }

    @Override
    public boolean consistent(Node child) {
        boolean flag = false;
        child.getValues().remove(this.getAssignment());
        if (child.getValues().size() != 0){
            child.setAssignment(child.getValues().get(0));
            System.out.println("yes");
            flag = true;
        }
        return flag;
    }

    public String getAssignment() {return assignment;}
    public void setAssignment(String assignment) {this.assignment = assignment;}
}
