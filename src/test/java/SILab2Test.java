import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {


    Item A = new Item(null, "24892725", 25, 0);
    Item D = new Item("Cake","04914851", 450, 0.25f);
    Item B = new Item("Fanta","1LSFJNM2", 12, 0.1f);

    Item C = new Item("Doritos", null, 15, 0);

    Item F= new Item(	"Snack",	"24892725",	25,	0);
    Item G= new Item(	"Cake",	"04914851",	450,	0.25f);
    Item H= new Item(	"Cheese",	"58589158",	350,	0);
    Item I= new Item(	"Ball",	"84014857",	500,	0.1f);

    List<Item> blist = new ArrayList<>();
    List<Item> clist = new ArrayList<>();

    List<Item> adlist = new ArrayList<>();

    List<Item> multiple_condicion_list = new ArrayList<>();




    @Test
    void checkCart_EveryBranch() {
        RuntimeException ex;

        ex = assertThrows(RuntimeException.class, () -> SILab2.checkCart(null,0));
        assertEquals("allItems list can't be null!", ex.getMessage());


        clist.add(C);

       ex = assertThrows(RuntimeException.class, () -> SILab2.checkCart(clist,0));
       assertEquals("No barcode!", ex.getMessage());

        blist.add(B);

        ex = assertThrows(RuntimeException.class, () -> SILab2.checkCart(blist,0));
        assertEquals("Invalid character in item barcode!", ex.getMessage());

        adlist.add(A);
        adlist.add(D);

        assertTrue(SILab2.checkCart(adlist, 800));

        assertFalse(SILab2.checkCart(adlist, 100));


    }

    @Test
    void checkCart_multiple_condition(){

        multiple_condicion_list.add(F);
        multiple_condicion_list.add(G);
        multiple_condicion_list.add(H);
        multiple_condicion_list.add(I);

        //expected sum 507.5, Tri pati False, Ednas true so site mozni nacini.


        assertTrue(SILab2.checkCart(multiple_condicion_list, 508));

        assertFalse(SILab2.checkCart(multiple_condicion_list, 507));


    }

}