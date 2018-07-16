package org.baeldung.controller;

import org.baeldung.persistence.model.Settlement;
import org.baeldung.service.SalesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("settlement")
public class SettlementController {

	private static final Logger LOG = LoggerFactory.getLogger(SettlementController.class);


	@RequestMapping(value = "/getSettlement", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public @ResponseBody Settlement getSettlement() {
		LOG.info(" getSettlement");
		Settlement settlement = new Settlement();
		settlement.setSettlementSystemId(84422L);
		return settlement;
	}

	@RequestMapping(value = "/postSettlement", method = RequestMethod.POST, 
			consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE },
			produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
	public @ResponseBody Settlement postSettlement(@RequestBody Settlement settlement) {
		LOG.info(" postSettlement {}", settlement.getSettlementSystemId());
		return settlement;
	}

}