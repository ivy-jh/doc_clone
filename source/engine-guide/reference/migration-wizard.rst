.. _migration-wizard:

Migration Wizard
----------------

The Migration Wizard helps you to migrate all crucial configuration from an old
Axon Ivy Engine installation to your new Axon Ivy Engine.

The Wizard is expected to be run from a downloaded and untouched Axon Ivy Engine.
Please consult the :ref:`migration` chapter for detailed instructions when to use
the wizard on your operating system.

**Start**

#. Start a new, untouched Axon Ivy Engine.
#. Browse to the URI where the engine runs: e.g., http://localhost:8080 .
#. Choose :guilabel:`Setup Engine` > :guilabel:`Migrate Axon Ivy Engine` in your Browser.
   
**Usage**

.. figure:: /_images/engine-cockpit/engine-cockpit-migrate.png

#. Provide the old Axon Ivy Engine installation directory to the Migration Wizard. 
   Note, that the old Axon Ivy Engine must be stopped.
#. Click :guilabel:`Load location`.
#. The Migration Wizard will make up front checks if the engine can be migrated.
#. If you upgrade to a new major version, you will need to provide a new licence file.
   Otherwise you won't be able to start the Axon Ivy Engine after migration.
#. You can inspect all the tasks which will be done and click on :guilabel:`Start`.
#. Wait until the Migration Wizard has completed.
#. Restart the Axon Ivy Engine.
