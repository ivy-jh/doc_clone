.. rubric:: Migration

#. Do a backup of the system database and all of your data of your Axon ivy
   Engine. If you run your Axon Ivy Engine in a Virtual Machine, then you can
   take a snapshot.
#. Use the :ref:`migration-wizard` to migrate your Axon Ivy Engine. The
   migration wizard is responsible to copy the configuration, error pages,
   dropins and many more to the new place. It will also update the schema of the
   system database. You can start using the wizard by starting the new
   |ivy-engine|. Browse to the |ivy-engine| URI (e.g., http://localhost:8080)
   and click on ``Setup Wizard`` > ``Migration Wizard``.
#. Restart your Axon Ivy Engine.
#. Apply the :ref:`migration-upgrade-engine-post`.
