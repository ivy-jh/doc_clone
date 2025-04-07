Services
--------

.. _engine-cockpit-notification-channels:

Notification Channels
^^^^^^^^^^^^^^^^^^^^^

The **notification channels** view shows all available channels where user
notifications can be sent to. Each channel has its own configuration and
has an own state which indicates if the channel is properly working. You can configure
a channel by  :ref:`clicking <engine-cockpit-notification-channel-detail>` on it.

.. figure:: /_images/engine-cockpit/engine-cockpit-notification-channels.png


.. _engine-cockpit-notification-channel-detail:

Notification Channel Detail
^^^^^^^^^^^^^^^^^^^^^^^^^^^

Each channel has its own configuration. A channel can be enabled/disabled and you
can configure the default subscription settings. Users can override the subscriptions
in their own profiles.

.. figure:: /_images/engine-cockpit/engine-cockpit-notification-channel-mail.png



Databases
^^^^^^^^^

The **databases** view displays an overview of your configured databases within
your projects. You can switch the application by clicking on the tabs at the top
of the view. To get more information about a database click on an entry to
view its :ref:`engine-cockpit-database-detail` page.

.. note::
    If you want to add a new database configuration, please refer
    to :ref:`database-configuration`.

.. figure:: /_images/engine-cockpit/engine-cockpit-databases.png


.. _engine-cockpit-database-detail:

Database Detail
"""""""""""""""

In the **Database Detail** view you see all configurations of the selected
database. You can test if the configuration works: By clicking on the
:guilabel:`Arrow` button, you direct the engine to try and establish a
connection to this database. You can change most connection properties in this
view. If you click on the :guilabel:`Reset` button the database configuration
will be reset to the original property values. In this view you can also see information
about the last 200 executed *SQL* queries and the connections used, too.

.. note:: 
    Not every property can be modified here yet. But you can override them in the
    :ref:`app-yaml` file.

.. figure:: /_images/engine-cockpit/engine-cockpit-database-detail.png


Web Services
^^^^^^^^^^^^

The **Web Services** page lists all defined web services for each application.
You can switch the application by clicking on the tabs at the top of the view.
To see detailed information about a web service click on an entry to view its
:ref:`engine-cockpit-webservice-detail` page.

.. note::
    If you want to add a new web service, please refer to
    :ref:`Designer Guide
    <webservice-clients-configuration>`.

.. figure:: /_images/engine-cockpit/engine-cockpit-webservice.png


.. _engine-cockpit-webservice-detail:

Web Service Detail
""""""""""""""""""

This view displays all configuration values of a web service. You can change
the credentials or the endpoint settings. You can also reset them to their original
values by clicking on the :guilabel:`Reset` button.

To test if an endpoint is accessible press on the :guilabel:`Arrow` button next to it.
Please be aware that only *Http Basic* authentication is supported and the request is an
empty *POST* message.

.. note:: 
    If you wish to change a value that is not editable in this editor you can
    do so by modifying the :ref:`app-yaml` file.

.. figure:: /_images/engine-cockpit/engine-cockpit-webservice-detail.png


REST Clients
^^^^^^^^^^^^

The **REST Clients** view gives an overview of all REST clients for each
application. You can switch the application by clicking on the tabs at the top
of the view. To see detailed information about a web service click on an entry
to view its :ref:`engine-cockpit-rest-client-detail` page.

.. note::
    If you want to add a new REST client, please refer to
    :ref:`Designer Guide <rest-clients-configuration>`.

.. figure:: /_images/engine-cockpit/engine-cockpit-rest-clients.png


.. _engine-cockpit-rest-client-detail:

REST Client Detail
""""""""""""""""""

The **REST Client Detail** page shows all configuration values of a REST service.
Some of these values can be modified directly in this editor. You can reset your
changes by clicking on the :guilabel:`Reset` button. If you want to test your
configuration settings, click on the :guilabel:`Arrow` button. This will start a
*HEAD* request with defined authentication credentials.

.. note:: 
    If you wish to change a value that is not editable in this editor you can
    do so by modifying the :ref:`app-yaml` file.

.. figure:: /_images/engine-cockpit/engine-cockpit-rest-client-detail.png


Search Engine
^^^^^^^^^^^^^

You can use the **Search Engine** view to display information about your running
Search Engine instance. The information panel shows some configurations and
allows you to directly get to the
:ref:`engine-cockpit-system-configuration` page by clicking on the
:guilabel:`cog` button. To run queries against your Search Engine, click on the
:guilabel:`bug` button.

The **Indices** panel lists all indices from the Search Engine. You can trigger a
*reindex* command or run a document specific query command.

.. figure:: /_images/engine-cockpit/engine-cockpit-search-engine.png

