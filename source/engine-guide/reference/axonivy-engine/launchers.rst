.. _axonivy-engine:

.. _engine-launchers:

Engine Launchers
================

These programs start an instance of an Axon Ivy Engine.

.. tip::
    An Axon Ivy Engine can also be started as a service. For more information
    see section :ref:`engine-service`.


.. rubric:: Launchers

The following program launchers are available for the Axon Ivy Engine:

+---------------------------------+----------+-----------------+
| Launcher                        | Platform | Console support |
+=================================+==========+=================+
| :file:`bin/AxonIvyEngine.exe`   | Windows  | no              |
+---------------------------------+----------+-----------------+
| :file:`bin/AxonIvyEngineC.exe`  | Windows  | yes             |
+---------------------------------+----------+-----------------+
| :file:`bin/AxonIvyEngine`       | Linux    | yes             |
+---------------------------------+----------+-----------------+


.. rubric:: Options

The following options are available for the Axon Ivy Engine:

+--------------+-----------------------------------------------------------------------------------------------------------------------------------------------------+-----------+
| Option       | Description                                                                                                                                         | Mandatory |
+==============+=====================================================================================================================================================+===========+
| -start       | Starts the engine. Same behavior as if no options are given. Allows to stop the engine by pressing a key in the console if a console is available.  | no        |
+--------------+-----------------------------------------------------------------------------------------------------------------------------------------------------+-----------+
| -startdaemon | Starts the engine as a background process. Does not allow to stop the engine by pressing a key in the console.                                      | no        |
+--------------+-----------------------------------------------------------------------------------------------------------------------------------------------------+-----------+
| -stop        | Stops the engine. Only initiate the stop but will not wait until the engine has really stopped.                                                     | no        |
+--------------+-----------------------------------------------------------------------------------------------------------------------------------------------------+-----------+
| -stopdaemon  | Stops the engine running as a background process. Will wait until the engine has really stopped.                                                    | no        |
+--------------+-----------------------------------------------------------------------------------------------------------------------------------------------------+-----------+
| -restart     | Restarts the engine. If the engine is running, it will stop it. Then, start the engine again.                                                       | no        |
+--------------+-----------------------------------------------------------------------------------------------------------------------------------------------------+-----------+
| -status      | Prints the current status of the engine.                                                                                                            | no        |
+--------------+-----------------------------------------------------------------------------------------------------------------------------------------------------+-----------+
| -maintenance | Starts the engine in maintenance mode.                                                                                                              | no        |
+--------------+-----------------------------------------------------------------------------------------------------------------------------------------------------+-----------+
