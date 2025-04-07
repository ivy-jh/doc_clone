.. _deployment-maven-plugin:

Maven Plugin
------------

If you have Maven available in your
environment, use our :ref:`deployment-maven-plugin`, which supports both
deployment types.

The Maven `project-build-plugin
<http://axonivy.github.io/project-build-plugin/>`_ makes automated continuous
deployment to an Axon Ivy Engine possible. The Maven plugin can deploy projects
file based or via HTTP. The file based mechanism is the default.

For the :ref:`file based deployment <deployment-deploying>` the deployment 
folder must be available on the same machine on which the build is
executed. You may use Windows-Shares or SMB-Configurations.

On the other hand the HTTP deployment is based on the :ref:`REST API<deployment-rest-api>` 
service of the Axon Ivy Engine. For the deployment you
need the credentials of an administrator.



.. _deployment-maven-plugin-command-line:

Command Line Deployment
^^^^^^^^^^^^^^^^^^^^^^^

The :code:`deploy-to-engine` goal can be execute on the command line. The
following two examples deploys the project :file:`myProject.iar` to the
application **portal** of the Axon Ivy Engine.

.. code:: bash

    #  file based deployment to c:/axonivy/engine
    mvn com.axonivy.ivy.ci:project-build-plugin:12.0.0:deploy-to-engine \
      -Divy.deploy.file=myProject.iar \
      -Divy.deploy.engine.dir=c:/axonviy/engine \
      -Divy.deploy.engine.app=portal


.. code:: bash

    # http based deployment to http://localhost:8080/
    # default credentials admin/admin used for demo engine
    mvn com.axonivy.ivy.ci:project-build-plugin:12.0.0:deploy-to-engine \
      -Divy.deploy.file=myProject.iar \
      -Divy.deploy.method=HTTP \
      -Divy.deploy.engine.url=http://localhost:8080/ \
      -Divy.deploy.engine.app=portal


.. _deployment-maven-plugin-build:

Goal Execution with POM
^^^^^^^^^^^^^^^^^^^^^^^

The :code:`deploy-to-engine` goal can also be executed with a given :file:`pom.xml` file. 
The configuration where to deploy the project can then be configured in the :file:`pom.xml`.

The following :file:`pom.xml` snippet deploys the current project to the
application **portal** of the Axon Ivy Engine at :file:`c:/axonivy/engine`.

.. literalinclude:: deployment-maven-build.xml
  :language: xml
  :linenos:


Execute the :code:`deploy-to-engine` goal in the directory where the :file:`pom.xml` file is located:

.. code:: bash

    mvn ivy:deploy-to-engine


The next example deploys the current project to the application **portal** to an
Axon Ivy Engine which is accessible at http://localhost:8080. You
need to configure the credentials of an administrator user in the maven
:file:`settings.xml` file. Your custom defined :file:`serverId` must match with
:code:`deployServerId`.

.. literalinclude:: http-deployment-maven-build.xml
  :language: xml
  :linenos:

.. literalinclude:: http-deployment-settings.xml
  :language: xml
  :linenos:

Bind to Maven Lifecycle
^^^^^^^^^^^^^^^^^^^^^^^

To deploy an ivy-archive (IAR) during it's maven build `lifecycle
<https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html>`_,
configure an :code:`execution` which binds the :code:`deploy-to-engine` goal to a lifecycle phase.

.. literalinclude:: lifecylce-deployment-maven-build.xml
  :language: xml
  :linenos:
  
Execute the maven lifecycle in the directory where the :file:`pom.xml` file is located:

.. code:: bash

    mvn site-deploy 

Further examples are documented on GitHub in the :link-url:`project-build-examples
<build-examples>` repository.
