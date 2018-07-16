package org.baeldung.controller;

import java.util.List;
import java.util.Optional;

import org.baeldung.persistence.model.Settlement;
import org.baeldung.persistence.model.Video;
import org.baeldung.persistence.repo.SettlementRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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

	@Autowired
	private SettlementRepository settlementRepository;

	@RequestMapping(value = "/getSettlement/{settlementId}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public @ResponseBody Settlement getSettlement(@PathVariable long settlementId) {
		LOG.info(" getSettlement");
		Optional<Settlement> optSettlement = settlementRepository.findById(settlementId);
		return optSettlement.get();
	}
	
	


	@RequestMapping(value = "/getAllSettlement", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public @ResponseBody Iterable<Settlement> getAllSettlement() {
		LOG.info(" getAllSettlement");
		Iterable<Settlement> settlements = settlementRepository.findAll();
		return settlements;
	}

	@RequestMapping(value = "/postSettlement", method = RequestMethod.POST, 
			consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE },
			produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
	public @ResponseBody Settlement postSettlement(@RequestBody Settlement settlement) {
		LOG.info(" postSettlement {}", settlement.getSettlementSystemId());
		settlementRepository.save(settlement);
		return settlement;
	}

	@RequestMapping(value = "/postAllSettlement", method = RequestMethod.POST, 
			consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE },
			produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
	public @ResponseBody List<Settlement> postAllSettlement(@RequestBody  List<Settlement> settlements) {
		LOG.info(" postSettlement {}", settlements.size());
		settlementRepository.saveAll(settlements);
		return settlements;
	}

}