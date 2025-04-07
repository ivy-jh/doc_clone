.. _reverse-proxy-secure-path:

Path
====

We recommend providing only the Axon Ivy application(s) that your users need to access
via the reverse proxy. The Axon Ivy Engine makes it easy to do that because all
URLs of an application share the left-hand side of their URL. For example: If
your application is named :code:`demo-app`, then you only need to allow access
for the URL :code:`https://ivyengine/demo-app`. 

|

.. rubric:: Restrict system access

The Axon Ivy Engine itself provides administration functionality under the base
url :code:`system` e.g., :code:`https://ivyengine/system`. Do not allow or
explicitly restrict the access to this URL in your reverse proxy configuration.

|

.. rubric:: Well appreciated redirect

A redirect from the root URL :code:`/` to your application home URL will be much
appreciated by your end users. E.g., when a user is accessing
:code:`https://ivyengine/` then they should be redirected to
:code:`https://ivyengine/demo-app`.

|

.. rubric:: Examples

The configuration examples for :ref:`NGINX <reverse-proxy-nginx>` and for
:ref:`Apache HTTP Server <reverse-proxy-apache>` follow all of these recommendations.
The configuration script provided for :ref:`Microsoft IIS <reverse-proxy-iis>`
routes all traffic to the Axon Ivy Engine. We recommend to only route specific
applications by manually modifing the rules in :guilabel:`URL Rewrite`.


Block URLs on the Axon Ivy Engine
*********************************

Alternatively, URLs can also be blocked directly on the Axon Ivy Engine which
utilizes and underlying Apache Tomcat for serving HTTP requests. Open the
:ref:`web-xml` file in :file:`[engineDir]/configuration/` and add the following
configuration inside the :code:`<web-app>` tag to block system access: 

.. literalinclude:: blocking-url-web.xml
  :language: xml
  :linenos:

After changing the configuration restart the Axon Ivy Engine. Note: Using this
scheme reduces engine performance slightly, as the Axon Ivy Engine has to check
every incoming request if it needs to be blocked. Reverse proxies are better
suited for this task.
