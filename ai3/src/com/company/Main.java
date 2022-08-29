package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here


        ArrayList<String> numbers = new ArrayList<>();
        for(int i = 1; i < 10; i++){
            numbers.add(String.valueOf(i));
        }
        Sudoku sudoku = new Sudoku(numbers,"");
        sudoku.controlAllElements();
        sudoku.cercaNodo();
        sudoku.solveCycleGraph(0,0,0);
        sudoku.topologicalSort();
        sudoku.arcConsistent();
        sudoku.solveTree();
        sudoku.printSudoku();


        /*Sudoku sudoku1 = new Sudoku(numbers,0);
        sudoku1.controlAllElements();
        sudoku1.cercaNodo();
        sudoku1.solveCycleGraph(0,0,0);
        sudoku1.topologicalSort();
        sudoku.arcConsistent();
        sudoku.solveTree();
        sudoku.printSudoku();
        /*
         */




        /*ArrayList<String> color = new ArrayList<>();
        color.add("red");
        color.add("green");
        color.add("bleu");
        MapColoring graph = new MapColoring(color);
        graph1.addNode(new MapColoringNode('A'));//0
        graph1.addNode(new MapColoringNode('B'));//1
        graph1.addNode(new MapColoringNode('C'));//2
        graph1.addNode(new MapColoringNode('D'));//3
        graph1.addNode(new MapColoringNode('E'));//4
        graph1.addNode(new MapColoringNode('F'));//5
        graph1.addNode(new MapColoringNode('G'));//6
        graph1.addNode(new MapColoringNode('I'));//7
        graph1.addNode(new MapColoringNode('L'));//8
        graph1.addNode(new MapColoringNode('H'));//9


        graph1.addEdge(0,1);//AB
        graph1.addEdge(0,2);//AC
        graph1.addEdge(0,6);//AG
        graph1.addEdge(1,3);//BD
        graph1.addEdge(1,5);//BF
        graph1.addEdge(2,9);//CH
        graph1.addEdge(2,4);//CE
        graph1.addEdge(3,4);//DE
        graph.addEdge(3,7);//DI
        graph1.addEdge(4,8);//EL
        graph1.addEdge(5,8);//FH
        graph1.addEdge(5,9);//FL
        graph1.addEdge(6,7);//GI
        graph1.addEdge(6,8);//GL
        graph1.addEdge(9,7);//HI

        graph1.print();
        graph1.cercaNodo();
        graph1.solveCycleGraph(0,0,0);
        graph1.topologicalSort();
        graph1.arcCOnsistent();
        graph1.solveTree();
        graph1.printMapColoring();*/
        /*


        ArrayList<String> color = new ArrayList<>();
        color.add("red");
        color.add("green");
        color.add("bleu");
        MapColoring graph = new MapColoring(color);
        graph.addNode(new MapColoringNode('W'));//0
        graph.addNode(new MapColoringNode('N'));//1
        graph.addNode(new MapColoringNode('S'));//2
        graph.addNode(new MapColoringNode('Q'));//3
        graph.addNode(new MapColoringNode('P'));//4
        graph.addNode(new MapColoringNode('V'));//5
        graph.addNode(new MapColoringNode('T'));//6


        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(1,3);
        graph.addEdge(2,4);
        graph.addEdge(3,4);
        graph.addEdge(2,5);
        graph.addEdge(4,5);

        graph.print();
        graph.cercaNodo();
        graph.solveCycleGraph(0,0,0);
        graph.topologicalSort();
        graph.arcConsistent();
        graph.solveTree();
        graph.printMapColoring();*/





    }
}
