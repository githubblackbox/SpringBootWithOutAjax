package onesoft.com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import onesoft.com.Model.Language;

@Repository
public class LanguageRepository {

	@Autowired
    JdbcTemplate template;

    /*Getting all Items from table*/
    public List<Language> getAllItems(){
        List<Language> items = template.query("select id, bname, author, price from woajax",(result,rowNum)->new Language(result.getInt("id"),
                result.getString("bname"),result.getString("author"),result.getInt("price")));
        return items;
    } 
    
    /*Getting a specific item by item id from table*/
    public Language getItem(int itemId){
        String query = "SELECT * FROM woajax WHERE ID=?";
        Language item = template.queryForObject(query,new Object[]{itemId},new BeanPropertyRowMapper<>(Language.class));

        return item;
    }
    
    /*Adding an item into database table*/
    public int addItem(String bname,String author,int price){
        String query = "INSERT INTO woajax(bname,author,price) VALUES(?,?,?)";
        return template.update(query,bname,author,price);
    }
    
    /*updating an item into database table*/
    public int updateItem(int itemId,String bname,String author,int price){
        String query = "update woajax set bname=?, author=?, price=? where id=?";
        return template.update(query,bname,author,price,itemId);
    }
    
    /*delete an item from database*/
    public int deleteItem(int id){
        String query = "DELETE FROM woajax WHERE ID =?";
        return template.update(query,id);
    }
 }
