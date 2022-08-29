package com.company;

import java.util.ArrayList;

public abstract class Node {

    Object data;
    boolean cycleset = false;
    boolean explored = false;
    ArrayList<String> values;
    String assignment;
    Object possibleAssignement;
    int consequences;
    ArrayList<Object> removedElement = new ArrayList<>();


    Node(Object data){
        values = new ArrayList<>();
        this.data = data;
    }

    public boolean isCycleset() {
        return cycleset;
    }
    public void setConsequences(int consequences) {this.consequences = consequences;}
    public void setCycleset(boolean cycleset) {
        this.cycleset = cycleset;
    }
    public boolean isExplored() {
        return explored;
    }
    public void setExplored(boolean explored) {
        this.explored = explored;
    }
    public abstract boolean consistent(Node child);
    public Object getData() {return data;}
    public ArrayList<String> getValues() {return values;}
    public String getAssignment() {return assignment;}
    public void setAssignment(String assignment) {this.assignment = assignment;}

    public void printDomain(){
        System.out.print("var "+this.getData()+": ");
        for (int i = 0; i < this.getValues().size();i++){
            System.out.print(" "+this.getValues().get(i));
        }
        System.out.println();
    }

    public ArrayList<Object> getRemovedElement() {return removedElement;}

    public void removeMyNonValidElement(){
       printDomain();

        for (Object m : removedElement) {
            System.out.println(m);
            values.remove(m);
        }
        printDomain();
    }
}
