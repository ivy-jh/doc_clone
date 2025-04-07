Projects
========

Axon Ivy Projects can be seen as development modules that encapsulate
the processes and other artifacts that form an application. An Axon Ivy
project roughly comprises of processes, User Dialogs, Data Classes, a
Content Management System and various configurations. All of those
aspects are explained in separate chapters of this document.

Projects can be reused, i.e., any project can depend on functionality
which is implemented by another project. Projects that implement reused
functionality and/or artifacts are called **required projects** with
respect to the project that makes use of that functionality. The latter
is in turn called the **dependent project*** with respect to its required
projects.

Once you have finished your development you will usually want to install
the implemented application or workflow on an Axon Ivy Engine. Projects
form the single unit of deployment for this purpose, i.e., you deploy
each project into a container on the engine which is called *process model version*.
A project may be deployed in multiple versions on the
engine; each process model version therefore contains a snapshot of a
project at a specific point of time in development. See chapter
:ref:`deployment` for more information on this topic.

The data that specifies a project's deployment information is contained
in the project's :ref:`project-deployment-descriptor`. The deployment
descriptor (formerly known as library) specifies all of the required
projects and the specific versions in which they must be present on the
engine in order for the deployed project to work. The descriptor also
defines an unique deployment ID and the development version of a project
(*not* equal to the process model version), as well as some information
about the project provider and a description of the project itself.

On the engine, a project in a specific development state/version
corresponds to a process model version, as explained above. On the
engine, all the deployed versions of a project are children of a
*process model* container (which corresponds to the project as an entity
without a specific version). The process models themselves are part of
an *application* (see chapter :ref:`deployment` for a
more thorough explanation).

In the Designer, projects may only exist in one version at a given point
of time. Projects are created and organized inside an Eclipse
*workspace*. Roughly, on the Designer, the *workspace* corresponds to
the *application* on the engine. Since projects can only exist in one
version on the Designer, there is no *process model* equivalent
necessary in the Designer.

When working on a project, which depends on other projects, then the
required projects need to be present as well in the Designer, which
means that they must be present in the current workspace. Otherwise
dependencies cannot be resolved and reused artifacts are not available,
which will prevent the application from running.

.. toctree::
  :maxdepth: 1

  ivyArchive
  ivyProjectView
  newProjectWizard
  importing
  exporting
  converting
  preferences
  deployment
  validate
