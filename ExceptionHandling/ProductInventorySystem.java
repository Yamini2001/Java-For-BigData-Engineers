
package ExceptionHandling;

class ProductInventory {

    String[] productname = {
        "Biscuits", "Namkeen", "Ghee", "Sugar"
    };

    public void displayProduct(int i) {

        try {

            System.out.println("Product name: " + productname[i]);

        }

        catch(ArrayIndexOutOfBoundsException e) {

            System.out.println("Array out of bound: "
                               + e.getMessage());

        }

    }

}

public class ProductInventorySystem {

    public static void main(String[] args) {

        ProductInventory p = new ProductInventory();

        p.displayProduct(2);

    }

}
