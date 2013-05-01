package org.levi.reusable.demo.rest;

import java.net.InetSocketAddress;
import java.net.Proxy;

import org.junit.Test;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public class RestTemplateTest {

	@Test
	public void test() {
		Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxy.pal.sap.com", 9999));
		SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
		requestFactory.setProxy(proxy);

		RestTemplate restTemplate = new RestTemplate(requestFactory);
		String url = "https://ajax.googleapis.com/ajax/services/search/web?v=1.0&q={query}";
		String result = restTemplate.getForObject(url, String.class,
				"SpringSource");
	}

}
