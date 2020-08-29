package ap;
import org.testng.annotations.*;
import static org.testng.Assert.*;

public class PostOfficeTest {
    private List<Product> products_unique0 = new List<Product>();
    private List<Product> products_unique1 = new List<Product>();
    private List<Product> products_unique2 = new List<Product>();
    private List<Product> products_unique3 = new List<Product>();
    private List<Product> products_unique4 = new List<Product>();
    private List<Product> products_unique7 = new List<Product>();
    private List<Product> products_unique7b = new List<Product>();
    private Product product1 =  new Product("p1","produto",5,5);
    private Product product2 =  new Product("p2","produto",10,10);
    private Product product3 =  new Product("p3","produto",15,15);
    private Product product4 =  new Product("p4","produto",15,15);
    private Product product7 =  new Product("p7","produto",40,40);

    @BeforeMethod
    private void setUp(){
        product1.store(1);
        products_unique1.add(product1);

        product2.store(2);
        products_unique2.add(product2);

        product3.stor(3);
        products_unique3.add(product3);

        product4.store(4);
        products_unique4.add(product4);

        product7.store(8);
        products_unique7.add(product7);
        products_unique7.add(product2);

        products_unique7b.add(product7);
        products_unique7b.add(product1);

    }

    //TC1 (2,1,5,1,T)
    @Test()
    public void test1aProductsMaxEquals2(){
        //Arrange
        PostOffice po = new PostOffice(2,products_unique1);
        
        //Assert
        assertEquals(po.getProducts().size(), 1);
        assertEquals(po.getMaxNumberOfProducts(), 2);
        assertEquals(po.getNumberOfProducts(), 1);
    }

    //TC1 (2,1,5,1,T)
    @Test()
    public void test1bProductsMaxEquals2(){
        //Arrange
        PostOffice po = new PostOffice(10,products_unique1);
        po.setMaxNumberOfProducts(2);

        
        //Assert
        assertEquals(po.getProducts().size(), 1);
        assertEquals(po.getMaxNumberOfProducts(), 2);
        assertEquals(po.getNumberOfProducts(), 1);
    }

    //TC2 (1,2,10,2,T)
    @Test()
    public void test2aProductsMaxEquals1(){
     //Arrange
     PostOffice po = new PostOffice(10,products_unique2);
     po.setMaxNumberOfProducts(1);

     
     //Assert
     assertEquals(po.getProducts().size(), 1);
     assertEquals(po.getMaxNumberOfProducts(), 2);
     assertEquals(po.getNumberOfProducts(), 1);
    }
    //TC2 (1,2,10,2,T)
    @Test(expectedExceptions = Invalidoperation.class)
    public void test2abProductsMaxEquals1(){
        PostOffice po = new PostOffice(1,products_unique2);
    }

    //TC3 (20,3,15,3,T)
    @Test()
    public void test3aProductsMaxEquals20(){
        //Arrange
        PostOffice po = new PostOffice(20,products_unique3);

        //Assert
        assertEquals(po.getProducts().size(), 1);
        assertEquals(po.getMaxNumberOfProducts(), 20);
        assertEquals(po.getNumberOfProducts(), 3);
    }

    //TC3 (20,3,15,3,T)
    @Test()
    public void test3bProductsMaxEquals20(){
        //Arrange
        PostOffice po = new PostOffice(10,products_unique3);
        po.setMaxNumberOfProducts(20);
    
        //Assert
        assertEquals(po.getProducts().size(), 1);
        assertEquals(po.getMaxNumberOfProducts(), 20);
        assertEquals(po.getNumberOfProducts(), 3);
    }

    //TC4 (21,4,20,4,T)
    @Test(expectedExceptions = Invalidoperation.class)
    public void test4aProductsMaxEquals21(){
        PostOffice po = new PostOffice(21,products_unique4);
    }

    //TC4 (21,4,20,4,T)
    @Test()
    public void test4bProductsMaxEquals21(){
        //Arrange
        PostOffice po = new PostOffice(10,products_unique4);
        po.setMaxNumberOfProducts(21);
    
        //Assert
        assertEquals(po.getProducts().size(), 1);
        assertEquals(po.getMaxNumberOfProducts(), 10);
        assertEquals(po.getNumberOfProducts(), 4);
    }

    //TC5 (3,0,25,0,T)
    @Test()
    public void test5aNumberOfProducts0(){
        //Arrange
        PostOffice po = new PostOffice(3,products_unique0);

        //Assert
        assertEquals(po.getProducts().size(), 0);
        assertEquals(po.getMaxNumberOfProducts(), 3);
        assertEquals(po.getNumberOfProducts(), 0);
    }

    //TC5 (3,0,25,0,T)
    @Test()
    public void test5bNumberOfProducts0(){
        //Arrange
        PostOffice po = new PostOffice(3,products_unique1);
        po.update("p1",0);

        //Assert
        assertEquals(po.getProducts().size(), 1);
        assertEquals(po.getMaxNumberOfProducts(), 3);
        assertEquals(po.getNumberOfProducts(), 0);
    }

    //TC5 (3,0,25,0,T)
    @Test()
    public void test5cNumberOfProducts0(){
        //Arrange
        PostOffice po = new PostOffice(3,products_unique1);
        po.update("p1",0);
        po.removeProduct("p1");

        //Assert
        assertEquals(po.getProducts().size(), 0);
        assertEquals(po.getMaxNumberOfProducts(), 3);
        assertEquals(po.getNumberOfProducts(), 0);
    }

    //TC7 (1O,1O,35,8,T)
    @Test()
    public void test7aNumberOfProductsEqualsMax(){
        //Arrange
        PostOffice po = new PostOffice(10,products_unique7);

        //Assert
        assertEquals(po.getProducts().size(), 2);
        assertEquals(po.getMaxNumberOfProducts(), 10);
        assertEquals(po.getNumberOfProducts(), 10);
    }

    //TC7 (1O,1O,35,8,T)
    @Test()
    public void test7bNumberOfProductsEqualsMax(){
        //Arrange
        PostOffice po = new PostOffice(10,products_unique7b);
        po.update("p1",2);

        //Assert
        assertEquals(po.getProducts().size(), 2);
        assertEquals(po.getMaxNumberOfProducts(), 10);
        assertEquals(po.getNumberOfProducts(), 10);
    }

    //TC7 (1O,1O,35,8,T)
    @Test()
    public void test7cNumberOfProductsEqualsMax(){
        //Arrange
        PostOffice po = new PostOffice(15,products_unique7);
        setMaxNumberOfProducts(10);

        //Assert
        assertEquals(po.getProducts().size(), 2);
        assertEquals(po.getMaxNumberOfProducts(), 10);
        assertEquals(po.getNumberOfProducts(), 10);
    }

    //TC7 (1O,1O,35,8,T)
    @Test()
    public void test7dNumberOfProductsEqualsMax(){
        //Arrange
        PostOffice po = new PostOffice(15,products_unique7b);
        setMaxNumberOfProducts(10);
        po.update("p1",2);

        //Assert
        assertEquals(po.getProducts().size(), 2);
        assertEquals(po.getMaxNumberOfProducts(), 10);
        assertEquals(po.getNumberOfProducts(), 10);
    }

    //TC7 (1O,1O,35,8,T)
    @Test()
    public void test7eNumberOfProductsEqualsMax(){
        //Arrange
        PostOffice po = new PostOffice(15,products_unique7b);
        po.update("p1",2);
        setMaxNumberOfProducts(10);

        //Assert
        assertEquals(po.getProducts().size(), 2);
        assertEquals(po.getMaxNumberOfProducts(), 10);
        assertEquals(po.getNumberOfProducts(), 10);
    }
}