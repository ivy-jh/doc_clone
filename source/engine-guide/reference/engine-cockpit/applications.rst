.. _engine-cockpit-application:

Applications
------------

The **applications** page lists all workflow applications running on the engine. 

You control the state of these applications with start, stop and lock actions.
Each application has its process models and process model versions. They can be
started and stopped separately. You can add a new application by clicking on the
:guilabel:`Add` button. By clicking on an application, you switch to the
:ref:`engine-cockpit-application-detail`. A click on a process model version will
open the :ref:`engine-cockpit-pmv-detail` view.

To deploy new versions of an application, you click on the :guilabel:`Deployment`
button. This opens the **Deployment Dialog**. See
:ref:`engine-cockpit-application-detail` for more information about the deployment
dialog.

.. figure:: /_images/engine-cockpit/engine-cockpit-applications.png


.. _engine-cockpit-application-detail:

Application Detail
^^^^^^^^^^^^^^^^^^

The **Application detail** page shows information similar to the Dashboard
but specifically for the chosen application. In this page, you can change the 
:ref:`engine-cockpit-security-system`, start or stop the
application and edit the application's configuration settings.

If you want to deploy a project, click on the :guilabel:`Deployment` button and select
your :file:`.iar` or :file:`.zip` file. Note that you can set additional deployment
options here; see chapter :ref:`deployment-options` for more information. To be able to
use this feature the :ref:`deployment-rest-api` feature needs to be enabled in the
(:ref:`security-engine-optional-features`).

.. note:: 
    For CI/CD pipeline deployments refer to the :ref:`deployment-deploying`
    chapter.

.. figure:: /_images/engine-cockpit/engine-cockpit-application-detail.png


.. _engine-cockpit-pmv-detail:

Pmv Detail
^^^^^^^^^^

The detail page of the **process model version** displays all information
about a individual process model version. This includes basic information, 
activity state and lists all dependencies from and to this process model version.

.. figure:: /_images/engine-cockpit/engine-cockpit-pmv-detail.png

