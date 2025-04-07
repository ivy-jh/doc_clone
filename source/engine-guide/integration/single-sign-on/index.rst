.. _single-sign-on:

Single Sign-on
==============

Single Sign-on (SSO) means that the user only has to log in once and is
automatically authenticated against the connected services. This means that the
user does not have to authenticate himself each time and for each individual
service with his username and password.

Axon Ivy Engine supports Single Sign-on. The configuration depends on the given
infrastructure, but the concept looks always the same. 

The user is browsing the Axon Ivy Engine via a intermediate service - a
:ref:`reverse proxy server <reverse-proxy>`. The reverse proxy server is
responsible to authenticate the user and add a user identifier to the request.
The Axon Ivy Engine will automatically log in the user when the user is known in
the :ref:`security system <configuration-security-system>` of the Axon Ivy Engine.


|

.. graphviz:: overview.dot

|


Therefore you need to configure your reverse proxy to set the identifier of
the authenticated user as a HTTP header. For :ref:`Microsoft IIS <reverse-proxy-iis>`
we provide an auto configuration script.

Next you need to enable SSO in :ref:`ivy-yaml`:

.. literalinclude:: ../../../../target/resources/includes/configuration/templates/ivy-sso.yaml
  :language: yaml
  :linenos:


.. warning::
  If you enable SSO you have to ensure that the Axon Ivy Engine cannot be accessed 
  directly. All traffic hsd to be routed via the reverse proxy. Otherwise, an 
  attacker could simply send a valid user name in the header of his faked HTTP 
  request and immediately has access bypassing the authentication!

You can integrate Axon Ivy Engine with every :ref:`Web Application Firewall
<web-application-firewall>` of your choice. And if nothing fits your needs then
you can implement your :ref:`own SSO solution <sso-custom-solution>`.

.. toctree::
    :maxdepth: 1
    :hidden:

    web-application-firewall/index
    custom-solution
