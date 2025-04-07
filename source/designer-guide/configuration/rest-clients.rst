.. _rest-clients-configuration:


REST Clients
============

The REST clients configuration contains the definition of all REST
services, to be consumed by an |ivy| process.

.. tip::

   Before you create a new REST client, take a look at the :ref:`Axon
   Ivy Market <market>`. There, you may find a suitable connector already.


REST Client
-----------

A REST client can be referenced by name or universally unique identifier (UUID).
|ivy| generates the UUID when a new REST client is created and will never
change. You define the name of a REST client when you create a new REST client.
You can change it later. To ensure that renaming a REST client will not break
the reference, refer to the REST client by its UUID only.

Find additional information on using REST clients in the chapter
:ref:`integration-rest`.

.. _rest-client-configuration-editor:

REST Client Editor
------------------

Use the REST client Editor to create and edit REST client configurations.

.. figure:: /_images/designer-configuration/rest-client-editor.png
   :alt: REST Client Editor
   :align: center
   
   REST Client Editor


REST Clients Tree Editor
~~~~~~~~~~~~~~~~~~~~~~~~

Shows the REST clients of the current project.

- :guilabel:`Add Client`
  Adds a new REST client.

- :guilabel:`Remove`
  Removes the selected REST client.


REST Client Details Editor
~~~~~~~~~~~~~~~~~~~~~~~~~~

Shows the details of the currently selected REST client.

REST Client Section
^^^^^^^^^^^^^^^^^^^

- :guilabel:`UUID`
  Universal unique identifier of the REST client. The REST client can
  be referenced by this UUID. Cannot be modified.

- :guilabel:`Name`
  The name of the REST client. You can refer to the REST client by
  this name. You can modify it. Note that references using the name will
  break if you change it.
  
- :guilabel:`Icon` 
  Choose an icon that represents the system that this REST
  client communicates with. |ivy| uses this icon as a decorator icon
  on REST client call process elements that reference this REST client.  

- :guilabel:`Description`
  Description of the REST client.

- :guilabel:`Uri`
  The base URI under which the remote service publishes its resources
  (e.g., https://api.twitter.com/1.1).

  The URI can contain template placeholders which are resolved later by
  the client user (e.g., https://api.twitter.com/{version}).

  ::

     ivy.rest.client("twitter").resolveTemplate("version", "1.1").get()



.. _rest-clients-generator-wizard:

OpenAPI Client Generator
^^^^^^^^^^^^^^^^^^^^^^^^
The OpenAPI client generator wizard provides validation and inscription editor simplification features 
for specific calls with a :ref:`process-element-rest-client-activity`. 
Click the *Generate REST classes* button to start the wizard. 

.. figure:: /_images/designer-configuration/rest-client-editor-main-section.png

**OpenAPI Clients**

- expose valid resource+method combos and their documentation
- display and validate typed query- and path parameters
- are aware of the payloads sent to and fro and generate Java objects for them

**Pre-Requisites**

- To generate an `OpenAPI <https://swagger.io/docs/specification/about/>`__
  client, you need an OpenAPI 3.0 JSON service descriptor. 
- The legacy Swagger 2.0 openapi.json format is also supported by the client generator.

.. figure:: /_images/designer-configuration/rest-client-generator-wizard.png


.. _rest-clients-openapi-migrate:

**Migrate to OpenAPI**

OpenAPI isn't the only popular format to describe REST service capabilities.

If you need to integrate an `OData service <https://www.odata.org/>`__, you
can convert your OData service description with our `OData converter
<http://odata-converter.axonivy.com>`__. The service description is usually
available under the given service URL ending with :code:`$metadata` e.g.
:code:`https://myService/cars/$metadata`

If you have other types of service descriptions, you may have a look at
`lucybot <https://lucybot-inc.github.io/api-spec-converter/>`__. It is able to
convert many other specification types to OpenAPI.


Authentication Section
^^^^^^^^^^^^^^^^^^^^^^

- :guilabel:`HTTP Basic`
  Adds support for HTTP Basic authentication.

- :guilabel:`HTTP Digest`
  Adds support for HTTP Digest authentication.

- :guilabel:`NTLM` 
  Adds support for NTLM (Windows) authentication. Optionally,
  you can configure the ``NTLM.domain`` and the ``NTLM.workstation`` in the
  properties section.

- :guilabel:`Username`
  The name of the user used to authenticate the client with the service.

- :guilabel:`Password`
  The password of the user used to authenticate the client with the service.

Features Section
^^^^^^^^^^^^^^^^

- :guilabel:`JSON` 
  Adds a feature that maps Java objects to JSON for requests and 
  JSON to Java objects for responses.

- :guilabel:`Features List`
  Shows the configured "features" classes. The classes configured here
  are registered in the WebTarget using the method ``register(Class)``.
  The classes need to implement a JAX-RS contract interface and must
  have a default constructor.

- :guilabel:`Add`
  Adds a new feature class.

- :guilabel:`Remove`
  Removes the selected feature.


.. _rest-clients-configuration-properties:

Properties Section
^^^^^^^^^^^^^^^^^^
 
Use Properties to customize the settings of the REST client or one of
its features.

- :guilabel:`Add`
  Adds a new property.

- :guilabel:`Add Password`
  Adds a new password property. The value of a password property is not
  visible in the table and is stored encrypted in the configuration file.

- :guilabel:`Remove`
  Removes the selected property.

**Client Properties**

Well known properties of REST clients are documented here:
`org.glassfish.jersey.client.ClientProperties <https://eclipse-ee4j.github.io/jersey.github.io/apidocs/latest/jersey/org/glassfish/jersey/client/ClientProperties.html>`__.

To configure SSL client authentication for a REST client call, specify the
property *SSL.keyAlias*. The value of this alias needs to correspond with a key
alias available in the client keystore configured under
:ref:`engine-cockpit-ssl`.

**JSON Properties**

The JSON feature knows many properties that customize the serialization from
JSON to Java objects and vice versa.

It is possible to read a very complex JSON object with many fields back to a
Java object that contains only a subset of these fields. To allow this
incomplete but efficient mapping, the property
``Deserialization.FAIL_ON_UNKNOWN_PROPERTIES`` must be set to ``false``.

Consult the Jackson documentation for a list of all configurable
items:

- `Jackson Deserialization features <https://github.com/FasterXML/jackson-databind/wiki/Deserialization-Features>`__
  can be set using ``Deserialization.`` as a prefix. E.g., ``Deserialization.FAIL_ON_UNKNOWN_PROPERTIES``

- `Jackson Serialization features <https://github.com/FasterXML/jackson-databind/wiki/Serialization-features>`__
  can be set using ``Serialization.`` as a prefix. E.g., ``Serialization.WRITE_ENUMS_USING_INDEX``

**Path Properties**

Properties prefixed with ``PATH.`` are used in resource paths on calling activities. 
If your target resources contain templates like ``{api.version}`` which 
re-occur on every instance of a call activity, you should set it as a global 
path property in the REST Client, rather than re-declaring it on every instance 
of the calling element.

Example:

If a valid resource of your remote service looks like this: ``https://api.twitter.com/{api.version}/status/...``

Then the path template ``{api.version}`` can be set globally on the REST Client
as a property:

+------------------+----------+
| Property         | Value    |
+------------------+----------+
| PATH.api.version |    2     |
+------------------+----------+

The resolved URI would consequently be: ``https://api.twitter.com/2/status/...``

**Connection Properties**

You can configure the library used to create and manage connections by setting a
connector provider ``jersey.client.connectorProvider``. By default, the Apache
HTTP Client (``org.glassfish.jersey.apache.connector.ApacheConnectorProvider``)
is used. This library uses a connection pool to reuse connections. By default,
the connection pool is limited to 5 connections. You can see how many
connections are currently in use by looking at the :ref:`life stats
<engine-cockpit-monitor-services>` in the :ref:`engine-cockpit`. If all
connections are in use most of the time, consider increasing the maximum number
of connections in the pool to avoid performance issues. Configure it by setting
the property ``jersey.client.pool.maxConnections``. 

As an alternative to the Apache HTTP Client, you can use ``java.net.URLConnection`` from the Java core library 
(``org.glassfish.jersey.client.HttpUrlConnectorProvider``). This connection provider does not have a maximum connection limit 
but has other restrictions like missing NTLM support.


Dynamic Properties
^^^^^^^^^^^^^^^^^^
You may need to adjust property values for multiple runtime environments. 
E.g., you call different service URIs for test and production, 
consequently with different credentials or OAUTH2 application identifiers.

If you anticipate this need, then you can simplify these configuration
adjustments for operations by using :ref:`dynamic-config` expressions in both
properties and other configuration values. E.g., the property
``appId=${ivy.var.cloudAppId}`` is evaluated at runtime and has the value of
the variable called ``cloudAppId``. Thus, your database name is now configurable
using variable ``cloudAppId``. Operations need to set this variable correctly; they
do not need to dive into the configuration of this external database.

