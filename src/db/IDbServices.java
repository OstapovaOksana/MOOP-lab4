package db;

import java.rmi.Remote;
import java.util.ArrayList;
import java.util.Map;

public interface IDbServices extends Remote {
    boolean addCategory(String name) throws Exception;
    DbCategory getCategory(int id) throws Exception;
    ArrayList<DbCategory> getCategories() throws Exception;
    boolean deleteCategory(int id) throws Exception;

    boolean addNews(String name, String publishingHouse, int categoryId) throws Exception;
    boolean updateNews(int id, Map<String,String> changes) throws Exception;
    DbNews getNewsById(int id) throws Exception;
    ArrayList<DbNews> getNews() throws Exception;
    ArrayList<DbNews> getNewsByCategory(int categoryId) throws Exception;
    boolean deleteNews(int id) throws Exception;
}