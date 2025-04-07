.. _migrate-120-131:

Migrating from 12.0 to 13.1
===========================

Upgrade to 13.1 is only supported from an |ivy-engine| 10.0 and higher.
If you have an |ivy-engine| older than version 10.0 you need first to migrate to a newer version.

License
*******

|tag-ops-changed|

You need to request a new license for |ivy-engine| 13.1.


Removal of Server Control Center for Windows
********************************************

|tag-ops-changed|

The Server Control Center for Windows has been removed. Prefer using Docker for
Windows to run the Axon Ivy Engine. If you still want to run the Axon Ivy Engine
on Windows without Docker, you can use :ref:`AxonIvyEngineService.exe
<engine-service>` to register the Axon Ivy Engine as a Windows Service.


Support for Case Scope Override removed
****************************************

Case scope overriding has been depreacted in LTS 8.0 and was now removed.
Use :ref:`strict_overriding` if you rely on case scope overriding.


Removal of Serenity PrimeFaces themes
*************************************

|tag-project-removed|

We removed the Serenity themes including the :code:`serenity-ivy` theme. 
Please use the :ref:`freya-ivy <freya-themes>` theme instead.


Changed Runtime logger name
****************************************

|tag-ops-changed|

We changed the Runtime logger name from :code:`runtime.[app name].[pm name].[category]` to
:code:`runtime.[security context name].[category].[app name].[pm name]`.


.. container:: admonition note toggle

  .. container:: admonition-title header

     **Detail**

  .. container:: detail 

    We added the security context name to the Runtime logger name and moved the category after the security context name.
    This is to make the logger name more unique and to be able to filter by security context name.
    The new logger name is: :code:`runtime.[security context name].[category].[app name].[pm name]`.

    In case you have a custom :code:`log4j2.xml` configuration, you need to adapt the  occurences of the runtime logger name in your configuration.

    From something like this:

    .. code-block:: xml

      <Logger name="runtimelog.myapp.hrm.rest_client" level="DEBUG">
        <AppenderRef ref="RuntimeLog"/>
      </Logger>

    To something like this:

    .. code-block:: xml

      <Logger name="runtimelog.securitycontext.rest_client.myapp.hrm" level="DEBUG">
        <AppenderRef ref="RuntimeLog"/>
      </Logger>


------------

.. include:: _tagLegend.rst
