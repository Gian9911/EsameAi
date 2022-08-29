package com.company;

public class MapColoringNode extends Node {

    MapColoringNode(Object data) {
        super(data);
        this.getValues().add("red");
        this.getValues().add("green");
        this.getValues().add("bleu");
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

    public String getAssignment() {
        return assignment;
    }
    public void setAssignment(String assignment) {
        this.assignment = assignment;
    }
}
