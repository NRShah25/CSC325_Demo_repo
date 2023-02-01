

package list.csc229_hw5;

/**
 *
 * @author nicholasshah
 */
public class CSC229_HW5 {

    public static void main(String[] args) {
       Purchase p1 = new Purchase("Onion",2.0,2.0);
       Purchase p2 = new Purchase("Carrot",6.0,3.0);
       Purchase p3 = new Purchase("Cabbage",1.0,5.0);
       Purchase p4 = new Purchase("Steak",12.0,16.0);
       Purchase p5 = new Purchase("Radish",2.0,2.0);
       
       PurchaseBinarySearchTree b1 = new PurchaseBinarySearchTree();
       b1.add(p1);
       b1.add(p2);
       b1.add(p3);
       b1.add(p4);
       b1.add(p5);
       
       b1.preorder();
        System.out.println(b1.totalCostUsingRecursion());
        System.out.println(b1.getPurchase("Onion"));
        System.out.println(b1.getPurchase("Steak"));
        System.out.println(b1.getLength());

        


    PurchaseBinarySearchTree b2 = new PurchaseBinarySearchTree(b1);
        System.out.println(b2.totalCostUsingRecursion());
        b2.preorder();
         System.out.println(b2.getPurchase("Steak"));
         
         PurchaseBinarySearchTree b3 = b2.makeCopy();
         b3.preorder();
         System.out.println(b3.getPurchase("Steak"));
         System.out.println(b3.equals(b2));
         


    }
}
