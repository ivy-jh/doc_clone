Engine Modes
============
The Axon Ivy Engine runs in different modes. If you have configured your Axon Ivy Engine
correctly it runs in :ref:`production-mode`. This is the standard mode.
The :ref:`demo-mode` and the :ref:`maintenance-mode` are special modes in which
your Axon Ivy Engine only runs if you have not yet configured it or there are
problems with your configuration.


.. _production-mode:

Production Mode
---------------
This is the standard mode. Ensure you run your Axon Ivy Engine in this mode. The
production mode is active if a valid license is installed and a system database
is configured and available in the correct version.


.. _demo-mode: 

Demo Mode
---------
Axon Ivy Engine offers a demo mode for demonstration purposes. The demo mode
allows you to install and start the Axon Ivy Engine without configuration and
without a productive license.  You can play with the Axon Ivy Engine. Try out
the :dev-url:`Portal </market/portal>` and :ref:`Cockpit <engine-cockpit>`,
deploy projects, etc. The username of the administrator in demo mode is
**admin** and password **admin**. 

.. warning:: 
    The Axon Ivy Engine uses an in-memory database as system database in demo mode.
    This means that all your data, all cases that are created by any sessions in
    demo mode are lost when you shut down the Axon Ivy Engine.


.. _maintenance-mode:

Maintenance Mode
----------------
In the maintenance mode you can use the :ref:`engine-cockpit` to fix license or
system database configuration problems. 

.. warning::
    In maintenance mode all functions of the Axon Ivy Engine except the
    :ref:`engine-cockpit` are disabled! 

The Axon Ivy Engine starts automatically in maintenance mode if there is a
problem with the license or the system database. You can disable the
automatic switch to maintenance mode in the :ref:`ivy-yaml` file:

.. code:: yaml

  Boot.MaintenanceMode: DISABLED

If mainteance mode is disabled and there is a license or system database problem the Axon Ivy Engine
will fail to start and will report an error. You can then start the Axon Ivy Engine
explicitly in maintenance mode by using the :ref:`command line option
<axonivy-engine>` :code:`-maintenance`.
