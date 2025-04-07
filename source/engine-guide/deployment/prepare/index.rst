.. _deployment-prepare:

Prepare
-------

Before deployment, the Axon Ivy project must be available as ivy-archive (IAR)
or packed as a zip-archive (ZIP). Therefore, we recommend building the Axon Ivy
projects with the help of Maven and the `project-build-plugin
<http://axonivy.github.io/project-build-plugin/>`_ which is crafting the
ivy-archives (IAR) in reproducible manor.

In this build process, an
executable :file:`*.iar`` file is generated from the sources of the Axon Ivy
project. Alternatively, the :ref:`export functionality
<designer-export-project>` of the Axon Ivy Designer can also be used.

.. rubric:: Application zip

It is also possible to pack multiple Axon Ivy projects in one single zip-archive
(:ref:`application <application>` zip). All project dependencies must be
resolved, either already installed in the application of the running Axon Ivy
Engine or part of the application zip itself.

::

    app.zip
    ├── hr.iar
    └── finance.iar

Using the Application Zip has a significant advantage over deploying individual
Axon Ivy projects. When deploying the individual Axon Ivy projects, they must be
deployed in the correct order. The sequence is determined by the dependency tree
between the Axon Ivy projects. If you pack all projects into an application zip,
the Axon Ivy Engine can determine the correct sequence itself.

.. Warning:: 

   The projects to be deployed must be at top level in a application zip. Many
   operating systems automatically create a parent folder within the zip. The
   following zip-archive won't be deployed.

   ::

       app.zip
       └── app
           ├── hr.iar
           └── finance.iar


.. rubric:: Advanced options

* You can provide an additional :file:`config` folder in the zip to
  :ref:`configure the application <deployment-configure-app>` at deploy time.
* By providing :file:`deploy.options.yaml` as part of your deployable, you can
  :ref:`influence the deployment behavior <deployment-options>`.
* Take always care of the correct :ref:`versioning <deployment-versioning>` of
  your Axon Ivy Projects.

.. toctree::
   :maxdepth: 1
   :hidden:
   
   application-configuration/index
   deployment-options/index
   versioning/index
