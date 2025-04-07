.. _deployment-directory:

Deployment-Directory
--------------------

Our file based deployment mechanism makes the deployment very easy: As soon as
you drop a file in the :ref:`deployment directory <ivy-yaml>`, the deployment is
started immediately if the Axon Ivy Engine is running. Otherwise, the deployment
is executed after the engine has started. 

.. Hint::

  There are sub-directories in the deployment directory for each application.
  The project can be copied to the corresponding sub-directory. You can also
  create a sub-directory manually. In this case, a new application will be
  created. Alternatively, the project can also be placed in the deployment
  directory itself. It is then deployed into the application with the same name
  as the filename.

This is an alternate approach to automate a CI/CD pipeline compared to REST-API.
It is always platform-dependent on which the Axon Ivy Engine is running. Furthermore
you need to verify if the deployment was succesful or not by checking the generated
log files in the deployment directory:

+------------------+------------------------------------------------------------------------+
| File suffix      | Description                                                            |
+==================+========================================================================+
| .deployed        | Last deployed file to the engine in case of a successful deployment    |
+------------------+------------------------------------------------------------------------+
| .notDeployed     | Last not deployed file to the engine in case of error while deployment |
+------------------+------------------------------------------------------------------------+
| .deploymentLog   | Contains the log output which is written during the deployment         |
+------------------+------------------------------------------------------------------------+
| .deploymentError | Contains the error cause and is only written when the deployment fails |
+------------------+------------------------------------------------------------------------+
