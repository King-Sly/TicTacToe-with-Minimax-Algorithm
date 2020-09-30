package PersonalProjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/** An abstract base class providing some functionality of the Tree interface. */
 public abstract class AbstractTree<E> implements Tree<E> {

     public boolean isInternal(Position<E> p) {
         return numChildren(p) > 0;
     }

     public boolean isExternal(Position<E> p) {
         return numChildren(p) == 0;
     }
     public boolean isRoot(Position<E> p) {
         return p == root( );
     }
     public boolean isEmpty() {
         return size() == 0;
     }

    /** Adds positions of the subtree rooted at Position p to the given snapshot. */
    private void preorderSubtree(Position<E> p, List<Position<E>> snapshot) {
        snapshot.add(p); // for preorder, we add position p before exploring subtrees
        for (Position<E> c : children(p))
            preorderSubtree(c, snapshot);
    }

    /** Returns an iterable collection of positions of the tree, reported in preorder. */
    public Iterable<Position<E>> preorder() {
        List<Position<E>> snapshot = new ArrayList<>( );
        if (!isEmpty())
            preorderSubtree(root(), snapshot); // fill the snapshot recursively
        return snapshot;
    }

    /** Adds positions of the subtree rooted at Position p to the given snapshot. */
    private void postOrderSubtree(Position<E> p, List<Position<E>> snapshot) {
        for (Position<E> c : children(p))
            preorderSubtree(c, snapshot);
        snapshot.add(p); // for postOrder, we add position p before exploring subtrees
    }

    /** Returns an iterable collection of positions of the tree, reported in preorder. */
    public Iterable<Position<E>> postOrder() {
        List<Position<E>> snapshot = new ArrayList<>( );
        if (!isEmpty( ))
            preorderSubtree(root(), snapshot); // fill the snapshot recursively
        return snapshot;
    }



    /** Returns an iterable collection of positions of the tree in breadth-first order. */
    public Iterable<Position<E>> breadthFirst() {
        List<Position<E>> snapshot = new ArrayList<>( );

        if (!isEmpty()) {
            LinkedQueue<Position<E>> fringe = new LinkedQueue<>();

            fringe.enqueue(root()); // start with the root

            while (!fringe.isEmpty()) {
                Position<E> p = fringe.dequeue( ); // remove from front of the queue
                snapshot.add(p); // report this position
                for (Position<E> c : children(p))
                    fringe.enqueue(c); // add children to back of queue
            }
        }
        return snapshot;
    }



}
