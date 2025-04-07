.. _deployment-configure-app:

Application Configuration
^^^^^^^^^^^^^^^^^^^^^^^^^

You can deploy the configuration of your application with the application zip.
Do so by adding a :file:`config` folder, that contains the :file:`.yaml`
configuration files like the :ref:`app-yaml`. This means that the application
configuration can be fully managed in a CI/CD pipeline instead of depending on
manual clicks in the engine cockpit.

::

    app.zip
    ├── config
    │   └── app.yaml
    ├── hr.iar
    └── finance.iar

.. literalinclude:: sample-app.yaml
  :language: yaml
  :linenos:

.. rubric:: Priority

The :file:`app.yaml` will be deployed into the :file:`config` folder of the
application itself (:file:`applications` directory) and serves as additional
configuration for the application, but with a lower priority than the regular
:ref:`<appName>/app.yaml <app-yaml>` (e.g., :file:`myApp/app.yaml`) in the
:file:`configuration` directory.


.. rubric:: Overriding Variables

The :file:`app.yaml` file can override :ref:`variables` declared in projects.
If these variables are values of type file (e.g :code:`[file: json]`), then
these files values can also be overriden by adding them to the :file:`app.zip` 
in :file:`<app.zip>/config/variables/myVariableName.json` as shown below.

::

    app.zip
    ├── config
    │   |──variables
    |   |  └─ userSettings.json
    │   └── app.yaml
    ├── finance.iar
    └── hr.iar

