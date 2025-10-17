import dao.IDao;
import entities.Category;
import entities.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import util.HibernateConfig;

public class PresentationCategory {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);

        @SuppressWarnings("unchecked")
        IDao<Category> categoryDao = (IDao<Category>) context.getBean("categoryDaoImpl");

        @SuppressWarnings("unchecked")
        IDao<Product> productDao = (IDao<Product>) context.getBean("productDaoImpl");


        // Create a category
        Category cat = new Category("Informatique");
        categoryDao.create(cat);

        // Create a product linked to category
        Product p1 = new Product();
        p1.setName("Clavier");
        p1.setPrice(200.0);
        p1.setCategory(cat);

        productDao.create(p1);

        System.out.println("Produit " + p1.getName() + " ajouté dans la catégorie " + cat.getName());
    }
}
