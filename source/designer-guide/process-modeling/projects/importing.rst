
.. _designer-import-project:

Importing a Project
--------------------

You can import existing Axon Ivy projects into your workspace using the
*Import Wizard*. Projects can be exported from the workspace using the
*Export Wizard* (See section :ref:`designer-export-project`.
This allows you to exchange or share your projects with other people.

Accessibility
~~~~~~~~~~~~~

You can access the Import Wizard over the menu:

*File -> Import ...*

Features
~~~~~~~~

For Axon Ivy users the following import sources and formats are useful:

General > Existing Projects into Workspace
   Imports a project from a project directory located somewhere in the
   file system into the workspace. The project directory may or may not
   be located in the workspace directory.

   .. figure:: /_images/ivy-project/project-import.png

   In the wizard page seen above you can select either the directory
   where your project(s) resides or a archive file (zip, jar, tar-gz)
   that contains the project(s). If Axon Ivy finds valid projects in the
   given directory or archive file, they can be (de-)selected for the
   import and you can decide whether the projects should be copied into
   your workspace directory or not (which has no effect if a project
   already is in the workspace directory). After clicking on the button
   *Finish* the import is performed and you will find the imported
   projects in the :ref:`ivy-project-view`.

Axon Ivy > Axon Ivy Archive (\*.iar)
   Imports Axon Ivy Archives (\*.iar) into the workspace.

   .. figure:: /_images/ivy-project/project-import-wizard.png

   In the wizard page seen above you can select the directory where your
   Axon Ivy Archives resides. If Axon Ivy finds valid Axon Ivy Archives
   in the given directory, they can be (de-)selected for the import and
   you can decide whether the Axon Ivy Archives should be copied into
   your workspace directory or not (which has no effect if an Axon Ivy
   Archive already is in the workspace directory). After clicking on the
   button *Finish* the import is performed and you will find the
   imported Axon Ivy Archives in the :ref:`ivy-project-view`.


.. _importing-demo-projects:

Importing demo projects
~~~~~~~~~~~~~~~~~~~~~~~

The Axon Ivy Designer can import several demo projects, which are
provided from our Market (internet connection needed). Those
demo projects are in the Axon Ivy Archive (\*.iar) format and can be imported
with the help of the :ref:`|ivy| Market <market>` or the *Axon Ivy Projects* link on the welcome page.

The following projects are available for |ivy-designer|:

.. table:: Demo projects for the Designer.

   +--------------------+-------------------------------------------------------------------------------------------------------------------------------------------------------------------+
   | Project name       | Demo content                                                                                                                                                      |
   +====================+===================================================================================================================================================================+
   | ConnectivityDemos  | Demonstrates the consuming and providing of :ref:`integration-rest` with ivy.                                                                                     |
   +--------------------+-------------------------------------------------------------------------------------------------------------------------------------------------------------------+
   | ErrorHandlingDemos | Samples that demonstrate the :ref:`error-handling`.                                                                                                               |
   +--------------------+-------------------------------------------------------------------------------------------------------------------------------------------------------------------+
   | HTMLDialogDemos    | Demonstrates several JSF components that can be used in :ref:`html-dialogs`.                                                                                      |
   +--------------------+-------------------------------------------------------------------------------------------------------------------------------------------------------------------+
   | QuickStartTutorial | The same project that is built in the :ref:`QuickStart Tutorial <axonivy-workbench>`.                                                                             |
   +--------------------+-------------------------------------------------------------------------------------------------------------------------------------------------------------------+
   | RuleEngineDemos    | Shows how to use the :ref:`rule-engine`.                                                                                                                          |
   +--------------------+-------------------------------------------------------------------------------------------------------------------------------------------------------------------+
   | WorkflowDemos      | Demonstrates how to handle typical Workflow use cases, makes use of features like :ref:`Signals <signal-reference>` and :ref:`business-data`                      |
   +--------------------+-------------------------------------------------------------------------------------------------------------------------------------------------------------------+

