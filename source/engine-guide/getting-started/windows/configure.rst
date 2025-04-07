Configure the Engine (Windows)
------------------------------

.. include:: ../_prepare-configuration.rst


Manual Setup
^^^^^^^^^^^^

Shutdown the Axon Ivy Engine first by stopping it. Use **ControlCenter.exe** or
**ControlCenterC.exe**. 

Alternatively, you can use one of the engine executables with command line
parameters as detailed in :ref:`Engine Launchers <engine-launchers>`. These are
well-suited for scripting.

* to stop an engine running as a console process, execute

.. code:: bat

    AxonIvyEngine stop


If you started the engine already as a service, you can also stop it in the
**services.msc** console.

Install the license: Copy the license file (:file:`*.lic`) into the
:file:`configuration` folder

.. code:: bat

    copy licence.lic <engineroot>\configuration\


To configure the system database, use the:code:`config-db` command of the
**EngineConfigCli** tool. Replace **yourdatabaseserver** with the hostname of
the server running your DBMS system. Replace **dbuser** and **password** with
the credentials of a technical database user with the permissions to create 
a new database and its structures (i.e., DDL permissions) on the database server.

Now, let's configure the database connection and create the system database:

.. code:: bat

    cd <engineroot>\bin\
    EngineConfigCli config-db org.postgresql.Driver jdbc:postgresql://<yourdatabaseserver>:5432/AxonIvySystemDatabase <dbuser> "<password>"
    EngineConfigCli create-db

Replace <yourdatabaseserver> with the DNS name of the database server, <dbuser> with the username and <password> with the password of the technical user.

.. Note::
  Administrators manage the Axon Ivy Engine. For example, they add or remove
  users, assign users to roles, enable, disable and deploy applications, etc. You need at
  least one administrator to manage the Axon Ivy Engine. In case of license
  problems, the Axon Ivy Engine sends mail notifications to the administrators.

.. include:: ../_webserver.rst

Now, start the Axon Ivy Engine again.

.. code:: bat

    AxonIvyEngine start 
   

.. Note:: 
  If you have changed the HTTP Settings, the HTTP port of the Axon Ivy Engine may have changed! 

Open a web browser and navigate to http://<yourservername>:<yourportnumber>/. As
you see, the header with the demo mode message is gone. You now have a
production-ready Axon Ivy Engine.


Register the Axon Ivy Engine as a Windows Service
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

In Windows, you can register your Axon Ivy Engine as a service to execute it in
the background. You can do this in a scriptable way using the command line.
Windows provides the service configuration utility sc.exe for this purpose.

.. code:: bat

    AxonIvyEngineService -register [windowsServiceName] [username] [password]

replace :code:`[windowsServiceName]` with the name you want to use for the
service, e.g. ivy_prod. The user specified by :code:`[username]` and
:code:`[password]` is used to run the service. 

Refer to :ref:`Engine Service <engine-service>` for more details on running Axon
Ivy as a service.

.. hint:: 
  You can add dependencies to this service for instance to wait for a DBMS or an
  external OpenSearch to start before Windows starts the Axon Ivy Engine. Please
  consult the Windows documentation for further details.
