System
------


.. _engine-cockpit-system-admins:

Administrators
^^^^^^^^^^^^^^

The **Administrators** page allows you to manage users with administrator
privileges. Any changes are stored to the :ref:`ivy-yaml` file. 

You need to specify an email address for administrators. The Axon Ivy Engine 
send notifications of critical events to the administrators, e.g., license violations.

.. note::
    Changes to administrators will only take effect after you restart the
    engine.

.. figure:: /_images/engine-cockpit/engine-cockpit-system-admins.png


.. _engine-cockpit-systemdb:

System Database
^^^^^^^^^^^^^^^

In the **System Database** page you to manage the system database configuration.
Any changes are stored in the :ref:`ivy-yaml` file. 

Please refer to the :ref:`Setup Wizard <setup-wizard-systemdb>` documentation
on how to configure your engine's system database.

.. warning::
    Before you save your configurations, be sure you can connect to the
    database. Otherwise you may have problems when restarting the engine.

.. note::
    Changes to system database will only take effect after you restarting the
    engine.

.. figure:: /_images/engine-cockpit/engine-cockpit-system-database.png

System Database Info
""""""""""""""""""""

If you need information about your system database, click the
:guilabel:`Info` button. The **System Database Info** page opens 
and shows Information about your database, driver, tables, triggers, and indices. 
You can see how much disk space the database, table, and indices use. 
The number of rows for tables and cardinality for indices gives you an idea of how much data is stored. 
The fragmentation gives you an indication if a reorganization of your database is recommended. 

.. _engine-cockpit-license:

License
^^^^^^^

In the **License** view you can upload or renew a license. If you have a valid
license you see a table with all information about it. On the right side you
have a life overview of your active sessions with the ability to kill sessions.

.. figure:: /_images/engine-cockpit/engine-cockpit-licence.png


.. _engine-cockpit-web-server:

Web Server
^^^^^^^^^^

In the **Web Server** view, you can quickly change your Tomcat Connectors or
reverse proxy server settings. There is also a data panel which shows you all
the headers of the current request and how the engine generates some URLs.

You may also get some messages here. These appear if the URL of your browser and
the **external base URL** or the configured **base URL** do not match. If this
is the case please refer to how to properly set up a :ref:`reverse proxy
<reverse-proxy>`.

.. figure:: /_images/engine-cockpit/engine-cockpit-web-server.png


.. _engine-cockpit-system-configuration:

System Configuration
^^^^^^^^^^^^^^^^^^^^

The **System Configuration** page displays an overview of all your engine
configuration settings. Configurations in grey represent default values. If
you want to edit an existing configuration, click on the :guilabel:`Pencil`
button. Clicking :guilabel:`More` allows you to reset a configuration setting or
view the complete configuration file.

.. warning::
    Application configurations are not shown in this view. You can see application
    configuration settings on page :ref:`engine-cockpit-application-detail`.

.. note::
    For more information about the configuration, please refer to the
    :ref:`configuration` section. 

.. figure:: /_images/engine-cockpit/engine-cockpit-system-config.png

.. _engine-cockpit-ssl:

SSL Settings
^^^^^^^^^^^^^^^^^^^^

These settings define the key and trust stores to be used for SSL/TLS
client connections.


A key store is used to read client keys (certificates). This is only
required if a server requests a client certificate in order to
authenticate the client.

A trust store is used to specify trusted server certificates or
certificates of certification authorities. An SSL client authenticates a
server by using the certificates in a trust store. If the server
provides a certificate that is signed by a certification authority known
by Java then the system trust store can be used. If the server uses a
certificate that is self signed or signed by a unknown certification
authority then a custom trust store can be used. The custom trust store
must contain the server certificate or the certificate of the unknown
certification authority.


.. figure:: /_images/engine-cockpit/engine-cockpit-SSL-client.png
   :alt: SSL Client
   :align: center
   

Key Store Settings
   Use custom key store
      If selected the key store configured below is used to read the
      client's key. A client key is only necessary if the server
      requests SSL client authentication. If not selected the system
      keystore is used. The system keystore can be configured by setting
      the Java system property ``javax.net.ssl.keyStore``.

   Key store file
      The file containing the client keys.

   Key store password
      Password used to read the key store file.

   Key password
      Password needed to decrypt the key. If empty the key store
      password is used instead.

   Key store type
      The type of the key store (e.g., JKS or PKCS12). If empty the
      system default type is used.

   Key store provider
      The security provider used to read the key store. If empty the
      system default provider is used.

   Key store algorithm
      The algorithm used to read the key store. If empty the system
      default algorithm is used.

Trust Store Settings
   Trust store file
      The file containing the trusted server certificates and/or
      certificates of certification authorities.

   Trust store password
      Password used to read the trust store file.

   Trust store type
      The type of the trust store (e.g., JKS or PKCS12). If empty the
      system default type is used.

   Trust store provider
      The security provider used to read the trust store. If empty the
      system default provider is used.

   Trust store algorithm
      The algorithm used to read the trust store. If emtpy the system
      default algorithm is used.

Key & Trust Store Certificates Table
      In the certificate table you can view all the certificates of the store. 
      You can see whether the certificate is valid or not. If you move the
      mouse cursor over the icon, a message is displayed explaining why the
      certificate is no longer valid. You will also see information about
      the alias, subject, algorithm and expiry date. It is possible to add
      or delete certificates as needed.


Other SSL Settings
   Enable insecure SSL and HTTPS connections
      Manipulates the JVMs default SSLSocketFactory, so that untrusted
      (self signed or outdated) certificates are silently accepted. This
      could for instance be useful to generate a Webservice stub from an
      insecure WSDL location.

   Modification of certificates
      Key and trust stores can also be created and modified (generating and
      importing certificates and keys) using a graphical key tool such as 
      KeyStore Explorer or the key tool included in the Java Development Kit
      (JDK). More information can be found in the JDK documentation.
   

.. note::

   The SSL Client trust- and key store settings are currently only
   considered when sending mails, for REST client calls, CXF Web Service
   client calls and when loading web service definition (WSDL) files.

.. _engine-cockpit-tls:

TLS Connenction Tester
^^^^^^^^^^^^^^^^^^^^^^^^^^

With the TLS Connection Tester you can test secure connections to WebServices 
(SOAP/REST) or active directories (LDAPS). This can be tested directly in 
the Engine-Cockpit next to the connection tester. Supported TLS standards
are detected and reported. Currently trusted certificates are printed and 
untrusted certificates are reported.

.. figure:: /_images/engine-cockpit/engine-cockpit-tls-tester.png
   :alt: TLS Tester
   :align: center

.. _engine-cockpit-config-editor:

Config File Editor
^^^^^^^^^^^^^^^^^^^^^

Configurations applied in the Engine Cockpit are stored in files.
The Config File Editor lets you review and modify these configurations.

.. figure:: /_images/engine-cockpit/engine-cockpit-config-file-editor.png

In the right upper corner, you can select the configuration file to be shown.

While editing our prominent YAML files, you have a rich set of authoring features at hand:

- **Validation**: keys used within the YAML files are validated against the official schema. So invalid values are being blamed with a warning marker.
- **Completion**: by pressing `CTRL+Space` the context completor helps you to identify and select valid configuration values or keys.
- **Help**: by hovering over keys you get context-specific documentation right where you are editing.
- **Formatting:** YAML content has strict formatting rules, and the editor takes care that whitespace indents are correct and in effect.

Note that all our text-based configuration files are editable, though the authoring features may be limited on some.

.. _engine-cockpit-cluster:

Cluster
^^^^^^^

If your engine runs with a :ref:`license-edition` license, your are able to
define a :ref:`cluster`. The engine cockpit will provide a **Cluster**
navigation menu item. It shows you an overview page of your running nodes and a
detail view dialog if you click on one of these node.

.. figure:: /_images/engine-cockpit/engine-cockpit-cluster.png
