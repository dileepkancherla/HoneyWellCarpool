package com.carpool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.carpool.model.Commuter;
import com.carpool.model.CommuterRequest;
import com.carpool.model.VehicleOwner;
import com.carpool.service.CommuterService;

@Controller
public class CommuterController {
	
	private CommuterService commuterService;
	
	@Autowired(required=true)
	@Qualifier(value="commuterService")
	public void setCommuterService(CommuterService ps){
		this.commuterService = ps;
	}
	
	@RequestMapping(value = "/commuters", method = RequestMethod.GET)
	public String listCommuters(Model model) {
		model.addAttribute("commuter", new Commuter());
		model.addAttribute("listcommuters", this.commuterService.listCommuters());
		return "commuter";
	}
	
	//For add and update Commuter both
	@RequestMapping(value= "/commuter/add", method = RequestMethod.POST)
	public String addCommuter(@ModelAttribute("commuter") Commuter p){
		
		if(p.getId() == 0){
			//new Commuter, add it
			this.commuterService.addCommuter(p);
		}else{
			//existing Commuter, call update
			this.commuterService.updateCommuter(p);
		}
		
		return "redirect:/commuters";
		
	}
	
	@RequestMapping("/requestForCarpool/{id}")
    public String removeCommuter(@PathVariable("id") int id,Model model){
		
		CommuterRequest commuterRequest = new CommuterRequest();
		commuterRequest.setFkCommuterId(id);
		model.addAttribute("commuterRequest",commuterRequest );
        return "requestForCarpool";
    }
 
	@RequestMapping("/fetchAvailableVehicles")
    public String fetchAvailableVehicles(@ModelAttribute("commuterRequest") CommuterRequest commuterRequest,Model model ){
	
	//need to add the logic to fetch the available vehicles based on origin and destination(by using Route Matching Algo)	
   	 List<VehicleOwner> list=commuterService.getVehicles();
   	 model.addAttribute("listVehicles",list);
   	 model.addAttribute("commuterRequest",commuterRequest );		
     return "requestForCarpool";
    }
	
    @RequestMapping("/edit/{id}")
    public String editCommuter(@PathVariable("id") int id, Model model){
        model.addAttribute("Commuter", this.commuterService.getCommuterById(id));
        model.addAttribute("listCommuters", this.commuterService.listCommuters());
        return "Commuter";
    }
	
}
