.. _process-properties:

Process Properties
------------------

Like the process elements that are used inside a process, the process
itself has an *inscription* that allows to specify and edit a processes
properties. To open and show a the inscription mask of a process you
simply select the process in the :ref:`ivy-project-view`,
right-click and select *inscription* from the pop-up menu.

Name and Description
~~~~~~~~~~~~~~~~~~~~

The common :ref:`process-element-tab-general` allows
to specify name, description and associated documents for each process.

Process Data
~~~~~~~~~~~~

The *Process Data tab* allows to specify the data class that will be
used to define the process's data structure.

|process-data-tab|

Each process must be associated with a data class, otherwise the tab
will show an error. The used data class is initially specified with the
:ref:`process-new-wizard`, but you may change
this association at any later time.

You can use the (C) button next to the data class field to select any
existing data class that is visible to the edited process. Please note
that **it is strongly recommended that you only set data classes that
are defined in the same project as the process** in order to avoid
dependencies on the specific implementation of another project.

It is legal for two processes to specify the same data class. This can
be desired if the processes operate on the same set of data (e.g., sub
processes) and it may facilitate the mapping in some cases.

Permissions
~~~~~~~~~~~

The *Permissions tab* allows to specify if the process can be viewed by
the end user on the engine or not.

|process-permissions-tab|

   .. note::

      Per default this is allowed for all business processes but not for
      the User Dialog Logic processes.


.. _process-properties-ws:

Web Service Process
~~~~~~~~~~~~~~~~~~~

The *Web Service Process* tab is only available on web service processes
and allows to specify the web service configuration.

|ws-process-tab|

The *Fully qualified Web Service name* will be used to generate the web
service class and the WSDL. The namespace part will be used as
*targetNamespace* in the WSDL. Choose this name carefully since it
should not be modified anymore as soon as clients start using the web
service.

The *Web Service authentication* options allows you to specify how
clients are authenticated when invoking the web service. You can select
one of the following available authentication methods:

None/Container
   Authentication is not handled by the web service element. However, if
   the web container (Tomcat) or a web server (Microsoft IIS/Apache)
   handles user authentication, the user is passed through to Axon Ivy
   (e.g., Single Sign-on).

WS Security
   UsernameToken with Password will be sent in clear-text to the ivy
   engine.

   .. warning::

      Only use this option in a trusted network or over a secure
      connection (e.g., HTTPS).

HTTP Basic
   Username and Password will be sent in clear-text to the Axon Ivy engine
   using standard HTTP Basic authentication mechanism.

   .. note::

      HTTP Basic is the only authentication option that is supported by
      Web Service processes and Web Service process elements in common.
      It can therefore be used to call a Web Service process from a Web
      Service process element if authentication is required.

   .. warning::

      Only use this option in a trusted network or over a secure
      connection (e.g., HTTPS).

   If the web container (Tomcat) or a web server (Microsoft IIS/Apache)
   already handles user authentication, the user is passed through to
   Axon Ivy without doing an additional HTTP Basic authentication.

.. |process-data-tab| image:: /_images/process-inscription/process-tab-process-data.png
.. |process-permissions-tab| image:: /_images/process-inscription/process-tab-permissions.png
.. |ws-process-tab| image:: /_images/process-inscription/ws-process-tab-ws-process.png
