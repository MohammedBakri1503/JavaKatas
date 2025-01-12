package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RoundRobinLoadBalancerTest {

    @Test
    void testAddServerAndRouteRequest() {
        RoundRobinLoadBalancer loadBalancer = new RoundRobinLoadBalancer();

        RoundRobinLoadBalancer.IP server1 = new RoundRobinLoadBalancer.IP("192.168.0.1");
        RoundRobinLoadBalancer.IP server2 = new RoundRobinLoadBalancer.IP("192.168.0.2");
        RoundRobinLoadBalancer.IP server3 = new RoundRobinLoadBalancer.IP("192.168.0.3");

        loadBalancer.addServer(server1);
        loadBalancer.addServer(server2);
        loadBalancer.addServer(server3);

        assertEquals(server1, loadBalancer.routeRequest(), "First request should go to the first server");
        assertEquals(server2, loadBalancer.routeRequest(), "Second request should go to the second server");
        assertEquals(server3, loadBalancer.routeRequest(), "Third request should go to the third server");
        assertEquals(server1, loadBalancer.routeRequest(), "Fourth request should go back to the first server");
    }

    @Test
    void testRemoveServer() {
        RoundRobinLoadBalancer loadBalancer = new RoundRobinLoadBalancer();

        RoundRobinLoadBalancer.IP server1 = new RoundRobinLoadBalancer.IP("192.168.0.1");
        RoundRobinLoadBalancer.IP server2 = new RoundRobinLoadBalancer.IP("192.168.0.2");
        RoundRobinLoadBalancer.IP server3 = new RoundRobinLoadBalancer.IP("192.168.0.3");

        loadBalancer.addServer(server1);
        loadBalancer.addServer(server2);
        loadBalancer.addServer(server3);

        loadBalancer.removeServer(server2);

        assertEquals(server1, loadBalancer.routeRequest(), "After removal, the first request should go to the first server");
        assertEquals(server3, loadBalancer.routeRequest(), "After removal, the second request should go to the third server");
        assertEquals(server1, loadBalancer.routeRequest(), "The load balancer should cycle through the remaining servers");
    }

    @Test
    void testRouteRequestWithEmptyLoadBalancer() {
        RoundRobinLoadBalancer loadBalancer = new RoundRobinLoadBalancer();

        assertNull(loadBalancer.routeRequest(), "Routing request with no servers should return null");
    }

    @Test
    void testAddAndRemoveAllServers() {
        RoundRobinLoadBalancer loadBalancer = new RoundRobinLoadBalancer();

        RoundRobinLoadBalancer.IP server1 = new RoundRobinLoadBalancer.IP("192.168.0.1");
        RoundRobinLoadBalancer.IP server2 = new RoundRobinLoadBalancer.IP("192.168.0.2");

        loadBalancer.addServer(server1);
        loadBalancer.addServer(server2);

        assertEquals(server1, loadBalancer.routeRequest(), "First request should go to the first server");
        loadBalancer.removeServer(server1);
        loadBalancer.removeServer(server2);

        assertNull(loadBalancer.routeRequest(), "Routing request after removing all servers should return null");
    }

    @Test
    void testDuplicateServerAddition() {
        RoundRobinLoadBalancer loadBalancer = new RoundRobinLoadBalancer();

        RoundRobinLoadBalancer.IP server1 = new RoundRobinLoadBalancer.IP("192.168.0.1");

        loadBalancer.addServer(server1);
        loadBalancer.addServer(server1); // Duplicate addition

        assertEquals(server1, loadBalancer.routeRequest(), "First request should go to the only server");
        assertEquals(server1, loadBalancer.routeRequest(), "Duplicate servers should behave as a single server");
    }

    @Test
    void testInvalidIP() {
        assertThrows(IllegalArgumentException.class, () -> new RoundRobinLoadBalancer.IP("999.999.999.999"), "Invalid IP should throw IllegalArgumentException");
    }

    @Test
    void testValidIP() {
        RoundRobinLoadBalancer.IP validIP = new RoundRobinLoadBalancer.IP("192.168.0.1");
        assertEquals("192.168.0.1", validIP.toString(), "Valid IP address should be correctly initialized");
    }
}
