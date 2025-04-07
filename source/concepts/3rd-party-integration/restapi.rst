.. _integration-rest:

REST Services
=============

REST (representational state transfer) is an architectural style, based on
resources to provide inter-system communication.

The Java API specification for RESTful Web Services is called `JAX-RS
<https://docs.oracle.com/javaee/7/api/javax/ws/rs/package-summary.html#package.description>`__.
It provides portable APIs for developing, exposing and accessing web
applications designed and implemented in compliance with principles of the REST
architectural style.

|ivy| uses the reference implementation libraries of JAX-RS called `Jersey
<https://jersey.github.io/>`__.


Call a Remote REST Service
--------------------------

To call a remote REST service, you have to define it in the
:ref:`rest-clients-configuration`. After that, you can use a
:ref:`process-element-rest-client-activity` to call the REST service.

Find examples in the :ref:`ConnectivityDemos <importing-demo-projects>` project.


.. _integration-rest-provider:

Provide Your Own REST Services
------------------------------

To provide a custom REST service in your |ivy| project, `JAX-RS
<https://docs.oracle.com/javaee/7/api/javax/ws/rs/package-summary.html#package.description>`__
annotations can be used. A REST resource is created by adding a Java class to
the ``src`` directory. The Java class has to use the correct annotations (as
shown below) so it is detected as a REST resource and published automatically.
After publishing, the resource will be available on the base path
*/<appName>/api/*.

::

   /**
    * Provides the person REST resource 
    * on the path /myApplicationName/api/person
    */
   @Path("person")
   public class CustomProjectResource {
       @GET
       @Produces(MediaType.APPLICATION_JSON)
       public Person get() {
           Person p = new Person();
           p.setFirstname("Renato");
           p.setLastname("Stalder");
           return p;
       }
   }

Further information is available in the `JAX-RS API Specification
<https://docs.oracle.com/javaee/7/api/javax/ws/rs/package-summary.html#package.description>`__.

Many example REST services are available in the :ref:`ConnectivityDemos
<importing-demo-projects>`.


.. _integration-rest-api-spec:

API Publishing
--------------

Once you have provided new REST APIs with your project, you need to share the
service capabilities with your service users. This is simple, since services
defined within Ivy projects will be published as `OpenAPI
<https://www.openapis.org/>`__ service specifications. You only need to share the
specification as a file or serve it on a public URL so that clients can start
using it.

The technical interface description is available under the following URL path:

``/<appName>/api/openapi.json``
e.g., http://localhost:8081/designer/api/openapi.json (this one is from Designer)


.. _integration-rest-api-spec-annotate:

Custom OpenAPI Docs
^^^^^^^^^^^^^^^^^^^
The automatically generated OpenAPI specification exposes all strict service
capabilities without additional effort for you as a service provider.

However, there are many service interfaces that become easier to use if they are
enriched with explanatory documents. You may like to expose and explain
technical implementation details, such as strictly required parameters or
possible response statuses. You can provide this information by adding optional
OpenAPI annotations to your REST APIs.

The highlighted lines in the following example show frequent use cases of
these optional OpenAPI docs annotations.

.. container:: admonition note toggle

  .. container:: admonition-title header

     **Example OpenApiResource.java**


  .. literalinclude:: includes/OpenApiResource.java
    :language: java
    :start-after: import com.axonivy.connectivity.Person;
    :emphasize-lines: 7, 12, 13, 15, 17
    :linenos:



.. _integration-rest-api-browser:

API Browser
-----------

You can easily inspect all `OpenAPI <https://www.openapis.org/>`__ services with
the API Browser. It gives consumers of your services not only a detailed service
description, but a simple client to fire real calls against the services, too.

To access the API Browser, open the URL ``/system/api-browser``  with a web browser of your choice
e.g., http://localhost:8080/system/api-browser

.. figure:: /_images/concepts-integration/api-browse-app.png
    :align: center


.. _integration-rest-secure:

Secure APIs
-----------

REST APIs served by the |ivy-engine| are protected by default to provide safe
interactions with your API clients.


Basic Auth
^^^^^^^^^^
REST APIs are protected with Basic authentication so that only known users of
the security system can get valid responses. Setting HTTP Basic authentication
headers from an API client is simple and widely supported. However, since HTTP
Basic headers are base64 encoded and thus can easily be decoded, we strongly
recommend to allow :ref:`only encrypted HTTPS traffic
<reverse-proxy-secure-https>` on the REST APIs.

You can customize the authentication for a specific API method by setting
security annotations headers:

- @PermitAll: allows unauthenticated access to anonymous users
- @RolesAllowed: users must be authenticated and own the defined roles
- @DenyAll: nobody is allowed to invoke this service

You can review the security annotations in the demo project :link-url:`Secure
Service <demos-connect-secure-service-java>` within the :ref:`ConnectivityDemos
<importing-demo-projects>`.

CSRF Protection
^^^^^^^^^^^^^^^
To call a modifying REST service via ``PUT``, ``POST`` or ``DELETE``, the caller
needs to provide a HTTP header called ``X-Requested-By`` with any value, e.g.
``ivy``. The `CSRF filter
<https://github.com/jersey/jersey/blob/master/core-server/src/main/java/org/glassfish/jersey/server/filter/CsrfProtectionFilter.java>`__
protects REST services against cross-site request forgery (CSRF). If the client
omits the header on a modifying REST request, the response will indicate a
failure with the HTTP status code 400 (Bad Request).

User provided REST services via ``GET``, ``HEAD`` or ``OPTIONS`` have to be
implemented such that no data is modified.

The CSRF protection filter is enabled by default. However, it can be turned off
in an environment where the clients can be trusted (e.g., intranet). See the 
property ``REST.Servlet.CSRF.Protection`` in the :ref:`ivy-yaml`


Workflow API
------------

|ivy| provides a basic :ref:`Workflow API REST Service
<workflow-api>`. You can use it to enable remote systems to request
information about tasks of a user etc.


Pretty printing
-----------------

If you add the query param `pretty` to the URL to any REST Service provided by the |ivy-engine|
which produce JSON, then you get a pretty formatted JSON e.g., http://localhost:8081/designer/api/engine/info?pretty
