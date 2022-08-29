package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {

    ArrayList<LinkedList<Node>> alist;
    ArrayList<Integer> exploringnodes = new ArrayList<>();


    List<Node> cycleSet;
    ArrayList<String> domain;
    ArrayList<LinkedList<Node>> topological;

    Graph(ArrayList<String> list) {
        alist = new ArrayList<>();
        domain = list;
        cycleSet = new ArrayList<>();
        topological = new ArrayList<>();
    }

    public void addNode(Node node) {
        LinkedList<Node> currentList = new LinkedList<>();
        currentList.add(node);
        alist.add(currentList);
    }

    public void addEdge(int src, int dst) {
        LinkedList<Node> currentList = alist.get(src);
        LinkedList<Node> currentList2 = alist.get(dst);
        Node dstNode = alist.get(dst).get(0);
        currentList.add(dstNode);
        Node srcNode = alist.get(src).get(0);
        currentList2.add(srcNode);

    }

    public void cercaNodo() {
        ArrayList<Node> treeNodes = new ArrayList<>();

        for (LinkedList<Node> nodes : alist) {
            if (!nodes.get(0).isCycleset()) {
                nodes.get(0).setExplored(true);
                for (int j = 1; j < nodes.size(); j++) {
                    if (treeNodes.contains(nodes.get(j)) && !nodes.get(j).isExplored()) {
                        System.out.println("nodo padre: " + nodes.get(0).data + " -> " + nodes.get(j).data);
                        nodes.get(j).setCycleset(true);
                        cancellaNodoPerOttenereAlbero(nodes.get(j));
                    } else {
                        treeNodes.add(nodes.get(j));
                    }
                }
            }
        }
    }

    public void cancellaNodoPerOttenereAlbero(Node n) {
        if (!cycleSet.contains(n))
            cycleSet.add(n);
    }

    public void print() {
        for (LinkedList<Node> currentList : alist) {
            for (Node node : currentList) {
                System.out.print(node.data + " - ");
            }
            System.out.println();
        }
    }

    public int getIndexOfNode(Node n) {
        int i = -1;
        for (int t = 0; t < alist.size(); t++) {
            if (alist.get(t).get(0).data == n.data)
                i = t;
        }
        return i;
    }

    public void printCycleset() {
        for (Node node : cycleSet) {
            System.out.println(node.getData() + " " + node.getAssignment());
        }
    }

    public void topologicalSort() {
        int g = -1;
        ArrayList<Node> myNonCycleset = new ArrayList<>();
        for (LinkedList<Node> nodes : alist) {
            if (!nodes.get(0).isCycleset() && nodes.get(0).assignment == null) {
                g++;
                System.out.println(g);
                LinkedList<Node> link = new LinkedList<>();
                topological.add(link);
                topological.get(g).add(nodes.get(0));
                myNonCycleset.add(nodes.get(0));
                for (int j = 1; j < nodes.size(); j++) {
                    if (!nodes.get(j).isCycleset() && nodes.get(j).assignment == null && !myNonCycleset.contains(nodes.get(j))) {
                        topological.get(g).add(nodes.get(j));
                        myNonCycleset.add(nodes.get(j));
                    }
                }
            }
        }
        if (alist.size() > 0)
        printTopological();
    }

    public void printTopological() {
        System.out.println("topological sort ");
        for (LinkedList<Node> currentList : topological) {
            if (currentList.size() > 1) {
                for (Node node : currentList) {
                    System.out.print(node.data + " - ");
                }
                System.out.println();
            }
        }
    }

    public boolean solveCycleGraph(int i, int j, int v) {
        return true;
    }

    public boolean allAssign() {
        boolean flag = true;
        for (LinkedList<Node> nodes : alist)
            if (nodes.get(0).possibleAssignement == null && nodes.get(0).isCycleset()) {
                flag = false;
                break;
            }
        return flag;
    }

    public void propagate(int i) {
        System.out.println("voglio propagare il nodo: " + alist.get(i).get(0).getData());
        for (int j = 1; j < alist.get(i).size(); j++) {
            if (alist.get(i).get(0).possibleAssignement != null) {
                alist.get(i).get(j).getValues().remove(alist.get(i).get(0).possibleAssignement);

            } else if (alist.get(i).get(0).assignment != null)
                alist.get(i).get(j).getValues().remove(alist.get(i).get(0).assignment);
        }
        alist.get(i).get(0).printDomain();
    }

    public void consequences(int i) {
        for (int j = 1; j < alist.get(i).size(); j++) {
            if (alist.get(i).get(j).assignment != null)
                ;
            else if ((alist.get(i).get(j)).possibleAssignement != null)
                ;
            else if (alist.get(i).get(j).getValues().size() == 1 && (alist.get(i).get(j).possibleAssignement == null && alist.get(i).get(j).assignment != null)) {
                alist.get(i).get(j).possibleAssignement = alist.get(i).get(j).getValues().get(0);
                alist.get(i).get(j).setConsequences(exploringnodes.size() - 1);
                System.out.println("trovata conseguenze -> nodo: " + alist.get(i).get(j).getData() + " value: " + alist.get(i).get(j).possibleAssignement);
                propagate(getIndexOfNode(alist.get(i).get(j)));
            }
        }
    }

    public boolean controlAllElements () {
        for (int i = 0; i < alist.size(); i++) {
            if (alist.get(i).get(0).getValues().size() == 1 && alist.get(i).get(0).possibleAssignement == null &&
                    alist.get(i).get(0).assignment == null) {
                alist.get(i).get(0).setConsequences(exploringnodes.size() - 1);
                alist.get(i).get(0).printDomain();
                alist.get(i).get(0).possibleAssignement = alist.get(i).get(0).getValues().get(0);
                propagate(i);
                System.out.println("ho trovato il nodo " + alist.get(i).get(0).getData() +
                        " e gli ho dato l'unico valore disponibile: " +
                        alist.get(i).get(0).possibleAssignement);
            }
            if (alist.get(i).get(0).getValues().size() == 0) {
                System.out.println("è presente elemento con dominio vuoto: " + alist.get(i).get(0).getData());
                ripristino(exploringnodes.get(exploringnodes.size() - 1));
                return false;
            }
        }
        return true;
    }

    public void ripristino ( int pos){
        System.out.println("devo ripristinare");
        alist.get(pos).get(0).printDomain();
        String v = (String) alist.get(pos).get(0).possibleAssignement;
        alist.get(pos).get(0).getRemovedElement().add(v);
        for (LinkedList<Node> nodes : alist) {
            nodes.get(0).possibleAssignement = null;
            cloneDomain(nodes.get(0));
        }
        beginPropagate();
        alist.get(pos).get(0).removeMyNonValidElement();
        solveCycleGraph(0, 0, 0);
    }

    public void beginPropagate(){
        for (int i = 0; i < alist.size();i++){
            if (alist.get(i).get(0).assignment!=null)
                propagate(i);
        }
    }

    private void cloneDomain(Node node) {
        for (Object t : domain) {
            if (!node.getValues().contains(t)) {
                node.getValues().add(String.valueOf(t));
            }
        }
    }

    public void solveTree(){
        for (java.util.LinkedList<Node> nodes : topological) {
            if (nodes.get(0).possibleAssignement==null){
                nodes.get(0).possibleAssignement = nodes.get(0).getValues().get(0);
                propagate(getIndexOfNode(nodes.get(0)));
                consequences(getIndexOfNode(nodes.get(0)));
                controlAllElements();
            }
        }
    }

    public void niente(){
        System.out.println("Error, problema non risolvibile");
        alist = new ArrayList<>();
        domain = new ArrayList<>();
    }

    public void arcConsistent(){
        for (int i = 0; i < topological.size(); i++){
            if (topological.get(i).size() > 0){
                for (int j = topological.get(i).size()-1; j > 0; j--){
                    for (int value = 0; value < topological.get(i).get(j).getValues().size(); value++){
                        if (topological.get(i).get(0).getValues().contains(topological.get(i).get(j).getValues().get(value))
                                && (topological.get(i).get(0).getValues().size()-1) > 0){
                            System.out.println("ok");
                        }
                        else if (!topological.get(i).get(0).getValues().contains(topological.get(i).get(j).getValues().get(value))
                                && (topological.get(i).get(0).getValues().size()) > 0){
                            System.out.println("ok");
                        }
                        else{
                            System.out.println("no");
                        }

                    }
                }
            }
        }
    }

}
