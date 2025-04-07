.. _process-element-web-service-process-start:

Web Service Process Start
=========================

|image0| The *WS Start* element is located in the *WS Process* drawer of
the process editor palette and only available in web service processes.

Element Details
---------------

Each Web Service Start element will create a web service operation in
the web service where it is located. It has input and output parameters.

Inscription
-----------

.. include:: _tab-name.rst

Start Tab
~~~~~~~~~

This tab is used to define the name and input parameters of the web
service operation. See :ref:`process-element-tab-start`
for a more detailed description.

Start signature
   The name text field allows you to specify the name of the web service
   operation. This is the name that will also appear in the generated
   WSDL and will be used to call the web service operation.

Input parameters
   This table is used to define the input parameters of the operation.
   The list may be left empty if the operation does not require any
   input parameters. To add a new parameter, click the green plus icon
   and specify the name and type of the parameter.

   .. warning::

      Some restrictions apply to the definition of Web Service process
      input parameters. Please follow the rules below:

      **Do not use** the interface type ``Number`` as type for an input
      parameter. Instead use concrete types like ``Integer`` or
      ``Double``.

      **Do not use** complex types that contain a ``List`` attribute as
      input parameter (e.g., ``Employee`` with an attribute ``projects``
      of type ``List<Project>``). Use a ``java.util.List`` (e.g.
      ``java.util.List<Project>``) as type for such attributes instead.

      In both cases you can still map the incoming values to process
      attributes of type ``Number`` or ``List<?>`` in the mapping
      section.

Mapping of input parameters
   The input parameters defined above are available as fields on the
   ``param`` variable. You can assign the parameter values to the
   internal data fields in the table.

   .. note::

      The reason why you have to assign the incoming parameters to local
      data is to keep the implementation independent from the
      declaration. By doing so the implementation can be changed at a
      later point of time (rename data, use different data types, etc.)
      while at the same time the web service interface is kept stable.
      This has the effect that none of the clients of the web service
      have to be changed/adapted after an internal data change.

.. include:: _tab-result.rst

Web Service Tab
~~~~~~~~~~~~~~~

This tab is used to change the web service specific settings of the
operation.

.. figure:: /_images/process-inscription/web-service-process-start-tab-webservice.png
   :alt: Web Service Tab

   Web Service Tab

Web service
   As the web service's name and authentication options are defined for the 
   whole web service and not per web service operation, you can change these 
   settings on the :ref:`process-properties-ws` itself.

Responsible role
   You may specify a role that is required to call this start. If the
   start is invoked with a user not owning the selected role, an error
   will occur. The error can be handled by a catching :ref:`process-element-error-start`.

Exception handling
   The exception handling allows your web service operation to throw a
   custom exception if your process could not complete normally. When
   such an exception is thrown, no output parameters are returned to the
   client.

   After activating the exception handling, define the condition on
   which the exception should be thrown and the message to be returned
   to the caller.

Task Tab
~~~~~~~~

This tab defines information relevant to the task. The task created for
a web service call will normally not appear in a task list of a user.
The values on this tab are therefore only relevant for analyzing the
finished tasks and not for the task list itself.

.. figure:: /_images/process-inscription/web-service-process-start-tab-task.png
   :alt: Task Tab

   Task Tab

Entry in Task List
   Defines the name and description of the task.

Priority
   Here you select the priority of the task.

Custom fields
   The values set on this table are only informational and have no
   effect on how this task is treated by Axon Ivy.

Code
   This is a post construct code block for the Task that is defined in
   this tab. The created Task is provided as variable called
   Consult :ref:`process-element-tab-task` for details and use cases.

Case Tab
~~~~~~~~

On this tab you can configure the Case created by this Web Service
Process Start. See :ref:`process-element-tab-case`.


Customization
-------------

The Web Service endpoints are generated automatically in a Java file
which contains JAX-WS annotations to define the Web Service. If the
default configuration does not fit your needs, the generated Java file
can be managed and extended by the developer.

The Java file is located in the folder
``[project]/src_wsproc/[fully-qualified-name].java`` and gets
interpreted by the CXF library (http://cxf.apache.org/). The file has to
be moved to the ``src``-folder of the project and has to be in line with
the configuration of the WS Start Elements of the process. The
``fully-qualified-name`` is defined in the inscription mask of the
process.

The Java file in the ``src``-folder is under control of the Developer.
When a WS Start element configuration changes, the change has to be
adapted manually in the Java file.

.. |image0| image:: /_images/process-editor/elements/ws-start.png
