.. _reverse-proxy-secure-port:

Port
----

It is very important that the communication between the reverse proxy and the
Axon Ivy Engine is **exclusive** or restricted for administrators - especially
when :ref:`Single Sign-on <single-sign-on>` is activated. This means no one else
should be able to communicate directly with the Axon Ivy Engine using its ports e.g.
8080, 8443 or 8009 from the outside. How to configure this properly depends on
the setup.


Same host
^^^^^^^^^

If the reverse proxy and the Axon Ivy Engine run on the same host 

|

.. graphviz:: same-host.dot

|

then you just need to bind the connector - the protocol between the reverse proxy
and the Axon Ivy Engine - to localhost. For example when using HTTP then you
need to bind the HTTP connector to localhost (same for HTTPS). This ensures that
the Axon Ivy Engine can only be accessed via localhost.

.. code:: yaml

    # bind the HTTP connector to localhost exclusively
    Connector:
      HTTP:
        Address: localhost


Different Host
^^^^^^^^^^^^^^

If the reverse proxy and the Axon Ivy Engine run on two different hosts:

|

.. graphviz:: different-host.dot

|

You have to use one of the following approaches:

#. Configure your network such that only the reverse proxy
   can communicate with the Axon Ivy Engine.
#. Setup a firewall rule on the Axon Ivy Engine host,
   which blocks all requests but those from the IP address of the reverse
   proxy.
