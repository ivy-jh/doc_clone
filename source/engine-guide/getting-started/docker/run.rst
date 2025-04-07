Run the Docker Image
--------------------

Now, we will run the Axon Ivy Engine with a separate container that holds the
system database - in this case, we use PostgreSQL. Create a new folder somewhere
in your file system and copy-paste the following files to it:

:file:`compose.yaml`

.. literalinclude:: compose.yaml
   :language: yaml

:file:`ivy.yaml`

.. literalinclude:: ivy.yaml
   :language: yaml

Provide a valid license file in the same folder with the name
:file:`licence.lic`. If you don't supply a license, then this example will still
work, but the Axon Ivy Engine will run in :ref:`demo mode <demo-mode>`.

Open a terminal and execute :code:`docker-compose up` in the folder where you
saved :file:`compose.yaml`. After startup, the engine is available at
http://localhost:8080.
