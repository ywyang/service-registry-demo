package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
public class ServiceRegistryDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRegistryDemoApplication.class, args);
	}
	@RestController
	class ServiceInstanceRestController {

	    @Autowired
	    private DiscoveryClient discoveryClient;
		@Autowired
		private Environment env;

	    @RequestMapping("/service-instances/{applicationName}")
	    @LoadBalanced	
	    public List<ServiceInstance> serviceInstancesByApplicationName(
	            @PathVariable String applicationName) {
	        return this.discoveryClient.getInstances(applicationName);
	    }
	    
		@RequestMapping("/")
		public String home() {
			// This is useful for debugging
			// When having multiple instance of gallery service running at different ports.
			// We load balance among them, and display which instance received the request.
			return "Hello from SpringCloud Service running at port: " + env.getProperty("local.server.port");
		}
	}
}
