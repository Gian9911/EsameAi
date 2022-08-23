# EsameAi
Il seguente programma vede l'uso del cutset conditioning per risolvere istanze di problemi di csp, nello specifico 2 istanze di sudoku e 2 istanze di map coloring.
Nella repository sono presenti 7 file .java:
- Main: Contiente al suo interno le due istanze di map coloring scelte e invoca i metodi necessari per l'esecuzione del programma (non vengono costruite in questo file le istanze dei sudoku ma viene fatto dei costruttori della classe Sudoku).
- Graph: La classe contiene i metodi che servono per applicare cutset conditioning: ricerca dei nodi del cycleset, topological sort, assegnamento valori dell'albero, ecc... COntiene anche attributi utili alla collezione dell'albero risultato del topological sort, per collezionare i cycleset.
- MapColoring: Estende Graph, contiene un metodo per stampare in maniera efficiente il risultato.
- Sudoku: Estende Graph, contiene metodo per stampare in maniera chiara il risultato, 2 costruttori per implementare le due istanze del problema e un metodo addEdge per creare i vari vincoli presenti nel problema.
- Node: classe astratta, contiene mentodi e attributi per trovare e identificare i cycleset, l'insieme di valori ammissibili per quella variabile e altro...
- SudokuNode & MapColoringNode: estendono Node.

Le istanze dei quattro problemi sono già presenti nel file main, inseieme alle chaimate ai metodi necessarie, per cui basta solo lanciare il programma.
La sequenza di operazioni per replicare i risultati è la seguente:
1) Definire un ArrayList e inserirvi i valori del dominio.
2) Aggiungere le variabili desiderate
3) Istanziare un oggetto della classe a scelta tra: Sudoku e MapColoring
3.5) Se si fosse scelto MapColoring aggiungere anche i vincoli tramite il metodo addEdge()
Nota: addEdge() richiede un parametro int. Quindi si deve tener contro del valore associato a ciascun delle variabili istanziate: La prima che è stata inserita sarà la numero 0, la seconda la numero 1 ecc...
4)Usare il metodo cercaNodo per trovare i cycleset.
5)Invocare il metodo solveCycleGraph.
6)Invocare topologicalSort().
7)Invocare solveTree().
8)Stampare la soluzione a schermo: si può usare printSudoku() per l'istanza di sudoku o printMapColoring per l'istanza di Map Coloring
