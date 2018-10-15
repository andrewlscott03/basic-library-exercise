package org.exercise.basiclibrary.controller;

import java.util.List;

import org.basiclibrary.db.hibernate.Borrower;
import org.basiclibrary.db.hibernate.Resource;
import org.basiclibrary.db.repository.BorrowerRepository;
import org.basiclibrary.db.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import freemarker.ext.beans.BeansWrapper;
import freemarker.ext.beans.BeansWrapperBuilder;
import freemarker.ext.beans.CollectionModel;
import freemarker.template.Configuration;

@Controller
public class BasicLibraryWebController {
	
	@Autowired
	ResourceRepository resourceRepository;
	
	@Autowired
	BorrowerRepository borrowerRepository;
	
    @GetMapping("/")
    public String home() {
    	
        return "index";
    }
    
    private BeansWrapper beansWrapper = new BeansWrapperBuilder(Configuration.VERSION_2_3_21).build();
	
    @GetMapping("/resources")
    public String resources(Model model) {
    	
    	List<Resource> resourceList = resourceRepository.findAll(new Sort(Direction.ASC, "resourceName"));
    	CollectionModel collectionModel = new CollectionModel(resourceList, beansWrapper);
        model.addAttribute("resourceList", collectionModel);
        return "resources";
    }
    
    @GetMapping("/borrowers")
    public String borrowers(Model model) {
    	
    	List<Borrower> borrowerList = borrowerRepository.findAll(new Sort(Direction.ASC, "lastname", "firstname"));
    	CollectionModel collectionModel = new CollectionModel(borrowerList, beansWrapper);
        model.addAttribute("borrowerList", collectionModel);
        return "borrowers";
    }
}
