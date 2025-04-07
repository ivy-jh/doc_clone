Install the Engine (Linux)
--------------------------

We suggest you install the Axon Ivy Engine into a new folder called
:file:`/opt/ivy/engine`. Create the directory and change the owner to your
current user.

.. code:: bash

    cd /opt
    sudo mkdir ivy
    sudo chown myuser:myuser ivy

Replace **myuser** with the name of your current user.

.. Tip::
    Instead of using your current user, we suggest to use a special Linux user called
    **ivy**. First, create a new user and a group called ivy. Then, change the
    owner of the folder :file:`ivy` to the user **ivy**. After that, login as
    user **ivy** and work with this new user.

    .. code:: bash

        sudo mkdir ivy
        adduser ivy
        ...
        sudo chown ivy:ivy ivy
        ls -al
        ...
        drwxr-xr-x 3 ivy  ivy       4096 Sep 15 11:26 ivy
        ...
        login ivy
        ...

Download the latest engine:

.. code:: bash

    cd ivy
    mkdir engine
    cd engine
    wget https://developer.axonivy.com/permalink/|version|/axonivy-engine.zip -O engine.zip

.. include:: ../_packages.rst

To install Axon Ivy Engine, unzip the downloaded file
:file:`AxonIvyEngine*.zip` into a new :file:`AxonIvyEngine*` folder

.. code:: bash

    unzip engine.zip -d latest
    rm engine.zip
    cd latest

.. Note::
  The most important folders of the Axon Ivy Engine are:

  * :file:`bin` folder which contains all the executables.
  * :file:`configuration` folder which contains the configuration files.
  * :file:`deploy` folder which is used to deploy Axon Ivy projects.
