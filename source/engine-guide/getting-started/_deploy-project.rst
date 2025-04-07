Deploy an Axon Ivy Project
--------------------------

.. hint:: In this chapter, we use just one of the deployment methods available. 
    For details, refer to :ref:`Chapter Deployment <deployment>`.

Let's deploy an Axon Ivy project to the Axon Ivy Engine. 


First, navigate to the :file:`deploy` directory and download the demo
application to that directory.

.. code:: bash

    cd /opt/ivy/engine/deploy
    sudo -u ivy wget https://developer.axonivy.com/permalink/lib/|major-version|/demos.zip

.. Note::

    Here we deploy a new application by dropping a ZIP into the deploy folder. However, it is
    also possible to deploy packed projects (i.e., ``.iar`` archives) or unpacked projects.

You can monitor the deployment with:

.. code:: bash

    tail -f demos.zip.deploymentLog

As soon as the deployment has finished successfully, the zip file is postfixed with
:file:`.deployed`, e.g., :file:`demos.zip.deployed`. 
In case of an error, the postfix :file:`.notDeployed` is added, e.g., :file:`demos.zip.notDeployed`.

.. Note::

    An Axon Ivy Engine can run multiple applications at the same time. 
    
    Security Systems manage their users, tasks and cases. One or more
    applications can use a security system. Therefore, cases and tasks of all
    applications in a security system are visible in all applications within
    that security system.
    
    Therefore, you can use separate security systems to build multitenancy or
    stages (DEV, Q&A, PROD) without installing one Axon Ivy Engine per tenant
    and/or stage.

Refresh the main page of the Axon Ivy Engine. You see a new application.
Congratulations - you have installed and configured your first Axon Ivy Engine
and also deployed your first Axon Ivy processes!
