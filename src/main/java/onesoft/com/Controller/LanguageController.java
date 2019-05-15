package onesoft.com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import onesoft.com.Model.Language;

@RestController  
public class LanguageController {
	
	 @Autowired
	    LanguageRepository itemRepo;

	 
	    @RequestMapping("/getallItems")
	    @ResponseBody
	    public List<Language> getAllItems(){
	        return itemRepo.getAllItems();
	    }
	    

	    @RequestMapping("/getItem")
	    @ResponseBody
	    public Language getItem(@RequestParam("itemId") int itemId){
	        return itemRepo.getItem(itemId);
	    }

	    @RequestMapping("/addItem")
	    @ResponseBody
	    public String addItem(@RequestParam("bname") String bname,
	                              @RequestParam("author") String author, @RequestParam("price") int price){
	        if(itemRepo.addItem(bname,author,price) >= 1){
	            return "Item Added Successfully";
	        }else{
	            return "Something went wrong !";
	        }
	    }
	    
	    
	    
	    @RequestMapping("/updateItem")
	    @ResponseBody
	    public String updateItem(@RequestParam("itemId") int itemId,@RequestParam("bname") String bname,
	                              @RequestParam("author") String author, @RequestParam("price") int price){
	        if(itemRepo.updateItem(itemId,bname,author,price) >= 1){
	            return "Item updated Successfully";
	        }else{
	            return "Something went wrong !";
	        }
	    }
	    
	    
	    
	    @RequestMapping("/deleteItem")
	    @ResponseBody
	    public String deteteItem(@RequestParam("itemId") int itemId){
	        if(itemRepo.deleteItem(itemId) >= 1){
	            return "Item Deleted Successfully";
	        }else{
	            return "Something went wrong !";
	        }
	    }
	 }
