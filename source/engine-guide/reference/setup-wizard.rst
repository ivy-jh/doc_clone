.. _setup-wizard:

Setup Wizard
============

The Setup Wizard is a simple user interface for operators to apply the 
initial configuration that is necessary to turn a demo engine into a
productive Axon Ivy Engine instance. This includes among other steps the installation of a
license and the creation of a system database.

.. note::
    The changes that you make with the :ref:`setup-wizard` do not become active
    unless you restart the engine. However, configurations are constantly written
    from the wizard to the :ref:`ivy-yaml` file.

Advanced users might prefer to manually craft configurations in :ref:`ivy-yaml` and 
use the :ref:`engine-config-cli` to roll out an Axon Ivy Engine into production.
Configuration files make the installation process quickly reproducable in
various environments such as dev, test and prod.


.. _setup-wizard-launchers:

Launchers
---------

Start the :ref:`axonivy-engine` using its launcher. 
If the engine runs in the :ref:`demo-mode` you see a warning on
the info page with a link to the :ref:`setup-wizard`. 
E.g., http://myServer:myPort/system/engine-cockpit/faces/setup.xhtml

If you are not able to start the Axon Ivy Engine anymore, you can remove the
installed license file from the :file:`configuration` directory. The
Axon Ivy Engine should now start up in :ref:`demo-mode`.

.. note::
    For the usage of this tool, you will need an administrator user account. 
    If you run in :ref:`demo-mode` the name of the default administrator user
    is **admin** and the password is **admin** too.


.. _setup-wizard-license:

License
-------

In the :guilabel:`License` step you have to upload a valid license:

.. figure:: /_images/engine-cockpit/engine-cockpit-setup-licence.png

Use the :guilabel:`Choose license` button to open the file browser and select
the license file which should be used or simply drop your license file inside the marked
field.

.. note::
    It is possible to configure the engine without a valid license, but the
    engine will always start in the :ref:`demo-mode` if you do not have a valid license
    and therefore cannot use your configuration. 


.. _setup-wizard-admins:

System Administrators
---------------------

On the :guilabel:`Administrators` step you can configure users that have the
right to administer the Axon Ivy Engine:

.. figure:: /_images/engine-cockpit/engine-cockpit-setup-admins.png

Defining an email address for the administrators is mandatory. Notifications of
critical events, such as license violations, are sent to administrator email
addresses.

.. _setup-wizard-webserver:

Web Server Ports
----------------

In the :guilabel:`Web Server` step you enable and configure the web protocols of
the Axon Ivy Engine. Furthermore, you can customize the IP port bindings:

.. figure:: /_images/engine-cockpit/engine-cockpit-setup-webserver.png

The following protocols are supported:

+----------+--------------------------------------------------------------------------------------------------------------------------------------------------+
| Protocol | Description                                                                                                                                      |
+==========+==================================================================================================================================================+
| HTTP     | HTTP protocol                                                                                                                                    |
+----------+--------------------------------------------------------------------------------------------------------------------------------------------------+
| HTTPS    | HTTP protocol over secure socket layer (SSL).                                                                                                    |
+----------+--------------------------------------------------------------------------------------------------------------------------------------------------+

.. _setup-wizard-systemdb:

System Database
---------------

In the :guilabel:`System Database` step the Axon Ivy Engine, you can configure,
create and convert system databases:

.. figure:: /_images/engine-cockpit/engine-cockpit-setup-systemdb.png

First choose the database system and the JDBC driver you want to use. At the
moment the Axon Ivy Engine supports the following database systems:

* :ref:`MySQL <systemdb-mysql>`
* :ref:`MariaDB <systemdb-mariadb>`
* :ref:`Oracle <systemdb-oracle>`
* :ref:`Microsoft SQL Server <systemdb-mssql>`
* :ref:`Postgre SQL <systemdb-postgres>`

In the second part you need to define you connection settings. These depend on
the chosen **database system** and **JDBC driver**. Click on the database system links above to find information about how
to configure the connection settings. The applied db user needs the following
privileges:

* ``CREATE DATABASE`` (to create the system database out of the Engine Configuration)
* ``CREATE``, ``ALTER``, ``DROP``: Tables, Views, Indexes, Triggers (to update the Axon Ivy Engine)
* ``INSERT``, ``SELECT``, ``UPDATE``, ``DELETE`` data

In a third step, you may configure additional connection properties. When
clicking on the :guilabel:`Add Property` button a dialog will allow you to add
properties. See :ref:`systemdb` to find information which additional connection
properties are available for the database system that you have chosen.

At the top of the page the state of the connection is visible. Use the button
:guilabel:`Check Connection` to try to connect to the system database once you
have finished your configuration.


.. _setup-wizard-systemdb-create:

Create New System Database
^^^^^^^^^^^^^^^^^^^^^^^^^^

If the system database does not exist, use the :guilabel:`Create Database`
button to create a new **system database**. During the creation of a new
database the configured connection settings are used. Some additional
information may be required. It has to be defined in the **creation dialog**.
See :ref:`systemdb` to find what additional information is necessary for the
chosen database system.

.. note::
    You can previously create an empty database/schema. In this case the wizard
    will only create the necessary tables into the given
    database/schema. If the database/schema doesn't exist already, the wizard
    creates it with a best practice configuration. In this
    case the applied db user needs the following privileges:
    
    * ``CREATE``, ``ALTER``, ``DROP``: Tables, Views, Indexes, Triggers (to update the
      Axon Ivy Engine)
    * ``INSERT``, ``SELECT``, ``UPDATE``, ``DELETE`` data
 
    The best practice configurations are documented in chapter :ref:`System
    Database <systemdb>`.
