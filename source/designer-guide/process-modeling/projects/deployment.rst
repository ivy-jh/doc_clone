

.. _project-deployment-descriptor:

Project Deployment Descriptor
------------------------------

Each Axon Ivy project has a *deployment descriptor*. The deployment
descriptor defines various properties of a project that are important
with respect to deployment on the engine. Specifically the descriptor
defines:

1. A *unique project ID* (i.e., a fully qualified symbolic name) for the
   project, by which it can be identified and referenced. Also a current
   *development version* of the project is defined (please note that
   this version may, but does not necessarily have to be, identical with
   the project model version on the engine into which the project will
   eventually be deployed).

2. The *dependencies of a project to other projects* and the exact
   version range of those projects that must be available in order for
   the project to work. Once a project is referenced in this way, its
   artifacts may be used inside the referencing project. This applies
   especially to the following artifacts: User Dialogs, Data Classes,
   Web Service Configurations, CMS Entries, Configurations, Java classes
   or Java libraries (JAR files).

3. Information about the implementor of the project and its purpose.

The following figure illustrates the above:

.. figure:: /_images/ivy-project/deployment-descriptor.png
   :alt: A project dependency, defined by the Project Deployment Descriptor

   A project dependency, defined by the Project Deployment Descriptor

Since referenced projects may in turn reference other projects, a whole
(acyclic) dependency graph may be constructed this way. All artifacts of
projects that are reachable from some project in this way (i.e., by
following the arrows) can be used.

The following figure illustrates this feature. For example, a User
Dialog defined in *Project D* may be used in *Project A*. A Data Class
that is defined in *Project E* may also be used in *Project A*. However,
it is not possible to use a sub process defined in *Project B* from
*Project C* (unless *Project B* is added as required project in the
deployment descriptor of *Project C*).

The search order to look up reused artifacts is breadth first. The order
in which directly referenced projects are looked up, can be defined in
the :ref:`project-deployment-descriptor`.

.. figure:: /_images/ivy-project/deployment-descriptor-graph.png
   :alt: Project Dependency Graph

   Project Dependency Graph

Projects may be required with a specific version or within a specific
version range. This is also illustrated in the above figure.

When deploying projects on the engine, the availability of the required
projects (and their versions) is checked. If the required project
versions cannot be resolved, then a project cannot be deployed.
Therefore projects must be deployed *bottom up*, i.e., one must start by
deploying first the required projects that are lowest in the dependency
hierarchy.

.. _deployment-descriptor-editor:

Deployment Descriptor Editor
~~~~~~~~~~~~~~~~~~~~~~~~~~~~

The Deployment Descriptor editor allows to edit a project's deployment
properties as well as the required projects and their version ranges as
described above. Most of those properties can already be specified in
the :ref:`project-new-wizard`, when a project is
initially created.

The deployment descriptor editor consists of two tabs:

-  The *Deployment* tab is used to configure the project's own
   deployment information.

-  The *Required Projects* tab is used to define other projects
   (possibly in a specific version) that the project depends on.

The deployment description is stored as Maven pom.xml, allowing Ivy
Projects to be built on a continuous integration server. See
:ref:`continuous-integration`.

Accessibility
~~~~~~~~~~~~~

Axon Ivy Project Tree -> double click on the *Deployment* node inside
the project tree (|imagef0|)

Deployment Tab
~~~~~~~~~~~~~~

.. figure:: /_images/ivy-project/deployment-descriptor-editor-deployment.png

Group ID
   Identifies your project uniquely across all projects. It has to
   follow the package name rules, which means that it has to contain at
   least the domain name you control, and you can create as many
   subgroups as you want. e.g., ``com.acme.ria``.

Project ID
   You can choose any name you want in lowercase letters and without
   special symbols, e.g., ``users`` or ``user-manager``.

   On deployment to the Axon Ivy Engine the concatenated Group ID + Project
   ID will act as unique identifier of the project.

Project Version
   The current development version of the project.

Provider
   The name of the user or company that implements and maintains (i.e.
   provides) the project. The provider setting has not functional
   purpose. It is for documentation only.

Description
   A (short) description of the project's purpose and contents. The
   description setting has no functional purpose. It is for
   documentation only.

Required Projects Tab
^^^^^^^^^^^^^^^^^^^^^

.. figure:: /_images/ivy-project/deployment-descriptor-editor-required-projects.png
   :alt: Deployment Descriptor Editor: Required Libraries Tab

   Deployment Descriptor Editor: Required Libraries Tab

Required Projects
   A table shows the list of the required projects, both with their name
   and their ID (as defined in the project's deployment descriptor). The
   table also shows the version range in which the referenced project
   must be available.

   Name
      The display name of the required project (how it is shown in the
      workspace).

   ID
      The unique identifier of the required project.

   Version
      The range specification of the version that the referenced project
      is required to have.

   Note that the order in the table defines the order how referenced
   artifacts are searched (Use the **Up Button** and **Down Button** to
   change the order). The general search order in the dependency graph
   is *breadth first*, but the order that you define here is the search
   order that will be used on a specific node when searching the graph.

   Clicking the *Add* button brings up a dialog with a selection box, in
   which any of the projects that are currently present in the workspace
   may be selected as required project. Closed projects or projects
   that are already (directly) required, cannot be selected.

   Selecting an entry in the table and subsequently clicking the
   *Remove* button removes a project dependency.

Required Project Details
   Shows the details of the currently selected project.

   Group and Project ID
      The identifiers of the required project (not editable).

   Maximum Version
      Optionally specify the maximum version that the required project
      needs to have. Choose whether you want to include or exclude this
      maximal version by checking the **Inclusive** box

   Minimum Version
      Optionally specify the minimum version that the required project
      needs to have. Choose whether you want to include or exclude this
      minimal version by checking the **Inclusive** box

.. warning::

   Beware of cycles in the project dependencies! You should never
   require a project B from a project A, if B also requires A (or if B
   requires any project that in turn requires A, which would form a
   larger cycle). Error markers will be displayed when the workspace is
   built, and cycles are detected as this condition can lead to
   endless recursion and other unpredictable behavior when looking up
   artifacts.



Project Graph view
~~~~~~~~~~~~~~~~~~~~

The Project Graph view shows the dependency graph of all projects in the
workspace.

|image1|


Toolbar actions
^^^^^^^^^^^^^^^

|image2| Refreshes the complete graph. Manually moved nodes will be
rearranged by the auto layout algorithm.

|image3| Selects the zoom level of the view.

|image4| Selects the layout algorithm that arranges the nodes and
dependency edges in the view.

|image5| Automatically opens the Project Graph whenever a Library
Descriptor Editor is opened.


Graph actions
^^^^^^^^^^^^^

-  Double click on a node to open its Library Descriptor Editor

-  Drag a node to improve the layout

-  Click on a node to highlight it

Accessibility
^^^^^^^^^^^^^

-  Windows -> Show View -> Axon Ivy -> Project Graph

-  CTRL + 3 (Quick Access) -> Project Graph

-  Deployment Descriptor Editor -> Open Project Graph from header
   toolbar

   |image6|

.. |imagef0| image:: /_images/ivy-project/deployment-descriptor-button-library.png
.. |image1| image:: /_images/ivy-project/project-graph-view.png
.. |image2| image:: /_images/ivy-project/project-graph-button-refresh.png
.. |image3| image:: /_images/ivy-project/project-graph-button-zoom.png
.. |image4| image:: /_images/ivy-project/project-graph-button-layout.png
.. |image5| image:: /_images/ivy-project/project-graph-button-auto-show.png
.. |image6| image:: /_images/ivy-project/project-graph-view-open-action.png


Adding additional dependencies
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

To add Java libraries to your projects that are not included in the Axon Ivy
platform, you can include them as Maven dependencies.
 
To add a new dependency, open the Deployment Descriptor with the Maven POM
Editor by right clicking on the Deployment Descriptor file and choosing
**Open With -> Maven POM Editor** or click on the **Open with Maven POM Editor** 
action in the toolbar of the :ref:`deployment-descriptor-editor`.

Then go to the *Dependencies* tab and click **Add...** to add a new dependency.
All libraries included in the dependencies will be added to the classpath
and are also included in the packaged Axon Ivy project.

Automatic import of required Axon ivy Projects
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

By default, Axon Ivy Designer automatically imports other required Axon ivy projects from available Maven repositories. 
E.g., if your project has a dependency on the Axon ivy project ``com.axonivy.portal:portal-components`` and has configured 
the Maven repository of the Axon Ivy market ``https://maven.axonivy.com/`` then Axon Ivy Designer downloads the 
project from the repository and automatically imports it to the workspace. 

In some use cases, this automatic import is not desirable (E.g., project migration, etc.). 
For these cases, you can turn off the automatic import in the preferences.
On the toolbar of the :ref:`deployment-descriptor-editor`, you can see if the **Auto Import** is on or off.
There is also an action to trigger the execution of the automatic import. This action works even if **Auto Import** is turned off. 
A log with the executed tasks is shown to better understands what the automatic import is doing.   
