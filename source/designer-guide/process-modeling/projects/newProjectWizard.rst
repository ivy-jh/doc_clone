

.. _project-new-wizard:

New Project Wizard
-------------------

The *New Axon Ivy Project wizard* lets you create a new Axon Ivy
project.

On the first page you must specify the settings that are required for
the new project. After filling those in, you may already press *finish*
to create the new project.

The following pages are optional and you do not have to complete
them. However, they allow you to specify information with regard to
deployment or create a first process without further navigation steps.

Accessibility
~~~~~~~~~~~~~

File -> New -> Axon Ivy Project


Features
~~~~~~~~

.. figure:: /_images/ivy-project/new-project-wizard-1.png
   :alt: New Project Wizard: First Page

   New Project Wizard: First Page

This page lets you define the minimally required settings for a new
project.

Project name
   Chose a name that describes the contents or the purpose of your
   project. You are not allowed to use any special characters or spaces.

Group ID
   Identifies your project uniquely across all projects. It has to
   follow the package name rules, what means that has to be at least as
   a domain name you control, and you can create as many subgroups as
   you want. e.g., ``com.acme.ria``.

Project ID
   You can choose whatever name you want with lowercase letters and no
   strange symbols, e.g., ``users`` or ``user-manager``.

   During deployment to the engine the concatenated Group ID + Project
   ID will act as unique identifier of the project, once it is deployed.

Default namespace
   Define the default namespace for your project. This namespace will be
   used as standard namespace for new Axon Ivy artifacts.

Location
   Defines where to project will be created on your local disk. 
   By default the location will be your eclipse workspace.
   If a project is selected while opening the wizard, the location will
   be adjusted, so that the new project is created as child of the existing project, 
   which is handy to build multi-module projects.
   At any rate, you can adjust the default path to your needs.


Dependencies
~~~~~~~~~~~~~

.. figure:: /_images/ivy-project/new-project-wizard-2.png
   :alt: New Project Wizard: Second Page

   New Project Wizard: Second Page

The second page is optional. It allows you to specify any project from
the workspace as a required project. 
If there are yet no projects in the workspace, this page
isn't being displayed in the wizard.

Required Projects
   Check the projects that the new project should be depend upon. The
   selected projects will automatically be required with the version
   that they currently have in the workspace. The maximum version will
   be left empty.

   You can always reconfigure the required projects at a later point of
   time in the :ref:`project-deployment-descriptor`.

New process
~~~~~~~~~~~~~

.. figure:: /_images/ivy-project/new-project-wizard-3.png
   :alt: New Project Wizard: Third Page

   New Project Wizard: Third Page

The third page is optional. It allows you to quickly define a first
process that will be located in your new project. 

However, you can always skip this page and define processes later on
using the :ref:`process-new-wizard`.

Data Class
~~~~~~~~~~~~~

.. figure:: /_images/ivy-project/new-project-wizard-4.png
   :alt: New Project Wizard: Fourth Page

   New Project Wizard: Fourth Page

An optional page to adjust the Data Class being used by 
the first process, that may have been defined on the previous page.

However, you can change the Data later on if needed.
Detailed description on the Data Class creation can be found under 
:ref:`process-new-wizard-data`.
