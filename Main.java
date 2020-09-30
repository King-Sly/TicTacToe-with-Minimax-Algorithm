package PersonalProjects;


import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        LinkedBinaryTree<String> binaryTree = new LinkedBinaryTree<>();
        Position<String> a = binaryTree.addRoot("Sales");
        Position<String> b =  binaryTree.addLeft( a ,"Domestic");
        Position<String> c = binaryTree.addRight(a, "International");
        Position<String> d = binaryTree.addLeft(c, "Canada");
        Position<String> e = binaryTree.addRight(c, "Overseas");

        Iterable<Position<String>> iterable = binaryTree.positions();
        for (Position<String> p: iterable) {
            System.out.println("[ " + p.getElement() + " ]");
        }

        TicTac tt = new TicTac();
        tt.genBoards();
        tt.printResults();

    }
}
