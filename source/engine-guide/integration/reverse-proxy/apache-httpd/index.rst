.. _reverse-proxy-apache:

Apache HTTP Server
===================

To configure Apache HTTP Server as reverse proxy in front of the Axon Ivy Engine, 
configure it as follows:

* All HTTP traffic between client and reverse proxy is redirected to HTTPS
* Only the necessary applications (here: `demo-portal`) is available via the reverse proxy
* Apache HTTP Server communicates over HTTP with the Axon Ivy Engine

.. literalinclude:: vhosts.conf
    :language: apache

