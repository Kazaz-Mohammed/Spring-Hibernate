import dao.IDao;
import entities.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import util.HibernateConfig;
import java.util.List;

public class Presentation2 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);

        IDao<Product> productDao = context.getBean(IDao.class);

//        Create
        Product product = new Product();
        product.setName("Produit 1");
        product.setPrice(100.0);

        productDao.create(product);

        System.out.println("Produit sauvegardé : " + product.getName());

//********************************
//        Read
        List<Product> products = productDao.findAll();
        System.out.println("Liste des produits :");
        for (Product p : products) {
            System.out.println(p.getId() + " - " + p.getName() + " : " + p.getPrice());
        }

//        Update
        Product firstProduct = products.get(0);
        firstProduct.setPrice(150.0);
        productDao.update(firstProduct);
        System.out.println("Produit mis à jour : " + firstProduct.getName() + " -> " + firstProduct.getPrice());


//        Delete
        productDao.delete(firstProduct);
        System.out.println("Produit supprimé : " + firstProduct.getName());

    }
}
