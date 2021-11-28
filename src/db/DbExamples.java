package db;

import java.io.Serializable;
import java.util.HashMap;

public class DbExamples implements Serializable {
    private IDbServices services;

    public DbExamples(IDbServices services) {
        this.services = services;
    }

    public void runAll() throws Exception {
        example1();
        example2();
        example3();
        example4();
    }

    public void example1() throws Exception {
        System.out.println("\nExample 1");
        
        services.addCategory("New Category");
        System.out.println(services.getCategories());
        services.deleteCategory(4);
        System.out.println(services.getCategories());
    }

    public void example2() throws Exception {
        System.out.println("\nExample 2");

        System.out.println(services.getNews());
        services.addNews("Name", "PublishingHouse", 1);
        System.out.println(services.getNews());
        services.deleteNews(4);
        System.out.println(services.getNews());
    }

    public void example3() throws Exception {
        System.out.println("\nExample 3");

        System.out.println(services.getNewsByCategory(1));
        System.out.println(services.getNewsByCategory(2));
    }

    public void example4() throws Exception {
        System.out.println("\nExample 4");

        System.out.println(services.getNewsByCategory(1));
        services.updateNews(1, new HashMap<String, String>() {{
            put("name", "Changed Name");
            put("publishingHouse", "Changed Publishing House");
        }});
        System.out.println(services.getNewsByCategory(1));
    }
}
