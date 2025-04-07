.. _dos-brute-force-attack:

Denial of Service (DoS) and Brute Force Attack Prevention
=========================================================

`Web application firewalls (WAF) <https://en.wikipedia.org/wiki/Web_application_firewal>`_ or :ref:`reverse proxy servers <reverse-proxy>` 
prevent DoS and brute force attacks by default or by additional configurations.

Rate Limits
-----------

Rate limits control the number of requests a certain client can do in a certain time. 
If a client does more requests than allowed it either is blocked for some time or 
gets errors (e.g., 503 Service Temporary Unavailable).

Have a look at our `ivy-reverse-proxy-ngnix-fail2ban docker examples <https://github.com/axonivy/docker-samples/tree/master/ivy-reverse-proxy-nginx-fail2ban>`_ 
to see how rate limits can be configured with :ref:`NGINX reverse proxy <reverse-proxy-nginx>`.

Network Banning
---------------

Some tools can analyze log files from a :ref:`reverse proxy server <reverse-proxy>` and ban clients that behave badly. 
This can be done on the network level by banning the IP addresses of bad clients or on the application level. 

Have a look at our `ivy-reverse-proxy-ngnix-fail2ban docker examples <https://github.com/axonivy/docker-samples/tree/master/ivy-reverse-proxy-nginx-fail2ban>`_ 
to see how to configure network banning with `fail2ban <https://github.com/fail2ban/fail2ban>`_.

|ivy| Login Pages (Brute Force Attack)
-----------------------------------------

To help analyze log files for brute force attacks, the |ivy| login pages return a ``401 (Unauthorized)`` HTTP error code 
if a login attempt fails.
