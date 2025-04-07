.. _webservice-clients-configuration:

Web Service Clients
===================

The web service clients tree contains the definition of all web
services consumable by an |ivy| process.

.. figure:: /_images/designer-configuration/webservice-client-editor.png
   :alt: Web Service Clients Editor

   Web Service Clients Editor


Web Service Clients Tree
------------------------

Shows the web service clients.

- :guilabel:`Add Client`
  Adds a new web service client.

- :guilabel:`Remove`
  Remove the current selection.


Client Details Editor
---------------------

Details of the currently selected web service configuration node are
displayed on the right hand side. In this editor, you can change details of a tree
element.

Web Service Client Section
~~~~~~~~~~~~~~~~~~~~~~~~~~

The following attributes are available in the *Web Service* Section:

- :guilabel:`Name`
  The name attribute specifies the displayname of a web service
  configuration. The name is not used as identifier, so it can be
  changed at any time.
  
- :guilabel:`Icon`
  Choose an icon that represents the system that this web service
  communicates with. The icon will also be used as decorator icon on 
  Web Service process elements that references this web service.  

- :guilabel:`Description`
  Description of the web service. This field is for documentation
  purposes only.

- :guilabel:`WSDL URL`
  Service details and classes will be generated using the WSDL
  specified here. Please **use protocol prefixes** like:
  https://myserver.ch/hello.wsdl or file:/c:/temp/myWis.wsdl

- :guilabel:`Library` Select the library |ivy| uses to generate the web service
  client classes.

- :guilabel:`Generate WS classes` After specifying the mandatory fields
  :guilabel:`WSDL URL` and :guilabel:`Library`, click 
  :guilabel:`Generate WS classes` to read the WSDL and generate client classes. 
  The generated files are compiled and packaged into a jar file. The generated 
  jar file is located in the *lib_ws/client* folder of the |ivy| project and
  automatically added to the project libraries.

.. note::

   If you change the :guilabel:`WSDL URL`, the :guilabel:`WSDL` (i.e., the
   functionality or data structure of the Service) or the :guilabel:`Library`
   setting, you **must** re-generate the service classes.



Authentication Section
~~~~~~~~~~~~~~~~~~~~~~

.. figure:: /_images/designer-configuration/webservice-client-auth.png
   :alt: Authentication Section

   Authentication Section

Configures the authentication scheme and data used to authenticate with the
remote web service. The following attributes are available in the
*Authentication* section:

- :guilabel:`Type`
  The authentication type to be used. The available authentication
  types depend on the selected library.

- :guilabel:`Username`
  Name of the user used to authenticate the client. Will be stored as a
  property.

- :guilabel:`Password`
  Password of the user used to authenticate the client. Will be stored
  as a property.

.. tip::

   Authentication properties like (``username`` and ``password``) can be
   overridden in the :ref:`process-element-web-service-call-activity`
   that performs the call to the remote service. In these activities,
   authentication properties can contain scripted or dynamic values.



Features Section
~~~~~~~~~~~~~~~~

.. figure:: /_images/designer-configuration/webservice-client-features.png
   :alt: Features Section

   Features Section
   

Features add optional functionality to a web service client call
execution.

- :guilabel:`Add`
  Adds a new feature class to the list. All specified feature classes
  must implement the JAX-WS standard class
  `javax.xml.ws.WebServiceFeature <https://docs.oracle.com/javase/9/docs/api/javax/xml/ws/WebServiceFeature.html>`__
  or
  ``ch.ivyteam.ivy.webservice.exec.feature.WebServiceClientFeature``.

- :guilabel:`Remove`
  Removes the selected feature class from the list.



Properties Section
~~~~~~~~~~~~~~~~~~

.. figure:: /_images/designer-configuration/webservice-client-properties.png
   :alt: Properties Section

   Properties Section

Properties configure the web service client and its features. Some well
known properties are documented here:
`javax.xml.ws.BindingProvider <https://docs.oracle.com/javase/9/docs/api/javax/xml/ws/BindingProvider.html>`__

- :guilabel:`Add`
  Adds a new property.

- :guilabel:`Add Password`
  Adds a new password property. The value of a password property is not
  visible in the table and is stored encrypted in the configuration
  file.

- :guilabel:`Remove`
  Removes the selected property.

.. tip::

   In order to configure SSL client authentication for a web service,
   you need to specify the property *SSL.keyAlias*. The value of this
   alias needs to correspond with a key alias available in the client
   keystore configured in :ref:`engine-cockpit-ssl`.


Endpoint URIs Section
~~~~~~~~~~~~~-~~~~~~~

.. figure:: /_images/designer-configuration/webservice-client-endpoint-uris.png
   :alt: Endpoint URIs Section

   Endpoint URIs Section


The following attributes are available in the *Ports* section:

- :guilabel:`Ports` 
  The list of ports is available after web service client
  classes generation. (see: Generate WS classes). The content of this list
  originates from the specified WSDL and is populated with information from the
  client framework.

- :guilabel:`Default URI`
  The URI of the current web service. The initial URI is derived from the WSDL.
  You can override this setting if the address has changed.

- :guilabel:`Fallback URIs` An optional list of URIs. They are used as fallbacks
  if any error happens during the web service request. The default endpoint will
  be called first, then the fallback URIs in the order they are specified.
  Servers on the list are queried one by one until a successful web service
  invocation is achieved, or no more fallbacks are available. You find error
  messages in the runtime log when endpoint invocations fail. If a service
  invocation is successful, then the process continues.

  This list is optional. If this list is empty and no default URI is specified
  then an exception is raised during the call; the process continues with
  error handling.


Dynamic Endpoint URIs
^^^^^^^^^^^^^^^^^^^^^^^^^
You may need to adapt the endpoint URI to call according to your runtime
environment. E.g., you may have different endpoints for staging and production.
Therefore, we support :ref:`dynamic-config` expressions in URIs. 
An endpoint URI defined as  ``http://${ivy.var.erpHost}/soap/service`` 
will consume the host to call from the variable named ``erpHost``. 

The same mechanisms also work in properties alike, so you can also
re-use a variable to inject the credentials used to authenticate 
the service call.

Refer to :ref:`dynamic-config` for additional information.

