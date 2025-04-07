.. _cluster-load-balancer:

Load Balancer
=============

Axon Ivy Engine Clusters work with **sticky sessions**. The load balancer has to
forward all requests from a session to the same cluster node. Of course, if a
cluster node is no longer available then the request will be sent to another
cluster node. This will cause the user to get a new session, therefore
losing his work in the replaced session.

As described above, the load balancer has to ensure that all requests from the
same user session are sent to the same cluster node. This can be done as
follows: 

* configure the load balancer to always forward all requests sent from one
  client IP address to the same cluster node (IP based stickiness). 
* use the Axon Ivy Session Id to provide session stickiness. The session id is
  provided by Axon Ivy Engine Enterprise Edition as an HTTP session cookie with the
  name :code:`JSESSIONID`.

Often, :ref:`Reverse Proxies <reverse-proxy>` can be configured as load balancers.

HAProxy
-------

HAProxy is a free, fast, and reliable solution offering high availability, load
balancing, and proxying for TCP and HTTP-based applications. It is simple to set
up. It offers a Docker image that needs only minimal configuration.

We provide a :link-url:`sample on GitHub <docker-scaling-haproxy>` how to setup
an Axon Ivy Engine Cluster using HAProxy as the load balancer within
docker-compose.

NGINX
-----

NGINX is a free, open-source HTTP web server that serves as a reverse proxy
server, a mail proxy server, and a generic TCP/UDP proxy server and offers load
balancing features. It also offers a Docker image with minimal configuration
needs.

We provide a :link-url:`sample on GitHub <docker-scaling-nginx>` on how to setup
an Axon Ivy Engine Cluster using NGINX as the load balancer within docker-compose.
