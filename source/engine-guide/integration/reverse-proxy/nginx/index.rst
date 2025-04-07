.. _reverse-proxy-nginx:

NGINX
=====

This is how to configure NGINX as a reverse proxy in front of the Axon Ivy Engine:

* All HTTP traffic is redirected to HTTPS
* Only the application `demo-portal` is available via the reverse proxy
* NGINX communicates via HTTP with the Axon Ivy Engine

.. literalinclude:: proxy.conf
    :language: nginx
