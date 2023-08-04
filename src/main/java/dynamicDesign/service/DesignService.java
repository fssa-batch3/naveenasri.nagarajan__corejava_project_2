package dynamicDesign.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.SQLException;

import dynamicDesign.dao.DesignDAO;
import dynamicDesign.model.Design;
import dynamicDesign.service.exception.ServiceException;
import dynamicDesign.validation.DesignValidator;

public class DesignService {
	public  boolean createDesign(Design design) throws ServiceException {
        DesignDAO designDAO = new DesignDAO();

        try {
            // Check if the design is null
            if (design == null) {
                throw new IllegalArgumentException("Design is null");
            }
            // Perform validation checks for the design
            DesignValidator.validateDesign(design);

            // You can add additional business logic checks here if needed

            return designDAO.createDesign(design);
        } catch (IllegalArgumentException | SQLException e) {
            throw new ServiceException(e);
        }
    }

	   
//    public static void main(String[]args) {
//    	DesignService designservice  = new DesignService();
//    	Design design1 = new Design("Living Room Design", "https://example.com/design1", 100.0, "user@example.com", 1);
//    	
//      try{
//    	  System.out.print(designService.createDesign(design1));
//      }catch(Exception e) {
//    	  e.printStackTrace();
//    	  
//      }
      
    }








