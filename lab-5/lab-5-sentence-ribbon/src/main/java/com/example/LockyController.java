package com.example;

import java.net.URI;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class LockyController {

	@Value("${info}")
	String info;

	public class TestPerson {
		private String nombre;
		private int edad;
		private String domicilio;

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public int getEdad() {
			return edad;
		}

		public void setEdad(int edad) {
			this.edad = edad;
		}

		public String getDomicilio() {
			return domicilio;
		}

		public void setDomicilio(String domicilio) {
			this.domicilio = domicilio;
		}

	}

	@Autowired
	LoadBalancerClient client;

	@RequestMapping("/person")
	public @ResponseBody TestPerson showPersonExample() {
		TestPerson person = new TestPerson();
		person.setNombre("dummy");
		Calendar calendar = Calendar.getInstance();
		person.setEdad(calendar.get(Calendar.YEAR));
		person.setDomicilio("N/A");
		return person;
	}

	@RequestMapping("/persons")
	public @ResponseBody List<TestPerson> showPersonsExample(@RequestParam("names") String names,
			@RequestParam("ages") int[] ages, @RequestParam("addresses") String addresses) {
		List<TestPerson> list = null;
		if (names != null && !names.isEmpty()) {
			String[] namesSplit = names.split(",");
			String[] addressesSplit = addresses.split(",");
			list = new ArrayList<LockyController.TestPerson>();
			int i = 0;
			for (String namesIterator : namesSplit) {
				TestPerson person = new TestPerson();
				person.setNombre(namesIterator);
				person.setEdad(ages[i]);
				person.setDomicilio(addressesSplit[i]);
				list.add(person);
				i++;
			}
		}
		return list;
	}

	@RequestMapping("/sentence")
	public @ResponseBody String showLuckyWord() {
		StringBuilder builder = new StringBuilder();
		builder.append(getWord("LAB-4-CLIENT")).append(" ");
		builder.append(getWord("LAB-4-VERB")).append(" ");
		builder.append(getWord("LAB-4-ARTICLE")).append(" ");
		builder.append(getWord("LAB-4-ADJECTIVE")).append(" ");
		builder.append(getWord("LAB-4-NOUN")).append(" ");
		return builder.toString();
	}

	@RequestMapping("/info")
	public @ResponseBody String showServerInfo() {
		return info;
	}

	private String getWord(String service) {
		ServiceInstance serviceInstance = client.choose(service);
		if (serviceInstance != null) {
			URI uri = serviceInstance.getUri();
			if (uri != null) {
				return (new RestTemplate()).getForObject(uri, String.class);
			}
		}
		return service;
	}

}
