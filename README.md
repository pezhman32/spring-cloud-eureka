# Eureka server and client(s)
After running server module you can checkout http://localhost:8761/ or use `/health` and `/info` native endpoints.

Then you can create as many client instances as you want and check their status using above url (port is configured to choose a free one each time).
<br />
Also you can use http://localhost:8761/discoverClients endpoint to return list of available clients with `client1` id. This endpoint has been implemented for clients as well.
<br />
Another endpoint http://localhost:8761/nextClient provided to return next client in `client1` group. So we can use it for load balancers.

In order to provide `/discoverClients` and `/nextClient` in server, we had to put `@EnableDiscoveryClient` in server's configuration plus comment out `eureka.client.registerWithEureka` and `eureka.client.fetchRegistry` in server's `bootstrap.yml`. This will cause some startup performance issues.


### References:
- http://cloud.spring.io/spring-cloud-static/Brixton.SR5/#_service_discovery_eureka_clients
- http://stackoverflow.com/questions/35172625/spring-cloud-config-eureka-first-approach-not-working