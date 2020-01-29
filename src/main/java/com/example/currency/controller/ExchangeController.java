package com.example.currency.controller;

import com.example.currency.dto.CurrencyType;
import com.example.currency.dto.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriBuilderFactory;

import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class ExchangeController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${app.openexchange.latest}")
    private String latestUrl;
    @Value("${app.openexchange.app_id}")
    private String appId;


    @RequestMapping(value = "/")
    public String getExchangeNow(Model model) {
        Exchange exchange = restTemplate.getForObject(latestUrl+"?app_id=" + appId, Exchange.class);
        //Exchange exchange = restTemplate.getForObject(historicalUrl+ "2020-01-18.json" +"?app_id=" + appId, Exchange.class);
        model.addAttribute("headers", CurrencyType.names());
        model.addAttribute("pair", exchange.getRates().entrySet().stream()
                .filter(entry-> CurrencyType.names().contains(entry.getKey()))
                //.map(Map.Entry::getValue)
                .collect(Collectors.toList()));
        return "currency rates";
    }
}
